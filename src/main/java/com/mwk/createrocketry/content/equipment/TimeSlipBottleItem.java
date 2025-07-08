package com.mwk.createrocketry.content.equipment;

import com.mwk.createrocketry.config.CRCItems;
import com.mwk.createrocketry.config.CRConfigs;
import com.simibubi.create.content.kinetics.belt.behaviour.BeltProcessingBehaviour;
import com.simibubi.create.content.logistics.depot.DepotBehaviour;
import com.simibubi.create.foundation.blockEntity.SmartBlockEntity;
import com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.TickingBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@EventBusSubscriber
public class TimeSlipBottleItem extends Item {
    public TimeSlipBottleItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        return true;
    }

    public @NotNull InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        if (level instanceof ServerLevel server) {
            for (int i = 0; i < CRConfigs.server().items.timeslipBottleRandomTicks.get(); i++) {
                // blockstate must be fetched every time because it usually changes on random tick
                level.getBlockState(blockpos).randomTick(server, blockpos, level.getRandom());
            }
            for (int i = 0; i < CRConfigs.server().items.timeslipBottleBlockTicks.get(); i++) {
                level.getBlockState(blockpos).tick(server, blockpos, level.getRandom());
            }
            BlockEntity be = level.getBlockEntity(blockpos);
            if (be != null) tickTicker(level, level.getBlockState(blockpos), blockpos, be, be.getType());
        }
        handleConsume(level, blockpos.getX() + 0.5, blockpos.getY() + 0.5, blockpos.getZ() + 0.5, context.getPlayer(), context.getItemInHand(), context.getHand());

        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    // laughs in generics
    private static <T extends BlockEntity> void tickTicker(Level level, BlockState state, BlockPos pos, BlockEntity be, BlockEntityType<T> type) {
        BlockEntityTicker<T> ticker = state.getTicker(level, type);
        T t = (T) be;
        if (ticker == null) return;
        // special handling so that depot processing can be sped up
        BeltProcessingBehaviour processing = BlockEntityBehaviour.get(be, BeltProcessingBehaviour.TYPE);
        DepotBehaviour depot = null;
        if (processing != null) {
            depot = BlockEntityBehaviour.get(level, pos.below(2), DepotBehaviour.TYPE);
        }
        for (int i = 0; i < CRConfigs.server().items.timeslipBottleBlockEntityTicks.get(); i++) {
            ticker.tick(level, pos, state, t);
            if (depot != null) depot.tick();
        }
    }

    protected void handleConsume(Level level, double x, double y, double z, @Nullable Player player, ItemStack hand, InteractionHand interactionHand) {
        ItemStack container = null;
        if (hand.hasCraftingRemainingItem()) {
            container = hand.getCraftingRemainingItem();
        }
        hand.consume(1, player);
        if (container != null && player != null && !player.hasInfiniteMaterials()) {
            if (hand.isEmpty()) {
                player.setItemInHand(interactionHand, container);
            } else {
                player.getInventory().add(container);
            }
        }
        level.playSound(player, x, y, z, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }

    @SubscribeEvent
    public static void onEntityInteract(PlayerInteractEvent.EntityInteractSpecific interact) {
        Player player = interact.getEntity();
        ItemStack hand = player.getMainHandItem();
        if (hand.getItem() instanceof TimeSlipBottleItem timeslip) {
            Entity target = interact.getTarget();
            if (interact.getLevel() instanceof ServerLevel server) {
                for (int i = 0; i < CRConfigs.server().items.timeslipBottleEntityTicks.get(); i++) {
                    server.guardEntityTick(server::tickNonPassenger, target);
                }
            }
            timeslip.handleConsume(interact.getLevel(), target.getX(), target.getY(), target.getZ(), player, hand, InteractionHand.MAIN_HAND);
        }
    }
}

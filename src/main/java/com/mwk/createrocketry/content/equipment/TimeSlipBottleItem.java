package com.mwk.createrocketry.content.equipment;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

public class TimeSlipBottleItem extends BoneMealItem {
    public TimeSlipBottleItem(Properties properties) {
        super(properties);
    }

    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        BlockPos blockpos1 = blockpos.relative(context.getClickedFace());
        if (applyBonemeal(context.getItemInHand(), level, blockpos, context.getPlayer())) {
            applyBonemeal(context.getItemInHand(), level, blockpos, context.getPlayer());
            applyBonemeal(context.getItemInHand(), level, blockpos, context.getPlayer());
            applyBonemeal(context.getItemInHand(), level, blockpos, context.getPlayer());
            if (!level.isClientSide) {
                context.getPlayer().gameEvent(GameEvent.ITEM_INTERACT_FINISH);
                level.levelEvent(1505, blockpos, 15);
            }

            return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
            BlockState blockstate = level.getBlockState(blockpos);
            boolean flag = blockstate.isFaceSturdy(level, blockpos, context.getClickedFace());
            if (flag && growWaterPlant(context.getItemInHand(), level, blockpos1, context.getClickedFace())) {
                if (!level.isClientSide) {
                    context.getPlayer().gameEvent(GameEvent.ITEM_INTERACT_FINISH);
                    level.levelEvent(1505, blockpos1, 15);
                }

                return InteractionResult.sidedSuccess(level.isClientSide);
            } else {
                return InteractionResult.PASS;
            }
        }
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }
}

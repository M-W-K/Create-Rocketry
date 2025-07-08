package com.mwk.createrocketry.registries;

import com.simibubi.create.content.fluids.VirtualFluid;
import com.tterrag.registrate.util.entry.FluidEntry;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.FluidInteractionRegistry;
import net.neoforged.neoforge.fluids.FluidInteractionRegistry.InteractionInformation;
import org.jetbrains.annotations.Nullable;

import static com.mwk.createrocketry.CreateRocketry.REGISTRATE;

public class CRFluids {

    static {
        REGISTRATE.setCreativeTab(CRCreativeTabs.BASE_CREATIVE_TAB);
    }

    public static FluidEntry<BaseFlowingFluid.Flowing> BERYLLIUM_SLURRY = REGISTRATE
            .standardFluid("beryllium_slurry")
            .lang("Beryllium Slurry")
            .properties(b -> b.viscosity(3000)
                    .density(4000))
            .fluidProperties(p -> p.levelDecreasePerBlock(3)
                    .tickRate(100)
                    .slopeFindDistance(3)
                    .explosionResistance(1000f))
            .source(BaseFlowingFluid.Source::new)
            .block()
            .properties(p -> p.mapColor(MapColor.COLOR_GREEN))
            .build()
            .bucket()
            .build()
            .register();

    // TODO make this a blockfluid; implement timefix gel stabilization, hurt entities that touch the fluid without it
    // also rapidly increment item lifetimes, so they despawn much faster, for maximum rude
    public static FluidEntry<VirtualFluid> TIMESLIP_FLUX = REGISTRATE.virtualFluid("timeslip_flux")
            .lang("Timeslip Flux").register();



    public static void registerFluidInteractions() {
        // for when timeslip flux has a blockfluid
//        FluidInteractionRegistry.addInteraction(NeoForgeMod.LAVA_TYPE.value(), new InteractionInformation(
//                TIMESLIP_FLUX.getType(),
//                fluidState -> {
//                    return Blocks.MAGMA_BLOCK.defaultBlockState();
//                }
//        ));
    }

    @Nullable
    public static BlockState getInteraction(Fluid other, Fluid fluid) {
        if (other.isSame(Fluids.LAVA)) {
            if (fluid.isSame(TIMESLIP_FLUX.get()))
                return Blocks.MAGMA_BLOCK.defaultBlockState();
        }
        return null;
    }

    public static void register() {}
}

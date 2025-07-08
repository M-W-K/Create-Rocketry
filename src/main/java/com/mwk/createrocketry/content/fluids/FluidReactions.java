package com.mwk.createrocketry.content.fluids;

import com.mwk.createrocketry.registries.CRFluids;
import com.simibubi.create.api.event.PipeCollisionEvent;
import com.simibubi.create.foundation.fluid.FluidHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber
public class FluidReactions {

    @SubscribeEvent
    public static void handlePipeFlowCollisionFallback(PipeCollisionEvent.Flow event) {
        Fluid f1 = event.getFirstFluid();
        Fluid f2 = event.getSecondFluid();

        BlockState interaction = CRFluids.getInteraction(f1, f2);
        if (interaction != null) {
            event.setState(interaction);
        } else {
            interaction = CRFluids.getInteraction(f2, f1);
            if (interaction != null) {
                event.setState(interaction);
            }
        }
    }

    @SubscribeEvent
    public static void handlePipeSpillCollisionFallback(PipeCollisionEvent.Spill event) {
        Fluid pf = event.getPipeFluid();
        Fluid wf = event.getWorldFluid();

        BlockState interaction = CRFluids.getInteraction(pf, wf);
        if (interaction != null) {
            event.setState(interaction);
        } else {
            interaction = CRFluids.getInteraction(wf, pf);
            if (interaction != null) {
                event.setState(interaction);
            }
        }
    }
}

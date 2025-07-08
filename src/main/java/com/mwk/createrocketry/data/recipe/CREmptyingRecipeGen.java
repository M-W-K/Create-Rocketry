package com.mwk.createrocketry.data.recipe;

import com.mwk.createrocketry.CreateRocketry;
import com.mwk.createrocketry.registries.CRFluids;
import com.mwk.createrocketry.registries.CRItems;
import com.simibubi.create.api.data.recipe.EmptyingRecipeGen;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class CREmptyingRecipeGen extends EmptyingRecipeGen {

    GeneratedRecipe

    TIMESLIP_BOTTLE = create("timeslip_bottle", b -> b
            .require(CRItems.TIMESLIP_BOTTLE)
            .output(CRFluids.TIMESLIP_FLUX.get(), 250)
            .output(Items.GLASS_BOTTLE));

    public CREmptyingRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateRocketry.MODID);
    }
}

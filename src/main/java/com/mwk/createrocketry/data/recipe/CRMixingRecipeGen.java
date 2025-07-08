package com.mwk.createrocketry.data.recipe;

import com.mwk.createrocketry.CreateRocketry;
import com.mwk.createrocketry.registries.CRFluids;
import com.simibubi.create.AllFluids;
import com.simibubi.create.AllTags;
import com.simibubi.create.api.data.recipe.MixingRecipeGen;
import com.simibubi.create.content.processing.recipe.HeatCondition;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.common.Tags;

import java.util.concurrent.CompletableFuture;

public class CRMixingRecipeGen extends MixingRecipeGen {

    GeneratedRecipe

    BERYLLIUM_SLURRY_EMERALD = create("beryllium_slurry_emerald", b -> b
            .require(Fluids.WATER, 1000)
            .require(Tags.Items.GEMS_EMERALD)
            .output(CRFluids.BERYLLIUM_SLURRY.get(), 1000)
            .requiresHeat(HeatCondition.HEATED)),

    BERYLLIUM_SLURRY_PEARL = create("beryllium_slurry_pearl", b -> b
            .require(Fluids.WATER, 1000)
            .require(Tags.Items.ENDER_PEARLS)
            .output(CRFluids.BERYLLIUM_SLURRY.get(), 1000)
            .requiresHeat(HeatCondition.HEATED)),

    BERYLLIUM_SLURRY_CRUDE_EMERALD = create("beryllium_slurry_crude_emerald", b -> b
            .require(Fluids.LAVA, 1000)
            .require(Tags.Items.GEMS_EMERALD)
            .require(Items.WATER_BUCKET)
            .output(CRFluids.BERYLLIUM_SLURRY.get().getBucket())),

    BERYLLIUM_SLURRY_CRUDE_PEARL = create("beryllium_slurry_crude_pearl", b -> b
            .require(Fluids.LAVA, 1000)
            .require(Tags.Items.ENDER_PEARLS)
            .require(Items.WATER_BUCKET)
            .output(CRFluids.BERYLLIUM_SLURRY.get().getBucket())),

    TIMESLIP_FLUX = create("timeslip_flux", b -> b
            .require(Fluids.WATER, 500)
            .require(AllTags.AllItemTags.OBSIDIAN_DUST.tag)
            .require(Tags.Items.GEMS_AMETHYST)
            .require(Items.END_CRYSTAL)
            .output(CRFluids.TIMESLIP_FLUX.get(), 1000)
            .output(Items.GHAST_TEAR));

    public CRMixingRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateRocketry.MODID);
    }
}

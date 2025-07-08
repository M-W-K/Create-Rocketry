package com.mwk.createrocketry.data.recipe;

import com.mwk.createrocketry.CreateRocketry;
import com.mwk.createrocketry.registries.CRBlocks;
import com.mwk.createrocketry.registries.CRFluids;
import com.mwk.createrocketry.registries.CRItems;
import com.simibubi.create.api.data.recipe.FillingRecipeGen;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.Tags;

import java.util.concurrent.CompletableFuture;

public class CRFillingRecipeGen extends FillingRecipeGen {

    GeneratedRecipe

            BERYLLIUM_NUGGET_COAL = create("beryllium_nugget_coal", b -> b
            .require(CRFluids.BERYLLIUM_SLURRY.get(), 100)
            .require(Items.COAL)
            .output(CRItems.BERYLLIUM_NUGGET)),

    BERYLLIUM_NUGGET_CHARCOAL = create("beryllium_nugget_charcoal", b -> b
            .require(CRFluids.BERYLLIUM_SLURRY.get(), 100)
            .require(Items.CHARCOAL)
            .output(CRItems.BERYLLIUM_NUGGET)),

    BERYLLIUM_INGOT_GUNPOWDER = create("beryllium_ingot_gunpowder", b -> b
            .require(CRFluids.BERYLLIUM_SLURRY.get(), 750)
            .require(Items.GUNPOWDER)
            .output(CRItems.BERYLLIUM_INGOT)),

    BERYLLIUM_INGOT_BLAZE = create("beryllium_ingot_blaze", b -> b
            .require(CRFluids.BERYLLIUM_SLURRY.get(), 500)
            .require(Items.BLAZE_POWDER)
            .output(CRItems.BERYLLIUM_INGOT)),

    BERYLLIUM_INGOT_CHARGE = create("beryllium_ingot_charge", b -> b
            .require(CRFluids.BERYLLIUM_SLURRY.get(), 500)
            .require(Items.FIRE_CHARGE)
            .output(CRItems.BERYLLIUM_INGOT)),

    TIMESLIP_BOTTLE = create("timeslip_bottle", b -> b
            .require(CRFluids.TIMESLIP_FLUX.get(), 250)
            .require(Items.GLASS_BOTTLE)
            .output(CRItems.TIMESLIP_BOTTLE));

    public CRFillingRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateRocketry.MODID);
    }
}

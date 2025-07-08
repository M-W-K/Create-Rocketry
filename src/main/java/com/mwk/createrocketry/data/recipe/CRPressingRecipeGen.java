package com.mwk.createrocketry.data.recipe;

import com.mwk.createrocketry.CreateRocketry;
import com.mwk.createrocketry.registries.CRItems;
import com.simibubi.create.api.data.recipe.PressingRecipeGen;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;

import java.util.concurrent.CompletableFuture;

public class CRPressingRecipeGen extends PressingRecipeGen {

    GeneratedRecipe

    BERYLLIUM = create("beryllium_ingot", b -> b
            .require(CRItems.BERYLLIUM_INGOT)
            .output(CRItems.BERYLLIUM_SHEET)),

    BERYLLIUM_BRONZE = create("beryllium_bronze_ingot", b -> b
            .require(CRItems.BERYLLIUM_BRONZE_INGOT)
            .output(CRItems.BERYLLIUM_BRONZE_SHEET));

    public CRPressingRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateRocketry.MODID);
    }
}

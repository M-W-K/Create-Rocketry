package com.mwk.createrocketry.data.recipe;

import com.mwk.createrocketry.CreateRocketry;
import com.mwk.createrocketry.registries.CRItems;
import com.simibubi.create.api.data.recipe.HauntingRecipeGen;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.concurrent.CompletableFuture;

public class CRHauntingRecipeGen extends HauntingRecipeGen {

    GeneratedRecipe

    TIMESLIP = convert(() -> Ingredient.of(CRItems.TIMESLIP_BOTTLE), () -> CRItems.TIMEFIX_BOTTLE);

    public CRHauntingRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateRocketry.MODID);
    }
}

package com.mwk.createrocketry.data;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mwk.createrocketry.CreateRocketry;
import com.mwk.createrocketry.data.recipe.*;
import com.mwk.createrocketry.ponders.CRPonders;
import com.simibubi.create.foundation.utility.FilesHelper;
import com.tterrag.registrate.providers.ProviderType;
import net.createmod.ponder.foundation.PonderIndex;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class CRDatagen {
    public static void gatherDataHighPriority(GatherDataEvent event) {
        addExtraRegistrateData();
    }

    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        PackOutput output = gen.getPackOutput();
        CompletableFuture<HolderLookup.Provider> registries = event.getLookupProvider();

        gen.addProvider(event.includeServer(), new CRStandardRecipeGen(output, registries));
        gen.addProvider(event.includeServer(), new CRMixingRecipeGen(output, registries));
        gen.addProvider(event.includeServer(), new CRFillingRecipeGen(output, registries));
        gen.addProvider(event.includeServer(), new CRHauntingRecipeGen(output, registries));
        gen.addProvider(event.includeServer(), new CRPressingRecipeGen(output, registries));
        gen.addProvider(event.includeServer(), new CREmptyingRecipeGen(output, registries));
    }

    private static void addExtraRegistrateData() {
        CreateRocketry.REGISTRATE.addDataGenerator(ProviderType.LANG, provider -> {
            BiConsumer<String, String> langConsumer = provider::add;
            provideDefaultLang("interface", langConsumer);
            provideDefaultLang("tooltips", langConsumer);
            providePonderLang(langConsumer);
        });
    }

    private static void provideDefaultLang(String fileName, BiConsumer<String, String> consumer) {
        String path = "assets/" + CreateRocketry.MODID + "/lang/default/" + fileName + ".json";
        JsonElement jsonElement = FilesHelper.loadJsonResource(path);
        if (jsonElement == null) {
            throw new IllegalStateException(String.format("Could not find default lang file: %s", path));
        }
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue().getAsString();
            consumer.accept(key, value);
        }
    }

    private static void providePonderLang(BiConsumer<String, String> consumer) {
        // Register this since FMLClientSetupEvent does not run during datagen
        PonderIndex.addPlugin(new CRPonders());
        PonderIndex.getLangAccess().provideLang(CreateRocketry.MODID, consumer);
    }
}

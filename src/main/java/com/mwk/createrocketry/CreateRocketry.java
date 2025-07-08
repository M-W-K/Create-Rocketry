package com.mwk.createrocketry;

import com.mwk.createrocketry.config.CRConfigs;
import com.mwk.createrocketry.data.CRDatagen;
import com.mwk.createrocketry.registries.CRBlocks;
import com.mwk.createrocketry.registries.CRCreativeTabs;
import com.mwk.createrocketry.registries.CRFluids;
import com.mwk.createrocketry.registries.CRItems;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.item.ItemDescription;
import com.simibubi.create.foundation.item.KineticStats;
import com.simibubi.create.foundation.item.TooltipModifier;
import net.createmod.catnip.lang.FontHelper;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.fml.ModLoadingContext;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod(CreateRocketry.MODID)
public class CreateRocketry {
    public static final String MODID = "createrocketry";
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MODID)
            .defaultCreativeTab((ResourceKey<CreativeModeTab>) null);
    public static final Logger LOGGER = LogUtils.getLogger();

    static {
        REGISTRATE.setTooltipModifierFactory(item -> new ItemDescription.Modifier(item, FontHelper.Palette.STANDARD_CREATE)
                .andThen(TooltipModifier.mapNull(KineticStats.create(item))));
    }

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public CreateRocketry(IEventBus modEventBus, ModContainer modContainer) {
        REGISTRATE.registerEventListeners(modEventBus);

        CRCreativeTabs.register(modEventBus);
        CRBlocks.register();
        CRItems.register();
        CRFluids.register();

        modEventBus.addListener(EventPriority.LOWEST, CRDatagen::gatherData);
        modEventBus.addListener(EventPriority.HIGHEST, CRDatagen::gatherDataHighPriority);

        CRConfigs.register(ModLoadingContext.get(), modContainer);
    }

    public static void init(FMLCommonSetupEvent event) {
        CRFluids.registerFluidInteractions();
    }

    public static ResourceLocation crloc(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }
}

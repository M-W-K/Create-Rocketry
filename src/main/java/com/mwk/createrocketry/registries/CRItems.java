package com.mwk.createrocketry.registries;

import com.mwk.createrocketry.CreateRocketry;
import com.mwk.createrocketry.content.equipment.TimeFixBottleItem;
import com.mwk.createrocketry.content.equipment.TimeSlipBottleItem;
import com.mwk.createrocketry.content.equipment.tool.CRToolMaterials;
import com.simibubi.create.AllTags;
import com.simibubi.create.content.processing.sequenced.SequencedAssemblyItem;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.common.Tags;

import java.util.List;

import static com.mwk.createrocketry.CreateRocketry.REGISTRATE;
import static com.simibubi.create.AllTags.AllItemTags.PLATES;
import static com.simibubi.create.AllTags.commonItemTag;

public class CRItems {

    static {
        REGISTRATE.setCreativeTab(CRCreativeTabs.BASE_CREATIVE_TAB);
    }

    public static final ItemEntry<Item> BERYLLIUM_INGOT = taggedIngredient("beryllium_ingot", commonItemTag("ingots/beryllium"), Tags.Items.INGOTS),
            BERYLLIUM_SHEET = taggedIngredient("beryllium_sheet", commonItemTag("plates/beryllium"), PLATES.tag),
            BERYLLIUM_NUGGET = taggedIngredient("beryllium_nugget", commonItemTag("nuggets/beryllium"), Tags.Items.NUGGETS);

    public static final ItemEntry<Item> BERYLLIUM_BRONZE_INGOT = taggedIngredient("beryllium_bronze_ingot", commonItemTag("ingots/beryllium_bronze"), Tags.Items.INGOTS),
            BERYLLIUM_BRONZE_SHEET = taggedIngredient("beryllium_bronze_sheet", commonItemTag("plates/beryllium_bronze"), PLATES.tag),
            BERYLLIUM_BRONZE_NUGGET = taggedIngredient("beryllium_bronze_nugget", commonItemTag("nuggets/beryllium_bronze"), Tags.Items.NUGGETS);

    public static final ItemEntry<SmithingTemplateItem> BERYLLIUM_BRONZE_SMITHING_TEMPLATE =
            REGISTRATE.item("beryllium_bronze_smithing_template", p -> new SmithingTemplateItem(
                    Component.translatable(Util.makeDescriptionId("item", CreateRocketry.crloc("smithing_template.beryllium_bronze.applies_to"))).withStyle(ChatFormatting.BLUE),
                    Component.translatable(Util.makeDescriptionId("item", CreateRocketry.crloc("smithing_template.beryllium_bronze.ingredients"))).withStyle(ChatFormatting.BLUE),
                    Component.translatable(Util.makeDescriptionId("upgrade", CreateRocketry.crloc("beryllium_bronze"))).withStyle(ChatFormatting.GRAY),
                    Component.translatable(Util.makeDescriptionId("item", CreateRocketry.crloc("smithing_template.beryllium_bronze.base_slot_description"))),
                    Component.translatable(Util.makeDescriptionId("item", CreateRocketry.crloc("smithing_template.beryllium_bronze.additions_slot_description"))),
                    List.of(
                            ResourceLocation.withDefaultNamespace("item/empty_slot_sword"),
                            ResourceLocation.withDefaultNamespace("item/empty_slot_shovel"),
                            ResourceLocation.withDefaultNamespace("item/empty_slot_pickaxe"),
                            ResourceLocation.withDefaultNamespace("item/empty_slot_axe"),
                            ResourceLocation.withDefaultNamespace("item/empty_slot_hoe")
                    ),
                    List.of(ResourceLocation.withDefaultNamespace("item/empty_slot_ingot"))))
                    .register();

    public static final ItemEntry<SwordItem> NONSPARKING_SWORD =
            REGISTRATE.item("nonsparking_sword", p -> new SwordItem(CRToolMaterials.BERYLLIUM_BRONZE, p))
                    .properties(p -> p.stacksTo(1))
                    .properties(p -> p.attributes(SwordItem.createAttributes(CRToolMaterials.BERYLLIUM_BRONZE, 3.0F, -2.4F)))
                    .register();

    public static final ItemEntry<ShovelItem> NONSPARKING_SHOVEL =
            REGISTRATE.item("nonsparking_shovel", p -> new ShovelItem(CRToolMaterials.BERYLLIUM_BRONZE, p))
                    .properties(p -> p.stacksTo(1))
                    .properties(p -> p.attributes(ShovelItem.createAttributes(CRToolMaterials.BERYLLIUM_BRONZE, 1.5F, -3.0F)))
                    .register();

    public static final ItemEntry<PickaxeItem> NONSPARKING_PICKAXE =
            REGISTRATE.item("nonsparking_pickaxe", p -> new PickaxeItem(CRToolMaterials.BERYLLIUM_BRONZE, p))
                    .properties(p -> p.stacksTo(1))
                    .properties(p -> p.attributes(PickaxeItem.createAttributes(CRToolMaterials.BERYLLIUM_BRONZE, 1.0F, -2.8F)))
                    .register();

    public static final ItemEntry<AxeItem> NONSPARKING_AXE =
            REGISTRATE.item("nonsparking_axe", p -> new AxeItem(CRToolMaterials.BERYLLIUM_BRONZE, p))
                    .properties(p -> p.stacksTo(1))
                    .properties(p -> p.attributes(AxeItem.createAttributes(CRToolMaterials.BERYLLIUM_BRONZE, 6.0F, -3.1F)))
                    .register();

    public static final ItemEntry<HoeItem> NONSPARKING_HOE =
            REGISTRATE.item("nonsparking_hoe", p -> new HoeItem(CRToolMaterials.BERYLLIUM_BRONZE, p))
                    .properties(p -> p.stacksTo(1))
                    .properties(p -> p.attributes(HoeItem.createAttributes(CRToolMaterials.BERYLLIUM_BRONZE, -2.0F, -1.0F)))
                    .register();

    public static final ItemEntry<TimeSlipBottleItem> TIMESLIP_BOTTLE = REGISTRATE.item("timeslip_bottle", TimeSlipBottleItem::new)
            .tag(AllTags.AllItemTags.UPRIGHT_ON_BELT.tag)
            .properties(p -> p.stacksTo(16)
                    .craftRemainder(Items.GLASS_BOTTLE)
                    .food(new FoodProperties.Builder()
                            .alwaysEdible().fast()
                            .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 10 * 20, 5, false, true, true), 1F)
                            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 10 * 20, 5, false, true, true), 1F)
                            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 10 * 20, 5, false, true, true), 1F)
                            .usingConvertsTo(Items.GLASS_BOTTLE)
                            .build()))
            .lang("Bottle of Timeslip Flux")
            .register();

    public static final ItemEntry<TimeFixBottleItem> TIMEFIX_BOTTLE = REGISTRATE.item("timefix_bottle", TimeFixBottleItem::new)
            .tag(AllTags.AllItemTags.UPRIGHT_ON_BELT.tag)
            .properties(p -> p.stacksTo(16)
                    .craftRemainder(Items.GLASS_BOTTLE)
                    .food(new FoodProperties.Builder()
                            .alwaysEdible().nutrition(1).saturationModifier(5.5f)
                            .effect(() -> new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 10 * 20, 3, false, true, true), 1F)
                            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10 * 20, 3, false, true, true), 1F)
                            .effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 10 * 20, 3, false, true, true), 1F)
                            .usingConvertsTo(Items.GLASS_BOTTLE)
                            .build()))
            .lang("Bottle of Timefix Gel")
            .register();

    public static final ItemEntry<Item> TIMEFIX_GEL = taggedIngredient("timefix_gel");

    @SafeVarargs
    private static ItemEntry<Item> taggedIngredient(String name, TagKey<Item>... tags) {
        return REGISTRATE.item(name, Item::new)
                .tag(tags)
                .register();
    }

    @SafeVarargs
    private static ItemEntry<Item> taggedIngredientFireResistant(String name, TagKey<Item>... tags) {
        return REGISTRATE.item(name, Item::new)
                .tag(tags)
                .properties(Item.Properties::fireResistant)
                .register();
    }

    private static ItemEntry<SequencedAssemblyItem> sequencedIngredient(String name) {
        return REGISTRATE.item(name, SequencedAssemblyItem::new)
                .register();
    }

    private static ItemEntry<SequencedAssemblyItem> sequencedIngredient(String name, TagKey<Item>... tags) {
        return REGISTRATE.item(name, SequencedAssemblyItem::new)
                .tag(tags)
                .register();
    }

    public static void register() {}
}

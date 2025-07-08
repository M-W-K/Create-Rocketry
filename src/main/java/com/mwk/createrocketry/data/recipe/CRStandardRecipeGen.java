package com.mwk.createrocketry.data.recipe;

import com.mwk.createrocketry.CreateRocketry;
import com.mwk.createrocketry.registries.CRBlocks;
import com.mwk.createrocketry.registries.CRItems;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.api.data.recipe.BaseRecipeProvider;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.entry.ItemProviderEntry;
import net.createmod.catnip.registry.RegisteredObjectsHelper;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import net.neoforged.neoforge.common.conditions.NotCondition;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import static com.simibubi.create.AllTags.commonItemTag;

public class CRStandardRecipeGen extends BaseRecipeProvider {

    private Marker MATERIALS = enterFolder("materials");

    GeneratedRecipe

            BERYLLIUM_NUGGET = create(CRItems.BERYLLIUM_NUGGET).returns(9)
            .unlockedBy(CRItems.BERYLLIUM_INGOT)
            .viaShapeless(b -> b.requires(CRItems.BERYLLIUM_INGOT.get())),
    BERYLLIUM_INGOT = create(CRItems.BERYLLIUM_INGOT)
            .unlockedBy(CRItems.BERYLLIUM_NUGGET)
            .viaShaped(b -> b.define('C', CRItems.BERYLLIUM_NUGGET.get())
                    .pattern("CCC")
                    .pattern("CCC")
                    .pattern("CCC")),

    BERYLLIUM_INGOT_FROM_BLOCK = create(CRItems.BERYLLIUM_INGOT).withSuffix("_from_block")
            .returns(9)
            .unlockedBy(CRItems.BERYLLIUM_INGOT)
            .viaShapeless(b -> b.requires(CRBlocks.BERYLLIUM_BLOCK.get())),

    BERYLLIUM_BLOCK = create(CRBlocks.BERYLLIUM_BLOCK)
            .unlockedBy(CRItems.BERYLLIUM_INGOT)
            .viaShaped(b -> b.define('C', CRItems.BERYLLIUM_INGOT.get())
                    .pattern("CCC")
                    .pattern("CCC")
                    .pattern("CCC")),

    BERYLLIUM_BRONZE_NUGGET = create(CRItems.BERYLLIUM_BRONZE_NUGGET).returns(9)
            .unlockedBy(CRItems.BERYLLIUM_BRONZE_INGOT)
            .viaShapeless(b -> b.requires(CRItems.BERYLLIUM_BRONZE_INGOT.get())),

    BERYLLIUM_BRONZE_INGOT_FROM_NUGGETS = create(CRItems.BERYLLIUM_BRONZE_INGOT).withSuffix("_from_nuggets")
                    .unlockedBy(CRItems.BERYLLIUM_BRONZE_NUGGET)
                    .viaShaped(b -> b.define('C', CRItems.BERYLLIUM_BRONZE_NUGGET.get())
                            .pattern("CCC")
                            .pattern("CCC")
                            .pattern("CCC")),

    BERYLLIUM_BRONZE_INGOT_FROM_BLOCK = create(CRItems.BERYLLIUM_BRONZE_INGOT).withSuffix("_from_block")
            .returns(9)
            .unlockedBy(CRItems.BERYLLIUM_BRONZE_INGOT)
            .viaShapeless(b -> b.requires(CRBlocks.BERYLLIUM_BRONZE_BLOCK.get())),

    BERYLLIUM_BRONZE_BLOCK = create(CRBlocks.BERYLLIUM_BRONZE_BLOCK)
            .unlockedBy(CRItems.BERYLLIUM_BRONZE_INGOT)
            .viaShaped(b -> b.define('C', CRItems.BERYLLIUM_BRONZE_INGOT.get())
                    .pattern("CCC")
                    .pattern("CCC")
                    .pattern("CCC")),

    BERYLLIUM_BRONZE_INGOT = create(CRItems.BERYLLIUM_BRONZE_INGOT)
            .unlockedBy(CRItems.BERYLLIUM_INGOT)
            .viaShapeless(b -> b.requires(Ingredient.of(Tags.Items.INGOTS_COPPER), 7)
                    .requires(Ingredient.of(commonItemTag("ingots/beryllium")))),

    TIMEFIX_GEL = create(CRItems.TIMEFIX_GEL)
            .unlockedBy(CRItems.TIMEFIX_BOTTLE)
            .viaShapeless(b -> b.requires(CRItems.TIMEFIX_BOTTLE));

    private Marker TOOLS = enterFolder("tools");

    GeneratedRecipe

    NONSPARKING_SWORD = create(CRItems.NONSPARKING_SWORD)
            .unlockedBy(CRItems.BERYLLIUM_BRONZE_INGOT)
            .viaBerylliumBronzeSmithing(() -> Items.IRON_SWORD, () -> Ingredient.of(CRItems.BERYLLIUM_BRONZE_SHEET)),

    NONSPARKING_SHOVEL = create(CRItems.NONSPARKING_SHOVEL)
            .unlockedBy(CRItems.BERYLLIUM_BRONZE_INGOT)
            .viaBerylliumBronzeSmithing(() -> Items.IRON_SHOVEL, () -> Ingredient.of(CRItems.BERYLLIUM_BRONZE_SHEET)),

    NONSPARKING_PICKAXE = create(CRItems.NONSPARKING_PICKAXE)
            .unlockedBy(CRItems.BERYLLIUM_BRONZE_INGOT)
            .viaBerylliumBronzeSmithing(() -> Items.IRON_PICKAXE, () -> Ingredient.of(CRItems.BERYLLIUM_BRONZE_SHEET)),

    NONSPARKING_AXE = create(CRItems.NONSPARKING_AXE)
            .unlockedBy(CRItems.BERYLLIUM_BRONZE_INGOT)
            .viaBerylliumBronzeSmithing(() -> Items.IRON_AXE, () -> Ingredient.of(CRItems.BERYLLIUM_BRONZE_SHEET)),

    NONSPARKING_HOE = create(CRItems.NONSPARKING_HOE)
            .unlockedBy(CRItems.BERYLLIUM_BRONZE_INGOT)
            .viaBerylliumBronzeSmithing(() -> Items.IRON_HOE, () -> Ingredient.of(CRItems.BERYLLIUM_BRONZE_SHEET)),

    BERYLLIUM_BRONZE_SMITHING_TEMPLATE_REPLICATE = create(CRItems.BERYLLIUM_BRONZE_SMITHING_TEMPLATE)
            .withSuffix("_replicate").unlockedBy(CRItems.BERYLLIUM_BRONZE_INGOT)
            .returns(2)
            .viaShaped(b -> b.define('S', AllItems.STURDY_SHEET)
                    .define('C', commonItemTag("ingots/brass"))
                    .define('T', CRItems.BERYLLIUM_BRONZE_SMITHING_TEMPLATE)
                    .pattern("CTC")
                    .pattern("CSC")
                    .pattern("CCC")),

    BERYLLIUM_BRONZE_SMITHING_TEMPLATE = create(CRItems.BERYLLIUM_BRONZE_SMITHING_TEMPLATE)
            .unlockedBy(CRItems.BERYLLIUM_BRONZE_INGOT)
            .viaShaped(b -> b.define('S', AllBlocks.RAILWAY_CASING)
            .define('C', commonItemTag("storage_blocks/brass"))
                    .pattern("SCS")
                    .pattern("SCS")
                    .pattern("SSS"));




    /*
     * End of recipe list
     */

    static class Marker {
    }

    String currentFolder = "";

    Marker enterFolder(String folder) {
        currentFolder = folder;
        return new Marker();
    }

    GeneratedRecipeBuilder create(Supplier<ItemLike> result) {
        return new GeneratedRecipeBuilder(currentFolder, result);
    }

    GeneratedRecipeBuilder create(ItemProviderEntry<? extends ItemLike, ? extends ItemLike> result) {
        return create(result::get);
    }

    GeneratedRecipe createSpecial(Function<CraftingBookCategory, Recipe<?>> builder, String recipeType,
                                  String path) {
        ResourceLocation location = CreateRocketry.crloc(recipeType + "/" + currentFolder + "/" + path);
        return register(consumer -> {
            SpecialRecipeBuilder b = SpecialRecipeBuilder.special(builder);
            b.save(consumer, location.toString());
        });
    }

    GeneratedRecipe blastCrushedMetal(Supplier<? extends ItemLike> result, Supplier<? extends ItemLike> ingredient) {
        return create(result::get).withSuffix("_from_crushed")
                .viaCooking(ingredient)
                .rewardXP(.1f)
                .inBlastFurnace();
    }

    GeneratedRecipe metalCompacting(List<ItemProviderEntry<? extends ItemLike, ? extends ItemLike>> variants,
                                    List<Supplier<TagKey<Item>>> ingredients) {
        GeneratedRecipe result = null;
        for (int i = 0; i + 1 < variants.size(); i++) {
            ItemProviderEntry<? extends ItemLike, ? extends ItemLike> currentEntry = variants.get(i);
            ItemProviderEntry<? extends ItemLike, ? extends ItemLike> nextEntry = variants.get(i + 1);
            Supplier<TagKey<Item>> currentIngredient = ingredients.get(i);
            Supplier<TagKey<Item>> nextIngredient = ingredients.get(i + 1);

            result = create(nextEntry).withSuffix("_from_compacting")
                    .unlockedBy(currentEntry::get)
                    .viaShaped(b -> b.pattern("###")
                            .pattern("###")
                            .pattern("###")
                            .define('#', currentIngredient.get()));

            result = create(currentEntry).returns(9)
                    .withSuffix("_from_decompacting")
                    .unlockedBy(nextEntry::get)
                    .viaShapeless(b -> b.requires(nextIngredient.get()));
        }
        return result;
    }

    GeneratedRecipe conversionCycle(List<ItemProviderEntry<? extends ItemLike, ? extends ItemLike>> cycle) {
        GeneratedRecipe result = null;
        for (int i = 0; i < cycle.size(); i++) {
            ItemProviderEntry<? extends ItemLike, ? extends ItemLike> currentEntry = cycle.get(i);
            ItemProviderEntry<? extends ItemLike, ? extends ItemLike> nextEntry = cycle.get((i + 1) % cycle.size());
            result = create(nextEntry).withSuffix("_from_conversion")
                    .unlockedBy(currentEntry::get)
                    .viaShapeless(b -> b.requires(currentEntry.get()));
        }
        return result;
    }

    GeneratedRecipe clearData(ItemProviderEntry<? extends ItemLike, ? extends ItemLike> item) {
        return create(item).withSuffix("_clear")
                .unlockedBy(item::get)
                .viaShapeless(b -> b.requires(item.get()));
    }

    @Override
    public void buildRecipes(RecipeOutput output) {
        all.forEach(c -> c.register(output));
        CreateRocketry.LOGGER.info("{} registered {} recipe{}", getName(), all.size(), all.size() == 1 ? "" : "s");
    }

    protected GeneratedRecipe register(GeneratedRecipe recipe) {
        all.add(recipe);
        return recipe;
    }

    class GeneratedRecipeBuilder {

        private String path;
        private String suffix;
        private Supplier<? extends ItemLike> result;
        List<ICondition> recipeConditions;

        private Supplier<ItemPredicate> unlockedBy;
        private int amount;

        private GeneratedRecipeBuilder(String path) {
            this.path = path;
            this.recipeConditions = new ArrayList<>();
            this.suffix = "";
            this.amount = 1;
        }

        public GeneratedRecipeBuilder(String path, Supplier<? extends ItemLike> result) {
            this(path);
            this.result = result;
        }

        GeneratedRecipeBuilder returns(int amount) {
            this.amount = amount;
            return this;
        }

        GeneratedRecipeBuilder unlockedBy(Supplier<? extends ItemLike> item) {
            this.unlockedBy = () -> ItemPredicate.Builder.item()
                    .of(item.get())
                    .build();
            return this;
        }

        GeneratedRecipeBuilder unlockedByTag(Supplier<TagKey<Item>> tag) {
            this.unlockedBy = () -> ItemPredicate.Builder.item()
                    .of(tag.get())
                    .build();
            return this;
        }

        GeneratedRecipeBuilder whenModLoaded(String modid) {
            return withCondition(new ModLoadedCondition(modid));
        }

        GeneratedRecipeBuilder whenModMissing(String modid) {
            return withCondition(new NotCondition(new ModLoadedCondition(modid)));
        }

        GeneratedRecipeBuilder withCondition(ICondition condition) {
            recipeConditions.add(condition);
            return this;
        }

        GeneratedRecipeBuilder withSuffix(String suffix) {
            this.suffix = suffix;
            return this;
        }

        GeneratedRecipe viaShaped(UnaryOperator<ShapedRecipeBuilder> builder) {
            return register(consumer -> {
                ShapedRecipeBuilder b =
                        builder.apply(ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result.get(), amount));
                if (unlockedBy != null)
                    b.unlockedBy("has_item", inventoryTrigger(unlockedBy.get()));
                b.save(consumer, createLocation("crafting"));
            });
        }

        GeneratedRecipe viaShapeless(UnaryOperator<ShapelessRecipeBuilder> builder) {
            return register(recipeOutput -> {
                ShapelessRecipeBuilder b =
                        builder.apply(ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, result.get(), amount));
                if (unlockedBy != null)
                    b.unlockedBy("has_item", inventoryTrigger(unlockedBy.get()));

                RecipeOutput conditionalOutput = recipeOutput.withConditions(recipeConditions.toArray(new ICondition[0]));

                b.save(recipeOutput, createLocation("crafting"));
            });
        }

        GeneratedRecipe viaNetheriteSmithing(Supplier<? extends Item> base, Supplier<Ingredient> upgradeMaterial) {
            return register(consumer -> {
                SmithingTransformRecipeBuilder b =
                        SmithingTransformRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.of(base.get()), upgradeMaterial.get(), RecipeCategory.COMBAT, result.get()
                                        .asItem());
                b.unlocks("has_item", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(base.get())
                        .build()));
                b.save(consumer, createLocation("crafting"));
            });
        }

        GeneratedRecipe viaBerylliumBronzeSmithing(Supplier<? extends Item> base, Supplier<Ingredient> upgradeMaterial) {
            return register(consumer -> {
                SmithingTransformRecipeBuilder b =
                        SmithingTransformRecipeBuilder.smithing(Ingredient.of(CRItems.BERYLLIUM_BRONZE_SMITHING_TEMPLATE),
                                Ingredient.of(base.get()), upgradeMaterial.get(), RecipeCategory.COMBAT, result.get()
                                        .asItem());
                b.unlocks("has_item", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(base.get())
                        .build()));
                b.save(consumer, createLocation("crafting"));
            });
        }

        private ResourceLocation createSimpleLocation(String recipeType) {
            return CreateRocketry.crloc(recipeType + "/" + getRegistryName().getPath() + suffix);
        }

        private ResourceLocation createLocation(String recipeType) {
            return CreateRocketry.crloc(recipeType + "/" + path + "/" + getRegistryName().getPath() + suffix);
        }

        private ResourceLocation getRegistryName() {
            return RegisteredObjectsHelper.getKeyOrThrow(result.get().asItem());
        }

        GeneratedCookingRecipeBuilder viaCooking(Supplier<? extends ItemLike> item) {
            return unlockedBy(item).viaCookingIngredient(() -> Ingredient.of(item.get()));
        }

        GeneratedCookingRecipeBuilder viaCookingTag(Supplier<TagKey<Item>> tag) {
            return unlockedByTag(tag).viaCookingIngredient(() -> Ingredient.of(tag.get()));
        }

        GeneratedCookingRecipeBuilder viaCookingIngredient(Supplier<Ingredient> ingredient) {
            return new GeneratedCookingRecipeBuilder(ingredient);
        }

        class GeneratedCookingRecipeBuilder {

            private Supplier<Ingredient> ingredient;
            private float exp;
            private int cookingTime;

            GeneratedCookingRecipeBuilder(Supplier<Ingredient> ingredient) {
                this.ingredient = ingredient;
                cookingTime = 200;
                exp = 0;
            }

            GeneratedCookingRecipeBuilder forDuration(int duration) {
                cookingTime = duration;
                return this;
            }

            GeneratedCookingRecipeBuilder rewardXP(float xp) {
                exp = xp;
                return this;
            }

            GeneratedRecipe inFurnace() {
                return inFurnace(b -> b);
            }

            GeneratedRecipe inFurnace(UnaryOperator<SimpleCookingRecipeBuilder> builder) {
                return create(RecipeSerializer.SMELTING_RECIPE, builder, SmeltingRecipe::new, 1);
            }

            GeneratedRecipe inSmoker() {
                return inSmoker(b -> b);
            }

            GeneratedRecipe inSmoker(UnaryOperator<SimpleCookingRecipeBuilder> builder) {
                create(RecipeSerializer.SMELTING_RECIPE, builder, SmeltingRecipe::new, 1);
                create(RecipeSerializer.CAMPFIRE_COOKING_RECIPE, builder, CampfireCookingRecipe::new, 3);
                return create(RecipeSerializer.SMOKING_RECIPE, builder, SmokingRecipe::new, .5f);
            }

            GeneratedRecipe inBlastFurnace() {
                return inBlastFurnace(b -> b);
            }

            GeneratedRecipe inBlastFurnace(UnaryOperator<SimpleCookingRecipeBuilder> builder) {
                create(RecipeSerializer.SMELTING_RECIPE, builder, SmeltingRecipe::new, 1);
                return create(RecipeSerializer.BLASTING_RECIPE, builder, BlastingRecipe::new, .5f);
            }

            private <T extends AbstractCookingRecipe> GeneratedRecipe create(RecipeSerializer<T> serializer,
                                                                             UnaryOperator<SimpleCookingRecipeBuilder> builder, AbstractCookingRecipe.Factory<T> factory, float cookingTimeModifier) {
                return register(recipeOutput -> {
                    SimpleCookingRecipeBuilder b = builder.apply(SimpleCookingRecipeBuilder.generic(ingredient.get(),
                            RecipeCategory.MISC, result.get(), exp,
                            (int) (cookingTime * cookingTimeModifier), serializer, factory));
                    if (unlockedBy != null)
                        b.unlockedBy("has_item", inventoryTrigger(unlockedBy.get()));

                    RecipeOutput conditionalOutput = recipeOutput.withConditions(recipeConditions.toArray(new ICondition[0]));

                    b.save(conditionalOutput, createSimpleLocation(RegisteredObjectsHelper.getKeyOrThrow(serializer).getPath())
                    );
                });
            }
        }
    }

    @Override
    public String getName() {
        return "Create: Rocketry's Standard Recipes";
    }

    public CRStandardRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateRocketry.MODID);
    }
}

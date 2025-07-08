package com.mwk.createrocketry.content.equipment.tool;

import com.mwk.createrocketry.CreateRocketry;
import com.mwk.createrocketry.registries.CRItems;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public enum CRToolMaterials implements Tier {

    BERYLLIUM_BRONZE(CreateRocketry.crloc("beryllium_bronze").toString(), BlockTags.INCORRECT_FOR_IRON_TOOL, 750, 7.0F, 2.5F, 18, () -> Ingredient.of(CRItems.BERYLLIUM_BRONZE_INGOT));

    public final String name;

    private final TagKey<Block> incorrectBlocksForDrops;
    private final int uses;
    private final float speed;
    private final float damageBonus;
    private final int enchantValue;
    private final Supplier<Ingredient> repairMaterial;


    CRToolMaterials(String name, @NotNull TagKey<Block> incorrectBlocksForDrops, int uses, float speed, float damageBonus, int enchantValue,
                    Supplier<Ingredient> repairMaterial) {
        this.name = name;
        this.incorrectBlocksForDrops = incorrectBlocksForDrops;
        this.uses = uses;
        this.speed = speed;
        this.damageBonus = damageBonus;
        this.enchantValue = enchantValue;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getUses() {
        return uses;
    }

    @Override
    public float getSpeed() {
        return speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return damageBonus;
    }

    @Override
    public @NotNull TagKey<Block> getIncorrectBlocksForDrops() {
        return incorrectBlocksForDrops;
    }

    @Override
    public int getEnchantmentValue() {
        return enchantValue;
    }

    @Override
    public @NotNull Ingredient getRepairIngredient() {
        return repairMaterial.get();
    }
}

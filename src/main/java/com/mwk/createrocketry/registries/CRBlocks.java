package com.mwk.createrocketry.registries;

import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;

import static com.mwk.createrocketry.CreateRocketry.REGISTRATE;
import static com.simibubi.create.foundation.data.TagGen.*;

public class CRBlocks {

    static {
        REGISTRATE.setCreativeTab(CRCreativeTabs.BASE_CREATIVE_TAB);
    }

    public static final BlockEntry<Block> BERYLLIUM_BLOCK = REGISTRATE
            .block("beryllium_block", Block::new)
            .initialProperties(() -> Blocks.EMERALD_BLOCK)
            .transform(pickaxeOnly())
            .tag(BlockTags.NEEDS_IRON_TOOL)
            .tag(Tags.Blocks.STORAGE_BLOCKS)
            .transform(tagBlockAndItem("storage_blocks/beryllium"))
            .tag(Tags.Items.STORAGE_BLOCKS)
            .build()
            .register();

    public static final BlockEntry<Block> BERYLLIUM_BRONZE_BLOCK = REGISTRATE
            .block("beryllium_bronze_block", Block::new)
            .initialProperties(() -> Blocks.EMERALD_BLOCK)
            .transform(pickaxeOnly())
            .tag(BlockTags.NEEDS_IRON_TOOL)
            .tag(Tags.Blocks.STORAGE_BLOCKS)
            .transform(tagBlockAndItem("storage_blocks/beryllium_bronze"))
            .tag(Tags.Items.STORAGE_BLOCKS)
            .build()
            .register();


    public static void register() {}
}

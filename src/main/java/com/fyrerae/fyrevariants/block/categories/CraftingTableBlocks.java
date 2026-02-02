package com.fyrerae.fyrevariants.block.categories;

import com.fyrerae.fyrevariants.block.custom.FyreCraftingTableBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;

public class CraftingTableBlocks extends BaseBlockCategory {
    public static final DeferredBlock<Block> ACACIA_CRAFTING_TABLE;
    public static final DeferredBlock<Block> BAMBOO_CRAFTING_TABLE;
    public static final DeferredBlock<Block> BIRCH_CRAFTING_TABLE;
    public static final DeferredBlock<Block> CHERRY_CRAFTING_TABLE;
    public static final DeferredBlock<Block> CRIMSON_CRAFTING_TABLE;
    public static final DeferredBlock<Block> DARK_OAK_CRAFTING_TABLE;
    public static final DeferredBlock<Block> JUNGLE_CRAFTING_TABLE;
    public static final DeferredBlock<Block> MANGROVE_CRAFTING_TABLE;
    // Oak Crafting Table - Vanilla
    public static final DeferredBlock<Block> SPRUCE_CRAFTING_TABLE;
    public static final DeferredBlock<Block> WARPED_CRAFTING_TABLE;

    static {
        ACACIA_CRAFTING_TABLE = registerCraftingTable("acacia_crafting_table", true);
        BAMBOO_CRAFTING_TABLE = registerCraftingTable("bamboo_crafting_table", true);
        BIRCH_CRAFTING_TABLE = registerCraftingTable("birch_crafting_table", true);
        CHERRY_CRAFTING_TABLE = registerCraftingTable("cherry_crafting_table", true);
        CRIMSON_CRAFTING_TABLE = registerCraftingTable("crimson_crafting_table", false);
        DARK_OAK_CRAFTING_TABLE = registerCraftingTable("dark_oak_crafting_table", true);
        JUNGLE_CRAFTING_TABLE = registerCraftingTable("jungle_crafting_table", true);
        MANGROVE_CRAFTING_TABLE = registerCraftingTable("mangrove_crafting_table", true);
        // Oak Crafting Table - Vanilla
        SPRUCE_CRAFTING_TABLE = registerCraftingTable("spruce_crafting_table", true);
        WARPED_CRAFTING_TABLE = registerCraftingTable("warped_crafting_table", false);
    }

    public static void init() { }

    private static DeferredBlock<Block> registerCraftingTable(String name, boolean flammable) {
        return registerBlock(name, () -> createCraftingTable(flammable));
    }

    private static Block createCraftingTable(boolean flammable) {
        BlockBehaviour.Properties props = BlockBehaviour.Properties.of()
                .mapColor(MapColor.WOOD)
                .instrument(NoteBlockInstrument.BASS)
                .strength(2.5F)
                .sound(SoundType.WOOD);

        if (flammable) props.ignitedByLava();
        return new FyreCraftingTableBlock(props);
    }
}
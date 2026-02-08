package com.fyrerae.fyrevariants.block.categories;

import com.fyrerae.fyrevariants.block.custom.FyreFletchingTableBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;

public class FletchingTableBlocks extends BaseBlockCategory {
    public static final DeferredBlock<Block> ACACIA_FLETCHING_TABLE;
    public static final DeferredBlock<Block> BAMBOO_FLETCHING_TABLE;
    // Birch Fletching Table - Vanilla
    public static final DeferredBlock<Block> CHERRY_FLETCHING_TABLE;
    public static final DeferredBlock<Block> CRIMSON_FLETCHING_TABLE;
    public static final DeferredBlock<Block> DARK_OAK_FLETCHING_TABLE;
    public static final DeferredBlock<Block> JUNGLE_FLETCHING_TABLE;
    public static final DeferredBlock<Block> MANGROVE_FLETCHING_TABLE;
    public static final DeferredBlock<Block> OAK_FLETCHING_TABLE;
    public static final DeferredBlock<Block> SPRUCE_FLETCHING_TABLE;
    public static final DeferredBlock<Block> WARPED_FLETCHING_TABLE;

    static {
        ACACIA_FLETCHING_TABLE = registerFletchingTable("acacia_fletching_table", true);
        BAMBOO_FLETCHING_TABLE = registerFletchingTable("bamboo_fletching_table", true);
        // Birch Fletching Table - Vanilla
        CHERRY_FLETCHING_TABLE = registerFletchingTable("cherry_fletching_table", true);
        CRIMSON_FLETCHING_TABLE = registerFletchingTable("crimson_fletching_table", false);
        DARK_OAK_FLETCHING_TABLE = registerFletchingTable("dark_oak_fletching_table", true);
        JUNGLE_FLETCHING_TABLE = registerFletchingTable("jungle_fletching_table", true);
        MANGROVE_FLETCHING_TABLE = registerFletchingTable("mangrove_fletching_table", true);
        OAK_FLETCHING_TABLE = registerFletchingTable("oak_fletching_table", true);
        SPRUCE_FLETCHING_TABLE = registerFletchingTable("spruce_fletching_table", true);
        WARPED_FLETCHING_TABLE = registerFletchingTable("warped_fletching_table", false);
    }

    public static void init() { }

    private static DeferredBlock<Block> registerFletchingTable(String name, boolean flammable) {
        return registerBlock(name, () -> createFletchingTable(flammable));
    }

    private static Block createFletchingTable(boolean flammable) {
        BlockBehaviour.Properties props = BlockBehaviour.Properties.of()
                .mapColor(MapColor.WOOD)
                .instrument(NoteBlockInstrument.BASS)
                .strength(2.5f)
                .sound(SoundType.WOOD);

        if (flammable) props.ignitedByLava();
        return new FyreFletchingTableBlock(props);
    }
}

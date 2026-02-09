package com.fyrerae.fyrevariants.block.categories;

import com.fyrerae.fyrevariants.block.custom.FyreCartographyTableBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;

public class CartographyTableBlocks extends BaseBlockCategory {
    public static final DeferredBlock<Block> ACACIA_CARTOGRAPHY_TABLE;
    public static final DeferredBlock<Block> BAMBOO_CARTOGRAPHY_TABLE;
    public static final DeferredBlock<Block> BIRCH_CARTOGRAPHY_TABLE;
    public static final DeferredBlock<Block> CHERRY_CARTOGRAPHY_TABLE;
    public static final DeferredBlock<Block> CRIMSON_CARTOGRAPHY_TABLE;
    // Dark Oak - Vanilla
    public static final DeferredBlock<Block> JUNGLE_CARTOGRAPHY_TABLE;
    public static final DeferredBlock<Block> MANGROVE_CARTOGRAPHY_TABLE;
    public static final DeferredBlock<Block> OAK_CARTOGRAPHY_TABLE;
    public static final DeferredBlock<Block> SPRUCE_CARTOGRAPHY_TABLE;
    public static final DeferredBlock<Block> WARPED_CARTOGRAPHY_TABLE;

    static {
        ACACIA_CARTOGRAPHY_TABLE = registerCartographyTable("acacia_cartography_table", true);
        BAMBOO_CARTOGRAPHY_TABLE = registerCartographyTable("bamboo_cartography_table", true);
        BIRCH_CARTOGRAPHY_TABLE = registerCartographyTable("birch_cartography_table", true);
        CHERRY_CARTOGRAPHY_TABLE = registerCartographyTable("cherry_cartography_table", true);
        CRIMSON_CARTOGRAPHY_TABLE = registerCartographyTable("crimson_cartography_table", false);
        // Dark Oak - Vanilla
        JUNGLE_CARTOGRAPHY_TABLE = registerCartographyTable("jungle_cartography_table", true);
        MANGROVE_CARTOGRAPHY_TABLE = registerCartographyTable("mangrove_cartography_table", true);
        OAK_CARTOGRAPHY_TABLE = registerCartographyTable("oak_cartography_table", true);
        SPRUCE_CARTOGRAPHY_TABLE = registerCartographyTable("spruce_cartography_table", true);
        WARPED_CARTOGRAPHY_TABLE = registerCartographyTable("warped_cartography_table", false);
    }

    public static void init() { }

    private static DeferredBlock<Block> registerCartographyTable(String name, boolean flammable) {
        return registerBlock(name, () -> createCartographyTable(flammable));
    }

    private static Block createCartographyTable(boolean flammable) {
        BlockBehaviour.Properties props = BlockBehaviour.Properties.of()
                .mapColor(MapColor.WOOD)
                .instrument(NoteBlockInstrument.BASS)
                .strength(2.5F)
                .sound(SoundType.WOOD);

        if (flammable) props.ignitedByLava();
        return new FyreCartographyTableBlock(props);
    }
}

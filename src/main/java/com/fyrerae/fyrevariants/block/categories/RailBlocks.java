package com.fyrerae.fyrevariants.block.categories;

import com.fyrerae.fyrevariants.block.custom.FyreRailBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;

public class RailBlocks extends BaseBlockCategory {
    public static final DeferredBlock<Block> ACACIA_RAIL;
    public static final DeferredBlock<Block> BAMBOO_RAIL;
    public static final DeferredBlock<Block> BIRCH_RAIL;
    public static final DeferredBlock<Block> CHERRY_RAIL;
    public static final DeferredBlock<Block> CRIMSON_RAIL;
    public static final DeferredBlock<Block> DARK_OAK_RAIL;
    public static final DeferredBlock<Block> JUNGLE_RAIL;
    public static final DeferredBlock<Block> MANGROVE_RAIL;
    // Oak Rail - Vanilla
    public static final DeferredBlock<Block> SPRUCE_RAIL;
    public static final DeferredBlock<Block> WARPED_RAIL;

    static {
        ACACIA_RAIL = registerRail("acacia_rail", true);
        BAMBOO_RAIL = registerRail("bamboo_rail", true);
        BIRCH_RAIL = registerRail("birch_rail", true);
        CHERRY_RAIL = registerRail("cherry_rail", true);
        CRIMSON_RAIL = registerRail("crimson_rail", false);
        DARK_OAK_RAIL = registerRail("dark_oak_rail", true);
        JUNGLE_RAIL = registerRail("jungle_rail", true);
        MANGROVE_RAIL = registerRail("mangrove_rail", true);
        // Oak Rail - Vanilla
        SPRUCE_RAIL = registerRail("spruce_rail", true);
        WARPED_RAIL = registerRail("warped_rail", false);
    }

    public static void init() { }

    private static DeferredBlock<Block> registerRail(String name, boolean flammable) {
        return registerBlock(name, () -> createRail(flammable));
    }

    private static Block createRail(boolean flammable) {
        BlockBehaviour.Properties props = BlockBehaviour.Properties.of()
                .mapColor(MapColor.NONE)
                .noCollission()
                .strength(0.7F)
                .sound(SoundType.METAL);

        if (flammable) props.ignitedByLava();
        return new FyreRailBlock(props);
    }
}
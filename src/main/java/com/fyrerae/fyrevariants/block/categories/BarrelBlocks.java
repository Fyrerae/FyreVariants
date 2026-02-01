package com.fyrerae.fyrevariants.block.categories;

import com.fyrerae.fyrevariants.block.custom.FyreBarrelBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;

public class BarrelBlocks extends BaseBlockCategory {
    public static final DeferredBlock<Block> ACACIA_BARREL;
    public static final DeferredBlock<Block> BAMBOO_BARREL;
    public static final DeferredBlock<Block> BIRCH_BARREL;
    public static final DeferredBlock<Block> CHERRY_BARREL;
    public static final DeferredBlock<Block> CRIMSON_BARREL;
    public static final DeferredBlock<Block> DARK_OAK_BARREL;
    public static final DeferredBlock<Block> JUNGLE_BARREL;
    public static final DeferredBlock<Block> MANGROVE_BARREL;
    public static final DeferredBlock<Block> OAK_BARREL;
    // Spruce Barrel - Vanilla
    public static final DeferredBlock<Block> WARPED_BARREL;

    static {
        ACACIA_BARREL = registerBarrel("acacia_barrel", true);
        BAMBOO_BARREL = registerBarrel("bamboo_barrel", true);
        BIRCH_BARREL = registerBarrel("birch_barrel", true);
        CHERRY_BARREL = registerBarrel("cherry_barrel", true);
        CRIMSON_BARREL = registerBarrel("crimson_barrel", false);
        DARK_OAK_BARREL = registerBarrel("dark_oak_barrel", true);
        JUNGLE_BARREL = registerBarrel("jungle_barrel", true);
        MANGROVE_BARREL = registerBarrel("mangrove_barrel", true);
        OAK_BARREL = registerBarrel("oak_barrel", true);
        // Spruce Barrel - Vanilla
        WARPED_BARREL = registerBarrel("warped_barrel", false);
    }

    public static void init() { }

    private static DeferredBlock<Block> registerBarrel(String name, boolean flammable) {
        return registerBlock(name, () -> createBarrel(flammable));
    }

    private static Block createBarrel(boolean flammable) {
        BlockBehaviour.Properties props = BlockBehaviour.Properties.of()
                .mapColor(MapColor.WOOD)
                .instrument(NoteBlockInstrument.BASS)
                .strength(2.5f)
                .sound(SoundType.WOOD);

        if (flammable) props.ignitedByLava();
        return new FyreBarrelBlock(props);
    }
}
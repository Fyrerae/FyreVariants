package com.fyrerae.fyrevariants.block.categories;

import com.fyrerae.fyrevariants.block.custom.FyreComposterBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ComposterBlocks extends BaseBlockCategory {
    public static final DeferredBlock<Block> ACACIA_COMPOSTER;
    public static final DeferredBlock<Block> BAMBOO_COMPOSTER;
    public static final DeferredBlock<Block> BIRCH_COMPOSTER;
    public static final DeferredBlock<Block> CHERRY_COMPOSTER;
    public static final DeferredBlock<Block> CRIMSON_COMPOSTER;
    public static final DeferredBlock<Block> DARK_OAK_COMPOSTER;
    public static final DeferredBlock<Block> JUNGLE_COMPOSTER;
    public static final DeferredBlock<Block> MANGROVE_COMPOSTER;
    public static final DeferredBlock<Block> OAK_COMPOSTER;
    public static final DeferredBlock<Block> WARPED_COMPOSTER;

    static {
        ACACIA_COMPOSTER = registerComposter("acacia_composter", true);
        BAMBOO_COMPOSTER = registerComposter("bamboo_composter", true);
        BIRCH_COMPOSTER = registerComposter("birch_composter", true);
        CHERRY_COMPOSTER = registerComposter("cherry_composter", true);
        CRIMSON_COMPOSTER = registerComposter("crimson_composter", false);
        DARK_OAK_COMPOSTER = registerComposter("dark_oak_composter", true);
        JUNGLE_COMPOSTER = registerComposter("jungle_composter", true);
        MANGROVE_COMPOSTER = registerComposter("mangrove_composter", true);
        OAK_COMPOSTER = registerComposter("oak_composter", true);
        WARPED_COMPOSTER = registerComposter("warped_composter", false);
    }

    public static void init() { }

    private static DeferredBlock<Block> registerComposter(String name, boolean flammable) {
        return registerBlock(name, () -> createComposter(flammable));
    }

    private static Block createComposter(boolean flammable) {
        BlockBehaviour.Properties props = BlockBehaviour.Properties.of()
                .mapColor(MapColor.WOOD)
                .instrument(NoteBlockInstrument.BASS)
                .strength(0.6F)
                .sound(SoundType.WOOD)
                .noOcclusion();

        if (flammable) props.ignitedByLava();
        return new FyreComposterBlock(props);
    }
}
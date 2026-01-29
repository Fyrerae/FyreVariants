package com.fyrerae.fyrevariants.block.categories;

import com.fyrerae.fyrevariants.block.custom.FyreLadderBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;

public class LadderBlocks extends BaseBlockCategory {
    public static final DeferredBlock<Block> ACACIA_LADDER;
    public static final DeferredBlock<Block> BAMBOO_LADDER;
    public static final DeferredBlock<Block> BIRCH_LADDER;
    public static final DeferredBlock<Block> CHERRY_LADDER;
    public static final DeferredBlock<Block> CRIMSON_LADDER;
    public static final DeferredBlock<Block> DARK_OAK_LADDER;
    public static final DeferredBlock<Block> JUNGLE_LADDER;
    public static final DeferredBlock<Block> MANGROVE_LADDER;
    public static final DeferredBlock<Block> SPRUCE_LADDER;
    public static final DeferredBlock<Block> WARPED_LADDER;

    static {
        ACACIA_LADDER = registerLadder("acacia_ladder", true);
        BAMBOO_LADDER = registerLadder("bamboo_ladder", true);
        BIRCH_LADDER = registerLadder("birch_ladder", true);
        CHERRY_LADDER = registerLadder("cherry_ladder", true);
        CRIMSON_LADDER = registerLadder("crimson_ladder", false);
        DARK_OAK_LADDER = registerLadder("dark_oak_ladder", true);
        JUNGLE_LADDER = registerLadder("jungle_ladder", true);
        MANGROVE_LADDER = registerLadder("mangrove_ladder", true);
        SPRUCE_LADDER = registerLadder("spruce_ladder", true);
        WARPED_LADDER = registerLadder("warped_ladder", false);
    }

    public static void init() { }

    private static DeferredBlock<Block> registerLadder(String name, boolean flammable) {
        return registerBlock(name, () -> createLadder(flammable));
    }

    private static Block createLadder(boolean flammable) {
        BlockBehaviour.Properties props = BlockBehaviour.Properties.of()
                .mapColor(MapColor.WOOD)
                .instrument(NoteBlockInstrument.BASS)
                .strength(0.4F)
                .sound(SoundType.LADDER)
                .noOcclusion()
                .isValidSpawn((state, level, pos, entity) -> false)
                .isRedstoneConductor((state, level, pos) -> false);

        if (flammable) props.ignitedByLava();
        return new FyreLadderBlock(props);
    }
}
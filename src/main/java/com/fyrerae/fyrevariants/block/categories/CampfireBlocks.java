package com.fyrerae.fyrevariants.block.categories;

import com.fyrerae.fyrevariants.block.custom.FyreCampfireBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;

public class CampfireBlocks extends BaseBlockCategory {
    public static final DeferredBlock<Block> ACACIA_CAMPFIRE;
    public static final DeferredBlock<Block> BAMBOO_CAMPFIRE;
    public static final DeferredBlock<Block> BIRCH_CAMPFIRE;
    public static final DeferredBlock<Block> CHERRY_CAMPFIRE;
    public static final DeferredBlock<Block> CRIMSON_CAMPFIRE;
    public static final DeferredBlock<Block> DARK_OAK_CAMPFIRE;
    public static final DeferredBlock<Block> JUNGLE_CAMPFIRE;
    public static final DeferredBlock<Block> MANGROVE_CAMPFIRE;
    // Oak Campfire - Vanilla
    public static final DeferredBlock<Block> SPRUCE_CAMPFIRE;
    public static final DeferredBlock<Block> WARPED_CAMPFIRE;

    static {
        ACACIA_CAMPFIRE = registerCampfire("acacia_campfire", false);
        BAMBOO_CAMPFIRE = registerCampfire("bamboo_campfire", false);
        BIRCH_CAMPFIRE = registerCampfire("birch_campfire", false);
        CHERRY_CAMPFIRE = registerCampfire("cherry_campfire", false);
        CRIMSON_CAMPFIRE = registerCampfire("crimson_campfire", false);
        DARK_OAK_CAMPFIRE = registerCampfire("dark_oak_campfire", false);
        JUNGLE_CAMPFIRE = registerCampfire("jungle_campfire", false);
        MANGROVE_CAMPFIRE = registerCampfire("mangrove_campfire", false);
        // Oak Campfire - Vanilla
        SPRUCE_CAMPFIRE = registerCampfire("spruce_campfire", false);
        WARPED_CAMPFIRE = registerCampfire("warped_campfire", false);
    }

    public static void init() { }

    private static DeferredBlock<Block> registerCampfire(String name, boolean flammable) {
        return registerBlock(name, () -> createCampfire(flammable));
    }

    private static Block createCampfire(boolean flammable) {
        BlockBehaviour.Properties props = BlockBehaviour.Properties.of()
                .mapColor(MapColor.PODZOL)
                .instrument(NoteBlockInstrument.BASS)
                .strength(2.0F)
                .sound(SoundType.WOOD)
                .lightLevel(state -> state.getValue(FyreCampfireBlock.LIT) ? 15 : 0)
                .noOcclusion();

        if (flammable) props.ignitedByLava();
        return new FyreCampfireBlock(true, 1, props);
    }
}

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

    public static final DeferredBlock<Block> ACACIA_SOUL_CAMPFIRE;
    public static final DeferredBlock<Block> BAMBOO_SOUL_CAMPFIRE;
    public static final DeferredBlock<Block> BIRCH_SOUL_CAMPFIRE;
    public static final DeferredBlock<Block> CHERRY_SOUL_CAMPFIRE;
    public static final DeferredBlock<Block> CRIMSON_SOUL_CAMPFIRE;
    public static final DeferredBlock<Block> DARK_OAK_SOUL_CAMPFIRE;
    public static final DeferredBlock<Block> JUNGLE_SOUL_CAMPFIRE;
    public static final DeferredBlock<Block> MANGROVE_SOUL_CAMPFIRE;
    // Soul Oak Campfire - Vanilla
    public static final DeferredBlock<Block> SPRUCE_SOUL_CAMPFIRE;
    public static final DeferredBlock<Block> WARPED_SOUL_CAMPFIRE;

    static {
        ACACIA_CAMPFIRE = registerCampfire("acacia_campfire", false, false);
        BAMBOO_CAMPFIRE = registerCampfire("bamboo_campfire", false, false);
        BIRCH_CAMPFIRE = registerCampfire("birch_campfire", false, false);
        CHERRY_CAMPFIRE = registerCampfire("cherry_campfire", false, false);
        CRIMSON_CAMPFIRE = registerCampfire("crimson_campfire", false, false);
        DARK_OAK_CAMPFIRE = registerCampfire("dark_oak_campfire", false, false);
        JUNGLE_CAMPFIRE = registerCampfire("jungle_campfire", false, false);
        MANGROVE_CAMPFIRE = registerCampfire("mangrove_campfire", false, false);
        // Oak Campfire - Vanilla
        SPRUCE_CAMPFIRE = registerCampfire("spruce_campfire", false, false);
        WARPED_CAMPFIRE = registerCampfire("warped_campfire", false, false);

        ACACIA_SOUL_CAMPFIRE = registerCampfire("acacia_soul_campfire", false, true);
        BAMBOO_SOUL_CAMPFIRE = registerCampfire("bamboo_soul_campfire", false, true);
        BIRCH_SOUL_CAMPFIRE = registerCampfire("birch_soul_campfire", false, true);
        CHERRY_SOUL_CAMPFIRE = registerCampfire("cherry_soul_campfire", false, true);
        CRIMSON_SOUL_CAMPFIRE = registerCampfire("crimson_soul_campfire", false, true);
        DARK_OAK_SOUL_CAMPFIRE = registerCampfire("dark_oak_soul_campfire", false, true);
        JUNGLE_SOUL_CAMPFIRE = registerCampfire("jungle_soul_campfire", false, true);
        MANGROVE_SOUL_CAMPFIRE = registerCampfire("mangrove_soul_campfire", false, true);
        // Soul Oak Campfire - Vanilla
        SPRUCE_SOUL_CAMPFIRE = registerCampfire("spruce_soul_campfire", false, true);
        WARPED_SOUL_CAMPFIRE = registerCampfire("warped_soul_campfire", false, true);
    }

    public static void init() { }

    private static DeferredBlock<Block> registerCampfire(String name, boolean flammable, boolean isSoulCampfire) {
        return registerBlock(name, () -> createCampfire(flammable, isSoulCampfire));
    }


    private static Block createCampfire(boolean flammable, boolean isSoulCampfire) {
        int lightLevel = isSoulCampfire ? 10 : 15;
        int fireDamage = isSoulCampfire ? 2 : 1;

        BlockBehaviour.Properties props = BlockBehaviour.Properties.of()
                .mapColor(MapColor.PODZOL)
                .instrument(NoteBlockInstrument.BASS)
                .strength(2.0F)
                .sound(SoundType.WOOD)
                .lightLevel(state -> state.getValue(FyreCampfireBlock.LIT) ? lightLevel : 0)
                .noOcclusion();

        if (flammable) props.ignitedByLava();
        return new FyreCampfireBlock(true, fireDamage, props);
    }
}

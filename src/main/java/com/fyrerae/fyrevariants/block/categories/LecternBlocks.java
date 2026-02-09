package com.fyrerae.fyrevariants.block.categories;

import com.fyrerae.fyrevariants.block.custom.FyreLecternBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;

public class LecternBlocks extends BaseBlockCategory {
    public static final DeferredBlock<Block> ACACIA_LECTERN;
    public static final DeferredBlock<Block> BAMBOO_LECTERN;
    public static final DeferredBlock<Block> BIRCH_LECTERN;
    public static final DeferredBlock<Block> CHERRY_LECTERN;
    public static final DeferredBlock<Block> CRIMSON_LECTERN;
    public static final DeferredBlock<Block> DARK_OAK_LECTERN;
    public static final DeferredBlock<Block> JUNGLE_LECTERN;
    public static final DeferredBlock<Block> MANGROVE_LECTERN;
    // Oak - Vanilla
    public static final DeferredBlock<Block> SPRUCE_LECTERN;
    public static final DeferredBlock<Block> WARPED_LECTERN;

    static {
        ACACIA_LECTERN = registerLectern("acacia_lectern", true);
        BAMBOO_LECTERN = registerLectern("bamboo_lectern", true);
        BIRCH_LECTERN = registerLectern("birch_lectern", true);
        CHERRY_LECTERN = registerLectern("cherry_lectern", true);
        CRIMSON_LECTERN = registerLectern("crimson_lectern", false);
        DARK_OAK_LECTERN = registerLectern("dark_oak_lectern", true);
        JUNGLE_LECTERN = registerLectern("jungle_lectern", true);
        MANGROVE_LECTERN = registerLectern("mangrove_lectern", true);
        // Oak - Vanilla
        SPRUCE_LECTERN = registerLectern("spruce_lectern", true);
        WARPED_LECTERN = registerLectern("warped_lectern", false);
    }

    public static void init() { }

    private static DeferredBlock<Block> registerLectern(String name, boolean flammable) {
        return registerBlock(name, () -> createLectern(flammable));
    }

    private static Block createLectern(boolean flammable) {
        BlockBehaviour.Properties props = BlockBehaviour.Properties.of()
                .mapColor(MapColor.WOOD)
                .instrument(NoteBlockInstrument.BASS)
                .strength(2.5F)
                .sound(SoundType.WOOD);

        if (flammable) props.ignitedByLava();
        return new FyreLecternBlock(props);
    }
}
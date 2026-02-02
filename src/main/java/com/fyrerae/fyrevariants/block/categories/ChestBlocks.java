package com.fyrerae.fyrevariants.block.categories;

import com.fyrerae.fyrevariants.block.custom.FyreChestBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ChestBlocks extends BaseBlockCategory {
    public static final DeferredBlock<Block> ACACIA_CHEST;
    public static final DeferredBlock<Block> BAMBOO_CHEST;
    public static final DeferredBlock<Block> BIRCH_CHEST;
    public static final DeferredBlock<Block> CHERRY_CHEST;
    public static final DeferredBlock<Block> CRIMSON_CHEST;
    public static final DeferredBlock<Block> DARK_OAK_CHEST;
    public static final DeferredBlock<Block> JUNGLE_CHEST;
    public static final DeferredBlock<Block> MANGROVE_CHEST;
    // Oak Chest - Vanilla
    public static final DeferredBlock<Block> SPRUCE_CHEST;
    public static final DeferredBlock<Block> WARPED_CHEST;

    static {
        ACACIA_CHEST = registerChest("acacia_chest", true);
        BAMBOO_CHEST = registerChest("bamboo_chest", true);
        BIRCH_CHEST = registerChest("birch_chest", true);
        CHERRY_CHEST = registerChest("cherry_chest", true);
        CRIMSON_CHEST = registerChest("crimson_chest", false);
        DARK_OAK_CHEST = registerChest("dark_oak_chest", true);
        JUNGLE_CHEST = registerChest("jungle_chest", true);
        MANGROVE_CHEST = registerChest("mangrove_chest", true);
        // Oak Chest - Vanilla
        SPRUCE_CHEST = registerChest("spruce_chest", true);
        WARPED_CHEST = registerChest("warped_chest", false);
    }

    public static void init() { }

    private static DeferredBlock<Block> registerChest(String name, boolean flammable) {
        return registerBlock(name, () -> createChest(flammable));
    }

    private static Block createChest(boolean flammable) {
        BlockBehaviour.Properties props = BlockBehaviour.Properties.of()
                .mapColor(MapColor.WOOD)
                .instrument(NoteBlockInstrument.BASS)
                .strength(2.5F)
                .sound(SoundType.WOOD);

        if (flammable) props.ignitedByLava();
        return new FyreChestBlock(props);
    }
}
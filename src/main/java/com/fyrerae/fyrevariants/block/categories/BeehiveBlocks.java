package com.fyrerae.fyrevariants.block.categories;

import com.fyrerae.fyrevariants.block.custom.FyreBeehiveBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;

public class BeehiveBlocks extends BaseBlockCategory {
    public static final DeferredBlock<Block> ACACIA_BEEHIVE;
    public static final DeferredBlock<Block> BAMBOO_BEEHIVE;
    public static final DeferredBlock<Block> BIRCH_BEEHIVE;
    public static final DeferredBlock<Block> CHERRY_BEEHIVE;
    public static final DeferredBlock<Block> CRIMSON_BEEHIVE;
    public static final DeferredBlock<Block> DARK_OAK_BEEHIVE;
    public static final DeferredBlock<Block> JUNGLE_BEEHIVE;
    public static final DeferredBlock<Block> MANGROVE_BEEHIVE;
    public static final DeferredBlock<Block> SPRUCE_BEEHIVE;
    public static final DeferredBlock<Block> WARPED_BEEHIVE;

    static {
        ACACIA_BEEHIVE = registerBeehive("acacia_beehive", true);
        BAMBOO_BEEHIVE = registerBeehive("bamboo_beehive", true);
        BIRCH_BEEHIVE = registerBeehive("birch_beehive", true);
        CHERRY_BEEHIVE = registerBeehive("cherry_beehive", true);
        CRIMSON_BEEHIVE = registerBeehive("crimson_beehive", false);
        DARK_OAK_BEEHIVE = registerBeehive("dark_oak_beehive", true);
        JUNGLE_BEEHIVE = registerBeehive("jungle_beehive", true);
        MANGROVE_BEEHIVE = registerBeehive("mangrove_beehive", true);
        SPRUCE_BEEHIVE = registerBeehive("spruce_beehive", true);
        WARPED_BEEHIVE = registerBeehive("warped_beehive", false);
    }

    public static void init() { }

    private static DeferredBlock<Block> registerBeehive(String name, boolean flammable) {
        return registerBlock(name, () -> createBeehive(flammable));
    }

    private static Block createBeehive(boolean flammable) {
        BlockBehaviour.Properties props = BlockBehaviour.Properties.of()
                .mapColor(MapColor.WOOD)
                .instrument(NoteBlockInstrument.BASS)
                .strength(0.6f)
                .sound(SoundType.WOOD);

        if (flammable) props.ignitedByLava();
        return new FyreBeehiveBlock(props);
    }
}

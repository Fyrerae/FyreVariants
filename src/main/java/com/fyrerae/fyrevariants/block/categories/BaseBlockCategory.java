package com.fyrerae.fyrevariants.block.categories;

import com.fyrerae.fyrevariants.block.FyreBlocks;
import com.fyrerae.fyrevariants.item.FyreItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.function.Supplier;

public abstract class BaseBlockCategory {
    protected static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = FyreBlocks.BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        FyreItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
}
package com.fyrerae.fyrevariants.utils;

import com.fyrerae.fyrevariants.block.categories.*;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class FyreCreativeTabs {
    private static final Map<ResourceKey<CreativeModeTab>, Consumer<BuildCreativeModeTabContentsEvent>> TAB_HANDLERS = new HashMap<>();

    static {
        registerTabHandler(CreativeModeTabs.FUNCTIONAL_BLOCKS, FyreCreativeTabs::addFunctionalBlocks);
        registerTabHandler(CreativeModeTabs.BUILDING_BLOCKS, FyreCreativeTabs::addBuildingBlocks);
        registerTabHandler(CreativeModeTabs.REDSTONE_BLOCKS, FyreCreativeTabs::addRedstoneBlocks);
    }

    private static void registerTabHandler(ResourceKey<CreativeModeTab> tab, Consumer<BuildCreativeModeTabContentsEvent> handler) {
        TAB_HANDLERS.put(tab, handler);
    }

    public static void addCreative(BuildCreativeModeTabContentsEvent event) {
        Consumer<BuildCreativeModeTabContentsEvent> handler = TAB_HANDLERS.get(event.getTabKey());
        if (handler != null) handler.accept(event);
    }

    public static void addRedstoneBlocks(BuildCreativeModeTabContentsEvent event) {
        addBlocksFromClass(event, ComposterBlocks.class);
        addBlocksFromClass(event, BarrelBlocks.class);
        addBlocksFromClass(event, ChestBlocks.class);
        addBlocksFromClass(event, RailBlocks.class);
    }

    public static void addFunctionalBlocks(BuildCreativeModeTabContentsEvent event) {
        addBlocksFromClass(event, LadderBlocks.class);
        addBlocksFromClass(event, ComposterBlocks.class);
        addBlocksFromClass(event, CraftingTableBlocks.class);
        addBlocksFromClass(event, BarrelBlocks.class);
        addBlocksFromClass(event, ChestBlocks.class);
    }

    private static void addBuildingBlocks(BuildCreativeModeTabContentsEvent event) {

    }

    private static void addBlocksFromClass(BuildCreativeModeTabContentsEvent event, Class<?> blockClass) {
        try {
            for (Field field : blockClass.getDeclaredFields()) {
                if (field.getType() == DeferredBlock.class) {
                    field.setAccessible(true);
                    DeferredBlock<Block> block = (DeferredBlock<Block>) field.get(null);
                    event.accept(block);
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Failed to add blocks from class: " + blockClass.getName(), e);
        }
    }
}
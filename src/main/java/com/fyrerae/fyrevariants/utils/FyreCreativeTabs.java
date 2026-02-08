package com.fyrerae.fyrevariants.utils;

import com.fyrerae.fyrevariants.block.categories.*;
import com.fyrerae.fyrevariants.item.MinecartItems;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@SuppressWarnings("unchecked")
public class FyreCreativeTabs {
    private static final Map<ResourceKey<CreativeModeTab>, Consumer<BuildCreativeModeTabContentsEvent>> TAB_HANDLERS = new HashMap<>();

    static {
        registerTabHandler(CreativeModeTabs.FUNCTIONAL_BLOCKS, FyreCreativeTabs::addFunctionalBlocks);
        registerTabHandler(CreativeModeTabs.BUILDING_BLOCKS, FyreCreativeTabs::addBuildingBlocks);
        registerTabHandler(CreativeModeTabs.REDSTONE_BLOCKS, FyreCreativeTabs::addRedstoneBlocks);
        registerTabHandler(CreativeModeTabs.TOOLS_AND_UTILITIES, FyreCreativeTabs::addToolsUtilities);
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
        addItemsFromClass(event, MinecartItems.class);
    }

    public static void addToolsUtilities(BuildCreativeModeTabContentsEvent event) {
        addBlocksFromClass(event, RailBlocks.class);
        addItemsFromClass(event, MinecartItems.class);
    }

    public static void addFunctionalBlocks(BuildCreativeModeTabContentsEvent event) {
        addBlocksFromClass(event, LadderBlocks.class);
        addBlocksFromClass(event, ComposterBlocks.class);
        addBlocksFromClass(event, CraftingTableBlocks.class);
        addBlocksFromClass(event, BarrelBlocks.class);
        addBlocksFromClass(event, ChestBlocks.class);
        addBlocksFromClass(event, CampfireBlocks.class);
        addBlocksFromClass(event, BeehiveBlocks.class);
        addBlocksFromClass(event, FletchingTableBlocks.class);
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

    private static void addItemsFromClass(BuildCreativeModeTabContentsEvent event, Class<?> itemClass) {
        try {
            for (Field field : itemClass.getDeclaredFields()) {
                if (field.getType() == DeferredItem.class) {
                    field.setAccessible(true);
                    DeferredItem<?> item = (DeferredItem<?>) field.get(null);
                    event.accept(item);
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Failed to add items from class: " + itemClass.getName(), e);
        }
    }
}
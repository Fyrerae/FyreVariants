package com.fyrerae.fyrevariants.client;

import com.fyrerae.fyrevariants.block.categories.LadderBlocks;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class FyreCreativeTabs {
    private static final Map<ResourceKey<CreativeModeTab>, Consumer<BuildCreativeModeTabContentsEvent>> TAB_HANDLERS = new HashMap<>();

    static {
        registerTabHandler(CreativeModeTabs.FUNCTIONAL_BLOCKS, FyreCreativeTabs::addFunctionalBlocks);
        registerTabHandler(CreativeModeTabs.BUILDING_BLOCKS, FyreCreativeTabs::addBuildingBlocks);
    }

    private static void registerTabHandler(ResourceKey<CreativeModeTab> tab, Consumer<BuildCreativeModeTabContentsEvent> handler) {
        TAB_HANDLERS.put(tab, handler);
    }

    public static void addCreative(BuildCreativeModeTabContentsEvent event) {
        Consumer<BuildCreativeModeTabContentsEvent> handler = TAB_HANDLERS.get(event.getTabKey());
        if (handler != null) handler.accept(event);
    }

    public static void addFunctionalBlocks(BuildCreativeModeTabContentsEvent event) {
        event.accept(LadderBlocks.ACACIA_LADDER);
        event.accept(LadderBlocks.BAMBOO_LADDER);
        event.accept(LadderBlocks.BIRCH_LADDER);
        event.accept(LadderBlocks.CHERRY_LADDER);
        event.accept(LadderBlocks.CRIMSON_LADDER);
        event.accept(LadderBlocks.DARK_OAK_LADDER);
        event.accept(LadderBlocks.JUNGLE_LADDER);
        event.accept(LadderBlocks.MANGROVE_LADDER);
        event.accept(LadderBlocks.SPRUCE_LADDER);
        event.accept(LadderBlocks.WARPED_LADDER);
    }

    private static void addBuildingBlocks(BuildCreativeModeTabContentsEvent event) {

    }
}
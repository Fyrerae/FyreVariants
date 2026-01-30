package com.fyrerae.fyrevariants.utils;

import com.fyrerae.fyrevariants.block.categories.BarrelBlocks;
import com.fyrerae.fyrevariants.block.categories.ComposterBlocks;
import com.fyrerae.fyrevariants.block.categories.CraftingTableBlocks;
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
        event.accept(ComposterBlocks.ACACIA_COMPOSTER);
        event.accept(ComposterBlocks.BAMBOO_COMPOSTER);
        event.accept(ComposterBlocks.BIRCH_COMPOSTER);
        event.accept(ComposterBlocks.CHERRY_COMPOSTER);
        event.accept(ComposterBlocks.CRIMSON_COMPOSTER);
        event.accept(ComposterBlocks.DARK_OAK_COMPOSTER);
        event.accept(ComposterBlocks.JUNGLE_COMPOSTER);
        event.accept(ComposterBlocks.MANGROVE_COMPOSTER);
        event.accept(ComposterBlocks.OAK_COMPOSTER);
        event.accept(ComposterBlocks.WARPED_COMPOSTER);
        event.accept(BarrelBlocks.ACACIA_BARREL);
        event.accept(BarrelBlocks.BAMBOO_BARREL);
        event.accept(BarrelBlocks.BIRCH_BARREL);
        event.accept(BarrelBlocks.CHERRY_BARREL);
        event.accept(BarrelBlocks.CRIMSON_BARREL);
        event.accept(BarrelBlocks.DARK_OAK_BARREL);
        event.accept(BarrelBlocks.JUNGLE_BARREL);
        event.accept(BarrelBlocks.MANGROVE_BARREL);
        event.accept(BarrelBlocks.OAK_BARREL);
        event.accept(BarrelBlocks.WARPED_BARREL);
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
        event.accept(ComposterBlocks.ACACIA_COMPOSTER);
        event.accept(ComposterBlocks.BAMBOO_COMPOSTER);
        event.accept(ComposterBlocks.BIRCH_COMPOSTER);
        event.accept(ComposterBlocks.CHERRY_COMPOSTER);
        event.accept(ComposterBlocks.CRIMSON_COMPOSTER);
        event.accept(ComposterBlocks.DARK_OAK_COMPOSTER);
        event.accept(ComposterBlocks.JUNGLE_COMPOSTER);
        event.accept(ComposterBlocks.MANGROVE_COMPOSTER);
        event.accept(ComposterBlocks.OAK_COMPOSTER);
        event.accept(ComposterBlocks.WARPED_COMPOSTER);
        event.accept(CraftingTableBlocks.ACACIA_CRAFTING_TABLE);
        event.accept(CraftingTableBlocks.BAMBOO_CRAFTING_TABLE);
        event.accept(CraftingTableBlocks.BIRCH_CRAFTING_TABLE);
        event.accept(CraftingTableBlocks.CHERRY_CRAFTING_TABLE);
        event.accept(CraftingTableBlocks.CRIMSON_CRAFTING_TABLE);
        event.accept(CraftingTableBlocks.DARK_OAK_CRAFTING_TABLE);
        event.accept(CraftingTableBlocks.JUNGLE_CRAFTING_TABLE);
        event.accept(CraftingTableBlocks.MANGROVE_CRAFTING_TABLE);
        event.accept(CraftingTableBlocks.SPRUCE_CRAFTING_TABLE);
        event.accept(CraftingTableBlocks.WARPED_CRAFTING_TABLE);
        event.accept(BarrelBlocks.ACACIA_BARREL);
        event.accept(BarrelBlocks.BAMBOO_BARREL);
        event.accept(BarrelBlocks.BIRCH_BARREL);
        event.accept(BarrelBlocks.CHERRY_BARREL);
        event.accept(BarrelBlocks.CRIMSON_BARREL);
        event.accept(BarrelBlocks.DARK_OAK_BARREL);
        event.accept(BarrelBlocks.JUNGLE_BARREL);
        event.accept(BarrelBlocks.MANGROVE_BARREL);
        event.accept(BarrelBlocks.OAK_BARREL);
        event.accept(BarrelBlocks.WARPED_BARREL);
    }

    private static void addBuildingBlocks(BuildCreativeModeTabContentsEvent event) {

    }
}
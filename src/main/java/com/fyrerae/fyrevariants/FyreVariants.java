package com.fyrerae.fyrevariants;

import com.fyrerae.fyrevariants.block.FyreBlocks;
import com.fyrerae.fyrevariants.item.FyreItems;
import com.fyrerae.fyrevariants.client.FyreCreativeTabs;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(FyreVariants.MOD_ID)
public class FyreVariants {
    public static final String MOD_ID = "fyrevariants";

    public FyreVariants(IEventBus modEventBus) {
        FyreItems.register(modEventBus);
        FyreBlocks.register(modEventBus);
        modEventBus.addListener(FyreCreativeTabs::addCreative);
    }
}
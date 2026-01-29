package com.fyrerae.fyrevariants.item;

import com.fyrerae.fyrevariants.FyreVariants;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class FyreItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(FyreVariants.MOD_ID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
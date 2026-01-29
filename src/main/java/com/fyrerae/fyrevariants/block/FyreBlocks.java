package com.fyrerae.fyrevariants.block;

import com.fyrerae.fyrevariants.FyreVariants;
import com.fyrerae.fyrevariants.block.categories.LadderBlocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class FyreBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(FyreVariants.MOD_ID);

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);

        LadderBlocks.init();
    }
}
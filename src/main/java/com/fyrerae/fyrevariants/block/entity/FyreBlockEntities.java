package com.fyrerae.fyrevariants.block.entity;

import com.fyrerae.fyrevariants.FyreVariants;
import com.fyrerae.fyrevariants.block.categories.BarrelBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class FyreBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, FyreVariants.MOD_ID);

    public static final Supplier<BlockEntityType<FyreBarrelBlockEntity>> BARREL = BLOCK_ENTITIES.register("barrel",
            () -> BlockEntityType.Builder.of(FyreBarrelBlockEntity::new,
                    BarrelBlocks.ACACIA_BARREL.get(),
                    BarrelBlocks.BAMBOO_BARREL.get(),
                    BarrelBlocks.BIRCH_BARREL.get(),
                    BarrelBlocks.CHERRY_BARREL.get(),
                    BarrelBlocks.CRIMSON_BARREL.get(),
                    BarrelBlocks.DARK_OAK_BARREL.get(),
                    BarrelBlocks.JUNGLE_BARREL.get(),
                    BarrelBlocks.MANGROVE_BARREL.get(),
                    BarrelBlocks.OAK_BARREL.get(),
                    BarrelBlocks.WARPED_BARREL.get()
            ).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
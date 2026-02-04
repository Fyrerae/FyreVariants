package com.fyrerae.fyrevariants.block.entity;

import com.fyrerae.fyrevariants.FyreVariants;
import com.fyrerae.fyrevariants.block.categories.BarrelBlocks;
import com.fyrerae.fyrevariants.block.categories.CampfireBlocks;
import com.fyrerae.fyrevariants.block.categories.ChestBlocks;
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

    public static final Supplier<BlockEntityType<FyreChestBlockEntity>> CHEST = BLOCK_ENTITIES.register("chest",
            () -> BlockEntityType.Builder.of(FyreChestBlockEntity::new,
                    ChestBlocks.ACACIA_CHEST.get(),
                    ChestBlocks.BAMBOO_CHEST.get(),
                    ChestBlocks.BIRCH_CHEST.get(),
                    ChestBlocks.CHERRY_CHEST.get(),
                    ChestBlocks.CRIMSON_CHEST.get(),
                    ChestBlocks.DARK_OAK_CHEST.get(),
                    ChestBlocks.JUNGLE_CHEST.get(),
                    ChestBlocks.MANGROVE_CHEST.get(),
                    ChestBlocks.SPRUCE_CHEST.get(),
                    ChestBlocks.WARPED_CHEST.get()
            ).build(null));

    public static final Supplier<BlockEntityType<FyreCampfireBlockEntity>> CAMPFIRE = BLOCK_ENTITIES.register("campfire",
            () -> BlockEntityType.Builder.of(FyreCampfireBlockEntity::new,
                    CampfireBlocks.ACACIA_CAMPFIRE.get(),
                    CampfireBlocks.BAMBOO_CAMPFIRE.get(),
                    CampfireBlocks.BIRCH_CAMPFIRE.get(),
                    CampfireBlocks.CHERRY_CAMPFIRE.get(),
                    CampfireBlocks.CRIMSON_CAMPFIRE.get(),
                    CampfireBlocks.DARK_OAK_CAMPFIRE.get(),
                    CampfireBlocks.JUNGLE_CAMPFIRE.get(),
                    CampfireBlocks.MANGROVE_CAMPFIRE.get(),
                    CampfireBlocks.SPRUCE_CAMPFIRE.get(),
                    CampfireBlocks.WARPED_CAMPFIRE.get(),
                    CampfireBlocks.ACACIA_SOUL_CAMPFIRE.get(),
                    CampfireBlocks.BAMBOO_SOUL_CAMPFIRE.get(),
                    CampfireBlocks.BIRCH_SOUL_CAMPFIRE.get(),
                    CampfireBlocks.CHERRY_SOUL_CAMPFIRE.get(),
                    CampfireBlocks.CRIMSON_SOUL_CAMPFIRE.get(),
                    CampfireBlocks.DARK_OAK_SOUL_CAMPFIRE.get(),
                    CampfireBlocks.JUNGLE_SOUL_CAMPFIRE.get(),
                    CampfireBlocks.MANGROVE_SOUL_CAMPFIRE.get(),
                    CampfireBlocks.SPRUCE_SOUL_CAMPFIRE.get(),
                    CampfireBlocks.WARPED_SOUL_CAMPFIRE.get()
            ).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
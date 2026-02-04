package com.fyrerae.fyrevariants.entity;

import com.fyrerae.fyrevariants.FyreVariants;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class FyreEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(Registries.ENTITY_TYPE, FyreVariants.MOD_ID);

    public static final DeferredHolder<EntityType<?>, EntityType<FyreMinecartEntity>> COPPER_MINECART =
            ENTITY_TYPES.register("copper_minecart", () -> EntityType.Builder.<FyreMinecartEntity>of(
                    FyreMinecartEntity::new,
                    MobCategory.MISC
            ).sized(0.98F, 0.7F).clientTrackingRange(8).build("copper_minecart"));

    public static final DeferredHolder<EntityType<?>, EntityType<FyreMinecartEntity>> GOLD_MINECART =
            ENTITY_TYPES.register("gold_minecart", () -> EntityType.Builder.<FyreMinecartEntity>of(
                    FyreMinecartEntity::new,
                    MobCategory.MISC
            ).sized(0.98F, 0.7F).clientTrackingRange(8).build("gold_minecart"));

    public static final DeferredHolder<EntityType<?>, EntityType<FyreMinecartEntity>> DIAMOND_MINECART =
            ENTITY_TYPES.register("diamond_minecart", () -> EntityType.Builder.<FyreMinecartEntity>of(
                    FyreMinecartEntity::new,
                    MobCategory.MISC
            ).sized(0.98F, 0.7F).clientTrackingRange(8).build("diamond_minecart"));

    public static final DeferredHolder<EntityType<?>, EntityType<FyreMinecartEntity>> NETHERITE_MINECART =
            ENTITY_TYPES.register("netherite_minecart", () -> EntityType.Builder.<FyreMinecartEntity>of(
                    FyreMinecartEntity::new,
                    MobCategory.MISC
            ).sized(0.98F, 0.7F).clientTrackingRange(8).build("netherite_minecart"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
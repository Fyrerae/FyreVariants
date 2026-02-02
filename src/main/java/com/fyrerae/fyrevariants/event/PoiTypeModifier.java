package com.fyrerae.fyrevariants.event;

import com.fyrerae.fyrevariants.FyreVariants;
import com.fyrerae.fyrevariants.block.categories.BarrelBlocks;
import com.fyrerae.fyrevariants.block.categories.ComposterBlocks;
import com.google.common.collect.ImmutableSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.ai.village.poi.PoiTypes;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.RegisterEvent;

import java.util.HashSet;
import java.util.Set;

@EventBusSubscriber(modid = FyreVariants.MOD_ID)
public class PoiTypeModifier {

    @SubscribeEvent
    public static void modifyPoiTypes(RegisterEvent event) {
        event.register(Registries.POINT_OF_INTEREST_TYPE, registry -> {
            // Farmer
            Set<BlockState> composterStates = new HashSet<>();
            composterStates.addAll(ComposterBlocks.ACACIA_COMPOSTER.get().getStateDefinition().getPossibleStates());
            composterStates.addAll(ComposterBlocks.BAMBOO_COMPOSTER.get().getStateDefinition().getPossibleStates());
            composterStates.addAll(ComposterBlocks.BIRCH_COMPOSTER.get().getStateDefinition().getPossibleStates());
            composterStates.addAll(ComposterBlocks.CHERRY_COMPOSTER.get().getStateDefinition().getPossibleStates());
            composterStates.addAll(ComposterBlocks.CRIMSON_COMPOSTER.get().getStateDefinition().getPossibleStates());
            composterStates.addAll(ComposterBlocks.DARK_OAK_COMPOSTER.get().getStateDefinition().getPossibleStates());
            composterStates.addAll(ComposterBlocks.JUNGLE_COMPOSTER.get().getStateDefinition().getPossibleStates());
            composterStates.addAll(ComposterBlocks.MANGROVE_COMPOSTER.get().getStateDefinition().getPossibleStates());
            composterStates.addAll(ComposterBlocks.OAK_COMPOSTER.get().getStateDefinition().getPossibleStates());
            composterStates.addAll(ComposterBlocks.WARPED_COMPOSTER.get().getStateDefinition().getPossibleStates());

            registry.register(PoiTypes.FARMER, new PoiType(ImmutableSet.copyOf(composterStates), 1, 1));

            // Fisherman
            Set<BlockState> barrelStates = new HashSet<>();
            barrelStates.addAll(BarrelBlocks.ACACIA_BARREL.get().getStateDefinition().getPossibleStates());
            barrelStates.addAll(BarrelBlocks.BAMBOO_BARREL.get().getStateDefinition().getPossibleStates());
            barrelStates.addAll(BarrelBlocks.BIRCH_BARREL.get().getStateDefinition().getPossibleStates());
            barrelStates.addAll(BarrelBlocks.CHERRY_BARREL.get().getStateDefinition().getPossibleStates());
            barrelStates.addAll(BarrelBlocks.CRIMSON_BARREL.get().getStateDefinition().getPossibleStates());
            barrelStates.addAll(BarrelBlocks.DARK_OAK_BARREL.get().getStateDefinition().getPossibleStates());
            barrelStates.addAll(BarrelBlocks.JUNGLE_BARREL.get().getStateDefinition().getPossibleStates());
            barrelStates.addAll(BarrelBlocks.MANGROVE_BARREL.get().getStateDefinition().getPossibleStates());
            barrelStates.addAll(BarrelBlocks.OAK_BARREL.get().getStateDefinition().getPossibleStates());
            barrelStates.addAll(BarrelBlocks.WARPED_BARREL.get().getStateDefinition().getPossibleStates());

            registry.register(PoiTypes.FISHERMAN, new PoiType(ImmutableSet.copyOf(barrelStates), 1, 1));
        });
    }
}
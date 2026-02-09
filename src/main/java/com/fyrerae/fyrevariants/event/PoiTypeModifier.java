package com.fyrerae.fyrevariants.event;

import com.fyrerae.fyrevariants.FyreVariants;
import com.fyrerae.fyrevariants.block.categories.*;
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
            // Farmer - Composters
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

            // Fisherman - Barrels
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

            // Fletcher - Fletching Tables
            Set<BlockState> fletchingTableStates = new HashSet<>();
            fletchingTableStates.addAll(FletchingTableBlocks.ACACIA_FLETCHING_TABLE.get().getStateDefinition().getPossibleStates());
            fletchingTableStates.addAll(FletchingTableBlocks.BAMBOO_FLETCHING_TABLE.get().getStateDefinition().getPossibleStates());
            fletchingTableStates.addAll(FletchingTableBlocks.CHERRY_FLETCHING_TABLE.get().getStateDefinition().getPossibleStates());
            fletchingTableStates.addAll(FletchingTableBlocks.CRIMSON_FLETCHING_TABLE.get().getStateDefinition().getPossibleStates());
            fletchingTableStates.addAll(FletchingTableBlocks.DARK_OAK_FLETCHING_TABLE.get().getStateDefinition().getPossibleStates());
            fletchingTableStates.addAll(FletchingTableBlocks.JUNGLE_FLETCHING_TABLE.get().getStateDefinition().getPossibleStates());
            fletchingTableStates.addAll(FletchingTableBlocks.MANGROVE_FLETCHING_TABLE.get().getStateDefinition().getPossibleStates());
            fletchingTableStates.addAll(FletchingTableBlocks.OAK_FLETCHING_TABLE.get().getStateDefinition().getPossibleStates());
            fletchingTableStates.addAll(FletchingTableBlocks.SPRUCE_FLETCHING_TABLE.get().getStateDefinition().getPossibleStates());
            fletchingTableStates.addAll(FletchingTableBlocks.WARPED_FLETCHING_TABLE.get().getStateDefinition().getPossibleStates());

            registry.register(PoiTypes.FLETCHER, new PoiType(ImmutableSet.copyOf(fletchingTableStates), 1, 1));

            // Cartographer - Cartography Tables
            Set<BlockState> cartographyTableStates = new HashSet<>();
            cartographyTableStates.addAll(CartographyTableBlocks.ACACIA_CARTOGRAPHY_TABLE.get().getStateDefinition().getPossibleStates());
            cartographyTableStates.addAll(CartographyTableBlocks.BAMBOO_CARTOGRAPHY_TABLE.get().getStateDefinition().getPossibleStates());
            cartographyTableStates.addAll(CartographyTableBlocks.BIRCH_CARTOGRAPHY_TABLE.get().getStateDefinition().getPossibleStates());
            cartographyTableStates.addAll(CartographyTableBlocks.CHERRY_CARTOGRAPHY_TABLE.get().getStateDefinition().getPossibleStates());
            cartographyTableStates.addAll(CartographyTableBlocks.CRIMSON_CARTOGRAPHY_TABLE.get().getStateDefinition().getPossibleStates());
            cartographyTableStates.addAll(CartographyTableBlocks.JUNGLE_CARTOGRAPHY_TABLE.get().getStateDefinition().getPossibleStates());
            cartographyTableStates.addAll(CartographyTableBlocks.MANGROVE_CARTOGRAPHY_TABLE.get().getStateDefinition().getPossibleStates());
            cartographyTableStates.addAll(CartographyTableBlocks.OAK_CARTOGRAPHY_TABLE.get().getStateDefinition().getPossibleStates());
            cartographyTableStates.addAll(CartographyTableBlocks.SPRUCE_CARTOGRAPHY_TABLE.get().getStateDefinition().getPossibleStates());
            cartographyTableStates.addAll(CartographyTableBlocks.WARPED_CARTOGRAPHY_TABLE.get().getStateDefinition().getPossibleStates());

            registry.register(PoiTypes.CARTOGRAPHER, new PoiType(ImmutableSet.copyOf(cartographyTableStates), 1, 1));

            // Librarian - Lecterns
            Set<BlockState> lecternStates = new HashSet<>();
            lecternStates.addAll(LecternBlocks.ACACIA_LECTERN.get().getStateDefinition().getPossibleStates());
            lecternStates.addAll(LecternBlocks.BAMBOO_LECTERN.get().getStateDefinition().getPossibleStates());
            lecternStates.addAll(LecternBlocks.BIRCH_LECTERN.get().getStateDefinition().getPossibleStates());
            lecternStates.addAll(LecternBlocks.CHERRY_LECTERN.get().getStateDefinition().getPossibleStates());
            lecternStates.addAll(LecternBlocks.CRIMSON_LECTERN.get().getStateDefinition().getPossibleStates());
            lecternStates.addAll(LecternBlocks.DARK_OAK_LECTERN.get().getStateDefinition().getPossibleStates());
            lecternStates.addAll(LecternBlocks.JUNGLE_LECTERN.get().getStateDefinition().getPossibleStates());
            lecternStates.addAll(LecternBlocks.MANGROVE_LECTERN.get().getStateDefinition().getPossibleStates());
            lecternStates.addAll(LecternBlocks.SPRUCE_LECTERN.get().getStateDefinition().getPossibleStates());
            lecternStates.addAll(LecternBlocks.WARPED_LECTERN.get().getStateDefinition().getPossibleStates());

            registry.register(PoiTypes.LIBRARIAN, new PoiType(ImmutableSet.copyOf(lecternStates), 1, 1));

            // Bees - Beehives
            Set<BlockState> beehiveStates = new HashSet<>();
            beehiveStates.addAll(BeehiveBlocks.ACACIA_BEEHIVE.get().getStateDefinition().getPossibleStates());
            beehiveStates.addAll(BeehiveBlocks.BAMBOO_BEEHIVE.get().getStateDefinition().getPossibleStates());
            beehiveStates.addAll(BeehiveBlocks.BIRCH_BEEHIVE.get().getStateDefinition().getPossibleStates());
            beehiveStates.addAll(BeehiveBlocks.CHERRY_BEEHIVE.get().getStateDefinition().getPossibleStates());
            beehiveStates.addAll(BeehiveBlocks.CRIMSON_BEEHIVE.get().getStateDefinition().getPossibleStates());
            beehiveStates.addAll(BeehiveBlocks.DARK_OAK_BEEHIVE.get().getStateDefinition().getPossibleStates());
            beehiveStates.addAll(BeehiveBlocks.JUNGLE_BEEHIVE.get().getStateDefinition().getPossibleStates());
            beehiveStates.addAll(BeehiveBlocks.MANGROVE_BEEHIVE.get().getStateDefinition().getPossibleStates());
            beehiveStates.addAll(BeehiveBlocks.SPRUCE_BEEHIVE.get().getStateDefinition().getPossibleStates());
            beehiveStates.addAll(BeehiveBlocks.WARPED_BEEHIVE.get().getStateDefinition().getPossibleStates());

            registry.register(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath(FyreVariants.MOD_ID, "beehive"),
                    new PoiType(ImmutableSet.copyOf(beehiveStates), 0, 1));
        });
    }
}
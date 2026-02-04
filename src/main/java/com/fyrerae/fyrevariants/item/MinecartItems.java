package com.fyrerae.fyrevariants.item;

import com.fyrerae.fyrevariants.FyreVariants;
import com.fyrerae.fyrevariants.entity.FyreEntityTypes;
import com.fyrerae.fyrevariants.entity.FyreMinecartEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseRailBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.RailShape;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

@SuppressWarnings("deprecation")
public class MinecartItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(FyreVariants.MOD_ID);

    public static final DeferredItem<Item> COPPER_MINECART;
    public static final DeferredItem<Item> GOLD_MINECART;
    public static final DeferredItem<Item> DIAMOND_MINECART;
    public static final DeferredItem<Item> NETHERITE_MINECART;

    static {
        COPPER_MINECART = registerMinecart("copper_minecart", "copper", false);
        GOLD_MINECART = registerMinecart("gold_minecart", "gold", false);
        DIAMOND_MINECART = registerMinecart("diamond_minecart", "diamond", false);
        NETHERITE_MINECART = registerMinecart("netherite_minecart", "netherite", true);
    }

    private static DeferredItem<Item> registerMinecart(String name, String variantType, boolean fireResistant) {
        return ITEMS.register(name, () -> createMinecart(variantType, fireResistant));
    }

    private static MinecartItem createMinecart(String variantType, boolean fireResistant) {
        Item.Properties props = new Item.Properties();
        if (fireResistant) props.fireResistant();

        EntityType<FyreMinecartEntity> entityType = getEntityTypeForVariant(variantType);
        return new MinecartItem(entityType, variantType, props);
    }

    private static EntityType<FyreMinecartEntity> getEntityTypeForVariant(String variantType) {
        return switch (variantType) {
            case "copper" -> FyreEntityTypes.COPPER_MINECART.get();
            case "gold" -> FyreEntityTypes.GOLD_MINECART.get();
            case "diamond" -> FyreEntityTypes.DIAMOND_MINECART.get();
            case "netherite" -> FyreEntityTypes.NETHERITE_MINECART.get();
            default -> throw new IllegalArgumentException("Unknown minecart variant: " + variantType);
        };
    }

    static class MinecartItem extends Item {
        private final EntityType<FyreMinecartEntity> type;
        private final String variantType;

        public MinecartItem(EntityType<FyreMinecartEntity> type, String variantType, Properties properties) {
            super(properties);
            this.type = type;
            this.variantType = variantType;
        }

        @Override
        public InteractionResult useOn(UseOnContext context) {
            Level level = context.getLevel();
            BlockPos blockpos = context.getClickedPos();
            BlockState blockstate = level.getBlockState(blockpos);

            if (!blockstate.is(BlockTags.RAILS)) {
                return InteractionResult.FAIL;
            } else {
                ItemStack itemstack = context.getItemInHand();
                if (!level.isClientSide) {
                    RailShape railshape = blockstate.getBlock() instanceof BaseRailBlock
                            ? blockstate.getValue(((BaseRailBlock)blockstate.getBlock()).getShapeProperty())
                            : RailShape.NORTH_SOUTH;

                    double d0 = 0.0D;
                    if (railshape.isAscending()) {
                        d0 = 0.5D;
                    }

                    FyreMinecartEntity minecart = new FyreMinecartEntity(
                            this.type,
                            level,
                            (double)blockpos.getX() + 0.5D,
                            (double)blockpos.getY() + 0.0625D + d0,
                            (double)blockpos.getZ() + 0.5D
                    );

                    minecart.setVariantType(this.variantType);

                    if (itemstack.has(net.minecraft.core.component.DataComponents.CUSTOM_NAME)) {
                        minecart.setCustomName(itemstack.getHoverName());
                    }

                    level.addFreshEntity(minecart);
                    level.gameEvent(GameEvent.ENTITY_PLACE, blockpos, GameEvent.Context.of(context.getPlayer(), level.getBlockState(blockpos.below())));
                }

                itemstack.shrink(1);
                return InteractionResult.sidedSuccess(level.isClientSide);
            }
        }
    }
}
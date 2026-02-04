package com.fyrerae.fyrevariants.entity;

import com.fyrerae.fyrevariants.item.MinecartItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Minecart;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class FyreMinecartEntity extends Minecart {
    private static final EntityDataAccessor<String> MINECART_TYPE =
            SynchedEntityData.defineId(FyreMinecartEntity.class, EntityDataSerializers.STRING);

    public FyreMinecartEntity(EntityType<? extends Minecart> entityType, Level level) {
        super(entityType, level);
    }

    public FyreMinecartEntity(EntityType<? extends Minecart> entityType, Level level, double x, double y, double z) {
        super(entityType, level);
        this.setPos(x, y, z);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(MINECART_TYPE, "copper");
    }

    public void setVariantType(String variantType) {
        this.entityData.set(MINECART_TYPE, variantType);
    }

    @Override
    public Type getMinecartType() {
        return Type.RIDEABLE;
    }

    public String getVariantType() {
        return this.entityData.get(MINECART_TYPE);
    }

    @Override
    protected Vec3 getPassengerAttachmentPoint(Entity passenger, EntityDimensions dimensions, float partialTick) {
        float f = this.getSinglePassengerXOffset();
        return new Vec3(0.0, (double)(this.getDimensions(this.getPose()).height() * 0.5F) - 0.15625, (double)f);
    }

    protected float getSinglePassengerXOffset() {
        return 0.0F;
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putString("VariantType", this.getVariantType());
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        if (tag.contains("VariantType")) {
            this.setVariantType(tag.getString("VariantType"));
        }
    }

    @Override
    public Item getDropItem() {
        return switch (getVariantType()) {
            case "copper" -> MinecartItems.COPPER_MINECART.get();
            case "gold" -> MinecartItems.GOLD_MINECART.get();
            case "diamond" -> MinecartItems.DIAMOND_MINECART.get();
            case "netherite" -> MinecartItems.NETHERITE_MINECART.get();
            default -> super.getDropItem();
        };
    }
}
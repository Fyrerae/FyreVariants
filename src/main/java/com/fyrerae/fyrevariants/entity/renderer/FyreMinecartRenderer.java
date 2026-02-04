package com.fyrerae.fyrevariants.entity.renderer;

import com.fyrerae.fyrevariants.FyreVariants;
import com.fyrerae.fyrevariants.entity.FyreMinecartEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.MinecartModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.vehicle.AbstractMinecart;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class FyreMinecartRenderer extends EntityRenderer<FyreMinecartEntity> {
    private static final ResourceLocation COPPER_MINECART_LOCATION = ResourceLocation.fromNamespaceAndPath(FyreVariants.MOD_ID, "textures/entity/minecart/copper.png");
    private static final ResourceLocation GOLD_MINECART_LOCATION = ResourceLocation.fromNamespaceAndPath(FyreVariants.MOD_ID, "textures/entity/minecart/gold.png");
    private static final ResourceLocation DIAMOND_MINECART_LOCATION = ResourceLocation.fromNamespaceAndPath(FyreVariants.MOD_ID, "textures/entity/minecart/diamond.png");
    private static final ResourceLocation NETHERITE_MINECART_LOCATION = ResourceLocation.fromNamespaceAndPath(FyreVariants.MOD_ID, "textures/entity/minecart/netherite.png");

    protected final EntityModel<AbstractMinecart> model;

    public FyreMinecartRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.shadowRadius = 0.7F;
        this.model = new MinecartModel<>(context.bakeLayer(ModelLayers.MINECART));
    }

    @Override
    public void render(FyreMinecartEntity entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
        poseStack.pushPose();

        long i = (long)entity.getId() * 493286711L;
        i = i * i * 4392167121L + i * 98761L;
        float f = (((float)(i >> 16 & 7L) + 0.5F) / 8.0F - 0.5F) * 0.004F;
        float f1 = (((float)(i >> 20 & 7L) + 0.5F) / 8.0F - 0.5F) * 0.004F;
        float f2 = (((float)(i >> 24 & 7L) + 0.5F) / 8.0F - 0.5F) * 0.004F;
        poseStack.translate(f, f1, f2);

        double d0 = Mth.lerp((double)partialTick, entity.xOld, entity.getX());
        double d1 = Mth.lerp((double)partialTick, entity.yOld, entity.getY());
        double d2 = Mth.lerp((double)partialTick, entity.zOld, entity.getZ());
        double d3 = 0.3F;
        Vec3 vec3 = entity.getPos(d0, d1, d2);
        float f3 = Mth.lerp(partialTick, entity.xRotO, entity.getXRot());

        if (vec3 != null) {
            Vec3 vec31 = entity.getPosOffs(d0, d1, d2, d3);
            Vec3 vec32 = entity.getPosOffs(d0, d1, d2, -d3);
            if (vec31 == null) {
                vec31 = vec3;
            }

            if (vec32 == null) {
                vec32 = vec3;
            }

            poseStack.translate(vec3.x - d0, (vec31.y + vec32.y) / 2.0 - d1, vec3.z - d2);
            Vec3 vec33 = vec32.add(-vec31.x, -vec31.y, -vec31.z);
            if (vec33.length() != 0.0) {
                vec33 = vec33.normalize();
                entityYaw = (float)(Math.atan2(vec33.z, vec33.x) * 180.0 / Math.PI);
                f3 = (float)(Math.atan(vec33.y) * 73.0);
            }
        }

        poseStack.translate(0.0F, 0.375F, 0.0F);
        poseStack.mulPose(Axis.YP.rotationDegrees(180.0F - entityYaw));
        poseStack.mulPose(Axis.ZP.rotationDegrees(-f3));
        float f5 = (float)entity.getHurtTime() - partialTick;
        float f6 = entity.getDamage() - partialTick;
        if (f6 < 0.0F) {
            f6 = 0.0F;
        }

        if (f5 > 0.0F) {
            poseStack.mulPose(Axis.XP.rotationDegrees(Mth.sin(f5) * f5 * f6 / 10.0F * (float)entity.getHurtDir()));
        }

        int j = entity.getDisplayOffset();
        BlockState blockstate = entity.getDisplayBlockState();
        if (blockstate.getRenderShape() != RenderShape.INVISIBLE) {
            poseStack.pushPose();
            poseStack.scale(0.75F, 0.75F, 0.75F);
            poseStack.translate(-0.5F, (float)(j - 8) / 16.0F, 0.5F);
            poseStack.mulPose(Axis.YP.rotationDegrees(90.0F));
            this.renderMinecartContents(entity, partialTick, blockstate, poseStack, bufferSource, packedLight);
            poseStack.popPose();
        }

        poseStack.scale(-1.0F, -1.0F, 1.0F);
        this.model.setupAnim(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        VertexConsumer vertexconsumer = bufferSource.getBuffer(this.model.renderType(this.getTextureLocation(entity)));
        this.model.renderToBuffer(poseStack, vertexconsumer, packedLight, OverlayTexture.NO_OVERLAY);
        poseStack.popPose();
    }

    protected void renderMinecartContents(FyreMinecartEntity entity, float partialTick, BlockState state, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {

    }

    @Override
    public ResourceLocation getTextureLocation(FyreMinecartEntity entity) {
        return switch (entity.getVariantType()) {
            case "copper" -> COPPER_MINECART_LOCATION;
            case "gold" -> GOLD_MINECART_LOCATION;
            case "diamond" -> DIAMOND_MINECART_LOCATION;
            case "netherite" -> NETHERITE_MINECART_LOCATION;
            default -> COPPER_MINECART_LOCATION;
        };
    }
}
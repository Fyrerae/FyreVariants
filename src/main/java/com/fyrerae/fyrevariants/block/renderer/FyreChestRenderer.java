package com.fyrerae.fyrevariants.block.renderer;

import com.fyrerae.fyrevariants.FyreVariants;
import com.fyrerae.fyrevariants.block.entity.FyreChestBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BrightnessCombiner;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.DoubleBlockCombiner;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.ChestType;

public class FyreChestRenderer implements BlockEntityRenderer<FyreChestBlockEntity> {
    private final ModelPart lid;
    private final ModelPart bottom;
    private final ModelPart lock;
    private final ModelPart doubleLeftLid;
    private final ModelPart doubleLeftBottom;
    private final ModelPart doubleLeftLock;
    private final ModelPart doubleRightLid;
    private final ModelPart doubleRightBottom;
    private final ModelPart doubleRightLock;

    public FyreChestRenderer(BlockEntityRendererProvider.Context context) {
        ModelPart modelpart = context.bakeLayer(ModelLayers.CHEST);
        this.bottom = modelpart.getChild("bottom");
        this.lid = modelpart.getChild("lid");
        this.lock = modelpart.getChild("lock");
        ModelPart part1 = context.bakeLayer(ModelLayers.DOUBLE_CHEST_LEFT);
        this.doubleLeftBottom = part1.getChild("bottom");
        this.doubleLeftLid = part1.getChild("lid");
        this.doubleLeftLock = part1.getChild("lock");
        ModelPart part2 = context.bakeLayer(ModelLayers.DOUBLE_CHEST_RIGHT);
        this.doubleRightBottom = part2.getChild("bottom");
        this.doubleRightLid = part2.getChild("lid");
        this.doubleRightLock = part2.getChild("lock");
    }

    @Override
    public void render(FyreChestBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        Level level = blockEntity.getLevel();
        boolean flag = level != null;
        BlockState blockstate = flag ? blockEntity.getBlockState() : Blocks.CHEST.defaultBlockState().setValue(ChestBlock.FACING, Direction.SOUTH);
        Block block = blockstate.getBlock();

        if (block instanceof ChestBlock chestblock) {
            ChestType chesttype = blockstate.getValue(ChestBlock.TYPE);
            poseStack.pushPose();
            float f = blockstate.getValue(ChestBlock.FACING).toYRot();
            poseStack.translate(0.5F, 0.5F, 0.5F);
            poseStack.mulPose(com.mojang.math.Axis.YP.rotationDegrees(-f));
            poseStack.translate(-0.5F, -0.5F, -0.5F);

            DoubleBlockCombiner.NeighborCombineResult<? extends ChestBlockEntity> neighborcombineresult;
            if (flag) {
                neighborcombineresult = chestblock.combine(blockstate, level, blockEntity.getBlockPos(), true);
            } else {
                neighborcombineresult = DoubleBlockCombiner.Combiner::acceptNone;
            }

            float openness = neighborcombineresult.apply(ChestBlock.opennessCombiner(blockEntity)).get(partialTick);
            openness = 1.0F - openness;
            openness = 1.0F - openness * openness * openness;
            int i = neighborcombineresult.apply(new BrightnessCombiner<>()).applyAsInt(packedLight);
            Material material = this.getMaterial(blockEntity, chesttype);
            VertexConsumer vertexconsumer = material.buffer(bufferSource, RenderType::entityCutout);

            if (chesttype == ChestType.LEFT) {
                this.render(poseStack, vertexconsumer, this.doubleLeftLid, this.doubleLeftLock, this.doubleLeftBottom, openness, i, packedOverlay);
            } else if (chesttype == ChestType.RIGHT) {
                this.render(poseStack, vertexconsumer, this.doubleRightLid, this.doubleRightLock, this.doubleRightBottom, openness, i, packedOverlay);
            } else {
                this.render(poseStack, vertexconsumer, this.lid, this.lock, this.bottom, openness, i, packedOverlay);
            }

            poseStack.popPose();
        }
    }

    private void render(PoseStack poseStack, VertexConsumer consumer, ModelPart lid, ModelPart lock, ModelPart bottom, float openness, int packedLight, int packedOverlay) {
        lid.xRot = -(openness * ((float)Math.PI / 2F));
        lock.xRot = lid.xRot;
        lid.render(poseStack, consumer, packedLight, packedOverlay);
        lock.render(poseStack, consumer, packedLight, packedOverlay);
        bottom.render(poseStack, consumer, packedLight, packedOverlay);
    }

    protected Material getMaterial(FyreChestBlockEntity blockEntity, ChestType chestType) {
        String woodType = getWoodType(blockEntity.getBlockState().getBlock());
        return switch (chestType) {
            case LEFT -> new Material(Sheets.CHEST_SHEET, ResourceLocation.fromNamespaceAndPath(FyreVariants.MOD_ID, "entity/chest/" + woodType + "_left"));
            case RIGHT -> new Material(Sheets.CHEST_SHEET, ResourceLocation.fromNamespaceAndPath(FyreVariants.MOD_ID, "entity/chest/" + woodType + "_right"));
            default -> new Material(Sheets.CHEST_SHEET, ResourceLocation.fromNamespaceAndPath(FyreVariants.MOD_ID, "entity/chest/" + woodType));
        };
    }

    private String getWoodType(Block block) {
        String blockName = block.toString();
        if (blockName.contains("acacia")) return "acacia";
        if (blockName.contains("bamboo")) return "bamboo";
        if (blockName.contains("birch")) return "birch";
        if (blockName.contains("cherry")) return "cherry";
        if (blockName.contains("crimson")) return "crimson";
        if (blockName.contains("dark_oak")) return "dark_oak";
        if (blockName.contains("jungle")) return "jungle";
        if (blockName.contains("mangrove")) return "mangrove";
        if (blockName.contains("spruce")) return "spruce";
        if (blockName.contains("warped")) return "warped";
        return "oak";
    }
}
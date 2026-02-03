package com.fyrerae.fyrevariants.event;

import com.fyrerae.fyrevariants.FyreVariants;
import com.fyrerae.fyrevariants.block.entity.FyreBlockEntities;
import com.fyrerae.fyrevariants.block.renderer.FyreCampfireRenderer;
import com.fyrerae.fyrevariants.block.renderer.FyreChestRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = FyreVariants.MOD_ID, value = Dist.CLIENT)
public class ClientModEvents {

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(FyreBlockEntities.CHEST.get(), FyreChestRenderer::new);
        event.registerBlockEntityRenderer(FyreBlockEntities.CAMPFIRE.get(), FyreCampfireRenderer::new);
    }
}
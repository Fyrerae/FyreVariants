package com.fyrerae.fyrevariants.event;

import com.fyrerae.fyrevariants.FyreVariants;
import com.fyrerae.fyrevariants.block.entity.FyreBlockEntities;
import com.fyrerae.fyrevariants.block.renderer.FyreCampfireRenderer;
import com.fyrerae.fyrevariants.block.renderer.FyreChestRenderer;
import com.fyrerae.fyrevariants.block.renderer.FyreLecternRenderer;
import com.fyrerae.fyrevariants.entity.FyreEntityTypes;
import com.fyrerae.fyrevariants.entity.renderer.FyreMinecartRenderer;
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
        event.registerBlockEntityRenderer(FyreBlockEntities.LECTERN.get(), FyreLecternRenderer::new);
        event.registerEntityRenderer(FyreEntityTypes.COPPER_MINECART.get(), FyreMinecartRenderer::new);
        event.registerEntityRenderer(FyreEntityTypes.GOLD_MINECART.get(), FyreMinecartRenderer::new);
        event.registerEntityRenderer(FyreEntityTypes.DIAMOND_MINECART.get(), FyreMinecartRenderer::new);
        event.registerEntityRenderer(FyreEntityTypes.NETHERITE_MINECART.get(), FyreMinecartRenderer::new);
    }
}
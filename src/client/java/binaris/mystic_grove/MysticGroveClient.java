package binaris.mystic_grove;

import binaris.mystic_grove.registry.MysticBlocks;
import binaris.mystic_grove.registry.MysticEntities;
import binaris.mystic_grove.render.MysticDeerModel;
import binaris.mystic_grove.render.MysticDeerRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;

public class MysticGroveClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.

		BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.MYSTIC_LEAVES, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.GLOW_SHROOM, RenderLayer.getCutout());

		BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.ETHER_BLOSSOM, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(MysticBlocks.POTTED_ETHER_BLOSSOM, RenderLayer.getCutout());

		EntityRendererRegistry.INSTANCE.register(MysticEntities.MYSTIC_DEER, MysticDeerRenderer::new);

		EntityModelLayerRegistry.registerModelLayer(MysticDeerModel.MODEL_DEER, MysticDeerModel::getTexturedModelData);
	}
}
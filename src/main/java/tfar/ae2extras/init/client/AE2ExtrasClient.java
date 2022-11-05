package tfar.ae2extras.init.client;

import appeng.init.client.InitBuiltInModels;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import tfar.ae2extras.init.ModBlocks;

public class AE2ExtrasClient {

    public static void models(ModelRegistryEvent e) {
        InitBuiltInModelsEx.init();
    }

    public static void client(FMLClientSetupEvent t) {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CRAFTING_STORAGE_1M, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CRAFTING_STORAGE_4M, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CRAFTING_STORAGE_16M, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CRAFTING_STORAGE_64M, RenderType.cutout());

    }
}

package tfar.ae2extras.init.client;

import appeng.items.storage.BasicStorageCell;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import tfar.ae2extras.init.ModBlocks;
import tfar.ae2extras.init.ModItems;

public class AE2ExtrasClient {

    public static void reg(IEventBus bus) {
        bus.addListener(AE2ExtrasClient::client);
        InitAutoRotatingModelEx.init(bus);
        bus.addListener(AE2ExtrasClient::colors);
    }


    public static void client(FMLClientSetupEvent t) {
        InitBuiltInModelsEx.init();
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CRAFTING_STORAGE_1M, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CRAFTING_STORAGE_4M, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CRAFTING_STORAGE_16M, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CRAFTING_STORAGE_64M, RenderType.cutout());

    }

    public static void colors(RegisterColorHandlersEvent.Item event) {
     /*   itemColors.register(PortableCellItem::getColor, AEItems.PORTABLE_ITEM_CELL1K, AEItems.PORTABLE_FLUID_CELL1K,
                AEItems.PORTABLE_ITEM_CELL4K, AEItems.PORTABLE_FLUID_CELL4K,
                AEItems.PORTABLE_ITEM_CELL16K, AEItems.PORTABLE_FLUID_CELL16K,
                AEItems.PORTABLE_ITEM_CELL64K, AEItems.PORTABLE_FLUID_CELL64K);*/

        event.getItemColors().register(BasicStorageCell::getColor, ModItems.ITEM_CELL_1M, ModItems.FLUID_CELL_1M,
                ModItems.ITEM_CELL_4M, ModItems.FLUID_CELL_4M,
                ModItems.ITEM_CELL_16M, ModItems.FLUID_CELL_16M,
                ModItems.ITEM_CELL_64M, ModItems.FLUID_CELL_64M);
    }
}

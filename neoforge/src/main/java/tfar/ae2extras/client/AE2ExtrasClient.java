package tfar.ae2extras.client;

import appeng.init.client.InitScreens;
import appeng.items.storage.BasicStorageCell;
import appeng.items.tools.powered.PortableCellItem;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.Item;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import tfar.ae2extras.AE2Extras;
import tfar.ae2extras.MonoCellScreen;
import tfar.ae2extras.init.ModBlocks;
import tfar.ae2extras.init.AE2ExtrasItems;
import tfar.ae2extras.init.ModMenuTypes;
import tfar.ae2extras.integration.Integration;
import tfar.ae2extras.integration.mekanism.AE2ExtrasMekCompatClient;

@Mod(value = AE2Extras.MOD_ID,dist = Dist.CLIENT)
public class AE2ExtrasClient {

    public AE2ExtrasClient(IEventBus bus){
        bus.addListener(AE2ExtrasClient::client);
        bus.addListener(AE2ExtrasClient::colors);
        bus.addListener(this::registerScreens);
    }

    public static void client(FMLClientSetupEvent t) {
        BuiltInModelsEx.init();
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CRAFTING_STORAGE_1M, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CRAFTING_STORAGE_4M, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CRAFTING_STORAGE_16M, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CRAFTING_STORAGE_64M, RenderType.cutout());
    }

    void registerScreens(RegisterMenuScreensEvent event) {
        InitScreens.register(event,ModMenuTypes.MONO_CELL, MonoCellScreen::new,"/screens/mono_cell.json");
    }

    public static void colors(RegisterColorHandlersEvent.Item event) {
        event.register(PortableCellItem::getColor,
                AE2ExtrasItems.PORTABLE_ITEM_CELL_1M, AE2ExtrasItems.PORTABLE_FLUID_CELL_1M,
                AE2ExtrasItems.PORTABLE_ITEM_CELL_4M, AE2ExtrasItems.PORTABLE_FLUID_CELL_4M,
                AE2ExtrasItems.PORTABLE_ITEM_CELL_16M, AE2ExtrasItems.PORTABLE_FLUID_CELL_16M,
                AE2ExtrasItems.PORTABLE_ITEM_CELL_64M, AE2ExtrasItems.PORTABLE_FLUID_CELL_64M);

        event.register(BasicStorageCell::getColor, AE2ExtrasItems.ITEM_CELL_1M, AE2ExtrasItems.FLUID_CELL_1M,
                AE2ExtrasItems.ITEM_CELL_4M, AE2ExtrasItems.FLUID_CELL_4M,
                AE2ExtrasItems.ITEM_CELL_16M, AE2ExtrasItems.FLUID_CELL_16M,
                AE2ExtrasItems.ITEM_CELL_64M, AE2ExtrasItems.FLUID_CELL_64M);

        event.register(BasicStorageCell::getColor, AE2ExtrasItems.monoCells().toArray(Item[]::new));

        if (Integration.appmek.loaded) {
            AE2ExtrasMekCompatClient.colors(event);
        }
    }
}

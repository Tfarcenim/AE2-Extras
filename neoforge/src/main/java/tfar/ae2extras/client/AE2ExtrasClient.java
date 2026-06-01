package tfar.ae2extras.client;

import appeng.client.InitScreens;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import tfar.ae2extras.AE2Extras;
import tfar.ae2extras.MonoCellScreen;
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

    static void client(FMLClientSetupEvent t) {
        BuiltInModelsEx.init();
    }

    void registerScreens(RegisterMenuScreensEvent event) {
        InitScreens.register(event,ModMenuTypes.MONO_CELL, MonoCellScreen::new,"/screens/mono_cell.json");
    }

    static void colors(RegisterColorHandlersEvent.ItemTintSources event) {

        if (Integration.appmek.loaded) {
            AE2ExtrasMekCompatClient.colors(event);
        }
    }

}

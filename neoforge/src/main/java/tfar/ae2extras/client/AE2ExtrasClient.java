package tfar.ae2extras.client;

import appeng.api.client.StorageCellModels;
import appeng.client.AppEngClient;
import appeng.client.InitScreens;
import appeng.client.api.model.parts.RegisterPartModelsEvent;
import appeng.client.render.crafting.CraftingCubeModel;
import appeng.core.definitions.AEItems;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.InitializeClientRegistriesEvent;
import net.neoforged.neoforge.client.event.RegisterBlockStateModels;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import tfar.ae2extras.AE2Extras;
import tfar.ae2extras.MonoCellScreen;
import tfar.ae2extras.init.AE2ExtrasItems;
import tfar.ae2extras.init.ModMenuTypes;
import tfar.ae2extras.integration.Integration;
import tfar.ae2extras.integration.mekanism.AE2ExtrasMekCompatClient;

@Mod(value = AE2Extras.MOD_ID,dist = Dist.CLIENT)
public class AE2ExtrasClient {

    public static final Identifier MODEL_CELL_ITEMS_1M = AE2Extras.id("block/drive_1m_item_cell");
    public static final Identifier MODEL_CELL_ITEMS_4M = AE2Extras.id("block/drive_4m_item_cell");
    public static final Identifier MODEL_CELL_ITEMS_16M = AE2Extras.id("block/drive_16m_item_cell");
    public static final Identifier MODEL_CELL_ITEMS_64M = AE2Extras.id("block/drive_64m_item_cell");

    public static final Identifier MODEL_CELL_FLUIDS_1M = AE2Extras.id("block/drive_1m_fluid_cell");
    public static final Identifier MODEL_CELL_FLUIDS_4M = AE2Extras.id("block/drive_4m_fluid_cell");
    public static final Identifier MODEL_CELL_FLUIDS_16M = AE2Extras.id("block/drive_16m_fluid_cell");
    public static final Identifier MODEL_CELL_FLUIDS_64M = AE2Extras.id("block/drive_64m_fluid_cell");

    public AE2ExtrasClient(IEventBus bus){
        bus.addListener(AE2ExtrasClient::client);
        bus.addListener(AE2ExtrasClient::colors);
        bus.addListener(this::registerScreens);
        bus.addListener(this::initCustomClientRegistries);
        bus.addListener(this::registerBlockStateModels);
    }

    static void client(FMLClientSetupEvent t) {
        BuiltInModelsEx.init();
    }

    void registerScreens(RegisterMenuScreensEvent event) {
        InitScreens.register(event,ModMenuTypes.MONO_CELL, MonoCellScreen::new,"/screens/mono_cell.json");
    }

    private void initCustomClientRegistries(InitializeClientRegistriesEvent event) {
        StorageCellModels.registerModel(AE2ExtrasItems.ITEM_CELL_1M, MODEL_CELL_ITEMS_1M);
        StorageCellModels.registerModel(AE2ExtrasItems.ITEM_CELL_4M, MODEL_CELL_ITEMS_4M);
        StorageCellModels.registerModel(AE2ExtrasItems.ITEM_CELL_16M, MODEL_CELL_ITEMS_16M);
        StorageCellModels.registerModel(AE2ExtrasItems.ITEM_CELL_64M, MODEL_CELL_ITEMS_64M);

        StorageCellModels.registerModel(AE2ExtrasItems.FLUID_CELL_1M, MODEL_CELL_FLUIDS_1M);
        StorageCellModels.registerModel(AE2ExtrasItems.FLUID_CELL_4M, MODEL_CELL_FLUIDS_4M);
        StorageCellModels.registerModel(AE2ExtrasItems.FLUID_CELL_16M, MODEL_CELL_FLUIDS_16M);
        StorageCellModels.registerModel(AE2ExtrasItems.FLUID_CELL_64M, MODEL_CELL_FLUIDS_64M);

        StorageCellModels.registerModel(AE2ExtrasItems.PORTABLE_ITEM_CELL_1M, MODEL_CELL_ITEMS_1M);
        StorageCellModels.registerModel(AE2ExtrasItems.PORTABLE_ITEM_CELL_4M, MODEL_CELL_ITEMS_4M);
        StorageCellModels.registerModel(AE2ExtrasItems.PORTABLE_ITEM_CELL_16M, MODEL_CELL_ITEMS_16M);
        StorageCellModels.registerModel(AE2ExtrasItems.PORTABLE_ITEM_CELL_64M, MODEL_CELL_ITEMS_64M);

        StorageCellModels.registerModel(AE2ExtrasItems.PORTABLE_FLUID_CELL_1M, MODEL_CELL_FLUIDS_1M);
        StorageCellModels.registerModel(AE2ExtrasItems.PORTABLE_FLUID_CELL_4M, MODEL_CELL_FLUIDS_4M);
        StorageCellModels.registerModel(AE2ExtrasItems.PORTABLE_FLUID_CELL_16M, MODEL_CELL_FLUIDS_16M);
        StorageCellModels.registerModel(AE2ExtrasItems.PORTABLE_FLUID_CELL_64M, MODEL_CELL_FLUIDS_64M);

    }

    private void registerBlockStateModels(RegisterBlockStateModels event) {
        event.registerModel(BuiltInModelsEx.Unbaked.ID, BuiltInModelsEx.Unbaked.MAP_CODEC);
    }

    static void colors(RegisterColorHandlersEvent.ItemTintSources event) {

        if (Integration.appmek.loaded) {
            AE2ExtrasMekCompatClient.colors(event);
        }
    }

}

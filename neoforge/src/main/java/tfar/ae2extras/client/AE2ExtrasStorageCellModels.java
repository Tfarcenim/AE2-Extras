package tfar.ae2extras.client;

import appeng.api.client.StorageCellModels;
import appeng.core.definitions.AEItems;
import net.minecraft.resources.ResourceLocation;
import tfar.ae2extras.init.AE2ExtrasItems;

public class AE2ExtrasStorageCellModels {

    private static final ResourceLocation MODEL_CELL_ITEMS_1K = ResourceLocation.parse(
            "ae2:block/drive/cells/1k_item_cell");
    private static final ResourceLocation MODEL_CELL_ITEMS_4K = ResourceLocation.parse(
            "ae2:block/drive/cells/4k_item_cell");
    private static final ResourceLocation MODEL_CELL_ITEMS_16K = ResourceLocation.parse(
            "ae2:block/drive/cells/16k_item_cell");
    private static final ResourceLocation MODEL_CELL_ITEMS_64K = ResourceLocation.parse(
            "ae2:block/drive/cells/64k_item_cell");
    private static final ResourceLocation MODEL_CELL_ITEMS_256K = ResourceLocation.parse(
            "ae2:block/drive/cells/256k_item_cell");
    private static final ResourceLocation MODEL_CELL_FLUIDS_1K = ResourceLocation.parse(
            "ae2:block/drive/cells/1k_fluid_cell");
    private static final ResourceLocation MODEL_CELL_FLUIDS_4K = ResourceLocation.parse(
            "ae2:block/drive/cells/4k_fluid_cell");
    private static final ResourceLocation MODEL_CELL_FLUIDS_16K = ResourceLocation.parse(
            "ae2:block/drive/cells/16k_fluid_cell");
    private static final ResourceLocation MODEL_CELL_FLUIDS_64K = ResourceLocation.parse(
            "ae2:block/drive/cells/64k_fluid_cell");
    private static final ResourceLocation MODEL_CELL_FLUIDS_256K = ResourceLocation.parse(
            "ae2:block/drive/cells/256k_fluid_cell");

    public static void init() {
        StorageCellModels.registerModel(AE2ExtrasItems.ITEM_CELL_1M, MODEL_CELL_ITEMS_1K);
        StorageCellModels.registerModel(AE2ExtrasItems.ITEM_CELL_4M, MODEL_CELL_ITEMS_4K);
        StorageCellModels.registerModel(AE2ExtrasItems.ITEM_CELL_16M, MODEL_CELL_ITEMS_16K);
        StorageCellModels.registerModel(AE2ExtrasItems.ITEM_CELL_64M, MODEL_CELL_ITEMS_64K);

        StorageCellModels.registerModel(AE2ExtrasItems.FLUID_CELL_1M, MODEL_CELL_FLUIDS_1K);
        StorageCellModels.registerModel(AE2ExtrasItems.FLUID_CELL_4M, MODEL_CELL_FLUIDS_4K);
        StorageCellModels.registerModel(AE2ExtrasItems.FLUID_CELL_16M, MODEL_CELL_FLUIDS_16K);
        StorageCellModels.registerModel(AE2ExtrasItems.FLUID_CELL_64M, MODEL_CELL_FLUIDS_64K);

        StorageCellModels.registerModel(AE2ExtrasItems.PORTABLE_ITEM_CELL_1M, MODEL_CELL_ITEMS_1K);
        StorageCellModels.registerModel(AE2ExtrasItems.PORTABLE_ITEM_CELL_4M, MODEL_CELL_ITEMS_4K);
        StorageCellModels.registerModel(AE2ExtrasItems.PORTABLE_ITEM_CELL_16M, MODEL_CELL_ITEMS_16K);
        StorageCellModels.registerModel(AE2ExtrasItems.PORTABLE_ITEM_CELL_64M, MODEL_CELL_ITEMS_64K);

        StorageCellModels.registerModel(AE2ExtrasItems.PORTABLE_FLUID_CELL_1M, MODEL_CELL_FLUIDS_1K);
        StorageCellModels.registerModel(AE2ExtrasItems.PORTABLE_FLUID_CELL_4M, MODEL_CELL_FLUIDS_4K);
        StorageCellModels.registerModel(AE2ExtrasItems.PORTABLE_FLUID_CELL_16M, MODEL_CELL_FLUIDS_16K);
        StorageCellModels.registerModel(AE2ExtrasItems.PORTABLE_FLUID_CELL_64M, MODEL_CELL_FLUIDS_64K);
    }
}

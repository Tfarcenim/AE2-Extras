package tfar.ae2extras.datagen.assets;

import appeng.block.networking.EnergyCellBlockItem;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import tfar.ae2extras.AE2Extras;
import tfar.ae2extras.init.AE2ExtrasItems;


public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput generator, ExistingFileHelper existingFileHelper) {
        super(generator, AE2Extras.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        storageCell(AE2ExtrasItems.ITEM_CELL_1M, "item/item_storage_cell_1m");
        storageCell(AE2ExtrasItems.ITEM_CELL_4M, "item/item_storage_cell_4m");
        storageCell(AE2ExtrasItems.ITEM_CELL_16M, "item/item_storage_cell_16m");
        storageCell(AE2ExtrasItems.ITEM_CELL_64M, "item/item_storage_cell_64m");

        storageCell(AE2ExtrasItems.FLUID_CELL_1M, "item/fluid_storage_cell_1m");
        storageCell(AE2ExtrasItems.FLUID_CELL_4M, "item/fluid_storage_cell_4m");
        storageCell(AE2ExtrasItems.FLUID_CELL_16M, "item/fluid_storage_cell_16m");
        storageCell(AE2ExtrasItems.FLUID_CELL_64M, "item/fluid_storage_cell_64m");

        flatSingleLayer(AE2ExtrasItems.CELL_COMPONENT_16M, "item/cell_component_16m");
        flatSingleLayer(AE2ExtrasItems.CELL_COMPONENT_1M, "item/cell_component_1m");
        flatSingleLayer(AE2ExtrasItems.CELL_COMPONENT_4M, "item/cell_component_4m");
        flatSingleLayer(AE2ExtrasItems.CELL_COMPONENT_64M, "item/cell_component_64m");

        storageCell(AE2ExtrasItems.MONO_ITEM_CELL_1K, "item/mono_item_storage_cell_1k");
        storageCell(AE2ExtrasItems.MONO_ITEM_CELL_4K, "item/mono_item_storage_cell_4k");
        storageCell(AE2ExtrasItems.MONO_ITEM_CELL_16K, "item/mono_item_storage_cell_16k");
        storageCell(AE2ExtrasItems.MONO_ITEM_CELL_64K, "item/mono_item_storage_cell_64k");
        storageCell(AE2ExtrasItems.MONO_ITEM_CELL_256K, "item/mono_item_storage_cell_256k");
        storageCell(AE2ExtrasItems.MONO_ITEM_CELL_1M, "item/mono_item_storage_cell_1m");
        storageCell(AE2ExtrasItems.MONO_ITEM_CELL_4M, "item/mono_item_storage_cell_4m");
        storageCell(AE2ExtrasItems.MONO_ITEM_CELL_16M, "item/mono_item_storage_cell_16m");
        storageCell(AE2ExtrasItems.MONO_ITEM_CELL_64M, "item/mono_item_storage_cell_16m");

        storageCell(AE2ExtrasItems.MONO_FLUID_CELL_1K, "item/mono_fluid_storage_cell_1k");
        storageCell(AE2ExtrasItems.MONO_FLUID_CELL_4K, "item/mono_fluid_storage_cell_4k");
        storageCell(AE2ExtrasItems.MONO_FLUID_CELL_16K, "item/mono_fluid_storage_cell_16k");
        storageCell(AE2ExtrasItems.MONO_FLUID_CELL_64K, "item/mono_fluid_storage_cell_64k");
        storageCell(AE2ExtrasItems.MONO_FLUID_CELL_256K, "item/mono_fluid_storage_cell_256k");
        storageCell(AE2ExtrasItems.MONO_FLUID_CELL_1M, "item/mono_fluid_storage_cell_1m");
        storageCell(AE2ExtrasItems.MONO_FLUID_CELL_4M, "item/mono_fluid_storage_cell_4m");
        storageCell(AE2ExtrasItems.MONO_FLUID_CELL_16M, "item/mono_fluid_storage_cell_16m");
        storageCell(AE2ExtrasItems.MONO_FLUID_CELL_64M, "item/mono_fluid_storage_cell_16m");

        portableItemCell(AE2ExtrasItems.PORTABLE_ITEM_CELL_1M,"ae2:item/portable_cell_side_1k");
        portableItemCell(AE2ExtrasItems.PORTABLE_ITEM_CELL_4M,"ae2:item/portable_cell_side_4k");
        portableItemCell(AE2ExtrasItems.PORTABLE_ITEM_CELL_16M,"ae2:item/portable_cell_side_16k");
        portableItemCell(AE2ExtrasItems.PORTABLE_ITEM_CELL_64M,"ae2:item/portable_cell_side_64k");

        portableFluidCell(AE2ExtrasItems.PORTABLE_FLUID_CELL_1M,"ae2:item/portable_cell_side_1k");
        portableFluidCell(AE2ExtrasItems.PORTABLE_FLUID_CELL_4M,"ae2:item/portable_cell_side_4k");
        portableFluidCell(AE2ExtrasItems.PORTABLE_FLUID_CELL_16M,"ae2:item/portable_cell_side_16k");
        portableFluidCell(AE2ExtrasItems.PORTABLE_FLUID_CELL_64M,"ae2:item/portable_cell_side_64k");
    }

    private void storageCell(Item item, String background) {
        String id = BuiltInRegistries.ITEM.getKey(item).getPath();
        singleTexture(
                id,
                mcLoc("item/generated"),
                "layer0",
                AE2Extras.id(background))
                .texture("layer1", ae2("item/storage_cell_led"));
    }

    private void portableItemCell(Item item,String background) {
        portableCell(item,ae2("item/portable_cell_item_housing"),background);
    }

    private void portableFluidCell(Item item,String background) {
        portableCell(item,ae2("item/portable_cell_fluid_housing"),background);
    }

    private void portableCell(Item item,ResourceLocation housing, String background) {
        String id = BuiltInRegistries.ITEM.getKey(item).getPath();
        singleTexture(
                id,
                mcLoc("item/generated"),
                "layer0", ae2("item/portable_cell_screen"))
                .texture("layer1", ae2("item/portable_cell_led"))
                .texture("layer2",housing)
                .texture("layer3", new ResourceLocation(background));
    }

    protected ResourceLocation ae2(String path) {
        return new ResourceLocation("ae2",path);
    }

    private ItemModelBuilder flatSingleLayer(Item item, String texture) {
        String id = BuiltInRegistries.ITEM.getKey(item).getPath();
        return singleTexture(
                id,
                mcLoc("item/generated"),
                "layer0",
                AE2Extras.id(texture));
    }

}

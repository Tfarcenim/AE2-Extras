package tfar.ae2extras.datagen.assets;

import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import tfar.ae2extras.AE2Extras;
import tfar.ae2extras.init.ModItems;


public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, AE2Extras.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        storageCell(ModItems.ITEM_CELL_1M, "item/item_storage_cell_1m");
        storageCell(ModItems.ITEM_CELL_4M, "item/item_storage_cell_4m");
        storageCell(ModItems.ITEM_CELL_16M, "item/item_storage_cell_16m");
        storageCell(ModItems.ITEM_CELL_64M, "item/item_storage_cell_64m");

        storageCell(ModItems.FLUID_CELL_1M, "item/fluid_storage_cell_1m");
        storageCell(ModItems.FLUID_CELL_4M, "item/fluid_storage_cell_4m");
        storageCell(ModItems.FLUID_CELL_16M, "item/fluid_storage_cell_16m");
        storageCell(ModItems.FLUID_CELL_64M, "item/fluid_storage_cell_64m");

        flatSingleLayer(ModItems.CELL_COMPONENT_16M, "item/cell_component_16m");
        flatSingleLayer(ModItems.CELL_COMPONENT_1M, "item/cell_component_1m");
        flatSingleLayer(ModItems.CELL_COMPONENT_4M, "item/cell_component_4m");
        flatSingleLayer(ModItems.CELL_COMPONENT_64M, "item/cell_component_64m");
    }

    private void storageCell(Item item, String background) {
        String id = Registry.ITEM.getKey(item).getPath();
        singleTexture(
                id,
                mcLoc("item/generated"),
                "layer0",
                AE2Extras.makeId(background))
                .texture("layer1", AE2Extras.makeId("item/storage_cell_led"));//todo, this is a vanilla AE2 texture, use the original when possible
    }

    private ItemModelBuilder flatSingleLayer(Item item, String texture) {
        String id = Registry.ITEM.getKey(item).getPath();
        return singleTexture(
                id,
                mcLoc("item/generated"),
                "layer0",
                AE2Extras.makeId(texture));
    }

}

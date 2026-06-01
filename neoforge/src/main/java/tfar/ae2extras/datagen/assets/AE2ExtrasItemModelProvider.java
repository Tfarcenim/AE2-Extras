package tfar.ae2extras.datagen.assets;

import appeng.client.item.PortableCellColorTintSource;
import appeng.client.item.StorageCellStateTintSource;
import appeng.core.definitions.ItemDefinition;
import appeng.datagen.providers.models.ModelSubProvider;
import appeng.datagen.providers.models.PartModelOutput;
import net.minecraft.client.color.item.Constant;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import tfar.ae2extras.AE2Extras;
import tfar.ae2extras.init.AE2ExtrasItems;
import tfar.ae2extras.integration.mekanism.MItems;

public class AE2ExtrasItemModelProvider extends ModelSubProvider {
    public AE2ExtrasItemModelProvider(BlockModelGenerators blockModels, ItemModelGenerators itemModels, PartModelOutput partModels) {
        super(blockModels, itemModels, partModels);
    }

    @Override
    protected void register() {
        storageCell(AE2ExtrasItems.ITEM_CELL_1M,AE2Extras.id("item/item_storage_cell_1m"));
        storageCell(AE2ExtrasItems.ITEM_CELL_4M, AE2Extras.id("item/item_storage_cell_4m"));
        storageCell(AE2ExtrasItems.ITEM_CELL_16M,AE2Extras.id( "item/item_storage_cell_16m"));
        storageCell(AE2ExtrasItems.ITEM_CELL_64M, AE2Extras.id("item/item_storage_cell_64m"));

        storageCell(AE2ExtrasItems.FLUID_CELL_1M,AE2Extras.id( "item/fluid_storage_cell_1m"));
        storageCell(AE2ExtrasItems.FLUID_CELL_4M, AE2Extras.id("item/fluid_storage_cell_4m"));
        storageCell(AE2ExtrasItems.FLUID_CELL_16M, AE2Extras.id("item/fluid_storage_cell_16m"));
        storageCell(AE2ExtrasItems.FLUID_CELL_64M, AE2Extras.id("item/fluid_storage_cell_64m"));

        storageCell(MItems.CHEMICAL_CELL_1M, AE2Extras.id("item/fluid_storage_cell_1m"));
        storageCell(MItems.CHEMICAL_CELL_4M, AE2Extras.id("item/fluid_storage_cell_4m"));
        storageCell(MItems.CHEMICAL_CELL_16M, AE2Extras.id("item/fluid_storage_cell_16m"));
        storageCell(MItems.CHEMICAL_CELL_64M, AE2Extras.id("item/fluid_storage_cell_64m"));


        storageCell(AE2ExtrasItems.MONO_ITEM_CELL_1K,  AE2Extras.id("item/mono_item_storage_cell_1k"));
        storageCell(AE2ExtrasItems.MONO_ITEM_CELL_4K,  AE2Extras.id("item/mono_item_storage_cell_4k"));
        storageCell(AE2ExtrasItems.MONO_ITEM_CELL_16K, AE2Extras.id( "item/mono_item_storage_cell_16k"));
        storageCell(AE2ExtrasItems.MONO_ITEM_CELL_64K,  AE2Extras.id("item/mono_item_storage_cell_64k"));
        storageCell(AE2ExtrasItems.MONO_ITEM_CELL_256K,  AE2Extras.id("item/mono_item_storage_cell_256k"));
        storageCell(AE2ExtrasItems.MONO_ITEM_CELL_1M,  AE2Extras.id("item/mono_item_storage_cell_1m"));
        storageCell(AE2ExtrasItems.MONO_ITEM_CELL_4M,  AE2Extras.id("item/mono_item_storage_cell_4m"));
        storageCell(AE2ExtrasItems.MONO_ITEM_CELL_16M, AE2Extras.id( "item/mono_item_storage_cell_16m"));
        storageCell(AE2ExtrasItems.MONO_ITEM_CELL_64M,  AE2Extras.id("item/mono_item_storage_cell_64m"));

        storageCell(AE2ExtrasItems.MONO_FLUID_CELL_1K,  AE2Extras.id("item/mono_fluid_storage_cell_1k"));
        storageCell(AE2ExtrasItems.MONO_FLUID_CELL_4K,  AE2Extras.id("item/mono_fluid_storage_cell_4k"));
        storageCell(AE2ExtrasItems.MONO_FLUID_CELL_16K,  AE2Extras.id("item/mono_fluid_storage_cell_16k"));
        storageCell(AE2ExtrasItems.MONO_FLUID_CELL_64K,  AE2Extras.id("item/mono_fluid_storage_cell_64k"));
        storageCell(AE2ExtrasItems.MONO_FLUID_CELL_256K,  AE2Extras.id("item/mono_fluid_storage_cell_256k"));
        storageCell(AE2ExtrasItems.MONO_FLUID_CELL_1M, AE2Extras.id( "item/mono_fluid_storage_cell_1m"));
        storageCell(AE2ExtrasItems.MONO_FLUID_CELL_4M,  AE2Extras.id("item/mono_fluid_storage_cell_4m"));
        storageCell(AE2ExtrasItems.MONO_FLUID_CELL_16M,  AE2Extras.id("item/mono_fluid_storage_cell_16m"));
        storageCell(AE2ExtrasItems.MONO_FLUID_CELL_64M,  AE2Extras.id("item/mono_fluid_storage_cell_64m"));

        portableItemCell(AE2ExtrasItems.PORTABLE_ITEM_CELL_1M,"ae2:item/portable_cell_side_1k");
        portableItemCell(AE2ExtrasItems.PORTABLE_ITEM_CELL_4M,"ae2:item/portable_cell_side_4k");
        portableItemCell(AE2ExtrasItems.PORTABLE_ITEM_CELL_16M,"ae2:item/portable_cell_side_16k");
        portableItemCell(AE2ExtrasItems.PORTABLE_ITEM_CELL_64M,"ae2:item/portable_cell_side_64k");

        portableFluidCell(AE2ExtrasItems.PORTABLE_FLUID_CELL_1M,"ae2:item/portable_cell_side_1k");
        portableFluidCell(AE2ExtrasItems.PORTABLE_FLUID_CELL_4M,"ae2:item/portable_cell_side_4k");
        portableFluidCell(AE2ExtrasItems.PORTABLE_FLUID_CELL_16M,"ae2:item/portable_cell_side_16k");
        portableFluidCell(AE2ExtrasItems.PORTABLE_FLUID_CELL_64M,"ae2:item/portable_cell_side_64k");

        portableChemicalCell(MItems.PORTABLE_CHEMICAL_STORAGE_CELL_1M,"ae2:item/portable_cell_side_1k");
        portableChemicalCell(MItems.PORTABLE_CHEMICAL_STORAGE_CELL_4M,"ae2:item/portable_cell_side_4k");
        portableChemicalCell(MItems.PORTABLE_CHEMICAL_STORAGE_CELL_16M,"ae2:item/portable_cell_side_16k");
        portableChemicalCell(MItems.PORTABLE_CHEMICAL_STORAGE_CELL_64M,"ae2:item/portable_cell_side_64k");

        flatSingleLayer(AE2ExtrasItems.CELL_COMPONENT_16M, "item/cell_component_16m");
        flatSingleLayer(AE2ExtrasItems.CELL_COMPONENT_1M, "item/cell_component_1m");
        flatSingleLayer(AE2ExtrasItems.CELL_COMPONENT_4M, "item/cell_component_4m");
        flatSingleLayer(AE2ExtrasItems.CELL_COMPONENT_64M, "item/cell_component_64m");

    }

    private void flatSingleLayer(ItemLike item, String texture) {
        var model = ModelTemplates.FLAT_ITEM.create(item.asItem(), TextureMapping.layer0(new Material(AE2Extras.id(texture))),
                itemModels.modelOutput);
        itemModels.itemModelOutput.accept(item.asItem(), ItemModelUtils.plainModel(model));
    }


    private void storageCell(Item item, Identifier background) {
        var model = itemModels.generateLayeredItem(
                item.asItem(),
                new Material(background),
                new Material(ae2("item/storage_cell_led")));
        itemModels.itemModelOutput.accept(item.asItem(), ItemModelUtils.tintedModel(
                model,
                new Constant(-1),
                new StorageCellStateTintSource()));
    }

    protected static Identifier ae2(String id) {
        return id.contains(":") ? Identifier.parse(id) : AE2Extras.id(id);
    }


    private void portableItemCell(Item item,String tier) {
        portableCell(item,"item",tier);
    }

    private void portableFluidCell(Item item,String tier) {
        portableCell(item,"fluid",tier);
    }

    private void portableChemicalCell(Item item,String background) {
        portableCell(item,"item",background);
    }

    public static final TextureSlot LAYER3 = TextureSlot.create("layer3");
    private static final ModelTemplate FOUR_LAYERED_ITEM = ModelTemplates.createItem("generated", TextureSlot.LAYER0,
            TextureSlot.LAYER1, TextureSlot.LAYER2, LAYER3);

    private void portableCell(Item item, String housingType, String tier) {

        var model = FOUR_LAYERED_ITEM.create(
                item.asItem(),
                TextureMapping.layered(
                                new Material(ae2("item/portable_cell_%s_housing".formatted(housingType))),
                                new Material(ae2("item/portable_cell_led")),
                                new Material(ae2("item/portable_cell_screen")))
                        .put(LAYER3, new Material(ae2("item/portable_cell_side_%s".formatted(tier)))),
                itemModels.modelOutput);
        itemModels.itemModelOutput.accept(item.asItem(), ItemModelUtils.tintedModel(
                model,
                new Constant(-1),
                new StorageCellStateTintSource(),
                new PortableCellColorTintSource()));
    }
}

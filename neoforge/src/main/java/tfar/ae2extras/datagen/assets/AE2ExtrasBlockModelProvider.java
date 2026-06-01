package tfar.ae2extras.datagen.assets;

import appeng.block.crafting.AbstractCraftingUnitBlock;
import appeng.block.crafting.CraftingUnitBlock;
import appeng.block.networking.EnergyCellBlock;
import appeng.client.item.EnergyFillLevelProperty;
import appeng.core.definitions.BlockDefinition;
import appeng.datagen.providers.models.ModelSubProvider;
import appeng.datagen.providers.models.PartModelOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.renderer.item.RangeSelectItemModel;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import tfar.ae2extras.AE2ExtrasCraftingUnitType;
import tfar.ae2extras.client.BuiltInModelsEx;
import tfar.ae2extras.init.AE2ExtrasBlocks;

import java.util.ArrayList;

import static appeng.core.AppEng.makeId;
import static net.minecraft.client.data.models.BlockModelGenerators.plainVariant;

public class AE2ExtrasBlockModelProvider extends ModelSubProvider {
    public AE2ExtrasBlockModelProvider(BlockModelGenerators blockModels, ItemModelGenerators itemModels, PartModelOutput partModels) {
        super(blockModels, itemModels, partModels);
    }

    @Override
    protected void register() {
        craftingModel(AE2ExtrasBlocks.CRAFTING_STORAGE_1M, "1m_storage");
        craftingModel(AE2ExtrasBlocks.CRAFTING_STORAGE_4M, "4m_storage");
        craftingModel(AE2ExtrasBlocks.CRAFTING_STORAGE_16M, "16m_storage");
        craftingModel(AE2ExtrasBlocks.CRAFTING_STORAGE_64M, "64m_storage");

        energyCell(AE2ExtrasBlocks.DENSER_ENERGY_CELL, "block/denser_energy_cell");
        energyCell(AE2ExtrasBlocks.DENSEST_ENERGY_CELL, "block/densest_energy_cell");

    }

    private void craftingModel(CraftingUnitBlock block, String name) {
        AE2ExtrasCraftingUnitType type = (AE2ExtrasCraftingUnitType) block.type;
        var unformedModel = ModelTemplates.CUBE_ALL.create(
                makeId("block/crafting/" + name), TextureMapping.cube(makeMaterial("block/crafting/" + name)),
                modelOutput);
        var formedModel = customBlockStateModel(new BuiltInModelsEx.Unbaked(type));

        blockModels.blockStateOutput
                .accept(
                        MultiVariantGenerator.dispatch(block)
                                .with(
                                        PropertyDispatch.initial(AbstractCraftingUnitBlock.FORMED)
                                                .select(false,
                                                        plainVariant(unformedModel))
                                                .select(true,
                                                        formedModel)));

        blockModels.registerSimpleItemModel(block.asItem(), unformedModel);
    }

    private void energyCell(
            Block block,
            String baseTexture) {

        var energyLevelDispatch = PropertyDispatch.initial(EnergyCellBlock.ENERGY_STORAGE);

        var models = new ArrayList<Identifier>();
        for (var i = 0; i < 5; i++) {
            var textures = TextureMapping.cube(getBlockTexture(block, "_" + i));
            var model = ModelTemplates.CUBE_ALL.createWithSuffix(block, "_" + i, textures, modelOutput);
            models.add(model);
            energyLevelDispatch.select(i, plainVariant(model));
        }
        blockStateOutput.accept(MultiVariantGenerator.dispatch(block).with(energyLevelDispatch));

        var itemLevelEntries = new ArrayList<RangeSelectItemModel.Entry>();
        for (var i = 1; i < models.size(); i++) {
            // The predicate matches "greater than", meaning for fill-level > 0 the first non-empty texture is used
            float fillFactor = i / (float) models.size();
            itemLevelEntries.add(new RangeSelectItemModel.Entry(fillFactor, ItemModelUtils.plainModel(models.get(i))));
        }

        itemModels.itemModelOutput.accept(
                block.asItem(),
                ItemModelUtils.rangeSelect(
                        new EnergyFillLevelProperty(), ItemModelUtils.plainModel(models.getFirst()), itemLevelEntries));

    }
}

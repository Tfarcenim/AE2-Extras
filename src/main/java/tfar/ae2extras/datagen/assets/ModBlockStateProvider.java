package tfar.ae2extras.datagen.assets;

import appeng.block.crafting.AbstractCraftingUnitBlock;
import appeng.block.networking.EnergyCellBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.common.data.ExistingFileHelper;
import tfar.ae2extras.AE2Extras;
import tfar.ae2extras.init.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput gen, ExistingFileHelper exFileHelper) {
        super(gen, AE2Extras.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        builtInBlockModel("crafting/accelerator_formed");
        builtInBlockModel("crafting/1m_storage_formed");
        builtInBlockModel("crafting/4m_storage_formed");
        builtInBlockModel("crafting/16m_storage_formed");
        builtInBlockModel("crafting/64m_storage_formed");

        //craftingModel(ModBlocks.CRAFTING_ACCELERATOR, "accelerator");
        craftingModel(ModBlocks.CRAFTING_STORAGE_1M, "1m_storage");
        craftingModel(ModBlocks.CRAFTING_STORAGE_4M, "4m_storage");
        craftingModel(ModBlocks.CRAFTING_STORAGE_16M, "16m_storage");
        craftingModel(ModBlocks.CRAFTING_STORAGE_64M, "64m_storage");

        //{
        //  "variants": {
        //    "fullness=0": {
        //      "model": "ae2:block/energy_cell_0"
        //    },
        //    "fullness=1": {
        //      "model": "ae2:block/energy_cell_1"
        //    },
        //    "fullness=2": {
        //      "model": "ae2:block/energy_cell_2"
        //    },
        //    "fullness=3": {
        //      "model": "ae2:block/energy_cell_3"
        //    },
        //    "fullness=4": {
        //      "model": "ae2:block/energy_cell_4"
        //    }
        //  }
        //}

        energyCell(ModBlocks.DENSER_ENERGY_CELL);
        energyCell(ModBlocks.DENSEST_ENERGY_CELL);
    }

    private void energyCell(EnergyCellBlock block) {
        String s = BuiltInRegistries.BLOCK.getKey(block).getPath();
        getVariantBuilder(block).forAllStates(state -> {
            int fullness = state.getValue(EnergyCellBlock.ENERGY_STORAGE);
            ModelFile modelFile = models().cubeAll(s+"_"+fullness,new ResourceLocation("ae2","block/dense_energy_cell_"+fullness));
            return ConfiguredModel.builder().modelFile(modelFile).build();
        });
        ModelFile model = itemModels().getBuilder(s)
                        .parent(models().getExistingFile(modLoc("block/"+s+"_0")))
                .override().predicate(new ResourceLocation( "ae2","fill_level"),0.2f)
                .model(models().getExistingFile(modLoc("block/"+s+"_1"))).end()
                .override().predicate(new ResourceLocation( "ae2","fill_level"),0.4f)
                .model(models().getExistingFile(modLoc("block/"+s+"_2"))).end()
                .override().predicate(new ResourceLocation( "ae2","fill_level"),0.6f)
                .model(models().getExistingFile(modLoc("block/"+s+"_3"))).end()
                .override().predicate(new ResourceLocation( "ae2","fill_level"),0.8f)
                .model(models().getExistingFile(modLoc("block/"+s+"_4")))
                .end()
                ;
    }

    private void craftingModel(Block block, String name) {
        BlockModelBuilder blockModel = models().cubeAll("block/crafting/" + name, AE2Extras.id("block/crafting/" + name));
        getVariantBuilder(block)
                .partialState().with(AbstractCraftingUnitBlock.FORMED, false).setModels(
                        new ConfiguredModel(blockModel))
                .partialState().with(AbstractCraftingUnitBlock.FORMED, true).setModels(
                        // Empty model, will be replaced dynamically
                        new ConfiguredModel(models().getBuilder("block/crafting/" + name + "_formed")));
        simpleBlockItem(block, blockModel);
    }

    private void builtInModel(Block block) {
        builtInModel(block, false);
    }

    private void builtInModel(Block block, boolean skipItem) {
        BlockModelBuilder model = builtInBlockModel(BuiltInRegistries.BLOCK.getKey(block).getPath());
        getVariantBuilder(block).partialState().setModels(new ConfiguredModel(model));

        if (!skipItem) {
            // The item model should not reference the block model since that will be replaced in-code
            itemModels().getBuilder(BuiltInRegistries.BLOCK.getKey(block).getPath());
        }
    }

    private BlockModelBuilder builtInBlockModel(String name) {
        BlockModelBuilder model = models().getBuilder("block/" + name);
        return model;
    }
}

package tfar.ae2extras.datagen.assets;

import appeng.block.crafting.AbstractCraftingUnitBlock;
import appeng.core.AppEng;
import appeng.core.definitions.AEBlocks;
import appeng.core.definitions.BlockDefinition;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.CustomLoaderBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import tfar.ae2extras.AE2Extras;
import tfar.ae2extras.init.ModBlocks;

import static appeng.core.AppEng.makeId;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
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
    }

    private void craftingModel(Block block, String name) {
        BlockModelBuilder blockModel = models().cubeAll("block/crafting/" + name, AE2Extras.makeId("block/crafting/" + name));
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
        BlockModelBuilder model = builtInBlockModel(Registry.BLOCK.getKey(block).getPath());
        getVariantBuilder(block).partialState().setModels(new ConfiguredModel(model));

        if (!skipItem) {
            // The item model should not reference the block model since that will be replaced in-code
            itemModels().getBuilder(Registry.BLOCK.getKey(block).getPath());
        }
    }

    private BlockModelBuilder builtInBlockModel(String name) {
        BlockModelBuilder model = models().getBuilder("block/" + name);
        ResourceLocation loaderId = AppEng.makeId("block/" + name);
        model.customLoader((bmb, efh) -> new CustomLoaderBuilder<>(loaderId, bmb, efh) {
        });
        return model;
    }


}

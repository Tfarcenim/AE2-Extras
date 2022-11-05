package tfar.ae2extras.datagen.data;

import appeng.core.definitions.AEBlocks;
import appeng.core.definitions.AEItems;
import appeng.datagen.providers.tags.ConventionTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import tfar.ae2extras.AE2Extras;
import tfar.ae2extras.init.ModBlocks;
import tfar.ae2extras.init.ModItems;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(ModBlocks.CRAFTING_STORAGE_1M)
                .requires(AEBlocks.CRAFTING_UNIT)
                .requires(ModItems.CELL_COMPONENT_1M)
                .unlockedBy("has_crafting_unit", has(AEBlocks.CRAFTING_UNIT))
                .save(consumer, AE2Extras.makeId("network/crafting/1m_cpu_crafting_storage"));
        ShapelessRecipeBuilder.shapeless(ModBlocks.CRAFTING_STORAGE_4M)
                .requires(ModItems.CELL_COMPONENT_4M)
                .requires(AEBlocks.CRAFTING_UNIT)
                .unlockedBy("has_crafting_unit", has(AEBlocks.CRAFTING_UNIT))
                .save(consumer, AE2Extras.makeId("network/crafting/4m_cpu_crafting_storage"));
        ShapelessRecipeBuilder.shapeless(ModBlocks.CRAFTING_STORAGE_16M)
                .requires(ModItems.CELL_COMPONENT_16M)
                .requires(AEBlocks.CRAFTING_UNIT)
                .unlockedBy("has_crafting_unit", has(AEBlocks.CRAFTING_UNIT))
                .save(consumer, AE2Extras.makeId("network/crafting/16m_cpu_crafting_storage"));
        ShapelessRecipeBuilder.shapeless(ModBlocks.CRAFTING_STORAGE_64M)
                .requires(AEBlocks.CRAFTING_UNIT)
                .requires(ModItems.CELL_COMPONENT_64M)
                .unlockedBy("has_crafting_unit", has(AEBlocks.CRAFTING_UNIT))
                .save(consumer, AE2Extras.makeId("network/crafting/64m_cpu_crafting_storage"));
        
        addItemCells(consumer);
        addFluidCells(consumer);
    }

    private void addItemCells(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(ModItems.CELL_COMPONENT_1M)
                .pattern("aba")
                .pattern("bcb")
                .pattern("aba")
                .define('a', ConventionTags.REDSTONE)
                .define('b', ConventionTags.ALL_CERTUS_QUARTZ)
                .define('c', AEItems.LOGIC_PROCESSOR)
                .unlockedBy("has_logic_processor", has(AEItems.LOGIC_PROCESSOR))
                .save(consumer, AE2Extras.makeId("network/cells/item_storage_components_cell_1m_part"));
        ShapedRecipeBuilder.shaped(ModItems.CELL_COMPONENT_4M)
                .pattern("aba")
                .pattern("cdc")
                .pattern("aca")
                .define('a', ConventionTags.REDSTONE)
                .define('b', AEItems.CALCULATION_PROCESSOR)
                .define('c', ModItems.CELL_COMPONENT_1M)
                .define('d', AEBlocks.QUARTZ_GLASS)
                .unlockedBy("has_cell_component_1m", has(ModItems.CELL_COMPONENT_1M))
                .save(consumer, AE2Extras.makeId("network/cells/item_storage_components_cell_4m_part"));
        ShapedRecipeBuilder.shaped(ModItems.CELL_COMPONENT_16M)
                .pattern("aba")
                .pattern("cdc")
                .pattern("aca")
                .define('a', ConventionTags.GLOWSTONE)
                .define('b', AEItems.CALCULATION_PROCESSOR)
                .define('c', ModItems.CELL_COMPONENT_4M)
                .define('d', AEBlocks.QUARTZ_GLASS)
                .unlockedBy("has_cell_component_4m", has(ModItems.CELL_COMPONENT_4M))
                .save(consumer, AE2Extras.makeId("network/cells/item_storage_components_cell_16k_part"));
        ShapedRecipeBuilder.shaped(ModItems.CELL_COMPONENT_64M)
                .pattern("aba")
                .pattern("cdc")
                .pattern("aca")
                .define('a', ConventionTags.GLOWSTONE)
                .define('b', AEItems.CALCULATION_PROCESSOR)
                .define('c', ModItems.CELL_COMPONENT_16M)
                .define('d', AEBlocks.QUARTZ_GLASS)
                .unlockedBy("has_cell_component_16k", has(ModItems.CELL_COMPONENT_16M))
                .save(consumer, AE2Extras.makeId("network/cells/item_storage_components_cell_64m_part"));

        ShapedRecipeBuilder.shaped(ModItems.ITEM_CELL_1M)
                .pattern("aba")
                .pattern("bcb")
                .pattern("ddd")
                .define('a', AEBlocks.QUARTZ_GLASS)
                .define('b', ConventionTags.REDSTONE)
                .define('c', ModItems.CELL_COMPONENT_1M)
                .define('d', ConventionTags.IRON_INGOT)
                .unlockedBy("has_cell_component_1m", has(ModItems.CELL_COMPONENT_1M))
                .save(consumer, AE2Extras.makeId("network/cells/item_storage_cell_1m"));
        ShapelessRecipeBuilder.shapeless(ModItems.ITEM_CELL_1M)
                .requires(AEItems.ITEM_CELL_HOUSING)
                .requires(ModItems.CELL_COMPONENT_1M)
                .unlockedBy("has_cell_component_1m", has(ModItems.CELL_COMPONENT_1M))
                .unlockedBy("has_item_cell_housing", has(AEItems.ITEM_CELL_HOUSING))
                .save(consumer, AE2Extras.makeId("network/cells/item_storage_cell_1m_storage"));

        ShapedRecipeBuilder.shaped(ModItems.ITEM_CELL_4M)
                .pattern("aba")
                .pattern("bcb")
                .pattern("ddd")
                .define('a', AEBlocks.QUARTZ_GLASS)
                .define('b', ConventionTags.REDSTONE)
                .define('c', ModItems.CELL_COMPONENT_4M)
                .define('d', ConventionTags.IRON_INGOT)
                .unlockedBy("has_cell_component_4m", has(ModItems.CELL_COMPONENT_4M))
                .save(consumer, AE2Extras.makeId("network/cells/item_storage_cell_4m"));
        ShapelessRecipeBuilder.shapeless(ModItems.ITEM_CELL_4M)
                .requires(AEItems.ITEM_CELL_HOUSING)
                .requires(ModItems.CELL_COMPONENT_4M)
                .unlockedBy("has_cell_component_4m", has(ModItems.CELL_COMPONENT_4M))
                .save(consumer, AE2Extras.makeId("network/cells/item_storage_cell_4m_storage"));

        ShapedRecipeBuilder.shaped(ModItems.ITEM_CELL_16M)
                .pattern("aba")
                .pattern("bcb")
                .pattern("ddd")
                .define('a', AEBlocks.QUARTZ_GLASS)
                .define('b', ConventionTags.REDSTONE)
                .define('c', ModItems.CELL_COMPONENT_16M)
                .define('d', ConventionTags.IRON_INGOT)
                .unlockedBy("has_cell_component_16k", has(ModItems.CELL_COMPONENT_16M))
                .save(consumer, AE2Extras.makeId("network/cells/item_storage_cell_16k"));
        ShapelessRecipeBuilder.shapeless(ModItems.ITEM_CELL_16M)
                .requires(ModItems.CELL_COMPONENT_16M)
                .requires(AEItems.ITEM_CELL_HOUSING)
                .unlockedBy("has_cell_component_16k", has(ModItems.CELL_COMPONENT_16M))
                .save(consumer, AE2Extras.makeId("network/cells/item_storage_cell_16k_storage"));

        ShapedRecipeBuilder.shaped(ModItems.ITEM_CELL_64M)
                .pattern("aba")
                .pattern("bcb")
                .pattern("ddd")
                .define('a', AEBlocks.QUARTZ_GLASS)
                .define('b', ConventionTags.REDSTONE)
                .define('c', ModItems.CELL_COMPONENT_64M)
                .define('d', ConventionTags.IRON_INGOT)
                .unlockedBy("has_cell_component_64m", has(ModItems.CELL_COMPONENT_64M))
                .save(consumer, AE2Extras.makeId("network/cells/item_storage_cell_64m"));
        ShapelessRecipeBuilder.shapeless(ModItems.ITEM_CELL_64M)
                .requires(AEItems.ITEM_CELL_HOUSING)
                .requires(ModItems.CELL_COMPONENT_64M)
                .unlockedBy("has_cell_component_64m", has(ModItems.CELL_COMPONENT_64M))
                .save(consumer, AE2Extras.makeId("network/cells/item_storage_cell_64m_storage"));
    }

    private void addFluidCells(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(ModItems.FLUID_CELL_1M)
                .pattern("aba")
                .pattern("bcb")
                .pattern("ddd")
                .define('a', AEBlocks.QUARTZ_GLASS)
                .define('b', ConventionTags.REDSTONE)
                .define('c', ModItems.CELL_COMPONENT_1M)
                .define('d', ConventionTags.COPPER_INGOT)
                .unlockedBy("has_cell_component_1m", has(ModItems.CELL_COMPONENT_1M))
                .save(consumer, AE2Extras.makeId("network/cells/fluid_storage_cell_1m"));
        ShapelessRecipeBuilder.shapeless(ModItems.FLUID_CELL_1M)
                .requires(AEItems.FLUID_CELL_HOUSING)
                .requires(ModItems.CELL_COMPONENT_1M)
                .unlockedBy("has_item_cell_housing", has(AEItems.FLUID_CELL_HOUSING))
                .unlockedBy("has_cell_component_1m", has(ModItems.CELL_COMPONENT_1M))
                .save(consumer, AE2Extras.makeId("network/cells/fluid_storage_cell_1m_storage"));

        ShapedRecipeBuilder.shaped(ModItems.FLUID_CELL_4M)
                .pattern("aba")
                .pattern("bcb")
                .pattern("ddd")
                .define('a', AEBlocks.QUARTZ_GLASS)
                .define('b', ConventionTags.REDSTONE)
                .define('c', ModItems.CELL_COMPONENT_4M)
                .define('d', ConventionTags.COPPER_INGOT)
                .unlockedBy("has_cell_component_4m", has(ModItems.CELL_COMPONENT_4M))
                .save(consumer, AE2Extras.makeId("network/cells/fluid_storage_cell_4m"));
        ShapelessRecipeBuilder.shapeless(ModItems.FLUID_CELL_4M)
                .requires(AEItems.FLUID_CELL_HOUSING)
                .requires(ModItems.CELL_COMPONENT_4M)
                .unlockedBy("has_cell_component_4m", has(ModItems.CELL_COMPONENT_4M))
                .save(consumer, AE2Extras.makeId("network/cells/fluid_storage_cell_4m_storage"));

        ShapedRecipeBuilder.shaped(ModItems.FLUID_CELL_16M)
                .pattern("aba")
                .pattern("bcb")
                .pattern("ddd")
                .define('a', AEBlocks.QUARTZ_GLASS)
                .define('b', ConventionTags.REDSTONE)
                .define('c', ModItems.CELL_COMPONENT_16M)
                .define('d', ConventionTags.COPPER_INGOT)
                .unlockedBy("has_cell_component_16k", has(ModItems.CELL_COMPONENT_16M))
                .save(consumer, AE2Extras.makeId("network/cells/fluid_storage_cell_16k"));
        ShapelessRecipeBuilder.shapeless(ModItems.FLUID_CELL_16M)
                .requires(AEItems.FLUID_CELL_HOUSING)
                .requires(ModItems.CELL_COMPONENT_16M)
                .unlockedBy("has_cell_component_16k", has(ModItems.CELL_COMPONENT_16M))
                .save(consumer, AE2Extras.makeId("network/cells/fluid_storage_cell_16k_storage"));

        ShapedRecipeBuilder.shaped(ModItems.FLUID_CELL_64M)
                .pattern("aba")
                .pattern("bcb")
                .pattern("ddd")
                .define('a', AEBlocks.QUARTZ_GLASS)
                .define('b', ConventionTags.REDSTONE)
                .define('c', ModItems.CELL_COMPONENT_64M)
                .define('d', ConventionTags.COPPER_INGOT)
                .unlockedBy("has_cell_component_64m", has(ModItems.CELL_COMPONENT_64M))
                .save(consumer, AE2Extras.makeId("network/cells/fluid_storage_cell_64m"));
        ShapelessRecipeBuilder.shapeless(ModItems.FLUID_CELL_64M)
                .requires(AEItems.FLUID_CELL_HOUSING)
                .requires(ModItems.CELL_COMPONENT_64M)
                .unlockedBy("has_cell_component_64m", has(ModItems.CELL_COMPONENT_64M))
                .save(consumer, AE2Extras.makeId("network/cells/fluid_storage_cell_64m_storage"));
    }
}

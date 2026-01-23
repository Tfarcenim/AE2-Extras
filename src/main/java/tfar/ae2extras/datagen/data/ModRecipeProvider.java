package tfar.ae2extras.datagen.data;

import appeng.core.definitions.AEBlocks;
import appeng.core.definitions.AEItems;
import appeng.datagen.providers.tags.ConventionTags;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import tfar.ae2extras.AE2Extras;
import tfar.ae2extras.init.ModBlocks;
import tfar.ae2extras.init.ModItems;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE,ModBlocks.CRAFTING_STORAGE_1M)
                .requires(AEBlocks.CRAFTING_UNIT)
                .requires(ModItems.CELL_COMPONENT_1M)
                .unlockedBy("has_crafting_unit", has(AEBlocks.CRAFTING_UNIT))
                .save(consumer, AE2Extras.id("network/crafting/1m_cpu_crafting_storage"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE,ModBlocks.CRAFTING_STORAGE_4M)
                .requires(ModItems.CELL_COMPONENT_4M)
                .requires(AEBlocks.CRAFTING_UNIT)
                .unlockedBy("has_crafting_unit", has(AEBlocks.CRAFTING_UNIT))
                .save(consumer, AE2Extras.id("network/crafting/4m_cpu_crafting_storage"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE,ModBlocks.CRAFTING_STORAGE_16M)
                .requires(ModItems.CELL_COMPONENT_16M)
                .requires(AEBlocks.CRAFTING_UNIT)
                .unlockedBy("has_crafting_unit", has(AEBlocks.CRAFTING_UNIT))
                .save(consumer, AE2Extras.id("network/crafting/16m_cpu_crafting_storage"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE,ModBlocks.CRAFTING_STORAGE_64M)
                .requires(AEBlocks.CRAFTING_UNIT)
                .requires(ModItems.CELL_COMPONENT_64M)
                .unlockedBy("has_crafting_unit", has(AEBlocks.CRAFTING_UNIT))
                .save(consumer, AE2Extras.id("network/crafting/64m_cpu_crafting_storage"));

        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE,ModItems.CELL_COMPONENT_1M)
                .pattern("aba")
                .pattern("bcb")
                .pattern("aba")
                .define('a', ConventionTags.REDSTONE)
                .define('b', ConventionTags.ALL_CERTUS_QUARTZ)
                .define('c', AEItems.LOGIC_PROCESSOR)
                .unlockedBy("has_logic_processor", has(AEItems.LOGIC_PROCESSOR))
                .save(consumer, AE2Extras.id("network/cells/item_storage_components_cell_1m_part"));
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE,ModItems.CELL_COMPONENT_4M)
                .pattern("aba")
                .pattern("cdc")
                .pattern("aca")
                .define('a', ConventionTags.REDSTONE)
                .define('b', AEItems.CALCULATION_PROCESSOR)
                .define('c', ModItems.CELL_COMPONENT_1M)
                .define('d', AEBlocks.QUARTZ_GLASS)
                .unlockedBy("has_cell_component_1m", has(ModItems.CELL_COMPONENT_1M))
                .save(consumer, AE2Extras.id("network/cells/item_storage_components_cell_4m_part"));
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE,ModItems.CELL_COMPONENT_16M)
                .pattern("aba")
                .pattern("cdc")
                .pattern("aca")
                .define('a', ConventionTags.GLOWSTONE)
                .define('b', AEItems.CALCULATION_PROCESSOR)
                .define('c', ModItems.CELL_COMPONENT_4M)
                .define('d', AEBlocks.QUARTZ_GLASS)
                .unlockedBy("has_cell_component_4m", has(ModItems.CELL_COMPONENT_4M))
                .save(consumer, AE2Extras.id("network/cells/item_storage_components_cell_16m_part"));
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE,ModItems.CELL_COMPONENT_64M)
                .pattern("aba")
                .pattern("cdc")
                .pattern("aca")
                .define('a', ConventionTags.GLOWSTONE)
                .define('b', AEItems.CALCULATION_PROCESSOR)
                .define('c', ModItems.CELL_COMPONENT_16M)
                .define('d', AEBlocks.QUARTZ_GLASS)
                .unlockedBy("has_cell_component_16k", has(ModItems.CELL_COMPONENT_16M))
                .save(consumer, AE2Extras.id("network/cells/item_storage_components_cell_64m_part"));

        cells(consumer,ModItems.CELL_COMPONENT_1M,ModItems.ITEM_CELL_1M,ModItems.FLUID_CELL_1M);
        cells(consumer,ModItems.CELL_COMPONENT_4M,ModItems.ITEM_CELL_4M,ModItems.FLUID_CELL_4M);
        cells(consumer,ModItems.CELL_COMPONENT_16M,ModItems.ITEM_CELL_16M,ModItems.FLUID_CELL_16M);
        cells(consumer,ModItems.CELL_COMPONENT_64M,ModItems.ITEM_CELL_64M,ModItems.FLUID_CELL_64M);

    }

    protected void cells(Consumer<FinishedRecipe> consumer, Item cellComponent,Item itemCell,Item fluidCell) {
        itemCell(consumer,cellComponent,itemCell);
        fluidCell(consumer,cellComponent,fluidCell);
    }


        protected void itemCell(Consumer<FinishedRecipe> consumer, Item cellComponent,Item result) {
        String s= BuiltInRegistries.ITEM.getKey(result).getPath();
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE,result)
                .pattern("aba")
                .pattern("bcb")
                .pattern("ddd")
                .define('a', AEBlocks.QUARTZ_GLASS)
                .define('b', ConventionTags.REDSTONE)
                .define('c', cellComponent)
                .define('d', ConventionTags.IRON_INGOT)
                .unlockedBy(getHasName(cellComponent), has(cellComponent))
                .save(consumer, AE2Extras.id("network/cells/"+s));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE,result)
                .requires(AEItems.ITEM_CELL_HOUSING)
                .requires(cellComponent)
                .unlockedBy(getHasName(cellComponent), has(cellComponent))
                .save(consumer, AE2Extras.id("network/cells/"+s+"_storage"));
    }

    protected void fluidCell(Consumer<FinishedRecipe> consumer, Item cellComponent,Item result){
        String s= BuiltInRegistries.ITEM.getKey(result).getPath();
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE,result)
                .pattern("aba")
                .pattern("bcb")
                .pattern("ddd")
                .define('a', AEBlocks.QUARTZ_GLASS)
                .define('b', ConventionTags.REDSTONE)
                .define('c', cellComponent)
                .define('d', ConventionTags.COPPER_INGOT)
                .unlockedBy(getHasName(cellComponent), has(cellComponent))
                .save(consumer, AE2Extras.id("network/cells/"+s));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE,result)
                .requires(AEItems.FLUID_CELL_HOUSING)
                .requires(cellComponent)
                .unlockedBy(getHasName(cellComponent), has(cellComponent))
                .save(consumer, AE2Extras.id("network/cells/"+s+"_storage"));
    }
}

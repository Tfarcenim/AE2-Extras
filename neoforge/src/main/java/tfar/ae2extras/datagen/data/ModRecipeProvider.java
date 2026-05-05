package tfar.ae2extras.datagen.data;

import appeng.api.stacks.AEKeyType;
import appeng.core.definitions.AEBlocks;
import appeng.core.definitions.AEItems;
import appeng.datagen.providers.tags.ConventionTags;
import appeng.items.tools.powered.PortableCellItem;
import me.ramidzkh.mekae2.AMItems;
import me.ramidzkh.mekae2.ae2.MekanismKeyType;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import tfar.ae2extras.AE2Extras;
import tfar.ae2extras.init.ModBlocks;
import tfar.ae2extras.init.AE2ExtrasItems;
import tfar.ae2extras.integration.mekanism.MItems;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {

    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput consumer) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE,ModBlocks.CRAFTING_STORAGE_1M)
                .requires(AEBlocks.CRAFTING_UNIT)
                .requires(AE2ExtrasItems.CELL_COMPONENT_1M)
                .unlockedBy("has_crafting_unit", has(AEBlocks.CRAFTING_UNIT))
                .save(consumer, AE2Extras.id("network/crafting/1m_cpu_crafting_storage"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE,ModBlocks.CRAFTING_STORAGE_4M)
                .requires(AE2ExtrasItems.CELL_COMPONENT_4M)
                .requires(AEBlocks.CRAFTING_UNIT)
                .unlockedBy("has_crafting_unit", has(AEBlocks.CRAFTING_UNIT))
                .save(consumer, AE2Extras.id("network/crafting/4m_cpu_crafting_storage"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE,ModBlocks.CRAFTING_STORAGE_16M)
                .requires(AE2ExtrasItems.CELL_COMPONENT_16M)
                .requires(AEBlocks.CRAFTING_UNIT)
                .unlockedBy("has_crafting_unit", has(AEBlocks.CRAFTING_UNIT))
                .save(consumer, AE2Extras.id("network/crafting/16m_cpu_crafting_storage"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE,ModBlocks.CRAFTING_STORAGE_64M)
                .requires(AEBlocks.CRAFTING_UNIT)
                .requires(AE2ExtrasItems.CELL_COMPONENT_64M)
                .unlockedBy("has_crafting_unit", has(AEBlocks.CRAFTING_UNIT))
                .save(consumer, AE2Extras.id("network/crafting/64m_cpu_crafting_storage"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ModBlocks.DENSER_ENERGY_CELL)
                .pattern("aaa")
                .pattern("aba")
                .pattern("aaa")
                .define('a', AEBlocks.DENSE_ENERGY_CELL)
                .define('b', AEItems.CALCULATION_PROCESSOR)
                .unlockedBy("has_dense_energy_cell", has(AEBlocks.DENSE_ENERGY_CELL))
                .save(consumer, AE2Extras.id("network/blocks/energy_denser_energy_cell"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.DENSEST_ENERGY_CELL)
                .pattern("aaa")
                .pattern("aba")
                .pattern("aaa")
                .define('a', ModBlocks.DENSER_ENERGY_CELL)
                .define('b', AEItems.CALCULATION_PROCESSOR)
                .unlockedBy("has_denser_energy_cell", has(ModBlocks.DENSER_ENERGY_CELL))
                .save(consumer, AE2Extras.id("network/blocks/energy_densest_energy_cell"));

        cells(consumer, AE2ExtrasItems.CELL_COMPONENT_1M, AE2ExtrasItems.ITEM_CELL_1M, AE2ExtrasItems.FLUID_CELL_1M, MItems.CHEMICAL_CELL_1M);
        cells(consumer, AE2ExtrasItems.CELL_COMPONENT_4M, AE2ExtrasItems.ITEM_CELL_4M, AE2ExtrasItems.FLUID_CELL_4M, MItems.CHEMICAL_CELL_4M);
        cells(consumer, AE2ExtrasItems.CELL_COMPONENT_16M, AE2ExtrasItems.ITEM_CELL_16M, AE2ExtrasItems.FLUID_CELL_16M, MItems.CHEMICAL_CELL_16M);
        cells(consumer, AE2ExtrasItems.CELL_COMPONENT_64M, AE2ExtrasItems.ITEM_CELL_64M, AE2ExtrasItems.FLUID_CELL_64M, MItems.CHEMICAL_CELL_64M);

        cellComponent(consumer,AEItems.CELL_COMPONENT_256K.asItem(),ConventionTags.REDSTONE,AEItems.CALCULATION_PROCESSOR.asItem(), AE2ExtrasItems.CELL_COMPONENT_1M);
        cellComponent(consumer, AE2ExtrasItems.CELL_COMPONENT_1M,ConventionTags.REDSTONE,AEItems.CALCULATION_PROCESSOR.asItem(), AE2ExtrasItems.CELL_COMPONENT_4M);
        cellComponent(consumer, AE2ExtrasItems.CELL_COMPONENT_4M,ConventionTags.GLOWSTONE,AEItems.CALCULATION_PROCESSOR.asItem(), AE2ExtrasItems.CELL_COMPONENT_16M);
        cellComponent(consumer, AE2ExtrasItems.CELL_COMPONENT_16M,ConventionTags.GLOWSTONE,AEItems.CALCULATION_PROCESSOR.asItem(), AE2ExtrasItems.CELL_COMPONENT_64M);

        monoCell(consumer,AEItems.ITEM_CELL_1K.asItem(), AE2ExtrasItems.MONO_ITEM_CELL_1K);
        monoCell(consumer,AEItems.ITEM_CELL_4K.asItem(), AE2ExtrasItems.MONO_ITEM_CELL_4K);
        monoCell(consumer,AEItems.ITEM_CELL_16K.asItem(), AE2ExtrasItems.MONO_ITEM_CELL_16K);
        monoCell(consumer,AEItems.ITEM_CELL_64K.asItem(), AE2ExtrasItems.MONO_ITEM_CELL_64K);
        monoCell(consumer,AEItems.ITEM_CELL_256K.asItem(), AE2ExtrasItems.MONO_ITEM_CELL_256K);
        monoCell(consumer,AE2ExtrasItems.ITEM_CELL_1M.asItem(), AE2ExtrasItems.MONO_ITEM_CELL_1M);
        monoCell(consumer,AE2ExtrasItems.ITEM_CELL_4M.asItem(), AE2ExtrasItems.MONO_ITEM_CELL_4M);
        monoCell(consumer,AE2ExtrasItems.ITEM_CELL_16M.asItem(), AE2ExtrasItems.MONO_ITEM_CELL_16M);
        monoCell(consumer,AE2ExtrasItems.ITEM_CELL_64M.asItem(), AE2ExtrasItems.MONO_ITEM_CELL_64M);

        monoCell(consumer,AEItems.FLUID_CELL_1K.asItem(), AE2ExtrasItems.MONO_FLUID_CELL_1K);
        monoCell(consumer,AEItems.FLUID_CELL_4K.asItem(), AE2ExtrasItems.MONO_FLUID_CELL_4K);
        monoCell(consumer,AEItems.FLUID_CELL_16K.asItem(), AE2ExtrasItems.MONO_FLUID_CELL_16K);
        monoCell(consumer,AEItems.FLUID_CELL_64K.asItem(), AE2ExtrasItems.MONO_FLUID_CELL_64K);
        monoCell(consumer,AEItems.FLUID_CELL_256K.asItem(), AE2ExtrasItems.MONO_FLUID_CELL_256K);
        monoCell(consumer,AE2ExtrasItems.FLUID_CELL_1M.asItem(), AE2ExtrasItems.MONO_FLUID_CELL_1M);
        monoCell(consumer,AE2ExtrasItems.FLUID_CELL_4M.asItem(), AE2ExtrasItems.MONO_FLUID_CELL_4M);
        monoCell(consumer,AE2ExtrasItems.FLUID_CELL_16M.asItem(), AE2ExtrasItems.MONO_FLUID_CELL_16M);
        monoCell(consumer,AE2ExtrasItems.FLUID_CELL_64M.asItem(), AE2ExtrasItems.MONO_FLUID_CELL_64M);

        portableCell(consumer,AE2ExtrasItems.PORTABLE_ITEM_CELL_1M);
        portableCell(consumer,AE2ExtrasItems.PORTABLE_ITEM_CELL_4M);
        portableCell(consumer,AE2ExtrasItems.PORTABLE_ITEM_CELL_16M);
        portableCell(consumer,AE2ExtrasItems.PORTABLE_ITEM_CELL_64M);

        portableCell(consumer,AE2ExtrasItems.PORTABLE_FLUID_CELL_1M);
        portableCell(consumer,AE2ExtrasItems.PORTABLE_FLUID_CELL_4M);
        portableCell(consumer,AE2ExtrasItems.PORTABLE_FLUID_CELL_16M);
        portableCell(consumer,AE2ExtrasItems.PORTABLE_FLUID_CELL_64M);


        portableCell(consumer,MItems.PORTABLE_CHEMICAL_STORAGE_CELL_1M);
        portableCell(consumer,MItems.PORTABLE_CHEMICAL_STORAGE_CELL_4M);
        portableCell(consumer,MItems.PORTABLE_CHEMICAL_STORAGE_CELL_16M);
        portableCell(consumer,MItems.PORTABLE_CHEMICAL_STORAGE_CELL_64M);
    }

    private void portableCell(RecipeOutput consumer, PortableCellItem cell) {
        Item housing;
        if (cell.getKeyType() == AEKeyType.items()) {
            housing = AEItems.ITEM_CELL_HOUSING.asItem();
        } else if (cell.getKeyType() == AEKeyType.fluids()) {
            housing = AEItems.FLUID_CELL_HOUSING.asItem();
        } else if (cell.getKeyType() == MekanismKeyType.TYPE) {
            housing = AMItems.CHEMICAL_CELL_HOUSING.get();
        } else {
            throw new RuntimeException("No housing known for " + cell.asItem());
        }

        var component = cell.getTier().componentSupplier().get();
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, cell)
                .requires(AEBlocks.SKY_STONE_CHEST)
                .requires(component)
                .requires(AEBlocks.ENERGY_CELL)
                .requires(housing)
                .unlockedBy("has_housing", has(housing))
                .unlockedBy("has_energy_cell", has(AEBlocks.ENERGY_CELL))
                .save(consumer, cell.getRecipeId());
    }

    protected void monoCell(RecipeOutput consumer,Item cell,Item result){
        ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE,result)
                .requires(cell).requires(AEItems.CALCULATION_PROCESSOR)
                .unlockedBy(getHasName(cell),has(cell))
                .save(consumer);
    }
    protected void cellComponent(RecipeOutput consumer, Item previous, TagKey<Item> addition, Item processor, Item result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE,result)
                .pattern("aba")
                .pattern("cdc")
                .pattern("aca")
                .define('a',addition)
                .define('b',processor)
                .define('c', previous)
                .define('d', AEBlocks.QUARTZ_GLASS)
                .unlockedBy(getHasName(previous), has(previous))
                .save(consumer);
    }

    protected void cells(RecipeOutput consumer, Item cellComponent,Item itemCell,Item fluidCell,Item chemicalCell) {
        itemCell(consumer,cellComponent,itemCell);
        fluidCell(consumer,cellComponent,fluidCell);
        chemicalCell(consumer,cellComponent,chemicalCell);
    }


        protected void itemCell(RecipeOutput consumer, Item cellComponent,Item result) {
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

    protected void chemicalCell(RecipeOutput consumer, Item cellComponent,Item result) {
        String s= BuiltInRegistries.ITEM.getKey(result).getPath();
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE,result)
                .pattern("aba")
                .pattern("bcb")
                .pattern("ddd")
                .define('a', AEBlocks.QUARTZ_GLASS)
                .define('b', ConventionTags.REDSTONE)
                .define('c', cellComponent)
                .define('d',  INGOTS_OSMIUM)
                .unlockedBy(getHasName(cellComponent), has(cellComponent))
                .save(consumer, AE2Extras.id("network/cells/"+s));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE,result)
                .requires(AMItems.CHEMICAL_CELL_HOUSING.get())
                .requires(cellComponent)
                .unlockedBy(getHasName(cellComponent), has(cellComponent))
                .save(consumer, AE2Extras.id("network/cells/"+s+"_storage"));
    }

    public static final TagKey<Item> INGOTS_OSMIUM = TagKey.create(Registries.ITEM, AE2Extras.id("ingots/osmium"));

    protected void fluidCell(RecipeOutput consumer, Item cellComponent,Item result){
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

package tfar.ae2extras.datagen.data;

import appeng.api.stacks.AEKeyType;
import appeng.core.ConventionTags;
import appeng.core.definitions.AEBlocks;
import appeng.core.definitions.AEItems;
import appeng.items.materials.StorageComponentItem;
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
import tfar.ae2extras.init.AE2ExtrasBlocks;
import tfar.ae2extras.init.AE2ExtrasItems;
import tfar.ae2extras.integration.Integration;
import tfar.ae2extras.integration.mekanism.MItems;

import java.util.concurrent.CompletableFuture;

public class AE2ExtrasRecipeProvider extends RecipeProvider {


    protected AE2ExtrasRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    @Override
    protected void buildRecipes() {
        shapeless(RecipeCategory.REDSTONE, AE2ExtrasBlocks.CRAFTING_STORAGE_1M)
                .requires(AEBlocks.CRAFTING_UNIT)
                .requires(AE2ExtrasItems.CELL_COMPONENT_1M)
                .unlockedBy("has_crafting_unit", has(AEBlocks.CRAFTING_UNIT))
                .save(output);
        shapeless(RecipeCategory.REDSTONE, AE2ExtrasBlocks.CRAFTING_STORAGE_4M)
                .requires(AE2ExtrasItems.CELL_COMPONENT_4M)
                .requires(AEBlocks.CRAFTING_UNIT)
                .unlockedBy("has_crafting_unit", has(AEBlocks.CRAFTING_UNIT))
                .save(output);
        shapeless(RecipeCategory.REDSTONE, AE2ExtrasBlocks.CRAFTING_STORAGE_16M)
                .requires(AE2ExtrasItems.CELL_COMPONENT_16M)
                .requires(AEBlocks.CRAFTING_UNIT)
                .unlockedBy("has_crafting_unit", has(AEBlocks.CRAFTING_UNIT))
                .save(output);
        shapeless(RecipeCategory.REDSTONE, AE2ExtrasBlocks.CRAFTING_STORAGE_64M)
                .requires(AEBlocks.CRAFTING_UNIT)
                .requires(AE2ExtrasItems.CELL_COMPONENT_64M)
                .unlockedBy("has_crafting_unit", has(AEBlocks.CRAFTING_UNIT))
                .save(output);

        shaped(RecipeCategory.MISC, AE2ExtrasBlocks.DENSER_ENERGY_CELL)
                .pattern("aaa")
                .pattern("aba")
                .pattern("aaa")
                .define('a', AEBlocks.DENSE_ENERGY_CELL)
                .define('b', AEItems.CALCULATION_PROCESSOR)
                .unlockedBy("has_dense_energy_cell", has(AEBlocks.DENSE_ENERGY_CELL))
                .save(output);

        shaped(RecipeCategory.MISC, AE2ExtrasBlocks.DENSEST_ENERGY_CELL)
                .pattern("aaa")
                .pattern("aba")
                .pattern("aaa")
                .define('a', AE2ExtrasBlocks.DENSER_ENERGY_CELL)
                .define('b', AEItems.CALCULATION_PROCESSOR)
                .unlockedBy("has_denser_energy_cell", has(AE2ExtrasBlocks.DENSER_ENERGY_CELL))
                .save(output);

        cells(AE2ExtrasItems.CELL_COMPONENT_1M, AE2ExtrasItems.ITEM_CELL_1M, AE2ExtrasItems.FLUID_CELL_1M);
        cells(AE2ExtrasItems.CELL_COMPONENT_4M, AE2ExtrasItems.ITEM_CELL_4M, AE2ExtrasItems.FLUID_CELL_4M);
        cells(AE2ExtrasItems.CELL_COMPONENT_16M, AE2ExtrasItems.ITEM_CELL_16M, AE2ExtrasItems.FLUID_CELL_16M);
        cells(AE2ExtrasItems.CELL_COMPONENT_64M, AE2ExtrasItems.ITEM_CELL_64M, AE2ExtrasItems.FLUID_CELL_64M);

        cellComponent(AEItems.CELL_COMPONENT_256K.asItem(),ConventionTags.REDSTONE,AEItems.CALCULATION_PROCESSOR.asItem(), AE2ExtrasItems.CELL_COMPONENT_1M);
        cellComponent(AE2ExtrasItems.CELL_COMPONENT_1M,ConventionTags.REDSTONE,AEItems.CALCULATION_PROCESSOR.asItem(), AE2ExtrasItems.CELL_COMPONENT_4M);
        cellComponent(AE2ExtrasItems.CELL_COMPONENT_4M,ConventionTags.GLOWSTONE,AEItems.CALCULATION_PROCESSOR.asItem(), AE2ExtrasItems.CELL_COMPONENT_16M);
        cellComponent(AE2ExtrasItems.CELL_COMPONENT_16M,ConventionTags.GLOWSTONE,AEItems.CALCULATION_PROCESSOR.asItem(), AE2ExtrasItems.CELL_COMPONENT_64M);

        monoCell(AEItems.ITEM_CELL_1K.asItem(), AE2ExtrasItems.MONO_ITEM_CELL_1K);
        monoCell(AEItems.ITEM_CELL_4K.asItem(), AE2ExtrasItems.MONO_ITEM_CELL_4K);
        monoCell(AEItems.ITEM_CELL_16K.asItem(), AE2ExtrasItems.MONO_ITEM_CELL_16K);
        monoCell(AEItems.ITEM_CELL_64K.asItem(), AE2ExtrasItems.MONO_ITEM_CELL_64K);
        monoCell(AEItems.ITEM_CELL_256K.asItem(), AE2ExtrasItems.MONO_ITEM_CELL_256K);
        monoCell(AE2ExtrasItems.ITEM_CELL_1M.asItem(), AE2ExtrasItems.MONO_ITEM_CELL_1M);
        monoCell(AE2ExtrasItems.ITEM_CELL_4M.asItem(), AE2ExtrasItems.MONO_ITEM_CELL_4M);
        monoCell(AE2ExtrasItems.ITEM_CELL_16M.asItem(), AE2ExtrasItems.MONO_ITEM_CELL_16M);
        monoCell(AE2ExtrasItems.ITEM_CELL_64M.asItem(), AE2ExtrasItems.MONO_ITEM_CELL_64M);

        monoCell(AEItems.FLUID_CELL_1K.asItem(), AE2ExtrasItems.MONO_FLUID_CELL_1K);
        monoCell(AEItems.FLUID_CELL_4K.asItem(), AE2ExtrasItems.MONO_FLUID_CELL_4K);
        monoCell(AEItems.FLUID_CELL_16K.asItem(), AE2ExtrasItems.MONO_FLUID_CELL_16K);
        monoCell(AEItems.FLUID_CELL_64K.asItem(), AE2ExtrasItems.MONO_FLUID_CELL_64K);
        monoCell(AEItems.FLUID_CELL_256K.asItem(), AE2ExtrasItems.MONO_FLUID_CELL_256K);
        monoCell(AE2ExtrasItems.FLUID_CELL_1M.asItem(), AE2ExtrasItems.MONO_FLUID_CELL_1M);
        monoCell(AE2ExtrasItems.FLUID_CELL_4M.asItem(), AE2ExtrasItems.MONO_FLUID_CELL_4M);
        monoCell(AE2ExtrasItems.FLUID_CELL_16M.asItem(), AE2ExtrasItems.MONO_FLUID_CELL_16M);
        monoCell(AE2ExtrasItems.FLUID_CELL_64M.asItem(), AE2ExtrasItems.MONO_FLUID_CELL_64M);

        portableCell(AE2ExtrasItems.PORTABLE_ITEM_CELL_1M);
        portableCell(AE2ExtrasItems.PORTABLE_ITEM_CELL_4M);
        portableCell(AE2ExtrasItems.PORTABLE_ITEM_CELL_16M);
        portableCell(AE2ExtrasItems.PORTABLE_ITEM_CELL_64M);

        portableCell(AE2ExtrasItems.PORTABLE_FLUID_CELL_1M);
        portableCell(AE2ExtrasItems.PORTABLE_FLUID_CELL_4M);
        portableCell(AE2ExtrasItems.PORTABLE_FLUID_CELL_16M);
        portableCell(AE2ExtrasItems.PORTABLE_FLUID_CELL_64M);

        if (Integration.appmek.loaded) {
            portableCell(MItems.PORTABLE_CHEMICAL_STORAGE_CELL_1M);
            portableCell(MItems.PORTABLE_CHEMICAL_STORAGE_CELL_4M);
            portableCell(MItems.PORTABLE_CHEMICAL_STORAGE_CELL_16M);
            portableCell(MItems.PORTABLE_CHEMICAL_STORAGE_CELL_64M);
        }
    }

    private void portableCell(PortableCellItem cell) {
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
        shapeless(RecipeCategory.MISC, cell)
                .requires(AEBlocks.SKY_STONE_CHEST)
                .requires(component)
                .requires(AEBlocks.ENERGY_CELL)
                .requires(housing)
                .unlockedBy("has_housing", has(housing))
                .unlockedBy("has_energy_cell", has(AEBlocks.ENERGY_CELL))
                .save(output);
    }

    protected void monoCell(Item cell,Item result){
        shapeless(RecipeCategory.REDSTONE,result)
                .requires(cell).requires(AEItems.CALCULATION_PROCESSOR)
                .unlockedBy(getHasName(cell),has(cell))
                .save(output);
    }
    protected void cellComponent(Item previous, TagKey<Item> addition, Item processor, Item result) {
        shaped(RecipeCategory.REDSTONE,result)
                .pattern("aba")
                .pattern("cdc")
                .pattern("aca")
                .define('a',addition)
                .define('b',processor)
                .define('c', previous)
                .define('d', AEBlocks.QUARTZ_GLASS)
                .unlockedBy(getHasName(previous), has(previous))
                .save(output);
    }

    protected void cells(StorageComponentItem cellComponent, Item itemCell, Item fluidCell, Item chemicalCell) {
        itemCell(cellComponent,itemCell);
        fluidCell(cellComponent,fluidCell);
        chemicalCell(cellComponent,chemicalCell);
    }

    protected void cells(StorageComponentItem cellComponent, Item itemCell, Item fluidCell) {
        itemCell(cellComponent,itemCell);
        fluidCell(cellComponent,fluidCell);
    }


        protected void itemCell(StorageComponentItem cellComponent,Item result) {
        String s= BuiltInRegistries.ITEM.getKey(result).getPath();
        shaped(RecipeCategory.REDSTONE,result)
                .pattern("aba")
                .pattern("bcb")
                .pattern("ddd")
                .define('a', AEBlocks.QUARTZ_GLASS)
                .define('b', ConventionTags.REDSTONE)
                .define('c', cellComponent)
                .define('d', ConventionTags.IRON_INGOT)
                .unlockedBy(getHasName(cellComponent), has(cellComponent))
                .save(output);
        shapeless(RecipeCategory.REDSTONE,result)
                .requires(AEItems.ITEM_CELL_HOUSING)
                .requires(cellComponent)
                .unlockedBy(getHasName(cellComponent), has(cellComponent))
                .save(output,"ae2extras:network/cells/"+s+"_storage");
    }

    protected void chemicalCell(Item cellComponent,Item result) {
        String s= BuiltInRegistries.ITEM.getKey(result).getPath();
        shaped(RecipeCategory.REDSTONE,result)
                .pattern("aba")
                .pattern("bcb")
                .pattern("ddd")
                .define('a', AEBlocks.QUARTZ_GLASS)
                .define('b', ConventionTags.REDSTONE)
                .define('c', cellComponent)
                .define('d',  INGOTS_OSMIUM)
                .unlockedBy(getHasName(cellComponent), has(cellComponent))
                .save(output);
        shapeless(RecipeCategory.REDSTONE,result)
                .requires(AMItems.CHEMICAL_CELL_HOUSING.get())
                .requires(cellComponent)
                .unlockedBy(getHasName(cellComponent), has(cellComponent))
                .save(output,"ae2extras:network/cells/"+s+"_storage");
    }

    public static final TagKey<Item> INGOTS_OSMIUM = TagKey.create(Registries.ITEM, AE2Extras.id("ingots/osmium"));

    protected void fluidCell(Item cellComponent,Item result){
        String s= BuiltInRegistries.ITEM.getKey(result).getPath();
        shaped(RecipeCategory.REDSTONE,result)
                .pattern("aba")
                .pattern("bcb")
                .pattern("ddd")
                .define('a', AEBlocks.QUARTZ_GLASS)
                .define('b', ConventionTags.REDSTONE)
                .define('c', cellComponent)
                .define('d', ConventionTags.COPPER_INGOT)
                .unlockedBy(getHasName(cellComponent), has(cellComponent))
                .save(output);
        shapeless(RecipeCategory.REDSTONE,result)
                .requires(AEItems.FLUID_CELL_HOUSING)
                .requires(cellComponent)
                .unlockedBy(getHasName(cellComponent), has(cellComponent))
                .save(output,"ae2extras:network/cells/"+s+"_storage");
    }

    public static class Runner extends RecipeProvider.Runner {
        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
            return new AE2ExtrasRecipeProvider(registries, output);
        }

        @Override
        public String getName() {
            return "Vanilla Recipes";
        }
    }
}

package tfar.ae2extras.datagen.assets;

import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.LanguageProvider;
import org.codehaus.plexus.util.StringUtils;
import tfar.ae2extras.AE2Extras;
import tfar.ae2extras.init.AE2ExtrasBlocks;
import tfar.ae2extras.init.AE2ExtrasItems;
import tfar.ae2extras.integration.mekanism.MItems;

import java.util.function.Supplier;

public class ModLangProvider extends LanguageProvider {
    public ModLangProvider(PackOutput output) {
        super(output, AE2Extras.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {

        add(AE2ExtrasItems.CELL_COMPONENT_1M, "1m ME Storage Component");
        add(AE2ExtrasItems.CELL_COMPONENT_4M, "4m ME Storage Component");
        add(AE2ExtrasItems.CELL_COMPONENT_16M, "16m ME Storage Component");
        add(AE2ExtrasItems.CELL_COMPONENT_64M, "64m ME Storage Component");

        add(AE2ExtrasBlocks.CRAFTING_STORAGE_1M, "1m Crafting Storage");
        add(AE2ExtrasBlocks.CRAFTING_STORAGE_4M, "4m Crafting Storage");
        add(AE2ExtrasBlocks.CRAFTING_STORAGE_16M, "16m Crafting Storage");
        add(AE2ExtrasBlocks.CRAFTING_STORAGE_64M, "64m Crafting Storage");

        add("itemGroup.ae2extras", "AE2 Extras");

        add(AE2ExtrasItems.ITEM_CELL_1M, "1m ME Storage Cell");
        add(AE2ExtrasItems.ITEM_CELL_4M, "4m ME Storage Cell");
        add(AE2ExtrasItems.ITEM_CELL_16M, "16m ME Storage Cell");
        add(AE2ExtrasItems.ITEM_CELL_64M, "64m ME Storage Cell");

        add(AE2ExtrasItems.FLUID_CELL_1M,  "1m ME Fluid Storage Cell");
        add(AE2ExtrasItems.FLUID_CELL_4M, "4m ME Fluid Storage Cell");
        add(AE2ExtrasItems.FLUID_CELL_16M,  "16m ME Fluid Storage Cell");
        add(AE2ExtrasItems.FLUID_CELL_64M,  "64m ME Fluid Storage Cell");

        add(MItems.CHEMICAL_CELL_1M,  "1m ME Chemical Storage Cell");
        add(MItems.CHEMICAL_CELL_4M, "4m ME Chemical Storage Cell");
        add(MItems.CHEMICAL_CELL_16M,  "16m ME Chemical Storage Cell");
        add(MItems.CHEMICAL_CELL_64M,  "64m ME Chemical Storage Cell");

        add(AE2ExtrasItems.PORTABLE_ITEM_CELL_1M,  "1m Portable Item Cell");
        add(AE2ExtrasItems.PORTABLE_ITEM_CELL_4M, "4m Portable Item Cell");
        add(AE2ExtrasItems.PORTABLE_ITEM_CELL_16M,  "16m Portable Item Cell");
        add(AE2ExtrasItems.PORTABLE_ITEM_CELL_64M,  "64m Portable Item Cell");

        add(AE2ExtrasItems.PORTABLE_FLUID_CELL_1M,  "1m Portable Fluid Cell");
        add(AE2ExtrasItems.PORTABLE_FLUID_CELL_4M, "4m Portable Fluid Cell");
        add(AE2ExtrasItems.PORTABLE_FLUID_CELL_16M,  "16m Portable Fluid Cell");
        add(AE2ExtrasItems.PORTABLE_FLUID_CELL_64M,  "64m Portable Fluid Cell");

        add(MItems.PORTABLE_CHEMICAL_STORAGE_CELL_1M,  "1m Portable Chemical Cell");
        add(MItems.PORTABLE_CHEMICAL_STORAGE_CELL_4M, "4m Portable Chemical Cell");
        add(MItems.PORTABLE_CHEMICAL_STORAGE_CELL_16M,  "16m Portable Chemical Cell");
        add(MItems.PORTABLE_CHEMICAL_STORAGE_CELL_64M,  "64m Portable Chemical Cell");

        add(AE2ExtrasItems.MONO_ITEM_CELL_1K,"1k ME Mono Item Storage Cell");
        add(AE2ExtrasItems.MONO_ITEM_CELL_4K,"4k ME Mono Item Storage Cell");
        add(AE2ExtrasItems.MONO_ITEM_CELL_16K,"16k ME Mono Item Storage Cell");
        add(AE2ExtrasItems.MONO_ITEM_CELL_64K,"64k ME Mono Item Storage Cell");
        add(AE2ExtrasItems.MONO_ITEM_CELL_256K,"256k ME Mono Item Storage Cell");
        add(AE2ExtrasItems.MONO_ITEM_CELL_1M,"1m ME Mono Item Storage Cell");
        add(AE2ExtrasItems.MONO_ITEM_CELL_4M,"4m ME Mono Item Storage Cell");
        add(AE2ExtrasItems.MONO_ITEM_CELL_16M,"16m ME Mono Item Storage Cell");
        add(AE2ExtrasItems.MONO_ITEM_CELL_64M,"64m ME Mono Item Storage Cell");

        add(AE2ExtrasItems.MONO_FLUID_CELL_1K,"1k ME Mono Fluid Storage Cell");
        add(AE2ExtrasItems.MONO_FLUID_CELL_4K,"4k ME Mono Fluid Storage Cell");
        add(AE2ExtrasItems.MONO_FLUID_CELL_16K,"16k ME Mono Fluid Storage Cell");
        add(AE2ExtrasItems.MONO_FLUID_CELL_64K,"64k ME Mono Fluid Storage Cell");
        add(AE2ExtrasItems.MONO_FLUID_CELL_256K,"256k ME Mono Fluid Storage Cell");
        add(AE2ExtrasItems.MONO_FLUID_CELL_1M,"1m ME Mono Fluid Storage Cell");
        add(AE2ExtrasItems.MONO_FLUID_CELL_4M,"4m ME Mono Fluid Storage Cell");
        add(AE2ExtrasItems.MONO_FLUID_CELL_16M,"16m ME Mono Fluid Storage Cell");
        add(AE2ExtrasItems.MONO_FLUID_CELL_64M,"64m ME Mono Fluid Storage Cell");

        addDefaultItem(() -> AE2ExtrasItems.DENSER_ENERGY_CELL);
        addDefaultItem(() -> AE2ExtrasItems.DENSEST_ENERGY_CELL);

        add("gui.ae2extras.MonoCell","Mono Cell");
    }

    protected void addDefaultItem(Supplier<? extends Item> supplier) {
        addItem(supplier, getNameFromItem(supplier.get()));
    }

    protected void addDefaultBlock(Supplier<? extends Block> supplier) {
        addBlock(supplier, getNameFromBlock(supplier.get()));
    }

    public static String getNameFromItem(Item item) {
        return StringUtils.capitaliseAllWords(item.getDescriptionId().split("\\.")[2].replace("_", " "));
    }

    public static String getNameFromBlock(Block block) {
        return StringUtils.capitaliseAllWords(block.getDescriptionId().split("\\.")[2].replace("_", " "));
    }

}

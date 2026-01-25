package tfar.ae2extras.datagen.assets;

import net.minecraft.data.PackOutput;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import org.codehaus.plexus.util.StringUtils;
import tfar.ae2extras.AE2Extras;
import tfar.ae2extras.init.ModBlocks;
import tfar.ae2extras.init.ModItems;

import java.util.function.Supplier;

public class ModLangProvider extends LanguageProvider {
    public ModLangProvider(PackOutput output) {
        super(output, AE2Extras.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {

        add(ModItems.CELL_COMPONENT_1M, "1m ME Storage Component");
        add(ModItems.CELL_COMPONENT_4M, "4m ME Storage Component");
        add(ModItems.CELL_COMPONENT_16M, "16m ME Storage Component");
        add(ModItems.CELL_COMPONENT_64M, "64m ME Storage Component");

        add(ModBlocks.CRAFTING_STORAGE_1M, "1m Crafting Storage");
        add(ModBlocks.CRAFTING_STORAGE_4M, "4m Crafting Storage");
        add(ModBlocks.CRAFTING_STORAGE_16M, "16m Crafting Storage");
        add(ModBlocks.CRAFTING_STORAGE_64M, "64m Crafting Storage");

        add("itemGroup.ae2extras", "AE2 Extras");

        add(ModItems.ITEM_CELL_1M, "1m ME Storage Cell");
        add(ModItems.ITEM_CELL_4M, "4m ME Storage Cell");
        add(ModItems.ITEM_CELL_16M, "16m ME Storage Cell");
        add(ModItems.ITEM_CELL_64M, "64m ME Storage Cell");

        add(ModItems.FLUID_CELL_1M,  "1m ME Fluid Storage Cell");
        add(ModItems.FLUID_CELL_4M, "4m ME Fluid Storage Cell");
        add(ModItems.FLUID_CELL_16M,  "16m ME Fluid Storage Cell");
        add(ModItems.FLUID_CELL_64M,  "64m ME Fluid Storage Cell");

        add(ModItems.MONO_ITEM_CELL_1K,"1k ME Mono Item Storage Cell");

        add("gui.ae2extras.MonoItemCell","Mono Item Cell");
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

package tfar.ae2extras.init;

import appeng.block.crafting.CraftingBlockItem;
import appeng.core.definitions.AEItems;
import appeng.items.materials.StorageComponentItem;
import appeng.items.storage.StorageTier;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import tfar.ae2extras.AE2Extras;

import java.util.ArrayList;
import java.util.List;

public class ModItems {

    public static Item.Properties props = new Item.Properties();
    public static StorageComponentItem CELL_COMPONENT_1M = new StorageComponentItem(props, AE2Extras.KILO);
    public static StorageComponentItem CELL_COMPONENT_4M = new StorageComponentItem(props, 4 * AE2Extras.KILO);
    public static StorageComponentItem CELL_COMPONENT_16M = new StorageComponentItem(props, 16 * AE2Extras.KILO);
    public static StorageComponentItem CELL_COMPONENT_64M = new StorageComponentItem(props, 64 * AE2Extras.KILO);
    public static Item FLUID_CELL_1M = AE2Extras.createFluidCell(CELL_COMPONENT_1M, 3, 1);
    public static Item FLUID_CELL_4M = AE2Extras.createFluidCell(CELL_COMPONENT_4M, 3.5f, 4);
    public static Item FLUID_CELL_16M = AE2Extras.createFluidCell(CELL_COMPONENT_16M, 4, 16);
    public static Item FLUID_CELL_64M = AE2Extras.createFluidCell(CELL_COMPONENT_64M, 4.5f, 64);
    public static Item ITEM_CELL_1M = AE2Extras.createItemCell(CELL_COMPONENT_1M, 3, 1);
    public static Item ITEM_CELL_4M = AE2Extras.createItemCell(CELL_COMPONENT_1M, 3.5f, 4);
    public static Item ITEM_CELL_16M = AE2Extras.createItemCell(CELL_COMPONENT_1M, 4, 16);
    public static Item ITEM_CELL_64M = AE2Extras.createItemCell(CELL_COMPONENT_64M, 4.5f, 64);

    public static Item CRAFTING_STORAGE_1M = new CraftingBlockItem(ModBlocks.CRAFTING_STORAGE_1M, ModItems.props, () -> ModItems.CELL_COMPONENT_1M);
    public static Item CRAFTING_STORAGE_4M = new CraftingBlockItem(ModBlocks.CRAFTING_STORAGE_4M, ModItems.props, () -> ModItems.CELL_COMPONENT_4M);
    public static Item CRAFTING_STORAGE_16M = new CraftingBlockItem(ModBlocks.CRAFTING_STORAGE_16M, ModItems.props, () -> ModItems.CELL_COMPONENT_16M);
    public static Item CRAFTING_STORAGE_64M = new CraftingBlockItem(ModBlocks.CRAFTING_STORAGE_64M, ModItems.props, () -> ModItems.CELL_COMPONENT_64M);

    public static Item MONO_ITEM_CELL_1K = AE2Extras.createMonoItemCell(StorageTier.SIZE_1K);

    public static final CreativeModeTab TAB = CreativeModeTab.builder().icon(() -> Items.DIAMOND.getDefaultInstance())
            .title(Component.translatable("itemGroup.ae2extras"))
            .displayItems((pParameters, pOutput) -> allItems().forEach(pOutput::accept))
            .build();

    static final List<Item> ITEMS = new ArrayList<>();

    public static List<Item> allItems() {
        if (ITEMS.isEmpty()) {
            BuiltInRegistries.ITEM.stream().filter(item -> BuiltInRegistries.ITEM.getKey(item).getNamespace().equals(AE2Extras.MODID))
                    .forEach(ITEMS::add);
        }
        return ITEMS;
    }
}

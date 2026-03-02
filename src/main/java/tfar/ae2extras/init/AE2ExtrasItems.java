package tfar.ae2extras.init;

import appeng.block.crafting.CraftingBlockItem;
import appeng.block.networking.EnergyCellBlockItem;
import appeng.core.definitions.AEItems;
import appeng.items.materials.StorageComponentItem;
import appeng.items.storage.StorageTier;
import appeng.items.tools.powered.PortableCellItem;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import tfar.ae2extras.AE2Extras;
import tfar.ae2extras.MonoStorageCellItem;
import tfar.ae2extras.StorageTierEX;

import java.util.ArrayList;
import java.util.List;

public class AE2ExtrasItems {

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

    public static PortableCellItem PORTABLE_FLUID_CELL_1M = AE2Extras.makePortableFluidCell(StorageTierEX.SIZE_1M);
    public static PortableCellItem PORTABLE_FLUID_CELL_4M = AE2Extras.makePortableFluidCell(StorageTierEX.SIZE_4M);
    public static PortableCellItem PORTABLE_FLUID_CELL_16M = AE2Extras.makePortableFluidCell(StorageTierEX.SIZE_16M);
    public static PortableCellItem PORTABLE_FLUID_CELL_64M = AE2Extras.makePortableFluidCell(StorageTierEX.SIZE_64M);
    public static PortableCellItem PORTABLE_ITEM_CELL_1M = AE2Extras.makePortableItemCell(StorageTierEX.SIZE_1M);
    public static PortableCellItem PORTABLE_ITEM_CELL_4M = AE2Extras.makePortableItemCell(StorageTierEX.SIZE_4M);
    public static PortableCellItem PORTABLE_ITEM_CELL_16M = AE2Extras.makePortableItemCell(StorageTierEX.SIZE_16M);
    public static PortableCellItem PORTABLE_ITEM_CELL_64M = AE2Extras.makePortableItemCell(StorageTierEX.SIZE_64M);

    public static Item CRAFTING_STORAGE_1M = new CraftingBlockItem(ModBlocks.CRAFTING_STORAGE_1M, AE2ExtrasItems.props, () -> AE2ExtrasItems.CELL_COMPONENT_1M);
    public static Item CRAFTING_STORAGE_4M = new CraftingBlockItem(ModBlocks.CRAFTING_STORAGE_4M, AE2ExtrasItems.props, () -> AE2ExtrasItems.CELL_COMPONENT_4M);
    public static Item CRAFTING_STORAGE_16M = new CraftingBlockItem(ModBlocks.CRAFTING_STORAGE_16M, AE2ExtrasItems.props, () -> AE2ExtrasItems.CELL_COMPONENT_16M);
    public static Item CRAFTING_STORAGE_64M = new CraftingBlockItem(ModBlocks.CRAFTING_STORAGE_64M, AE2ExtrasItems.props, () -> AE2ExtrasItems.CELL_COMPONENT_64M);

    public static Item MONO_ITEM_CELL_1K = AE2Extras.createMonoItemCell(StorageTier.SIZE_1K, AEItems.ITEM_CELL_1K::asItem);
    public static Item MONO_ITEM_CELL_4K = AE2Extras.createMonoItemCell(StorageTier.SIZE_4K,AEItems.ITEM_CELL_4K::asItem);
    public static Item MONO_ITEM_CELL_16K = AE2Extras.createMonoItemCell(StorageTier.SIZE_16K,AEItems.ITEM_CELL_16K::asItem);
    public static Item MONO_ITEM_CELL_64K = AE2Extras.createMonoItemCell(StorageTier.SIZE_64K,AEItems.ITEM_CELL_64K::asItem);
    public static Item MONO_ITEM_CELL_256K = AE2Extras.createMonoItemCell(StorageTier.SIZE_256K,AEItems.ITEM_CELL_256K::asItem);
    public static Item MONO_ITEM_CELL_1M = AE2Extras.createMonoItemCell(StorageTierEX.SIZE_1M,() -> ITEM_CELL_1M);
    public static Item MONO_ITEM_CELL_4M = AE2Extras.createMonoItemCell(StorageTierEX.SIZE_4M,() -> ITEM_CELL_4M);
    public static Item MONO_ITEM_CELL_16M = AE2Extras.createMonoItemCell(StorageTierEX.SIZE_16M,() -> ITEM_CELL_16M);
    public static Item MONO_ITEM_CELL_64M = AE2Extras.createMonoItemCell(StorageTierEX.SIZE_64M,() -> ITEM_CELL_64M);

    public static Item MONO_FLUID_CELL_1K = AE2Extras.createMonoFluidCell(StorageTier.SIZE_1K, AEItems.FLUID_CELL_1K::asItem);
    public static Item MONO_FLUID_CELL_4K = AE2Extras.createMonoFluidCell(StorageTier.SIZE_4K, AEItems.FLUID_CELL_4K::asItem);
    public static Item MONO_FLUID_CELL_16K = AE2Extras.createMonoFluidCell(StorageTier.SIZE_16K, AEItems.FLUID_CELL_16K::asItem);
    public static Item MONO_FLUID_CELL_64K = AE2Extras.createMonoFluidCell(StorageTier.SIZE_64K, AEItems.FLUID_CELL_64K::asItem);
    public static Item MONO_FLUID_CELL_256K = AE2Extras.createMonoFluidCell(StorageTier.SIZE_256K, AEItems.FLUID_CELL_256K::asItem);
    public static Item MONO_FLUID_CELL_1M = AE2Extras.createMonoFluidCell(StorageTierEX.SIZE_1M, () -> AE2ExtrasItems.FLUID_CELL_1M);
    public static Item MONO_FLUID_CELL_4M = AE2Extras.createMonoFluidCell(StorageTierEX.SIZE_4M, () -> AE2ExtrasItems.FLUID_CELL_4M);
    public static Item MONO_FLUID_CELL_16M = AE2Extras.createMonoFluidCell(StorageTierEX.SIZE_16M,() -> AE2ExtrasItems.FLUID_CELL_16M);
    public static Item MONO_FLUID_CELL_64M = AE2Extras.createMonoFluidCell(StorageTierEX.SIZE_64M, () -> AE2ExtrasItems.FLUID_CELL_64M);

    public static Item DENSER_ENERGY_CELL = new EnergyCellBlockItem(ModBlocks.DENSER_ENERGY_CELL, AE2ExtrasItems.props);
    public static Item DENSEST_ENERGY_CELL = new EnergyCellBlockItem(ModBlocks.DENSEST_ENERGY_CELL, AE2ExtrasItems.props);

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

    static final List<Item> MONO_CELLS = new ArrayList<>();

    public static List<Item> monoCells() {
        if (MONO_CELLS.isEmpty()) {
            BuiltInRegistries.ITEM.stream().filter(MonoStorageCellItem.class::isInstance)
                    .forEach(MONO_CELLS::add);
        }
        return MONO_CELLS;
    }

}

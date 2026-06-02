package tfar.ae2extras.init;

import appeng.api.stacks.AEKeyType;
import appeng.block.crafting.CraftingBlockItem;
import appeng.block.networking.EnergyCellBlockItem;
import appeng.items.materials.StorageComponentItem;
import appeng.items.storage.BasicStorageCell;
import appeng.items.storage.StorageTier;
import appeng.items.tools.powered.PortableCellItem;
import appeng.menu.me.common.MEStorageMenu;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import tfar.ae2extras.AE2Extras;
import tfar.ae2extras.MonoStorageCellItem;
import tfar.ae2extras.StorageTierEX;
import tfar.ae2extras.item.PortableCellExItem;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class AE2ExtrasItems {

    public static final int KILO = 1024;
    public static final int MEGA = KILO * KILO;
    public static StorageComponentItem CELL_COMPONENT_1M = registerItem("cell_component_1m",p -> new StorageComponentItem(p, KILO));
    public static StorageComponentItem CELL_COMPONENT_4M = registerItem("cell_component_4m",p -> new StorageComponentItem(p, 4 * KILO));
    public static StorageComponentItem CELL_COMPONENT_16M = registerItem("cell_component_16m",p -> new StorageComponentItem(p, 16 * KILO));
    public static StorageComponentItem CELL_COMPONENT_64M = registerItem("cell_component_64m",p -> new StorageComponentItem(p, 64 * KILO));

    public static Item FLUID_CELL_1M = createFluidCell(3, 1);
    public static Item FLUID_CELL_4M = createFluidCell(3.5f, 4);
    public static Item FLUID_CELL_16M = createFluidCell(4, 16);
    public static Item FLUID_CELL_64M = createFluidCell(4.5f, 64);
    public static Item ITEM_CELL_1M = createItemCell(3, 1);
    public static Item ITEM_CELL_4M = createItemCell(3.5f, 4);
    public static Item ITEM_CELL_16M = createItemCell(4, 16);
    public static Item ITEM_CELL_64M = createItemCell(4.5f, 64);

    public static PortableCellItem PORTABLE_FLUID_CELL_1M = makePortableFluidCell(StorageTierEX.SIZE_1M);
    public static PortableCellItem PORTABLE_FLUID_CELL_4M = makePortableFluidCell(StorageTierEX.SIZE_4M);
    public static PortableCellItem PORTABLE_FLUID_CELL_16M = makePortableFluidCell(StorageTierEX.SIZE_16M);
    public static PortableCellItem PORTABLE_FLUID_CELL_64M = makePortableFluidCell(StorageTierEX.SIZE_64M);
    public static PortableCellItem PORTABLE_ITEM_CELL_1M = makePortableItemCell(StorageTierEX.SIZE_1M);
    public static PortableCellItem PORTABLE_ITEM_CELL_4M = makePortableItemCell(StorageTierEX.SIZE_4M);
    public static PortableCellItem PORTABLE_ITEM_CELL_16M = makePortableItemCell(StorageTierEX.SIZE_16M);
    public static PortableCellItem PORTABLE_ITEM_CELL_64M = makePortableItemCell(StorageTierEX.SIZE_64M);

    public static Item CRAFTING_STORAGE_1M = registerBlock(AE2ExtrasBlocks.CRAFTING_STORAGE_1M,CraftingBlockItem::new);
    public static Item CRAFTING_STORAGE_4M = registerBlock(AE2ExtrasBlocks.CRAFTING_STORAGE_4M,CraftingBlockItem::new);
    public static Item CRAFTING_STORAGE_16M = registerBlock(AE2ExtrasBlocks.CRAFTING_STORAGE_16M, CraftingBlockItem::new);
    public static Item CRAFTING_STORAGE_64M = registerBlock(AE2ExtrasBlocks.CRAFTING_STORAGE_64M,CraftingBlockItem::new);

    public static Item MONO_ITEM_CELL_1K = createMonoItemCell(StorageTier.SIZE_1K);
    public static Item MONO_ITEM_CELL_4K = createMonoItemCell(StorageTier.SIZE_4K);
    public static Item MONO_ITEM_CELL_16K = createMonoItemCell(StorageTier.SIZE_16K);
    public static Item MONO_ITEM_CELL_64K = createMonoItemCell(StorageTier.SIZE_64K);
    public static Item MONO_ITEM_CELL_256K = createMonoItemCell(StorageTier.SIZE_256K);
    public static Item MONO_ITEM_CELL_1M = createMonoItemCell(StorageTierEX.SIZE_1M);
    public static Item MONO_ITEM_CELL_4M = createMonoItemCell(StorageTierEX.SIZE_4M);
    public static Item MONO_ITEM_CELL_16M = createMonoItemCell(StorageTierEX.SIZE_16M);
    public static Item MONO_ITEM_CELL_64M = createMonoItemCell(StorageTierEX.SIZE_64M);

    public static Item MONO_FLUID_CELL_1K = createMonoFluidCell(StorageTier.SIZE_1K);
    public static Item MONO_FLUID_CELL_4K = createMonoFluidCell(StorageTier.SIZE_4K);
    public static Item MONO_FLUID_CELL_16K = createMonoFluidCell(StorageTier.SIZE_16K);
    public static Item MONO_FLUID_CELL_64K = createMonoFluidCell(StorageTier.SIZE_64K);
    public static Item MONO_FLUID_CELL_256K = createMonoFluidCell(StorageTier.SIZE_256K);
    public static Item MONO_FLUID_CELL_1M = createMonoFluidCell(StorageTierEX.SIZE_1M);
    public static Item MONO_FLUID_CELL_4M = createMonoFluidCell(StorageTierEX.SIZE_4M);
    public static Item MONO_FLUID_CELL_16M = createMonoFluidCell(StorageTierEX.SIZE_16M);
    public static Item MONO_FLUID_CELL_64M = createMonoFluidCell(StorageTierEX.SIZE_64M);

    public static Item DENSER_ENERGY_CELL = registerBlock(AE2ExtrasBlocks.DENSER_ENERGY_CELL, EnergyCellBlockItem::new);
    public static Item DENSEST_ENERGY_CELL = registerBlock(AE2ExtrasBlocks.DENSEST_ENERGY_CELL, EnergyCellBlockItem::new);

    public static final CreativeModeTab TAB = CreativeModeTab.builder().icon(() -> Items.DIAMOND.getDefaultInstance())
            .title(Component.translatable("itemGroup.ae2extras"))
            .displayItems((pParameters, pOutput) -> allItems().forEach(pOutput::accept))
            .build();

    static final List<Item> ITEMS = new ArrayList<>();

    public static List<Item> allItems() {
        if (ITEMS.isEmpty()) {
            BuiltInRegistries.ITEM.stream().filter(item -> BuiltInRegistries.ITEM.getKey(item).getNamespace().equals(AE2Extras.MOD_ID))
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

    public static Item createItemCell(float idleDrain, int megaBytes) {
        return registerItem("item_storage_cell_"+megaBytes+"m",p -> new BasicStorageCell(p, idleDrain, KILO * megaBytes,
                8 * KILO * megaBytes, 63, AEKeyType.items()),noStack());
    }

    public static Item createMonoItemCell(StorageTier tier) {
        return registerItem("mono_item_cell_"+tier.namePrefix(),p -> new MonoStorageCellItem(p, tier.idleDrain(), tier.bytes() / KILO,
                1, 1, AEKeyType.items()),noStack());
    }

    public static Item createFluidCell(float idleDrain, int megaBytes) {
        return registerItem("fluid_storage_cell_"+megaBytes+"m",p -> new BasicStorageCell(p, idleDrain, KILO * megaBytes,
                8 * KILO * megaBytes, 63, AEKeyType.fluids()),noStack());
    }

    public static Item createMonoFluidCell(StorageTier tier) {
        return registerItem("mono_fluid_cell_"+tier.namePrefix(),p -> new MonoStorageCellItem(p,  tier.idleDrain(), tier.bytes() / KILO,
                1, 1, AEKeyType.fluids()),noStack());
    }

    public static PortableCellItem makePortableItemCell(StorageTier tier) {
        return registerItem("portable_item_cell_"+tier.namePrefix(),p -> new PortableCellExItem(AEKeyType.items(), 63 - tier.index() * 9,
                MEStorageMenu.PORTABLE_ITEM_CELL_TYPE, tier,p, 0xDDDDDD),noStack());
    }

    public static PortableCellItem makePortableFluidCell(StorageTier tier) {
        return registerItem("portable_fluid_cell_"+tier.namePrefix(),p -> new PortableCellExItem(AEKeyType.fluids(),
                18, MEStorageMenu.PORTABLE_FLUID_CELL_TYPE, tier, p, 0xFF6D36),noStack());
    }

    public static Item.Properties noStack() {
        return new Item.Properties().stacksTo(1);
    }



    private static Item registerBlock(Block block) {
        return registerBlock(block, BlockItem::new);
    }

    private static Item registerBlock(Block block, Item.Properties properties) {
        return registerBlock(block, BlockItem::new, properties);
    }

    private static Item registerBlock(Block block, UnaryOperator<Item.Properties> propertiesFunction) {
        return registerBlock(block, (b, p) -> new BlockItem(b, propertiesFunction.apply(p)));
    }


    private static Item registerBlock(Block block, BiFunction<Block, Item.Properties, Item> itemFactory) {
        return registerBlock(block, itemFactory, new Item.Properties());
    }

    private static Item registerBlock(Block block, BiFunction<Block, Item.Properties, Item> itemFactory, Item.Properties properties) {
        return registerItem(
                blockIdToItemId(block.builtInRegistryHolder().key()),
                p -> itemFactory.apply(block, p),
                properties.useBlockDescriptionPrefix().requiredFeatures(block.requiredFeatures())
        );
    }

    private static ResourceKey<Item> blockIdToItemId(ResourceKey<Block> blockName) {
        return ResourceKey.create(Registries.ITEM, blockName.identifier());
    }

    private static <I extends Item> I registerItem(String name, Function<Item.Properties, I> itemFactory) {
        return registerItem(modItemId(name), itemFactory, new Item.Properties());
    }

    private static <I extends Item> I registerItem(String name, Function<Item.Properties, I> itemFactory, Item.Properties properties) {
        return registerItem(modItemId(name), itemFactory, properties);
    }

    private static Item registerItem(String name, Item.Properties properties) {
        return registerItem(modItemId(name), Item::new, properties);
    }

    private static Item registerItem(String name) {
        return registerItem(modItemId(name), Item::new, new Item.Properties());
    }

    @SuppressWarnings("unchecked")
    private static <I extends Item> ResourceKey<I> modItemId(String name) {
        return (ResourceKey<I>) ResourceKey.create(Registries.ITEM, AE2Extras.id(name));
    }


    private static <I extends Item> I registerItem(ResourceKey<I> key, Function<Item.Properties, I> itemFactory) {
        return registerItem(key, itemFactory, new Item.Properties());
    }

    private static <I extends Item> I registerItem(ResourceKey<I> key, Function<Item.Properties, I> itemFactory, Item.Properties properties) {
        I item = itemFactory.apply(properties.setId((ResourceKey<Item>) key));
        if (item instanceof BlockItem blockItem) {
            blockItem.registerBlocks(Item.BY_BLOCK, item);
        }

        return Registry.register(BuiltInRegistries.ITEM,(ResourceKey<Item>) key, item);
    }

    public static void init() {

    }
}

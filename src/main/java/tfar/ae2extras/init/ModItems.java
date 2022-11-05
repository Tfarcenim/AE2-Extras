package tfar.ae2extras.init;

import appeng.items.materials.StorageComponentItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import tfar.ae2extras.AE2Extras;

public class ModItems {
    public static final CreativeModeTab TAB = new CreativeModeTab(AE2Extras.MODID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.DIAMOND);//ModBlocks.CRAFTING_STORAGE_16M.asItem().getDefaultInstance();
        }
    };
    public static Item.Properties props = new Item.Properties().tab(TAB);
    public static StorageComponentItem CELL_COMPONENT_1M = new StorageComponentItem(props,AE2Extras.KILO);
    public static StorageComponentItem CELL_COMPONENT_4M = new StorageComponentItem(props,4*AE2Extras.KILO);
    public static StorageComponentItem CELL_COMPONENT_16M = new StorageComponentItem(props,16*AE2Extras.KILO);
    public static StorageComponentItem CELL_COMPONENT_64M = new StorageComponentItem(props,64*AE2Extras.KILO);
    public static Item FLUID_CELL_1M = AE2Extras.createFluidCell(CELL_COMPONENT_1M,3,1);
    public static Item FLUID_CELL_4M = AE2Extras.createFluidCell(CELL_COMPONENT_4M,3.5f,4);
    public static Item FLUID_CELL_16M = AE2Extras.createFluidCell(CELL_COMPONENT_16M,4,16);
    public static Item FLUID_CELL_64M = AE2Extras.createFluidCell(CELL_COMPONENT_64M,4.5f,64);
    public static Item ITEM_CELL_1M = AE2Extras.createItemCell(CELL_COMPONENT_1M,3,1);
    public static Item ITEM_CELL_4M = AE2Extras.createItemCell(CELL_COMPONENT_1M,3.5f,4);
    public static Item ITEM_CELL_16M = AE2Extras.createItemCell(CELL_COMPONENT_1M,4,16);
    public static Item ITEM_CELL_64M = AE2Extras.createItemCell(CELL_COMPONENT_64M,4.5f,64);
}

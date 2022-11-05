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
    public static StorageComponentItem CELL_COMPONENT_16M = new StorageComponentItem(props,1);
    public static StorageComponentItem CELL_COMPONENT_4M = new StorageComponentItem(props,1);
    public static StorageComponentItem CELL_COMPONENT_1M = new StorageComponentItem(props,1);
    public static StorageComponentItem CELL_COMPONENT_256K = new StorageComponentItem(props,1);
}

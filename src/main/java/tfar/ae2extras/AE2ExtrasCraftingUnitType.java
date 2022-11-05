package tfar.ae2extras;

import appeng.block.crafting.ICraftingUnitType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import tfar.ae2extras.init.ModBlocks;

import java.util.function.Supplier;

public class AE2ExtrasCraftingUnitType implements ICraftingUnitType {


    public static AE2ExtrasCraftingUnitType STORAGE_1M = new AE2ExtrasCraftingUnitType(1,0,() -> ModBlocks.CRAFTING_STORAGE_1M);
    public static AE2ExtrasCraftingUnitType STORAGE_4M = new AE2ExtrasCraftingUnitType(4,0,() -> ModBlocks.CRAFTING_STORAGE_4M);
    public static AE2ExtrasCraftingUnitType STORAGE_16M = new AE2ExtrasCraftingUnitType(16,0,() -> ModBlocks.CRAFTING_STORAGE_16M);
    public static AE2ExtrasCraftingUnitType STORAGE_64M = new AE2ExtrasCraftingUnitType(64,0,() -> ModBlocks.CRAFTING_STORAGE_64M);
    public static AE2ExtrasCraftingUnitType ACCELERATOR_4 = new AE2ExtrasCraftingUnitType(0,4,() -> null);
    public static AE2ExtrasCraftingUnitType ACCELERATOR_16 = new AE2ExtrasCraftingUnitType(0,16,() -> null);
    private final int bytes;
    private final int accelerator;
    private final Supplier<ItemLike> item;

    protected AE2ExtrasCraftingUnitType(int megaBytes, int accelerator, Supplier<ItemLike> item) {
        this.bytes = megaBytes;
        this.accelerator = accelerator;
        this.item = item;
    }
    @Override
    public int getStorageBytes() {
        return bytes * 1048576;
    }

    @Override
    public int getAcceleratorThreads() {
        return accelerator;
    }

    @Override
    public Item getItemFromType() {
        return item.get().asItem();
    }
}

package tfar.ae2extras;

import appeng.block.crafting.ICraftingUnitType;
import net.minecraft.world.item.Item;

public class AE2ExtrasCraftingUnitType implements ICraftingUnitType {


    private final int bytes;
    private final int accelerator;
    private final Item item;

    protected AE2ExtrasCraftingUnitType(int bytes, int accelerator, Item item) {
        this.bytes = bytes;
        this.accelerator = accelerator;
        this.item = item;
    }
    @Override
    public int getStorageBytes() {
        return bytes;
    }

    @Override
    public int getAcceleratorThreads() {
        return accelerator;
    }

    @Override
    public Item getItemFromType() {
        return item;
    }
}

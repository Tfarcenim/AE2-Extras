package tfar.ae2extras;

import appeng.block.crafting.ICraftingUnitType;
import com.mojang.serialization.Codec;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import tfar.ae2extras.init.AE2ExtrasBlocks;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class AE2ExtrasCraftingUnitType implements ICraftingUnitType, StringRepresentable {

    private static final List<AE2ExtrasCraftingUnitType> TYPES = new ArrayList<>();

    public static AE2ExtrasCraftingUnitType STORAGE_1M = new AE2ExtrasCraftingUnitType(1,0,() -> AE2ExtrasBlocks.CRAFTING_STORAGE_1M,"storage_1m");
    public static AE2ExtrasCraftingUnitType STORAGE_4M = new AE2ExtrasCraftingUnitType(4,0,() -> AE2ExtrasBlocks.CRAFTING_STORAGE_4M,"storage_4m");
    public static AE2ExtrasCraftingUnitType STORAGE_16M = new AE2ExtrasCraftingUnitType(16,0,() -> AE2ExtrasBlocks.CRAFTING_STORAGE_16M,"storage_16m");
    public static AE2ExtrasCraftingUnitType STORAGE_64M = new AE2ExtrasCraftingUnitType(64,0,() -> AE2ExtrasBlocks.CRAFTING_STORAGE_64M,"storage_64m");
    public static AE2ExtrasCraftingUnitType ACCELERATOR_4 = new AE2ExtrasCraftingUnitType(0,4,() -> null,"accelerator_4");
    public static AE2ExtrasCraftingUnitType ACCELERATOR_16 = new AE2ExtrasCraftingUnitType(0,16,() -> null,"accelerator_16");
    private final int bytes;
    private final int accelerator;
    private final Supplier<ItemLike> item;
    private final String name;

    public static final Codec<AE2ExtrasCraftingUnitType> CODEC = StringRepresentable.fromValues(() -> TYPES.toArray(new AE2ExtrasCraftingUnitType[0]));

    protected AE2ExtrasCraftingUnitType(int megaBytes, int accelerator, Supplier<ItemLike> item,String name) {
        this.bytes = megaBytes;
        this.accelerator = accelerator;
        this.item = item;
        this.name = name;
        TYPES.add(this);
    }
    @Override
    public long getStorageBytes() {
        return bytes * 1048576L;
    }

    @Override
    public int getAcceleratorThreads() {
        return accelerator;
    }

    @Override
    public Item getItemFromType() {
        return item.get().asItem();
    }

    @Override
    public String getSerializedName() {
        return name;
    }

}

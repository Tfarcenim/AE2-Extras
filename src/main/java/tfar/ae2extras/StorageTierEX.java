package tfar.ae2extras;

import appeng.api.ids.AEItemIds;
import appeng.items.storage.StorageTier;
import net.minecraft.core.registries.BuiltInRegistries;
import tfar.ae2extras.init.ModItems;

public class StorageTierEX {
    public static final StorageTier SIZE_1M = new StorageTier(5, "1m", AE2Extras.MEGA, 3,
            () -> ModItems.CELL_COMPONENT_1M);
    public static final StorageTier SIZE_4M = new StorageTier(5, "4m",  AE2Extras.MEGA*4, 3.5,
            () -> BuiltInRegistries.ITEM.get(AEItemIds.CELL_COMPONENT_4K));
    public static final StorageTier SIZE_16M = new StorageTier(5, "16m",  AE2Extras.MEGA*16, 4,
            () -> BuiltInRegistries.ITEM.get(AEItemIds.CELL_COMPONENT_16K));
    public static final StorageTier SIZE_64M = new StorageTier(5, "64m",  AE2Extras.MEGA*64, 4.5,
            () -> BuiltInRegistries.ITEM.get(AEItemIds.CELL_COMPONENT_64K));
}

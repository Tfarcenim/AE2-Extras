package tfar.ae2extras;

import appeng.items.storage.StorageTier;
import tfar.ae2extras.init.AE2ExtrasItems;

public class StorageTierEX {
    public static final StorageTier SIZE_1M = new StorageTier(5, "1m", AE2ExtrasItems.MEGA, 3,
            () -> AE2ExtrasItems.CELL_COMPONENT_1M);
    public static final StorageTier SIZE_4M = new StorageTier(5, "4m",  AE2ExtrasItems.MEGA*4, 3.5,
            () -> AE2ExtrasItems.CELL_COMPONENT_4M);
    public static final StorageTier SIZE_16M = new StorageTier(5, "16m",  AE2ExtrasItems.MEGA*16, 4,
            () -> AE2ExtrasItems.CELL_COMPONENT_16M);
    public static final StorageTier SIZE_64M = new StorageTier(5, "64m",  AE2ExtrasItems.MEGA*64, 4.5,
            () -> AE2ExtrasItems.CELL_COMPONENT_64M);
}

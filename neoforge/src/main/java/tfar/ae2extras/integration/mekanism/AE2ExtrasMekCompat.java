package tfar.ae2extras.integration.mekanism;

import appeng.items.storage.StorageTier;
import appeng.items.tools.powered.PortableCellItem;
import me.ramidzkh.mekae2.AMMenus;
import me.ramidzkh.mekae2.item.ChemicalPortableCellItem;
import me.ramidzkh.mekae2.item.ChemicalStorageCell;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.RegisterEvent;
import tfar.ae2extras.AE2Extras;
import tfar.ae2extras.init.AE2ExtrasItems;

public class AE2ExtrasMekCompat {

    public static Item createChemicalCell(StorageTier storageTier) {
        return new ChemicalStorageCell(AE2ExtrasItems.noStack(),storageTier);
    }

    public static PortableCellItem createPortableChemicalCell(StorageTier storageTier) {
        return new ChemicalPortableCellItem(18, AMMenus.PORTABLE_CHEMICAL_CELL_TYPE, storageTier, AE2ExtrasItems.noStack(), 0);
    }

    public static void init() {

    }

    public static void register(RegisterEvent event) {
        event.register(Registries.ITEM, AE2Extras.id("chemical_cell_1m"),() -> MItems.CHEMICAL_CELL_1M);
        event.register(Registries.ITEM, AE2Extras.id("chemical_cell_4m"),() -> MItems.CHEMICAL_CELL_4M);
        event.register(Registries.ITEM, AE2Extras.id("chemical_cell_16m"),() -> MItems.CHEMICAL_CELL_16M);
        event.register(Registries.ITEM, AE2Extras.id("chemical_cell_64m"),() -> MItems.CHEMICAL_CELL_64M);

        event.register(Registries.ITEM, AE2Extras.id("portable_chemical_storage_cell_1m"),() -> MItems.PORTABLE_CHEMICAL_STORAGE_CELL_1M);
        event.register(Registries.ITEM, AE2Extras.id("portable_chemical_storage_cell_4m"),() -> MItems.PORTABLE_CHEMICAL_STORAGE_CELL_4M);
        event.register(Registries.ITEM, AE2Extras.id("portable_chemical_storage_cell_16m"),() -> MItems.PORTABLE_CHEMICAL_STORAGE_CELL_16M);
        event.register(Registries.ITEM, AE2Extras.id("portable_chemical_storage_cell_64m"),() -> MItems.PORTABLE_CHEMICAL_STORAGE_CELL_64M);
    }
}

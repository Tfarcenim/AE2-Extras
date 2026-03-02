package tfar.ae2extras.integration.mekanism;

import appeng.items.tools.powered.PortableCellItem;
import net.minecraft.world.item.Item;
import tfar.ae2extras.StorageTierEX;

public class MItems {
    public static Item CHEMICAL_CELL_1M = AE2ExtrasMekCompat.createChemicalCell(StorageTierEX.SIZE_1M);
    public static Item CHEMICAL_CELL_4M = AE2ExtrasMekCompat.createChemicalCell(StorageTierEX.SIZE_4M);
    public static Item CHEMICAL_CELL_16M = AE2ExtrasMekCompat.createChemicalCell(StorageTierEX.SIZE_16M);
    public static Item CHEMICAL_CELL_64M = AE2ExtrasMekCompat.createChemicalCell(StorageTierEX.SIZE_64M);

    public static PortableCellItem PORTABLE_CHEMICAL_STORAGE_CELL_1M = AE2ExtrasMekCompat.createPortableChemicalCell(StorageTierEX.SIZE_1M);
    public static PortableCellItem PORTABLE_CHEMICAL_STORAGE_CELL_4M = AE2ExtrasMekCompat.createPortableChemicalCell(StorageTierEX.SIZE_4M);
    public static PortableCellItem PORTABLE_CHEMICAL_STORAGE_CELL_16M = AE2ExtrasMekCompat.createPortableChemicalCell(StorageTierEX.SIZE_16M);
    public static PortableCellItem PORTABLE_CHEMICAL_STORAGE_CELL_64M = AE2ExtrasMekCompat.createPortableChemicalCell(StorageTierEX.SIZE_64M);}

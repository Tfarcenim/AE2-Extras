package tfar.ae2extras.init;

import appeng.block.crafting.CraftingUnitBlock;
import appeng.block.networking.EnergyCellBlock;
import tfar.ae2extras.AE2ExtrasCraftingUnitType;

public class AE2ExtrasBlocks {

    public static CraftingUnitBlock CRAFTING_STORAGE_1M = new CraftingUnitBlock(EnergyCellBlock.Properties.of(),AE2ExtrasCraftingUnitType.STORAGE_1M);
    public static CraftingUnitBlock CRAFTING_STORAGE_4M = new CraftingUnitBlock(EnergyCellBlock.Properties.of(),AE2ExtrasCraftingUnitType.STORAGE_4M);
    public static CraftingUnitBlock CRAFTING_STORAGE_16M = new CraftingUnitBlock(EnergyCellBlock.Properties.of(),AE2ExtrasCraftingUnitType.STORAGE_16M);
    public static CraftingUnitBlock CRAFTING_STORAGE_64M = new CraftingUnitBlock(EnergyCellBlock.Properties.of(),AE2ExtrasCraftingUnitType.STORAGE_64M);

    static final int i = 1600;
    public static EnergyCellBlock DENSER_ENERGY_CELL = new EnergyCellBlock(EnergyCellBlock.Properties.of(),1000*i*8, i*8, i*8);
    public static EnergyCellBlock DENSEST_ENERGY_CELL = new EnergyCellBlock(EnergyCellBlock.Properties.of(),1000*i*64, i*64, i*64);

}

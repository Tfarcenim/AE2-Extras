package tfar.ae2extras.init;

import appeng.block.crafting.CraftingUnitBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import tfar.ae2extras.AE2ExtrasCraftingUnitType;

import static appeng.block.AEBaseBlock.defaultProps;

public class ModBlocks {

    static BlockBehaviour.Properties craftingBlockProps = defaultProps(Material.METAL, MaterialColor.COLOR_GRAY);

    public static CraftingUnitBlock CRAFTING_STORAGE_64M= new CraftingUnitBlock(craftingBlockProps, AE2ExtrasCraftingUnitType.STORAGE_1M);
    public static CraftingUnitBlock CRAFTING_STORAGE_1M= new CraftingUnitBlock(craftingBlockProps, AE2ExtrasCraftingUnitType.STORAGE_4M);
    public static CraftingUnitBlock CRAFTING_STORAGE_4M= new CraftingUnitBlock(craftingBlockProps, AE2ExtrasCraftingUnitType.STORAGE_16M);
    public static CraftingUnitBlock CRAFTING_STORAGE_16M= new CraftingUnitBlock(craftingBlockProps, AE2ExtrasCraftingUnitType.STORAGE_64M);
}

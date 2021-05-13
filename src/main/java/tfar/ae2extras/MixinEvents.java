package tfar.ae2extras;

import appeng.block.crafting.AbstractCraftingUnitBlock;
import appeng.tile.crafting.CraftingStorageTileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

public class MixinEvents {
    public static void getStorageBytes(CraftingStorageTileEntity te, CallbackInfoReturnable<Integer> cir) {
        if (te.getWorld() == null || te.notLoaded() || te.isRemoved())
            return;
        cir.setReturnValue(AE2Extras.TypeSwitch(((AbstractCraftingUnitBlock<?>) te.getWorld().getBlockState(te.getPos()).getBlock()).type, 4, 16, 64, 256, null));
    }
}
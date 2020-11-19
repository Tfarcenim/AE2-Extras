package tfar.ae2extras.mixin;

import appeng.block.crafting.AbstractCraftingUnitBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import tfar.ae2extras.EnumHelper;
import tfar.ae2extras.AE2Extras;

@Mixin(AbstractCraftingUnitBlock.CraftingUnitType.class)
public class CraftingUnitTypeMixin {
	@Inject(at = @At("RETURN"), method = "<clinit>")
	private static void init(CallbackInfo info) {
		AE2Extras.STORAGE_256K = EnumHelper.addCraftingStorageUnit("STORAGE_256K");
		AE2Extras.STORAGE_1M = EnumHelper.addCraftingStorageUnit("STORAGE_1M");
		AE2Extras.STORAGE_4M = EnumHelper.addCraftingStorageUnit("STORAGE_4M");
		AE2Extras.STORAGE_16M = EnumHelper.addCraftingStorageUnit("STORAGE_16M");
	}
}

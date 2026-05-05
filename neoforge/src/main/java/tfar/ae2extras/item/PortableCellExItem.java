package tfar.ae2extras.item;

import appeng.api.stacks.AEKeyType;
import appeng.items.storage.StorageTier;
import appeng.items.tools.powered.PortableCellItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.MenuType;
import tfar.ae2extras.AE2Extras;

import java.util.Objects;

public class PortableCellExItem extends PortableCellItem {
    public PortableCellExItem(AEKeyType keyType, int totalTypes, MenuType<?> menuType, StorageTier tier, Properties props, int defaultColor) {
        super(keyType, totalTypes, menuType, tier, props, defaultColor);
    }

    @Override
    public ResourceLocation getRecipeId() {
        return AE2Extras.id("tools/" + Objects.requireNonNull(getRegistryName()).getPath());
    }
}

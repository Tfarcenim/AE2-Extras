package tfar.ae2extras;

import appeng.api.implementations.menuobjects.ItemMenuHost;
import appeng.api.upgrades.IUpgradeableObject;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class MonoCellHost extends ItemMenuHost {
    public MonoCellHost(Player player, @Nullable Integer slot, ItemStack itemStack) {
        super(player, slot, itemStack);
    }
}

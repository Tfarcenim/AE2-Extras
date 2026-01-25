package tfar.ae2extras;

import appeng.helpers.externalstorage.GenericStackInv;
import appeng.menu.SlotSemantics;
import appeng.menu.implementations.CellWorkbenchMenu;
import appeng.menu.implementations.UpgradeableMenu;
import appeng.menu.slot.CellPartitionSlot;
import appeng.menu.slot.FakeSlot;
import appeng.menu.slot.IPartitionSlotHost;
import net.minecraft.SharedConstants;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;
import java.util.Objects;

public class MonoCellMenu extends UpgradeableMenu<MonoCellHost> implements IPartitionSlotHost {
    private String itemName;

    public MonoCellMenu(MenuType<?> menuType, int id, Inventory ip, MonoCellHost host) {
        super(menuType, id, ip, host);

        //registerClientAction(CellWorkbenchMenu.ACTION_PARTITION, this::partition);


    }

    @Override
    protected void setupConfig() {
        var inv = getConfigInventory().createMenuWrapper();
            this.addSlot(new CellPartitionSlot(inv, this, 0), SlotSemantics.CONFIG);
    }

    private GenericStackInv getConfigInventory() {
        return Objects.requireNonNull(this.getHost().getConfig());
    }

    @Override
    public boolean isPartitionSlotEnabled(int idx) {
        return true;
    }


    public boolean setItemName(String pItemName) {
        String s = validateName(pItemName);
        if (s != null && !s.equals(this.itemName)) {
            this.itemName = s;
            ItemStack itemstack = getHost().getItemStack();
            if (Util.isBlank(s)) {
                itemstack.resetHoverName();
            } else {
                itemstack.setHoverName(Component.literal(s));
            }
            return true;
        } else {
            return false;
        }
    }

    @Nullable
    private static String validateName(String pItemName) {
        String s = SharedConstants.filterText(pItemName);
        return s.length() <= 50 ? s : null;
    }
}

package tfar.ae2extras;

import appeng.helpers.externalstorage.GenericStackInv;
import appeng.menu.SlotSemantics;
import appeng.menu.implementations.UpgradeableMenu;
import appeng.menu.slot.CellPartitionSlot;
import appeng.menu.slot.IPartitionSlotHost;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.util.StringUtil;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;
import java.util.Objects;

public class MonoCellMenu extends UpgradeableMenu<MonoCellMenuHost> implements IPartitionSlotHost {
    private String itemName;

    public MonoCellMenu(MenuType<?> menuType, int id, Inventory ip, MonoCellMenuHost host) {
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
            if (StringUtil.isBlank(s)) {
                itemstack.remove(DataComponents.CUSTOM_NAME);
            } else {
                itemstack.set(DataComponents.CUSTOM_NAME, Component.literal(s));
            }
            return true;
        } else {
            return false;
        }
    }

    @Nullable
    private static String validateName(String itemName) {
        String s = StringUtil.filterText(itemName);
        return s.length() <= 50 ? s : null;
    }
}

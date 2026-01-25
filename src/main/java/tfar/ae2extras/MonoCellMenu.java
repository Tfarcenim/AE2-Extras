package tfar.ae2extras;

import appeng.helpers.externalstorage.GenericStackInv;
import appeng.menu.SlotSemantics;
import appeng.menu.implementations.CellWorkbenchMenu;
import appeng.menu.implementations.UpgradeableMenu;
import appeng.menu.slot.CellPartitionSlot;
import appeng.menu.slot.FakeSlot;
import appeng.menu.slot.IPartitionSlotHost;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.MenuType;

import java.util.Objects;

public class MonoCellMenu extends UpgradeableMenu<MonoCellHost> implements IPartitionSlotHost {
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
}

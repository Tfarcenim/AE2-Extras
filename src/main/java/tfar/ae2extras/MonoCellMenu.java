package tfar.ae2extras;

import appeng.menu.implementations.UpgradeableMenu;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.MenuType;

public class MonoCellMenu extends UpgradeableMenu<MonoCellHost> {
    public MonoCellMenu(MenuType<?> menuType, int id, Inventory ip, MonoCellHost host) {
        super(menuType, id, ip, host);
    }
}

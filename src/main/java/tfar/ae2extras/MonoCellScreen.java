package tfar.ae2extras;

import appeng.client.gui.implementations.UpgradeableScreen;
import appeng.client.gui.style.ScreenStyle;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

/**
 * @see appeng.client.gui.implementations.CellWorkbenchScreen
 */
public class MonoCellScreen extends UpgradeableScreen<MonoCellMenu> {
    public MonoCellScreen(MonoCellMenu menu, Inventory playerInventory, Component title, ScreenStyle style) {
        super(menu, playerInventory, title, style);
    }
}

package tfar.ae2extras.init;

import appeng.menu.implementations.MenuTypeBuilder;
import net.minecraft.world.inventory.MenuType;
import tfar.ae2extras.MonoCellMenuHost;
import tfar.ae2extras.MonoCellMenu;

public class ModMenuTypes {
    public static final MenuType<MonoCellMenu> MONO_CELL = MenuTypeBuilder
            .create(MonoCellMenu::new, MonoCellMenuHost.class)
            .build("mono_item_cell");
}

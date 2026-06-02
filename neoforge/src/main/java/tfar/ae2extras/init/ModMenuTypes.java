package tfar.ae2extras.init;

import appeng.menu.implementations.MenuTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.inventory.MenuType;
import tfar.ae2extras.AE2Extras;
import tfar.ae2extras.MonoCellMenuHost;
import tfar.ae2extras.MonoCellMenu;

public class ModMenuTypes {
    public static final MenuType<MonoCellMenu> MONO_CELL = /*Registry.register(BuiltInRegistries.MENU,AE2Extras.id("mono_cell"),*/MenuTypeBuilder
            .create(MonoCellMenu::new, MonoCellMenuHost.class)
            .build("mono_cell");

    public static void init() {
    }
}

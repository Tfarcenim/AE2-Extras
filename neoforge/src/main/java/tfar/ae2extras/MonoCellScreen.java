package tfar.ae2extras;

import appeng.client.gui.implementations.UpgradeableScreen;
import appeng.client.gui.style.ScreenStyle;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.input.KeyEvent;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import tfar.ae2extras.network.C2SInputPacket;
import tfar.ae2extras.network.PacketHandler;

/**
 * @see appeng.client.gui.implementations.CellWorkbenchScreen
 */
public class MonoCellScreen extends UpgradeableScreen<MonoCellMenu> {

    protected EditBox editBox;

    public MonoCellScreen(MonoCellMenu menu, Inventory playerInventory, Component title, ScreenStyle style) {
        super(menu, playerInventory, title, style);
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;

        //values are set in screens
        this.editBox = new EditBox(this.font, 0, 0, 0, 0, Component.translatable("container.repair"));
        this.editBox.setCanLoseFocus(false);
        this.editBox.setTextColor(0x404040);
        this.editBox.setBordered(false);
        this.editBox.setMaxLength(50);
        this.editBox.setResponder(this::onNameChanged);

        this.addRenderableWidget(this.editBox);
        this.setInitialFocus(this.editBox);

        this.widgets.add("editbox",editBox);
    }

    @Override
    protected void init() {
        super.init();

        ItemStack stack = menu.getHost().getItemStack();
        if (stack.has(DataComponents.CUSTOM_NAME)) {
            String s= stack.getHoverName().getString();
            this.editBox.setValue(s);
        } else {
            this.editBox.setValue("");
        }
    }

    @Override
    public void resize(int width, int height) {
        //  String s = this.editBox.getValue();
        this.init(width, height);
        //  this.editBox.setValue(s);
    }

    @Override
    public boolean keyPressed(KeyEvent event) {
        if (event.isEscape()) {
            minecraft.player.closeContainer();
        }
        return editBox.keyPressed(event) || editBox.canConsumeInput() || super.keyPressed(event);
    }

    private void onNameChanged(String str) {
        ItemStack stack = menu.getHost().getItemStack();
        String s = str;
        if (this.menu.setItemName(s)) {
            PacketHandler.sendToServer(new C2SInputPacket(s));
        }

    }
}

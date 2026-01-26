package tfar.ae2extras;

import appeng.client.gui.implementations.UpgradeableScreen;
import appeng.client.gui.style.ScreenStyle;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import org.lwjgl.glfw.GLFW;
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

        this.addWidget(this.editBox);
        this.setInitialFocus(this.editBox);

        this.widgets.add("editbox",editBox);
    }

    @Override
    protected void init() {
        super.init();

        ItemStack stack = menu.getHost().getItemStack();
        if (stack.hasCustomHoverName()) {
            String s= stack.getHoverName().getString();
            this.editBox.setValue(s);
        } else {
            this.editBox.setValue("");
        }
    }

    @Override
    public void resize(Minecraft pMinecraft, int pWidth, int pHeight) {
      //  String s = this.editBox.getValue();
        this.init(pMinecraft, pWidth, pHeight);
      //  this.editBox.setValue(s);
    }

    /**
     * Called when a keyboard key is pressed within the GUI element.
     * <p>
     * @return {@code true} if the event is consumed, {@code false} otherwise.
     * @param pKeyCode the key code of the pressed key.
     * @param pScanCode the scan code of the pressed key.
     * @param pModifiers the keyboard modifiers.
     */
    @Override
    public boolean keyPressed(int pKeyCode, int pScanCode, int pModifiers) {
        if (pKeyCode == GLFW.GLFW_KEY_ESCAPE) {
            this.minecraft.player.closeContainer();
        }

        return this.editBox.keyPressed(pKeyCode, pScanCode, pModifiers) || this.editBox.canConsumeInput() || super.keyPressed(pKeyCode, pScanCode, pModifiers);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
        this.editBox.render(guiGraphics, mouseX, mouseY, partialTicks);
    }

    private void onNameChanged(String str) {
        ItemStack stack = menu.getHost().getItemStack();
        String s = str;
        if (this.menu.setItemName(s)) {
            PacketHandler.sendToServer(new C2SInputPacket(s));
        }

    }


    @Override
    public void containerTick() {
        super.containerTick();
        this.editBox.tick();
    }
}

package tfar.ae2extras;

import appeng.api.config.Actionable;
import appeng.api.implementations.menuobjects.IMenuItem;
import appeng.api.implementations.menuobjects.ItemMenuHost;
import appeng.api.stacks.AEKeyType;
import appeng.api.storage.StorageCells;
import appeng.api.upgrades.IUpgradeInventory;
import appeng.api.upgrades.UpgradeInventories;
import appeng.block.networking.EnergyCellBlockItem;
import appeng.core.localization.PlayerMessages;
import appeng.items.storage.BasicStorageCell;
import appeng.menu.MenuOpener;
import appeng.menu.locator.ItemMenuHostLocator;
import appeng.menu.locator.MenuLocators;
import appeng.recipes.game.StorageCellDisassemblyRecipe;
import appeng.util.InteractionUtil;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;
import tfar.ae2extras.init.ModMenuTypes;

public class MonoStorageCellItem extends BasicStorageCell implements IMenuItem {


    public MonoStorageCellItem(Properties properties, double idleDrain, int kilobytes, int bytesPerType, int totalTypes, AEKeyType keyType) {
        super(properties,idleDrain, kilobytes, bytesPerType, totalTypes, keyType);
    }

    @Override
    public IUpgradeInventory getUpgrades(ItemStack is) {
        return UpgradeInventories.forItem(is, 1);
    }

    @Override
    public InteractionResult onItemUseFirst(ItemStack stack, UseOnContext context) {
        return context.isSecondaryUseActive()
                && this.disassembleDrive(stack, context.getLevel(), context.getPlayer())
                ? InteractionResult.SUCCESS
                : InteractionResult.PASS;
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        if (!InteractionUtil.isInAlternateUseMode(player)
                || !disassembleDrive(player.getItemInHand(hand), level, player)) {
            if (!level.isClientSide()) {
                MenuOpener.open(ModMenuTypes.MONO_CELL, player, MenuLocators.forHand(player, hand));
            }
        }
        return InteractionResult.SUCCESS;
    }

    private boolean disassembleDrive(ItemStack stack, Level level, Player player) {
        if (!(level instanceof ServerLevel serverLevel)) {
            return false;
        }

        var playerInventory = player.getInventory();
        var disassemblyItems = StorageCellDisassemblyRecipe.getDisassemblyResult(serverLevel, stack.getItem());
        if (disassemblyItems.isEmpty() || playerInventory.getSelectedItem() != stack || stack.getCount() != 1) {
            return false;
        }

        if (level.isClientSide()) {
            return true; // Further checks cannot be done on the client
        }

        var inv = StorageCells.getCellInventory(stack, null);
        if (inv != null && !inv.getAvailableStacks().isEmpty()) {
            player.sendOverlayMessage(PlayerMessages.OnlyEmptyCellsCanBeDisassembled.text());
            return true; // Prevents the UI from opening and overlaying the error message
        }

        playerInventory.setItem(playerInventory.getSelectedSlot(), ItemStack.EMPTY);

        double remainingEnergy = 1;//getAECurrentPower(stack);todo
        for (var recipeStack : disassemblyItems) {
            var droppedStack = recipeStack.copy();
            // Dump remaining energy into whatever can accept it
            if (remainingEnergy > 0 && droppedStack.getItem() instanceof EnergyCellBlockItem energyCell) {
                remainingEnergy = energyCell.injectAEPower(droppedStack, remainingEnergy, Actionable.MODULATE);
            }

            playerInventory.placeItemBackInInventory(droppedStack);
        }

        // Drop upgrades
        getUpgrades(stack).forEach(playerInventory::placeItemBackInInventory);

        return true;
    }


    @Override
    public @Nullable ItemMenuHost<?> getMenuHost(Player player, ItemMenuHostLocator itemMenuHostLocator, @Nullable BlockHitResult blockHitResult) {
        return new MonoCellMenuHost(this,player,itemMenuHostLocator);
    }
}

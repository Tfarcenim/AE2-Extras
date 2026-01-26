package tfar.ae2extras;

import appeng.api.implementations.menuobjects.IMenuItem;
import appeng.api.implementations.menuobjects.ItemMenuHost;
import appeng.api.stacks.AEKeyType;
import appeng.api.upgrades.IUpgradeInventory;
import appeng.api.upgrades.UpgradeInventories;
import appeng.items.storage.BasicStorageCell;
import appeng.menu.MenuOpener;
import appeng.menu.locator.MenuLocators;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import tfar.ae2extras.init.ModMenuTypes;

public class MonoStorageCellItem extends BasicStorageCell implements IMenuItem {


    public MonoStorageCellItem(Properties properties, ItemLike coreItem, ItemLike housingItem, double idleDrain, int kilobytes, int bytesPerType, int totalTypes, AEKeyType keyType) {
        super(properties, coreItem, housingItem, idleDrain, kilobytes, bytesPerType, totalTypes, keyType);
    }

    @Override
    public IUpgradeInventory getUpgrades(ItemStack is) {
        return UpgradeInventories.forItem(is, 1);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!player.isCrouching()) {
            if (!level.isClientSide()) {
                MenuOpener.open(ModMenuTypes.MONO_CELL, player, MenuLocators.forHand(player, hand));
            }
            return new InteractionResultHolder<>(InteractionResult.sidedSuccess(level.isClientSide()),
                    player.getItemInHand(hand));
        } else {
            return super.use(level, player, hand);
        }
    }

    @Override
    public @Nullable ItemMenuHost getMenuHost(Player player, int inventorySlot, ItemStack stack, @Nullable BlockPos pos) {
        return new MonoCellHost(player,inventorySlot,stack);
    }
}

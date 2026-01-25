package tfar.ae2extras;

import appeng.api.config.CopyMode;
import appeng.api.config.Settings;
import appeng.api.implementations.menuobjects.ItemMenuHost;
import appeng.api.inventories.InternalInventory;
import appeng.api.storage.cells.ICellWorkbenchItem;
import appeng.api.upgrades.IUpgradeInventory;
import appeng.blockentity.misc.CellWorkbenchBlockEntity;
import appeng.helpers.IConfigInvHost;
import appeng.helpers.externalstorage.GenericStackInv;
import appeng.util.ConfigInventory;
import appeng.util.ConfigManager;
import appeng.util.inv.InternalInventoryHost;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class MonoCellHost extends ItemMenuHost implements IConfigInvHost, InternalInventoryHost {

    private final GenericStackInv config = new GenericStackInv(this::configChanged, GenericStackInv.Mode.CONFIG_TYPES,
            1);

    private ConfigInventory cacheConfig = null;
    boolean locked = false;

    private final ConfigManager manager = new ConfigManager(this::saveChanges);


    public MonoCellHost(Player player, @Nullable Integer slot, ItemStack itemStack) {
        super(player, slot, itemStack);
        this.config.readFromChildTag(itemStack.getTag(), "list");
    }

    @Override
    public GenericStackInv getConfig() {
        return config;
    }

    private void configChanged() {
        if (locked) {
            return;
        }

        this.locked = true;
        try {
            var c = this.getCellConfigInventory();
            if (c != null) {
                CellWorkbenchBlockEntity.copy(this.config, c);
                // Copy items back. The cell may change the items on insert, for example if a fluid tank gets turned
                // into a dummy fluid item.
                CellWorkbenchBlockEntity.copy(c, this.config);
            }
        } finally {
            this.locked = false;
        }
    }

    private ConfigInventory getCellConfigInventory() {
        if (this.cacheConfig == null) {
            var cell = this.getCell();
            if (cell == null) {
                return null;
            }

            var is = getItemStack();
            if (is.isEmpty()) {
                return null;
            }

            var inv = cell.getConfigInventory(is);
            if (inv == null) {
                return null;
            }

            this.cacheConfig = inv;
        }
        return this.cacheConfig;
    }

    public ICellWorkbenchItem getCell() {
        return getItemStack().getItem() instanceof ICellWorkbenchItem iCellWorkbenchItem ? iCellWorkbenchItem : null;
    }

    @Override
    public void saveChanges() {

    }

    @Override
    public void onChangeInventory(InternalInventory inv, int slot) {
        if (!this.locked) {
            this.locked = true;
            try {
                this.cacheConfig = null;

                var configInventory = this.getCellConfigInventory();
                if (configInventory != null) {
                    if (!configInventory.isEmpty()) {
                        // Copy cell -> config inventory
                        CellWorkbenchBlockEntity.copy(configInventory, this.config);
                    } else {
                        // Copy config inventory -> cell, when cell's config is empty
                        CellWorkbenchBlockEntity.copy(this.config, configInventory);
                        // Copy items back. The cell may change the items on insert, for example if a fluid tank gets
                        // turned
                        // into a dummy fluid item.
                        CellWorkbenchBlockEntity.copy(configInventory, this.config);
                    }
                } else if (this.manager.getSetting(Settings.COPY_MODE) == CopyMode.CLEAR_ON_REMOVE) {
                    this.config.clear();
                    this.saveChanges();
                }
            } finally {
                this.locked = false;
            }
        }
    }
}

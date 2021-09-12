package tfar.ae2extras.mixin;

import appeng.api.implementations.items.IStorageCell;
import appeng.api.storage.cells.ICellInventory;
import appeng.api.storage.cells.ISaveProvider;
import appeng.api.storage.data.IAEStack;
import appeng.me.storage.AbstractCellInventory;
import appeng.me.storage.BasicCellInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import tfar.ae2extras.AE2Extras;
import tfar.ae2extras.PatchedBasicCellInventory;

@Mixin(BasicCellInventory.class)
public abstract class BasicCellInventoryMixin <T extends IAEStack<T>> extends AbstractCellInventory<T> {

    protected BasicCellInventoryMixin(IStorageCell<T> cellType, ItemStack o, ISaveProvider container) {
        super(cellType, o, container);
    }

    @Inject(method = "createInventory",at = @At(value = "RETURN",ordinal = 0),locals = LocalCapture.CAPTURE_FAILHARD,remap = false, cancellable = true)
    private static <T extends IAEStack<T>> void yeet(ItemStack o, ISaveProvider container, CallbackInfoReturnable<ICellInventory<T>> cir, Item type, IStorageCell<T> cellType) {
        if (type.getRegistryName().getNamespace().equals(AE2Extras.MODID)) {
            cir.setReturnValue(new PatchedBasicCellInventory<>(cellType, o, container));
        }
    }

    /*


        @Shadow protected abstract boolean isStorageCell(T input);

    @Shadow private static boolean isCellEmpty(ICellInventory inv) {
        throw new RuntimeException("no");
    };

    @Overwrite(remap = false)
    public T injectItems(T input, Actionable mode, IActionSource src) {
        if (input == null) {
            return null;
        } else if (input.getStackSize() == 0L) {
            return null;
        } else if (this.cellType.isBlackListed(this.getItemStack(), input)) {
            return input;
        } else {
            if (this.isStorageCell(input)) {
                ICellInventory<?> meInventory = createInventory(((IAEItemStack)input).createItemStack(), null);
                if (!isCellEmpty(meInventory)) {
                    return input;
                }
            }

            T l = this.getCellItems().findPrecise(input);
            IAEStack<T> toWrite;
            if (l != null) {
                long remainingItemCount = this.getRemainingItemCount();
                if (remainingItemCount <= 0L) {
                    return input;
                } else if (input.getStackSize() > remainingItemCount) {
                    toWrite = input.copy();
                    toWrite.setStackSize(toWrite.getStackSize() - remainingItemCount);
                    if (mode == Actionable.MODULATE) {
                        l.setStackSize(l.getStackSize() + remainingItemCount);
                        this.saveChanges();
                    }

                    return (T)toWrite;
                } else {
                    if (mode == Actionable.MODULATE) {
                        l.setStackSize(l.getStackSize() + input.getStackSize());
                        this.saveChanges();
                    }

                    return null;
                }
            } else {
                if (this.canHoldNewItem()) {

                    long a = this.getRemainingItemCount();
                    int b = this.getBytesPerType() * this.itemsPerByte;

                    int remainingItemCount = (int)a - b;

                    if (remainingItemCount > 0) {
                        if (input.getStackSize() > (long)remainingItemCount) {
                            T toReturn = input.copy();
                            toReturn.setStackSize(input.getStackSize() - (long)remainingItemCount);
                            if (mode == Actionable.MODULATE) {
                                toWrite = input.copy();
                                toWrite.setStackSize(remainingItemCount);
                                this.cellItems.add((T)toWrite);
                                this.saveChanges();
                            }

                            return toReturn;
                        }

                        if (mode == Actionable.MODULATE) {
                            this.cellItems.add(input);
                            this.saveChanges();
                        }

                        return null;
                    }
                }

                return input;
            }
        }
    }*/
}

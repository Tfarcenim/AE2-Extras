package tfar.ae2extras;

/*
 * This file is part of Applied Energistics 2.
 * Copyright (c) 2013 - 2014, AlgorithmX2, All rights reserved.
 *
 * Applied Energistics 2 is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Applied Energistics 2 is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Applied Energistics 2.  If not, see <http://www.gnu.org/licenses/lgpl>.
 */

import appeng.api.storage.IMEInventory;
import appeng.api.storage.channels.IItemStorageChannel;
import appeng.api.storage.data.IAEItemStack;
import appeng.api.storage.data.IItemList;
import appeng.core.Api;
import appeng.core.AppEng;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.SpecialRecipe;
import net.minecraft.item.crafting.SpecialRecipeSerializer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.Optional;

public final class DisassembleRecipe extends SpecialRecipe {
    public static final IRecipeSerializer<appeng.recipes.game.DisassembleRecipe> SERIALIZER = new SpecialRecipeSerializer<>(
            appeng.recipes.game.DisassembleRecipe::new);

    static {
        SERIALIZER.setRegistryName(new ResourceLocation(AppEng.MOD_ID, "disassemble"));
    }

    private static final ItemStack MISMATCHED_STACK = ItemStack.EMPTY;

    public DisassembleRecipe(ResourceLocation id) {
        super(id);
    }

    @Override
    public boolean matches(@Nonnull final CraftingInventory inv, @Nonnull final World w) {
        return !this.getOutput(inv).isEmpty();
    }

    @Nonnull
    private ItemStack getOutput(final IInventory inventory) {
        int itemCount = 0;
        ItemStack output = MISMATCHED_STACK;

        for (int slotIndex = 0; slotIndex < inventory.getSizeInventory(); slotIndex++) {
            final ItemStack stackInSlot = inventory.getStackInSlot(slotIndex);
            if (!stackInSlot.isEmpty()) {
                // needs a single input in the recipe
                itemCount++;
                if (itemCount > 1) {
                    return MISMATCHED_STACK;
                }

                // handle storage cells
                Optional<ItemStack> maybeCellOutput = null;//this.getCellOutput(stackInSlot);
                if (maybeCellOutput.isPresent()) {
                    ItemStack storageCellStack = maybeCellOutput.get();
                    // make sure the storage cell stackInSlot empty...
                    final IMEInventory<IAEItemStack> cellInv = Api.instance().registries().cell().getCellInventory(
                            stackInSlot, null, Api.instance().storage().getStorageChannel(IItemStorageChannel.class));
                    if (cellInv != null) {
                        final IItemList<IAEItemStack> list = cellInv.getAvailableItems(
                                Api.instance().storage().getStorageChannel(IItemStorageChannel.class).createList());
                        if (!list.isEmpty()) {
                            return ItemStack.EMPTY;
                        }
                    }

                    output = storageCellStack;
                }
            }
        }

        return output;
    }

    @Nonnull
    @Override
    public ItemStack getCraftingResult(@Nonnull final CraftingInventory inv) {
        return this.getOutput(inv);
    }

    @Override
    public boolean canFit(int i, int i1) {
        return false;
    }

    @Nonnull
    @Override
    public IRecipeSerializer<appeng.recipes.game.DisassembleRecipe> getSerializer() {
        return SERIALIZER;
    }

}
package tfar.ae2extras;

import appeng.api.upgrades.Upgrades;
import appeng.blockentity.crafting.CraftingBlockEntity;
import appeng.blockentity.networking.EnergyCellBlockEntity;
import appeng.core.definitions.AEBlockEntities;
import appeng.core.definitions.AEItems;
import appeng.core.localization.GuiText;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.BlockEntityTypeAddBlocksEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.registries.RegisterEvent;
import tfar.ae2extras.client.AE2ExtrasStorageCellModels;
import tfar.ae2extras.datagen.ModDatagen;
import tfar.ae2extras.init.AE2ExtrasBlocks;
import tfar.ae2extras.init.AE2ExtrasItems;
import tfar.ae2extras.init.ModMenuTypes;
import tfar.ae2extras.integration.mekanism.AE2ExtrasMekCompat;
import tfar.ae2extras.integration.Integration;
import tfar.ae2extras.network.PacketHandler;

import java.util.List;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(AE2Extras.MOD_ID)
public class AE2ExtrasNeoforge {
    // Directly reference a log4j logger.


    public AE2ExtrasNeoforge(IEventBus bus) {
        // Register the setup method for modloading
        bus.addListener(this::blocks);
        bus.addListener(ModDatagen::gather);
        bus.addListener(this::common);
        bus.addListener(this::network);
        bus.addListener(this::addBlocks);
    }

    private void common(FMLCommonSetupEvent e) {

        Class<CraftingBlockEntity> entityClass = CraftingBlockEntity.class;

        Class<EnergyCellBlockEntity> energyCellClass = EnergyCellBlockEntity.class;
        BlockEntityType<CraftingBlockEntity> craftingStorage = AEBlockEntities.CRAFTING_STORAGE.get();

        AE2ExtrasBlocks.CRAFTING_STORAGE_1M.setBlockEntity(entityClass, craftingStorage, null, null);
        AE2ExtrasBlocks.CRAFTING_STORAGE_4M.setBlockEntity(entityClass, craftingStorage, null, null);
        AE2ExtrasBlocks.CRAFTING_STORAGE_16M.setBlockEntity(entityClass, craftingStorage, null, null);
        AE2ExtrasBlocks.CRAFTING_STORAGE_64M.setBlockEntity(entityClass, craftingStorage, null, null);

        BlockEntityType<EnergyCellBlockEntity> energyCell = AEBlockEntities.ENERGY_CELL.get();

        AE2ExtrasBlocks.DENSER_ENERGY_CELL.setBlockEntity(energyCellClass, energyCell, null, null);
        AE2ExtrasBlocks.DENSEST_ENERGY_CELL.setBlockEntity(energyCellClass, energyCell, null, null);

        AE2ExtrasStorageCellModels.init();

        handleUpgrades();
    }

    void addBlocks(BlockEntityTypeAddBlocksEvent event) {
        event.modify(AEBlockEntities.CRAFTING_STORAGE.get(), AE2ExtrasBlocks.CRAFTING_STORAGE_1M, AE2ExtrasBlocks.CRAFTING_STORAGE_4M,
                AE2ExtrasBlocks.CRAFTING_STORAGE_16M, AE2ExtrasBlocks.CRAFTING_STORAGE_64M);

        event.modify(AEBlockEntities.ENERGY_CELL.get(), AE2ExtrasBlocks.DENSER_ENERGY_CELL, AE2ExtrasBlocks.DENSEST_ENERGY_CELL);
    }

    void network(RegisterPayloadHandlersEvent event) {
        PacketHandler.registerPackets(event);
    }

    void handleUpgrades() {
        String storageCellGroup = GuiText.StorageCells.getTranslationKey();
        String portableCellGroup = GuiText.PortableCells.getTranslationKey();
        // Storage Cells
        var itemCells = List.of(
                AE2ExtrasItems.ITEM_CELL_1M, AE2ExtrasItems.ITEM_CELL_4M, AE2ExtrasItems.ITEM_CELL_16M, AE2ExtrasItems.ITEM_CELL_64M);
        for (var itemCell : itemCells) {
            Upgrades.add(AEItems.FUZZY_CARD, itemCell, 1, storageCellGroup);
            Upgrades.add(AEItems.INVERTER_CARD, itemCell, 1, storageCellGroup);
            Upgrades.add(AEItems.EQUAL_DISTRIBUTION_CARD, itemCell, 1, storageCellGroup);
            Upgrades.add(AEItems.VOID_CARD, itemCell, 1, storageCellGroup);
        }

        var fluidCells = List.of(
                AE2ExtrasItems.FLUID_CELL_1M, AE2ExtrasItems.FLUID_CELL_4M, AE2ExtrasItems.FLUID_CELL_16M, AE2ExtrasItems.FLUID_CELL_64M);
        for (var fluidCell : fluidCells) {
            Upgrades.add(AEItems.INVERTER_CARD, fluidCell, 1, storageCellGroup);
            Upgrades.add(AEItems.EQUAL_DISTRIBUTION_CARD, fluidCell, 1, storageCellGroup);
            Upgrades.add(AEItems.VOID_CARD, fluidCell, 1, storageCellGroup);
        }

        var portableCells = List.of(
                AE2ExtrasItems.PORTABLE_ITEM_CELL_1M, AE2ExtrasItems.PORTABLE_ITEM_CELL_4M, AE2ExtrasItems.PORTABLE_ITEM_CELL_16M,
                AE2ExtrasItems.PORTABLE_ITEM_CELL_64M);
        for (var portableCell : portableCells) {
            Upgrades.add(AEItems.FUZZY_CARD, portableCell, 1, portableCellGroup);
            Upgrades.add(AEItems.INVERTER_CARD, portableCell, 1, portableCellGroup);
            Upgrades.add(AEItems.EQUAL_DISTRIBUTION_CARD, portableCell, 1, portableCellGroup);
            Upgrades.add(AEItems.VOID_CARD, portableCell, 1, portableCellGroup);
            Upgrades.add(AEItems.ENERGY_CARD, portableCell, 2, portableCellGroup);
        }

        var portableFluidCells = List.of(
                AE2ExtrasItems.PORTABLE_FLUID_CELL_1M, AE2ExtrasItems.PORTABLE_FLUID_CELL_4M, AE2ExtrasItems.PORTABLE_FLUID_CELL_16M,
                AE2ExtrasItems.PORTABLE_FLUID_CELL_64M);
        for (var portableFluidCell : portableFluidCells) {
            Upgrades.add(AEItems.INVERTER_CARD, portableFluidCell, 1, portableCellGroup);
            Upgrades.add(AEItems.EQUAL_DISTRIBUTION_CARD, portableFluidCell, 1, portableCellGroup);
            Upgrades.add(AEItems.VOID_CARD, portableFluidCell, 1, portableCellGroup);
            Upgrades.add(AEItems.ENERGY_CARD, portableFluidCell, 2, portableCellGroup);
        }

        var monocells = AE2ExtrasItems.monoCells();
        for (var monocell : monocells) {
            Upgrades.add(AEItems.VOID_CARD, monocell, 1, storageCellGroup);
        }
    }

    private void blocks(final RegisterEvent event) {

        if (event.getRegistry() == BuiltInRegistries.BLOCK) {
            AE2ExtrasBlocks.init();
            AE2ExtrasItems.init();


            Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, AE2Extras.id("tab"), AE2ExtrasItems.TAB);
            ModMenuTypes.init();
            if (Integration.appmek.loaded) {
                AE2ExtrasMekCompat.register(event);
            }
        }
    }
}

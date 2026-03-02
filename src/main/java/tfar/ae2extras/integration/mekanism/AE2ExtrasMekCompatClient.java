package tfar.ae2extras.integration.mekanism;

import appeng.items.storage.BasicStorageCell;
import appeng.items.tools.powered.PortableCellItem;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import tfar.ae2extras.init.AE2ExtrasItems;

public class AE2ExtrasMekCompatClient {


    public static void colors(RegisterColorHandlersEvent.Item event) {
        event.register(PortableCellItem::getColor,
                MItems.PORTABLE_CHEMICAL_STORAGE_CELL_1M,
                MItems.PORTABLE_CHEMICAL_STORAGE_CELL_4M,
                MItems.PORTABLE_CHEMICAL_STORAGE_CELL_16M,
                MItems.PORTABLE_CHEMICAL_STORAGE_CELL_64M);

        event.register(BasicStorageCell::getColor, MItems.CHEMICAL_CELL_1M,
                MItems.CHEMICAL_CELL_4M,
                MItems.CHEMICAL_CELL_16M,
                MItems.CHEMICAL_CELL_64M);
    }
}

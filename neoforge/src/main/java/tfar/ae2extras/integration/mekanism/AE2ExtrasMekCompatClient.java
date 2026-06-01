package tfar.ae2extras.integration.mekanism;

import appeng.items.storage.BasicStorageCell;
import appeng.items.tools.powered.PortableCellItem;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import tfar.ae2extras.client.AE2ExtrasClient;

public class AE2ExtrasMekCompatClient {


    public static void colors(RegisterColorHandlersEvent.Item event) {
        event.register(AE2ExtrasClient.makeOpaque(PortableCellItem::getColor),
                MItems.PORTABLE_CHEMICAL_STORAGE_CELL_1M,
                MItems.PORTABLE_CHEMICAL_STORAGE_CELL_4M,
                MItems.PORTABLE_CHEMICAL_STORAGE_CELL_16M,
                MItems.PORTABLE_CHEMICAL_STORAGE_CELL_64M);

        event.register(AE2ExtrasClient.makeOpaque(BasicStorageCell::getColor), MItems.CHEMICAL_CELL_1M,
                MItems.CHEMICAL_CELL_4M,
                MItems.CHEMICAL_CELL_16M,
                MItems.CHEMICAL_CELL_64M);
    }
}

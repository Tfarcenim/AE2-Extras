package tfar.ae2extras.init.client;

import appeng.client.render.SimpleModelLoader;
import appeng.client.render.crafting.CraftingCubeModel;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.client.model.geometry.IModelGeometry;
import tfar.ae2extras.AE2Extras;
import tfar.ae2extras.AE2ExtrasCraftingUnitType;

import java.util.function.Supplier;

public class InitBuiltInModelsEx {
    public static void init() {

        addBuiltInModel("block/crafting/1m_storage_formed",
                () -> new CraftingCubeModel(new CraftingUnitModelProviderEx(AE2ExtrasCraftingUnitType.STORAGE_1M)));
        addBuiltInModel("block/crafting/4m_storage_formed",
                () -> new CraftingCubeModel(new CraftingUnitModelProviderEx(AE2ExtrasCraftingUnitType.STORAGE_4M)));
        addBuiltInModel("block/crafting/16m_storage_formed",
                () -> new CraftingCubeModel(new CraftingUnitModelProviderEx(AE2ExtrasCraftingUnitType.STORAGE_16M)));
        addBuiltInModel("block/crafting/64m_storage_formed",
                () -> new CraftingCubeModel(new CraftingUnitModelProviderEx(AE2ExtrasCraftingUnitType.STORAGE_64M)));

    //    addBuiltInModel("block/crafting/accelerator_formed",
    //            () -> new CraftingCubeModel(new CraftingUnitModelProvider(AE2ExtrasCraftingUnitType.ACCELERATOR)));

    }

    private static <T extends IModelGeometry<T>> void addBuiltInModel(String id, Supplier<T> modelFactory) {
        ModelLoaderRegistry.registerLoader(AE2Extras.makeId(id),
                new SimpleModelLoader<>(modelFactory));
    }
}

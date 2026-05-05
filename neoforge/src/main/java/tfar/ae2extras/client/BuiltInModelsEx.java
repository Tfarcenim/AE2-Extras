package tfar.ae2extras.client;

import appeng.client.render.crafting.CraftingCubeModel;
import appeng.hooks.BuiltInModelHooks;
import net.minecraft.client.resources.model.UnbakedModel;
import net.minecraft.resources.ResourceLocation;
import tfar.ae2extras.AE2Extras;
import tfar.ae2extras.AE2ExtrasCraftingUnitType;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class BuiltInModelsEx {

    private static final Map<ResourceLocation, UnbakedModel> builtInModels = new HashMap<>();

    public static void init() {
        addBuiltInModel("block/crafting/1m_storage_formed",
                () -> new CraftingCubeModel(new CraftingUnitModelProviderEx(AE2ExtrasCraftingUnitType.STORAGE_1M)));
        addBuiltInModel("block/crafting/4m_storage_formed",
                () -> new CraftingCubeModel(new CraftingUnitModelProviderEx(AE2ExtrasCraftingUnitType.STORAGE_4M)));
        addBuiltInModel("block/crafting/16m_storage_formed",
                () -> new CraftingCubeModel(new CraftingUnitModelProviderEx(AE2ExtrasCraftingUnitType.STORAGE_16M)));
        addBuiltInModel("block/crafting/64m_storage_formed",
                () -> new CraftingCubeModel(new CraftingUnitModelProviderEx(AE2ExtrasCraftingUnitType.STORAGE_64M)));
    }

    private static <T extends UnbakedModel> void addBuiltInModel(String id, Supplier<T> modelFactory) {
        builtInModels.put(AE2Extras.id(id), modelFactory.get());
    }

    public static UnbakedModel getBuiltInModel(ResourceLocation id) {
        return builtInModels.get(id);
    }
}

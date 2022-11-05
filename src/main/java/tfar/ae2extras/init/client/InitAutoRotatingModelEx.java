package tfar.ae2extras.init.client;

import appeng.block.AEBaseBlock;
import appeng.client.render.crafting.MonitorBakedModel;
import appeng.client.render.model.AutoRotatingBakedModel;
import appeng.core.AppEng;
import appeng.core.definitions.AEBlocks;
import appeng.core.definitions.BlockDefinition;
import appeng.init.client.InitAutoRotatingModel;
import com.google.common.collect.Sets;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import tfar.ae2extras.AE2Extras;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class InitAutoRotatingModelEx {
    private static final Map<String, Function<BakedModel, BakedModel>> CUSTOMIZERS = new HashMap<>();

    private InitAutoRotatingModelEx() {
    }

    public static void init(IEventBus modEventBus) {
        modEventBus.addListener(InitAutoRotatingModelEx::onModelBake);
    }

    private static void register(BlockDefinition<?> block, Function<BakedModel, BakedModel> customizer) {
        String path = block.id().getPath();
        CUSTOMIZERS.put(path, customizer);
    }

    private static void onModelBake(ModelBakeEvent event) {
        Map<ResourceLocation, BakedModel> modelRegistry = event.getModelRegistry();
        Set<ResourceLocation> keys = Sets.newHashSet(modelRegistry.keySet());
        BakedModel missingModel = modelRegistry.get(ModelBakery.MISSING_MODEL_LOCATION);

        for (ResourceLocation location : keys) {
            if (!location.getNamespace().equals(AE2Extras.MODID)) {
                continue;
            }

            BakedModel orgModel = modelRegistry.get(location);

            // Don't customize the missing model. This causes Forge to swallow exceptions
            if (orgModel == missingModel) {
                continue;
            }

            Function<BakedModel, BakedModel> customizer = CUSTOMIZERS.get(location.getPath());
            if (customizer != null) {
                BakedModel newModel = customizer.apply(orgModel);

                if (newModel != orgModel) {
                    modelRegistry.put(location, newModel);
                }
            }
        }
    }
}

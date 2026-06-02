package tfar.ae2extras.client;

import appeng.core.AppEng;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.client.renderer.block.dispatch.BlockStateModel;
import net.minecraft.client.resources.model.ModelBaker;
import net.minecraft.resources.Identifier;
import net.neoforged.neoforge.client.model.block.CustomUnbakedBlockStateModel;
import tfar.ae2extras.AE2Extras;
import tfar.ae2extras.AE2ExtrasCraftingUnitType;

public class BuiltInModelsEx {

    public static void init() {
    }

    public record Unbaked(AE2ExtrasCraftingUnitType type) implements CustomUnbakedBlockStateModel {
        public static final Identifier ID = AE2Extras.id("crafting_cube");
        public static final MapCodec<Unbaked> MAP_CODEC = RecordCodecBuilder
                .mapCodec(instance -> instance.group(
                        AE2ExtrasCraftingUnitType.CODEC.fieldOf("unit_type").forGetter(Unbaked::type))
                        .apply(instance, Unbaked::new));

        @Override
        public BlockStateModel bake(ModelBaker baker) {
            var provider = new CraftingUnitModelProviderEx(type);
            return provider.bake(baker.materials());
        }

        @Override
        public void resolveDependencies(Resolver resolver) {
        }

        @Override
        public MapCodec<Unbaked> codec() {
            return MAP_CODEC;
        }
    }

}

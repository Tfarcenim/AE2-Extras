package tfar.ae2extras.mixin;

import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.UnbakedModel;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import tfar.ae2extras.client.BuiltInModelsEx;

/**
 * Replicates the part of the Fabric API for adding built-in models that we actually use.
 */
@Mixin(ModelBakery.class)
public class ModelBakeryMixin {
    @Inject(at = @At("HEAD"), method = "getModel", cancellable = true)
    private void getModelHook(ResourceLocation id, CallbackInfoReturnable<UnbakedModel> cir) {
        var model = BuiltInModelsEx.getBuiltInModel(id);
        if (model != null) {
            cir.setReturnValue(model);
        }
    }
}

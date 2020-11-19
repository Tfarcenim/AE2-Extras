package appeng.client.render.crafting;

import appeng.block.crafting.AbstractCraftingUnitBlock;
import com.google.common.collect.Lists;
import net.minecraft.client.renderer.model.RenderMaterial;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.ResourceLocation;
import tfar.ae2extras.AE2Extras;

import java.util.List;
import java.util.function.Function;

public class GrossAE2Hacks {

    public static LightBakedModel getModel(Object model, TextureAtlasSprite ringCorner, TextureAtlasSprite ringSideHor, TextureAtlasSprite ringSideVer, Function<RenderMaterial, TextureAtlasSprite> spriteGetter, RenderMaterial lightBase, AbstractCraftingUnitBlock.CraftingUnitType type) {
        return new LightBakedModel(ringCorner, ringSideHor, ringSideVer, spriteGetter.apply(lightBase), getLightTexture(spriteGetter, type));
    }

    private static TextureAtlasSprite getLightTexture(Function<RenderMaterial, TextureAtlasSprite> textureGetter, AbstractCraftingUnitBlock.CraftingUnitType type) {

        if (type == AE2Extras.STORAGE_256K)
            return textureGetter.apply(STORAGE_256K_LIGHT);
        if (type == AE2Extras.STORAGE_1M)
            return textureGetter.apply(STORAGE_1M_LIGHT);
        if (type == AE2Extras.STORAGE_4M)
            return textureGetter.apply(STORAGE_4M_LIGHT);
        if (type == AE2Extras.STORAGE_16M)
            return textureGetter.apply(STORAGE_16M_LIGHT);
        throw new RuntimeException("whut");
    }

    private static final RenderMaterial STORAGE_256K_LIGHT = texture("256k_storage_light");
    private static final RenderMaterial STORAGE_1M_LIGHT = texture("1m_storage_light");
    private static final RenderMaterial STORAGE_4M_LIGHT = texture("4m_storage_light");
    private static final RenderMaterial STORAGE_16M_LIGHT = texture("16m_storage_light");

    private static RenderMaterial texture(String name) {
        return new RenderMaterial(AtlasTexture.LOCATION_BLOCKS_TEXTURE, new ResourceLocation(AE2Extras.MODID, "block/crafting/" + name));
    }

    public static List<RenderMaterial> materials = Lists.newArrayList(STORAGE_256K_LIGHT,STORAGE_1M_LIGHT,STORAGE_4M_LIGHT,STORAGE_16M_LIGHT);

}

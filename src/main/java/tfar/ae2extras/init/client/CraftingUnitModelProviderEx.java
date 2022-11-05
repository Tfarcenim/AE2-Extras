package tfar.ae2extras.init.client;

import appeng.client.render.crafting.AbstractCraftingUnitModelProvider;
import appeng.client.render.crafting.LightBakedModel;
import appeng.core.AppEng;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.Material;
import tfar.ae2extras.AE2Extras;
import tfar.ae2extras.AE2ExtrasCraftingUnitType;

import java.util.*;
import java.util.function.Function;

import static tfar.ae2extras.AE2ExtrasCraftingUnitType.*;

/**
 * based on
 */
public class CraftingUnitModelProviderEx extends AbstractCraftingUnitModelProvider<AE2ExtrasCraftingUnitType> {

    private static final List<Material> MATERIALS = new ArrayList<>();

    protected final static Material RING_CORNER = ae2Texture("ring_corner");
    protected final static Material RING_SIDE_HOR = ae2Texture("ring_side_hor");
    protected final static Material RING_SIDE_VER = ae2Texture("ring_side_ver");
    protected final static Material LIGHT_BASE = ae2Texture("light_base");
    //protected final static Material ACCELERATOR_LIGHT = texture("accelerator_light");
    protected final static Material STORAGE_1M_LIGHT = texture("1m_storage_light");
    protected final static Material STORAGE_4M_LIGHT = texture("4m_storage_light");
    protected final static Material STORAGE_16M_LIGHT = texture("16m_storage_light");
    protected final static Material STORAGE_64M_LIGHT = texture("64m_storage_light");

    public CraftingUnitModelProviderEx(AE2ExtrasCraftingUnitType type) {
        super(type);
    }

    @Override
    public List<Material> getMaterials() {
        return Collections.unmodifiableList(MATERIALS);
    }

    static final Map<AE2ExtrasCraftingUnitType, Material> map = new HashMap<>();

    static {
        map.put(STORAGE_1M, STORAGE_1M_LIGHT);
        map.put(STORAGE_4M, STORAGE_4M_LIGHT);
        map.put(STORAGE_16M, STORAGE_16M_LIGHT);
        map.put(STORAGE_64M, STORAGE_64M_LIGHT);
    }

    public TextureAtlasSprite getLightMaterial(Function<Material, TextureAtlasSprite> textureGetter) {
        return textureGetter.apply(map.get(type));
        //     throw new IllegalArgumentException(
        //         "Crafting unit type " + this.type + " does not use a light texture.");
    }

    @Override
    public BakedModel getBakedModel(Function<Material, TextureAtlasSprite> spriteGetter) {
        TextureAtlasSprite ringCorner = spriteGetter.apply(RING_CORNER);
        TextureAtlasSprite ringSideHor = spriteGetter.apply(RING_SIDE_HOR);
        TextureAtlasSprite ringSideVer = spriteGetter.apply(RING_SIDE_VER);

        //case /*ACCELERATOR,*/ STORAGE_1M, STORAGE_4M, STORAGE_16M, STORAGE_64M ->
        return new LightBakedModel(
                ringCorner, ringSideHor, ringSideVer, spriteGetter.apply(LIGHT_BASE),
                this.getLightMaterial(spriteGetter));
    }

    private static Material ae2Texture(String name) {
        Material mat = new Material(TextureAtlas.LOCATION_BLOCKS,
                AppEng.makeId("block/crafting/" + name));
        MATERIALS.add(mat);
        return mat;
    }

    private static Material texture(String name) {
        Material mat = new Material(TextureAtlas.LOCATION_BLOCKS,
                AE2Extras.makeId("block/crafting/" + name));
        MATERIALS.add(mat);
        return mat;
    }
}

package tfar.ae2extras.client;

import appeng.client.render.crafting.AbstractCraftingUnitModelProvider;
import appeng.client.render.crafting.LightBakedModel;
import appeng.core.AppEng;
import net.minecraft.client.renderer.block.dispatch.BlockStateModel;
import net.minecraft.client.resources.model.ModelDebugName;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.client.resources.model.sprite.MaterialBaker;
import tfar.ae2extras.AE2Extras;
import tfar.ae2extras.AE2ExtrasCraftingUnitType;

import java.util.*;

import static tfar.ae2extras.AE2ExtrasCraftingUnitType.*;

/**
 * @see appeng.client.render.crafting.CraftingUnitModelProvider
 */
public class CraftingUnitModelProviderEx extends AbstractCraftingUnitModelProvider<AE2ExtrasCraftingUnitType> implements ModelDebugName {

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

    static final Map<AE2ExtrasCraftingUnitType, Material> map = new HashMap<>();

    static {
        map.put(STORAGE_1M, STORAGE_1M_LIGHT);
        map.put(STORAGE_4M, STORAGE_4M_LIGHT);
        map.put(STORAGE_16M, STORAGE_16M_LIGHT);
        map.put(STORAGE_64M, STORAGE_64M_LIGHT);
    }

    public Material.Baked getLightMaterial(MaterialBaker textureGetter) {
        return textureGetter.get(map.get(type),this);
        //     throw new IllegalArgumentException(
        //         "Crafting unit type " + this.type + " does not use a light texture.");
    }

    @Override
    public BlockStateModel bake(MaterialBaker materialBaker) {

        Material.Baked ringCorner = materialBaker.get(RING_CORNER, this);
        Material.Baked ringSideHor = materialBaker.get(RING_SIDE_HOR, this);
        Material.Baked ringSideVer = materialBaker.get(RING_SIDE_VER, this);

        //case /*ACCELERATOR,*/ STORAGE_1M, STORAGE_4M, STORAGE_16M, STORAGE_64M ->
        return new LightBakedModel(
                ringCorner, ringSideHor, ringSideVer, materialBaker.get(LIGHT_BASE,this),
                this.getLightMaterial(materialBaker));
    }

    private static Material ae2Texture(String name) {
        Material mat = new Material(AppEng.makeId("block/crafting/" + name));
        MATERIALS.add(mat);
        return mat;
    }

    private static Material texture(String name) {
        Material mat = new Material(AE2Extras.id("block/crafting/" + name));
        MATERIALS.add(mat);
        return mat;
    }

    @Override
    public String debugName() {
        return getClass().toString();
    }
}

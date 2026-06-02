package tfar.ae2extras.init;

import appeng.block.crafting.CraftingUnitBlock;
import appeng.block.networking.EnergyCellBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import tfar.ae2extras.AE2Extras;
import tfar.ae2extras.AE2ExtrasCraftingUnitType;

import java.util.function.BiFunction;
import java.util.function.Function;

public class AE2ExtrasBlocks {

    public static CraftingUnitBlock CRAFTING_STORAGE_1M = register("1m_crafting_storage",p ->
                    new CraftingUnitBlock(p,AE2ExtrasCraftingUnitType.STORAGE_1M)
            ,BlockBehaviour.Properties.of());
    public static CraftingUnitBlock CRAFTING_STORAGE_4M = register("4m_crafting_storage",p ->
            new CraftingUnitBlock(p,AE2ExtrasCraftingUnitType.STORAGE_4M),BlockBehaviour.Properties.of());
    public static CraftingUnitBlock CRAFTING_STORAGE_16M = register("16m_crafting_storage",p ->
            new CraftingUnitBlock(p,AE2ExtrasCraftingUnitType.STORAGE_16M),EnergyCellBlock.Properties.of());
    public static CraftingUnitBlock CRAFTING_STORAGE_64M = register("64m_crafting_storage",p ->
            new CraftingUnitBlock(p,AE2ExtrasCraftingUnitType.STORAGE_64M),EnergyCellBlock.Properties.of());

    static final int i = 1600;
    public static EnergyCellBlock DENSER_ENERGY_CELL = register("denser_energy_cell",p ->
            new EnergyCellBlock(p,1000*i*8, i*8, i*8),EnergyCellBlock.Properties.of());
    public static EnergyCellBlock DENSEST_ENERGY_CELL = register("densest_energy_cell",p ->
            new EnergyCellBlock(p,1000*i*64, i*64, i*64),EnergyCellBlock.Properties.of());


    @SuppressWarnings("unchecked")
    private static <B extends Block> B register(ResourceKey<B> id, Function<BlockBehaviour.Properties, B> factory, BlockBehaviour.Properties properties) {
        Block block = factory.apply(properties.setId((ResourceKey<Block>) id));
        return (B)Registry.register(BuiltInRegistries.BLOCK, (ResourceKey<Block>)id, block);
    }

    private static <B extends Block> B register(String id, Function<BlockBehaviour.Properties, B> factory, BlockBehaviour.Properties properties) {
        return register(modBlockId(id), factory, properties);
    }

    @SuppressWarnings("unchecked")
    private static <B extends Block> ResourceKey<B> modBlockId(String name) {
        return (ResourceKey<B>) ResourceKey.create(Registries.BLOCK, AE2Extras.id(name));
    }

    public static void init() {

    }

}

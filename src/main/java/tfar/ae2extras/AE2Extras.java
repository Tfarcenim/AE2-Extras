package tfar.ae2extras;

import appeng.api.stacks.AEKeyType;
import appeng.block.crafting.CraftingBlockItem;
import appeng.block.crafting.CraftingUnitBlock;
import appeng.core.definitions.AEItems;
import appeng.items.storage.BasicStorageCell;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import tfar.ae2extras.init.ModBlocks;
import tfar.ae2extras.init.ModItems;

import static appeng.block.AEBaseBlock.defaultProps;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(AE2Extras.MODID)
public class AE2Extras {
    // Directly reference a log4j logger.

    public static final int KILO = 1024;
    public static final String MODID = "ae2extras";

    static Item.Properties props_nostack = new Item.Properties().tab(ModItems.TAB).stacksTo(1);

    public static Item createItemCell(Item cellComponent, float idleDrain, int megaBytes) {
        return new BasicStorageCell(props_nostack, cellComponent, AEItems.ITEM_CELL_HOUSING, idleDrain, 1024 * megaBytes, 8 * 1024 * megaBytes, 63, AEKeyType.items());
    }

    public static Item createFluidCell(Item cellComponent, float idleDrain, int megaBytes) {
        return new BasicStorageCell(props_nostack, cellComponent, AEItems.FLUID_CELL_HOUSING, idleDrain, 1024 * megaBytes, 8 * 1024 * megaBytes, 63, AEKeyType.fluids());
    }


    public AE2Extras() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        // Register the setup method for modloading
        bus.addGenericListener(Block.class, this::blocks);
        bus.addGenericListener(Item.class, this::items);
        bus.addGenericListener(RecipeSerializer.class, this::recipes);
        //     bus.addListener(this::client);
    }

    private void client(FMLClientSetupEvent t) {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CRAFTING_STORAGE_64M, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CRAFTING_STORAGE_1M, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CRAFTING_STORAGE_4M, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CRAFTING_STORAGE_16M, RenderType.cutout());

    }

    private void blocks(final RegistryEvent.Register<Block> event) {

        BlockBehaviour.Properties craftingBlockProps = defaultProps(Material.METAL, MaterialColor.COLOR_GRAY);

        ModBlocks.CRAFTING_STORAGE_1M = register(event.getRegistry(), "1m_crafting_storage", new CraftingUnitBlock(craftingBlockProps, AE2ExtrasCraftingUnitType.STORAGE_1M));
        ModBlocks.CRAFTING_STORAGE_4M = register(event.getRegistry(), "4m_crafting_storage", new CraftingUnitBlock(craftingBlockProps, AE2ExtrasCraftingUnitType.STORAGE_4M));
        ModBlocks.CRAFTING_STORAGE_16M = register(event.getRegistry(), "16m_crafting_storage", new CraftingUnitBlock(craftingBlockProps, AE2ExtrasCraftingUnitType.STORAGE_16M));
        ModBlocks.CRAFTING_STORAGE_64M = register(event.getRegistry(), "64m_crafting_storage", new CraftingUnitBlock(craftingBlockProps, AE2ExtrasCraftingUnitType.STORAGE_64M));
    }

    private void recipes(RegistryEvent.Register<RecipeSerializer<?>> event) {
        //  register(event.getRegistry(),"disassemble",DisassembleRecipe.SERIALIZER);
    }

    private void items(final RegistryEvent.Register<Item> event) {
        register(event.getRegistry(), ModBlocks.CRAFTING_STORAGE_1M.getRegistryName(), new CraftingBlockItem(ModBlocks.CRAFTING_STORAGE_1M, ModItems.props, () -> ModItems.CELL_COMPONENT_1M));
        register(event.getRegistry(), ModBlocks.CRAFTING_STORAGE_4M.getRegistryName(), new CraftingBlockItem(ModBlocks.CRAFTING_STORAGE_4M, ModItems.props, () -> ModItems.CELL_COMPONENT_4M));
        register(event.getRegistry(), ModBlocks.CRAFTING_STORAGE_16M.getRegistryName(), new CraftingBlockItem(ModBlocks.CRAFTING_STORAGE_16M, ModItems.props, () -> ModItems.CELL_COMPONENT_16M));
        register(event.getRegistry(), ModBlocks.CRAFTING_STORAGE_64M.getRegistryName(), new CraftingBlockItem(ModBlocks.CRAFTING_STORAGE_64M, ModItems.props, () -> ModItems.CELL_COMPONENT_64M));

        register(event.getRegistry(), "cell_component_1m", ModItems.CELL_COMPONENT_1M);
        register(event.getRegistry(), "cell_component_4m", ModItems.CELL_COMPONENT_4M);
        register(event.getRegistry(), "cell_component_16m", ModItems.CELL_COMPONENT_16M);
        register(event.getRegistry(), "cell_component_64m", ModItems.CELL_COMPONENT_64M);

        register(event.getRegistry(), "item_storage_cell_1m", ModItems.ITEM_CELL_1M);
        register(event.getRegistry(), "item_storage_cell_4m", ModItems.ITEM_CELL_4M);
        register(event.getRegistry(), "item_storage_cell_16m", ModItems.ITEM_CELL_16M);
        register(event.getRegistry(), "item_storage_cell_64m", ModItems.ITEM_CELL_64M);

        register(event.getRegistry(), "fluid_storage_cell_1m", ModItems.FLUID_CELL_1M);
        register(event.getRegistry(), "fluid_storage_cell_4m", ModItems.FLUID_CELL_4M);
        register(event.getRegistry(), "fluid_storage_cell_16m", ModItems.FLUID_CELL_16M);
        register(event.getRegistry(), "fluid_storage_cell_64m", ModItems.FLUID_CELL_64M);
    }

    private static <T extends IForgeRegistryEntry<T>> T register(IForgeRegistry<T> registry, ResourceLocation name, T obj) {
        registry.register(obj.setRegistryName(name));
        return obj;
    }

    private static <T extends IForgeRegistryEntry<T>> T register(IForgeRegistry<T> registry, String name, T obj) {
        return register(registry, new ResourceLocation(MODID, name), obj);
    }
}

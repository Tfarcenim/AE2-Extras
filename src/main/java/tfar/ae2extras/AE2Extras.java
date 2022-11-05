package tfar.ae2extras;

import appeng.block.crafting.CraftingUnitBlock;
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
public class AE2Extras
{
    // Directly reference a log4j logger.

    public static final String MODID = "ae2extras";

    public static AE2ExtrasCraftingUnitType STORAGE_256K;
    public static AE2ExtrasCraftingUnitType STORAGE_1M;
    public static AE2ExtrasCraftingUnitType STORAGE_4M;
    public static AE2ExtrasCraftingUnitType STORAGE_16M;

    static Item.Properties props_nostack = new Item.Properties().tab(ModItems.TAB).stacksTo(1);

  /*  public static Item ITEM_CELL_256K = new AdvancedStorageCellItem(props_nostack,256,2.5);
    public static Item ITEM_CELL_1M = new AdvancedStorageCellItem(props_nostack,1024,3);
    public static Item ITEM_CELL_4M = new AdvancedStorageCellItem(props_nostack,4096,3.5);
    public static Item ITEM_CELL_16M = new AdvancedStorageCellItem(props_nostack,16384,4);
    public static Item FLUID_CELL_256K = new AdvancedFluidStorageCellItem(props_nostack,256,2.5,() -> ModItems.FLUID_CELL_COMPONENT_256K);
    public static Item FLUID_CELL_1M = new AdvancedFluidStorageCellItem(props_nostack,1024,3,() -> ModItems.FLUID_CELL_COMPONENT_1M);
    public static Item FLUID_CELL_4M = new AdvancedFluidStorageCellItem(props_nostack,4096,3.5,() -> ModItems.FLUID_CELL_COMPONENT_4M);
    public static Item FLUID_CELL_16M = new AdvancedFluidStorageCellItem(props_nostack,16384,4,() -> ModItems.FLUID_CELL_COMPONENT_16M);*/


    public AE2Extras() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        // Register the setup method for modloading
      //  bus.addGenericListener(Block.class,this::blocks);
        bus.addGenericListener(Item.class,this::items);
      //  bus.addGenericListener(RecipeSerializer.class,this::recipes);
   //     bus.addListener(this::client);
    }

    private void client(FMLClientSetupEvent t) {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CRAFTING_STORAGE_256K, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CRAFTING_STORAGE_1M, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CRAFTING_STORAGE_4M, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CRAFTING_STORAGE_16M, RenderType.cutout());

    }

    private void blocks(final RegistryEvent.Register<Block> event) {

        BlockBehaviour.Properties craftingBlockProps = defaultProps(Material.METAL,MaterialColor.COLOR_GRAY);

        ModBlocks.CRAFTING_STORAGE_256K = register(event.getRegistry(), "256k_crafting_storage",new CraftingUnitBlock(craftingBlockProps,STORAGE_256K));
        ModBlocks.CRAFTING_STORAGE_1M = register(event.getRegistry(), "1m_crafting_storage",new CraftingUnitBlock(craftingBlockProps, STORAGE_1M));
        ModBlocks.CRAFTING_STORAGE_4M = register(event.getRegistry(), "4m_crafting_storage",new CraftingUnitBlock(craftingBlockProps, STORAGE_4M));
        ModBlocks.CRAFTING_STORAGE_16M = register(event.getRegistry(), "16m_crafting_storage",new CraftingUnitBlock(craftingBlockProps, STORAGE_16M));

    }

    private void recipes(RegistryEvent.Register<RecipeSerializer<?>> event) {
      //  register(event.getRegistry(),"disassemble",DisassembleRecipe.SERIALIZER);
    }

    private void items(final RegistryEvent.Register<Item> event) {
     //   register(event.getRegistry(), ModBlocks.CRAFTING_STORAGE_256K.getRegistryName(),new CraftingBlockItem(ModBlocks.CRAFTING_STORAGE_256K, ModItems.props));
      //  register(event.getRegistry(), ModBlocks.CRAFTING_STORAGE_1M.getRegistryName(),new CraftingBlockItem(ModBlocks.CRAFTING_STORAGE_1M, ModItems.props));
      //  register(event.getRegistry(), ModBlocks.CRAFTING_STORAGE_4M.getRegistryName(),new CraftingBlockItem(ModBlocks.CRAFTING_STORAGE_4M, ModItems.props));
    //    register(event.getRegistry(), ModBlocks.CRAFTING_STORAGE_16M.getRegistryName(),new CraftingBlockItem(ModBlocks.CRAFTING_STORAGE_16M, ModItems.props));

        register(event.getRegistry(),"256k_cell_component", ModItems.CELL_COMPONENT_256K);
        register(event.getRegistry(), "1m_cell_component", ModItems.CELL_COMPONENT_1M);
        register(event.getRegistry(), "4m_cell_component", ModItems.CELL_COMPONENT_4M);
        register(event.getRegistry(), "16m_cell_component", ModItems.CELL_COMPONENT_16M);

     //   register(event.getRegistry(),"256k_storage_cell",ITEM_CELL_256K);
     //   register(event.getRegistry(), "1m_storage_cell",ITEM_CELL_1M);
     //   register(event.getRegistry(), "4m_storage_cell",ITEM_CELL_4M);
     //   register(event.getRegistry(), "16m_storage_cell",ITEM_CELL_16M);

     //   register(event.getRegistry(),"256k_fluid_storage_cell",FLUID_CELL_256K);
      //  register(event.getRegistry(), "1m_fluid_storage_cell",FLUID_CELL_1M);
      //  register(event.getRegistry(), "4m_fluid_storage_cell",FLUID_CELL_4M);
      //  register(event.getRegistry(), "16m_fluid_storage_cell",FLUID_CELL_16M);
    }

    private static <T extends IForgeRegistryEntry<T>> T register(IForgeRegistry<T> registry, ResourceLocation name, T obj) {
        registry.register(obj.setRegistryName(name));
        return obj;
    }

    private static <T extends IForgeRegistryEntry<T>> T register(IForgeRegistry<T> registry, String name, T obj) {
        register(registry, new ResourceLocation(MODID, name), obj);
        return obj;
    }
}

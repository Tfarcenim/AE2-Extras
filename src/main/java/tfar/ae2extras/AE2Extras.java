package tfar.ae2extras;

import appeng.api.stacks.AEKeyType;
import appeng.block.crafting.CraftingBlockItem;
import appeng.blockentity.ClientTickingBlockEntity;
import appeng.blockentity.ServerTickingBlockEntity;
import appeng.blockentity.crafting.CraftingBlockEntity;
import appeng.core.definitions.AEBlockEntities;
import appeng.core.definitions.AEItems;
import appeng.items.storage.BasicStorageCell;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import tfar.ae2extras.datagen.ModDatagen;
import tfar.ae2extras.init.ModBlocks;
import tfar.ae2extras.init.ModItems;
import tfar.ae2extras.init.client.AE2ExtrasClient;
import tfar.ae2extras.init.client.InitAutoRotatingModelEx;

import static appeng.block.AEBaseBlock.defaultProps;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(AE2Extras.MODID)
public class AE2Extras {
    // Directly reference a log4j logger.

    public static final int KILO = 1024;
    public static final String MODID = "ae2extras";


    public static Item createItemCell(Item cellComponent, float idleDrain, int megaBytes) {
        return new BasicStorageCell(noStack(), cellComponent, AEItems.ITEM_CELL_HOUSING, idleDrain, KILO * megaBytes, 8 * KILO * megaBytes, 63, AEKeyType.items());
    }

    public static Item createFluidCell(Item cellComponent, float idleDrain, int megaBytes) {
        return new BasicStorageCell(noStack(), cellComponent, AEItems.FLUID_CELL_HOUSING, idleDrain, KILO * megaBytes, 8 * KILO * megaBytes, 63, AEKeyType.fluids());
    }

    static Item.Properties noStack() {
        return new Item.Properties().tab(ModItems.TAB).stacksTo(1);
    }


    public AE2Extras() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        // Register the setup method for modloading
        bus.addGenericListener(Block.class, this::blocks);
        bus.addGenericListener(Item.class, this::items);
        bus.addGenericListener(RecipeSerializer.class, this::recipes);
        bus.addListener(ModDatagen::gather);
        bus.addListener(this::common);
        if (FMLEnvironment.dist.isClient()) {
            AE2ExtrasClient.reg(bus);
        }
    }

    private void common(FMLCommonSetupEvent e) {

        Class<CraftingBlockEntity> entityClass = CraftingBlockEntity.class;

        BlockEntityTicker<CraftingBlockEntity> serverTicker = null;
        if (ServerTickingBlockEntity.class.isAssignableFrom(entityClass)) {
            serverTicker = (level, pos, state, entity) -> {
                ((ServerTickingBlockEntity) entity).serverTick();
            };
        }
        BlockEntityTicker<CraftingBlockEntity> clientTicker = null;
        if (ClientTickingBlockEntity.class.isAssignableFrom(entityClass)) {
            clientTicker = (level, pos, state, entity) -> {
                ((ClientTickingBlockEntity) entity).clientTick();
            };
        }

        BlockEntityType<CraftingBlockEntity> type = AEBlockEntities.CRAFTING_STORAGE;

        ModBlocks.CRAFTING_STORAGE_1M.setBlockEntity(entityClass,type,clientTicker,serverTicker);
        ModBlocks.CRAFTING_STORAGE_4M.setBlockEntity(entityClass,type,clientTicker,serverTicker);
        ModBlocks.CRAFTING_STORAGE_16M.setBlockEntity(entityClass,type,clientTicker,serverTicker);
        ModBlocks.CRAFTING_STORAGE_64M.setBlockEntity(entityClass,type,clientTicker,serverTicker);

    }

    private void blocks(final RegistryEvent.Register<Block> event) {
        register(event.getRegistry(), "1m_crafting_storage", ModBlocks.CRAFTING_STORAGE_1M);
        register(event.getRegistry(), "4m_crafting_storage", ModBlocks.CRAFTING_STORAGE_4M);
        register(event.getRegistry(), "16m_crafting_storage", ModBlocks.CRAFTING_STORAGE_16M);
        register(event.getRegistry(), "64m_crafting_storage", ModBlocks.CRAFTING_STORAGE_64M);
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
        return register(registry, makeId(name), obj);
    }

    public static ResourceLocation makeId(String id) {
        return new ResourceLocation(MODID, id);
    }
}

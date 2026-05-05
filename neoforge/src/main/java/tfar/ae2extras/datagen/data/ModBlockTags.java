package tfar.ae2extras.datagen.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import tfar.ae2extras.AE2Extras;
import tfar.ae2extras.init.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTags extends BlockTagsProvider {
    public ModBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, AE2Extras.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModBlocks.CRAFTING_STORAGE_1M,ModBlocks.CRAFTING_STORAGE_4M,ModBlocks.CRAFTING_STORAGE_16M
                ,ModBlocks.CRAFTING_STORAGE_64M,ModBlocks.DENSER_ENERGY_CELL,ModBlocks.DENSEST_ENERGY_CELL);


    }
}

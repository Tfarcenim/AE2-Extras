package tfar.ae2extras.datagen.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import tfar.ae2extras.AE2Extras;
import tfar.ae2extras.init.AE2ExtrasBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTags extends BlockTagsProvider {
    public ModBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, AE2Extras.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(AE2ExtrasBlocks.CRAFTING_STORAGE_1M, AE2ExtrasBlocks.CRAFTING_STORAGE_4M, AE2ExtrasBlocks.CRAFTING_STORAGE_16M
                , AE2ExtrasBlocks.CRAFTING_STORAGE_64M, AE2ExtrasBlocks.DENSER_ENERGY_CELL, AE2ExtrasBlocks.DENSEST_ENERGY_CELL);


    }
}

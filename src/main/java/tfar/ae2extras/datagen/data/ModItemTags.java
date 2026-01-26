package tfar.ae2extras.datagen.data;

import appeng.api.features.P2PTunnelAttunement;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import tfar.ae2extras.AE2Extras;
import tfar.ae2extras.init.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModItemTags extends ItemTagsProvider {
    public ModItemTags(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider,
                       CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, AE2Extras.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(P2PTunnelAttunement.getAttunementTag(P2PTunnelAttunement.ENERGY_TUNNEL))
                .add(ModBlocks.DENSEST_ENERGY_CELL.asItem(), ModBlocks.DENSER_ENERGY_CELL.asItem());
    }
}

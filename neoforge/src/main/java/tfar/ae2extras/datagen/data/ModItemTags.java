package tfar.ae2extras.datagen.data;

import appeng.api.features.P2PTunnelAttunement;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ItemTagsProvider;
import tfar.ae2extras.AE2Extras;
import tfar.ae2extras.init.AE2ExtrasBlocks;

import java.util.concurrent.CompletableFuture;

public class ModItemTags extends ItemTagsProvider {
    public ModItemTags(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider) {
        super(pOutput, pLookupProvider, AE2Extras.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(P2PTunnelAttunement.getAttunementTag(P2PTunnelAttunement.ENERGY_TUNNEL))
                .add(AE2ExtrasBlocks.DENSEST_ENERGY_CELL.asItem(), AE2ExtrasBlocks.DENSER_ENERGY_CELL.asItem());
    }
}

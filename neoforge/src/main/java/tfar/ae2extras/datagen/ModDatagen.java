package tfar.ae2extras.datagen;

import appeng.datagen.providers.models.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.Main;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import tfar.ae2extras.AE2Extras;
import tfar.ae2extras.datagen.assets.AE2ExtrasBlockModelProvider;
import tfar.ae2extras.datagen.assets.AE2ExtrasItemModelProvider;
import tfar.ae2extras.datagen.assets.ModLangProvider;
import tfar.ae2extras.datagen.data.ModBlockTags;
import tfar.ae2extras.datagen.data.ModItemTags;
import tfar.ae2extras.datagen.data.AE2ExtrasRecipeProvider;

import java.util.concurrent.CompletableFuture;

public class ModDatagen {
    public static void gather(GatherDataEvent.Client e) {
        DataGenerator dataGenerator = e.getGenerator();
        CompletableFuture<HolderLookup.Provider> lookupProvider = e.getLookupProvider();
        PackOutput packOutput = dataGenerator.getPackOutput();

        var pack = dataGenerator.getVanillaPack(true);

        // Models
        pack.addProvider(AE2ModelProvider.create(
                AE2Extras.MOD_ID,
                AE2ExtrasBlockModelProvider::new,
                //DecorationModelProvider::new,
                AE2ExtrasItemModelProvider::new//,
                //PartModelProvider::new
                )
        );

        pack.addProvider(Main.bindRegistries(AE2ExtrasRecipeProvider.Runner::new,lookupProvider));
            ModBlockTags modBlockTags = new ModBlockTags(packOutput,lookupProvider);
            dataGenerator.addProvider(true,modBlockTags);
            dataGenerator.addProvider(true,new ModItemTags(packOutput,lookupProvider));
            dataGenerator.addProvider(true,new ModLangProvider(packOutput));

    }
}

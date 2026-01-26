package tfar.ae2extras.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import tfar.ae2extras.datagen.assets.ModBlockStateProvider;
import tfar.ae2extras.datagen.assets.ModItemModelProvider;
import tfar.ae2extras.datagen.assets.ModLangProvider;
import tfar.ae2extras.datagen.data.ModBlockTags;
import tfar.ae2extras.datagen.data.ModItemTags;
import tfar.ae2extras.datagen.data.ModRecipeProvider;

import java.util.concurrent.CompletableFuture;

public class ModDatagen {
    public static void gather(GatherDataEvent e) {
        DataGenerator dataGenerator = e.getGenerator();
        CompletableFuture<HolderLookup.Provider> lookupProvider = e.getLookupProvider();
        PackOutput packOutput = dataGenerator.getPackOutput();
        ExistingFileHelper existingFileHelper = e.getExistingFileHelper();
        boolean server = e.includeServer();
        boolean client = e.includeClient();
        if (server) {
            dataGenerator.addProvider(true,new ModRecipeProvider(packOutput));
            ModBlockTags modBlockTags = new ModBlockTags(packOutput,lookupProvider,existingFileHelper);
            dataGenerator.addProvider(true,modBlockTags);
            dataGenerator.addProvider(true,new ModItemTags(packOutput,lookupProvider,modBlockTags.contentsGetter(),existingFileHelper));
        }
        if (client) {
            dataGenerator.addProvider(true,new ModItemModelProvider(packOutput,existingFileHelper));
            dataGenerator.addProvider(true,new ModBlockStateProvider(packOutput,existingFileHelper));
            dataGenerator.addProvider(true,new ModLangProvider(packOutput));
        }
    }
}

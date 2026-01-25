package tfar.ae2extras.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.data.event.GatherDataEvent;
import tfar.ae2extras.datagen.assets.ModBlockStateProvider;
import tfar.ae2extras.datagen.assets.ModItemModelProvider;
import tfar.ae2extras.datagen.assets.ModLangProvider;
import tfar.ae2extras.datagen.data.ModRecipeProvider;

public class ModDatagen {
    public static void gather(GatherDataEvent e) {
        DataGenerator dataGenerator = e.getGenerator();
        PackOutput packOutput = dataGenerator.getPackOutput();
        boolean server = e.includeServer();
        boolean client = e.includeClient();
        if (server) {
            dataGenerator.addProvider(true,new ModRecipeProvider(packOutput));
        }
        if (client) {
            dataGenerator.addProvider(true,new ModItemModelProvider(packOutput,e.getExistingFileHelper()));
            dataGenerator.addProvider(true,new ModBlockStateProvider(packOutput,e.getExistingFileHelper()));
            dataGenerator.addProvider(true,new ModLangProvider(packOutput));
        }
    }
}

package tfar.ae2extras.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import tfar.ae2extras.datagen.data.ModRecipeProvider;

public class ModDatagen {
    public static void gather(GatherDataEvent e) {
        DataGenerator dataGenerator = e.getGenerator();
        boolean server = e.includeServer();
        if (server) {
            dataGenerator.addProvider(new ModRecipeProvider(dataGenerator));
        }
    }
}

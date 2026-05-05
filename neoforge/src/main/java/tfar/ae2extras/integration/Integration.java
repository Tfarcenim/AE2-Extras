package tfar.ae2extras.integration;


import net.neoforged.fml.ModList;

public enum Integration {
    appmek,mekanism;
    public final boolean loaded = ModList.get().isLoaded(name());
}

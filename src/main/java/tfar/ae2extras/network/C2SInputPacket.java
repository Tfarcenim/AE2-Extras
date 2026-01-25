package tfar.ae2extras.network;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import tfar.ae2extras.MonoCellMenu;

public class C2SInputPacket implements C2SModPacket{

    private final String name;

    public C2SInputPacket(FriendlyByteBuf buffer) {
        name= buffer.readUtf();
    }

    public C2SInputPacket(String name) {
        this.name = name;
    }


    @Override
    public void handleServer(ServerPlayer player) {
        if (player.containerMenu instanceof MonoCellMenu monoCellMenu) {
            monoCellMenu.setItemName(name);
        }
    }

    @Override
    public void write(FriendlyByteBuf to) {
        to.writeUtf(name);
    }
}

package tfar.ae2extras.network;


import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import tfar.ae2extras.AE2Extras;

import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class PacketHandler {

    public static SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(AE2Extras.id(AE2Extras.MODID), () -> "1.0", s -> true, s -> true);;

    public static <MSG extends S2CModPacket> BiConsumer<MSG, Supplier<NetworkEvent.Context>> wrapS2C() {
        return ((msg, contextSupplier) -> {
            contextSupplier.get().enqueueWork(msg::handleClient);
            contextSupplier.get().setPacketHandled(true);
        });
    }

    public static <MSG extends C2SModPacket> BiConsumer<MSG, Supplier<NetworkEvent.Context>> wrapC2S() {
        return ((msg, contextSupplier) -> {
            ServerPlayer player = contextSupplier.get().getSender();
            contextSupplier.get().enqueueWork(() -> msg.handleServer(player));
            contextSupplier.get().setPacketHandled(true);
        });
    }

    public static <MSG> void sendToClient(MSG packet, ServerPlayer player) {
        INSTANCE.sendTo(packet, player.connection.connection, NetworkDirection.PLAY_TO_CLIENT);
    }

    public static <MSG> void sendToServer(MSG packet) {
        INSTANCE.sendToServer(packet);
    }



    public static void registerPackets() {
        registerServerPacket(C2SInputPacket.class, C2SInputPacket::new);
    }

    static int i;
   static <MSG extends C2SModPacket> void registerServerPacket(Class<MSG> packetLocation, Function<FriendlyByteBuf,MSG> reader) {
       INSTANCE.registerMessage(i++, packetLocation, MSG::write, reader, PacketHandler.wrapC2S());
    }
}

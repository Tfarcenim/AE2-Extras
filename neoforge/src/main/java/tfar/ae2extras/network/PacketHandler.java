package tfar.ae2extras.network;


import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.client.network.ClientPacketDistributor;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

public class PacketHandler {

    public static PayloadRegistrar registrar;

    public static <MSG extends C2SModPacket> void sendToServer(MSG packet) {
        ClientPacketDistributor.sendToServer(packet);
    }



    public static void registerPackets(RegisterPayloadHandlersEvent event) {
        registrar= event.registrar("1");
        registerServerPacket(C2SInputPacket.TYPE, C2SInputPacket.STREAM_CODEC);
    }

    static int i;
   static <MSG extends C2SModPacket> void registerServerPacket(CustomPacketPayload.Type<MSG> packetLocation, StreamCodec<RegistryFriendlyByteBuf,MSG> reader) {
       registrar.playToServer(packetLocation,reader, (payload, context) -> payload.handleServer((ServerPlayer) context.player()));
    }
}

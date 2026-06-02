package tfar.ae2extras.network;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import tfar.ae2extras.AE2Extras;
import tfar.ae2extras.MonoCellMenu;

public record C2SInputPacket(String name) implements C2SModPacket{

    public static final Type<C2SInputPacket> TYPE = new Type<>(AE2Extras.id("c2sinputpacket"));
    public static final StreamCodec<RegistryFriendlyByteBuf,C2SInputPacket> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.STRING_UTF8,C2SInputPacket::name,C2SInputPacket::new);

    @Override
    public void handleServer(ServerPlayer player) {
        if (player.containerMenu instanceof MonoCellMenu monoCellMenu) {
            monoCellMenu.setItemName(name);
        }
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}

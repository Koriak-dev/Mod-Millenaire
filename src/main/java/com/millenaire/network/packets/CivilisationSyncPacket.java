package com.millenaire.network.packets;

import com.millenaire.civilisations.CivilisationData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class CivilisationSyncPacket {
    private final CivilisationData civilisationData;

    public CivilisationSyncPacket(CivilisationData civilisationData) {
        this.civilisationData = civilisationData;
    }

    public static void encode(CivilisationSyncPacket packet, FriendlyByteBuf buffer) {
        buffer.writeNbt(packet.civilisationData.serializeNBT());
    }

    public static CivilisationSyncPacket decode(FriendlyByteBuf buffer) {
        CivilisationData data = new CivilisationData();
        data.deserializeNBT(buffer.readNbt());
        return new CivilisationSyncPacket(data);
    }

    public static void handle(CivilisationSyncPacket packet, Supplier<NetworkEvent.Context> context) {
        context.get().enqueueWork(() -> {
            // Handle packet on the main thread
            // Typically update client-side civilisation data
        });
        context.get().setPacketHandled(true);
    }
}

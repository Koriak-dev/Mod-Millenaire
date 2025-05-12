package com.millenaire.network.packets;

import com.millenaire.civilisations.village.VillageData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class VillageUpdatePacket {
    private final VillageData villageData;

    public VillageUpdatePacket(VillageData villageData) {
        this.villageData = villageData;
    }

    public static void encode(VillageUpdatePacket packet, FriendlyByteBuf buffer) {
        buffer.writeNbt(packet.villageData.serializeNBT());
    }

    public static VillageUpdatePacket decode(FriendlyByteBuf buffer) {
        VillageData data = new VillageData();
        data.deserializeNBT(buffer.readNbt());
        return new VillageUpdatePacket(data);
    }

    public static void handle(VillageUpdatePacket packet, Supplier<NetworkEvent.Context> context) {
        context.get().enqueueWork(() -> {
            // Handle packet on client side
            // TODO: Implement client-side village data update
        });
        context.get().setPacketHandled(true);
    }
}

package com.millenaire.network;

import com.millenaire.core.ModConstants;
import com.millenaire.network.packets.CivilisationSyncPacket;
import com.millenaire.network.packets.VillageUpdatePacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class ModPacketHandler {
    private static final String PROTOCOL_VERSION = ModConstants.NETWORK_PROTOCOL;
    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
        new ResourceLocation(ModConstants.MOD_ID, "main"),
        () -> PROTOCOL_VERSION,
        PROTOCOL_VERSION::equals,
        PROTOCOL_VERSION::equals
    );

    public static void registerPackets() {
        int id = 0;
        INSTANCE.registerMessage(id++, VillageUpdatePacket.class, 
            VillageUpdatePacket::encode, 
            VillageUpdatePacket::decode,
            VillageUpdatePacket::handle);

        INSTANCE.registerMessage(id++, CivilisationSyncPacket.class,
            CivilisationSyncPacket::encode,
            CivilisationSyncPacket::decode,
            CivilisationSyncPacket::handle);
    }
}

/**
 * FICHIER: ModPacketHandler.java
 * DESCRIPTION: Gestionnaire principal du réseau pour le mod Millénaire
 * RESPONSABILITES:
 * - Initialiser le canal de communication réseau
 * - Enregistrer tous les types de packets
 * - Gérer la version du protocole réseau
 */
package com.millenaire.network;

import com.millenaire.core.ModConstants;
import com.millenaire.network.packets.CivilisationSyncPacket;
import com.millenaire.network.packets.VillageUpdatePacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class ModPacketHandler {
    // Version du protocole réseau (définie dans ModConstants)
    private static final String PROTOCOL_VERSION = ModConstants.NETWORK_PROTOCOL;
    
    /**
     * Canal réseau principal pour la communication client-serveur
     */
    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
        new ResourceLocation(ModConstants.MOD_ID, "main"),
        () -> PROTOCOL_VERSION,
        PROTOCOL_VERSION::equals,
        PROTOCOL_VERSION::equals
    );

    /**
     * Enregistre tous les types de packets utilisés par le mod
     * Chaque packet doit être enregistré avec un ID unique
     */
    public static void registerPackets() {
        int id = 0;
        
        // Packet de mise à jour des villages
        INSTANCE.registerMessage(id++, VillageUpdatePacket.class, 
            VillageUpdatePacket::encode, 
            VillageUpdatePacket::decode,
            VillageUpdatePacket::handle);

        // Packet de synchronisation des civilisations
        INSTANCE.registerMessage(id++, CivilisationSyncPacket.class,
            CivilisationSyncPacket::encode,
            CivilisationSyncPacket::decode,
            CivilisationSyncPacket::handle);
    }
}

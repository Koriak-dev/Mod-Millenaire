/**
 * FICHIER: CivilisationSyncPacket.java
 * DESCRIPTION: Packet réseau pour la synchronisation des civilisations
 * RESPONSABILITES:
 * - Transmettre les données de civilisation entre client et serveur
 * - Sérialiser/désérialiser les données via NBT
 * - Maintenir la cohérence des données entre client et serveur
 */
package com.millenaire.network.packets;

import com.millenaire.civilisations.CivilisationData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class CivilisationSyncPacket {
    // Données de civilisation à synchroniser
    private final CivilisationData civilisationData;

    /**
     * Constructeur - Crée un nouveau packet de synchronisation
     * @param civilisationData Les données de civilisation à synchroniser
     */
    public CivilisationSyncPacket(CivilisationData civilisationData) {
        this.civilisationData = civilisationData;
    }

    /**
     * Encode les données de civilisation dans le buffer réseau
     * @param packet Le packet à encoder
     * @param buffer Le buffer de sortie
     */
    public static void encode(CivilisationSyncPacket packet, FriendlyByteBuf buffer) {
        buffer.writeNbt(packet.civilisationData.serializeNBT());
    }

    /**
     * Décode les données de civilisation depuis le buffer réseau
     * @param buffer Le buffer d'entrée
     * @return Un nouveau packet avec les données décodées
     */
    public static CivilisationSyncPacket decode(FriendlyByteBuf buffer) {
        CivilisationData data = new CivilisationData();
        data.deserializeNBT(buffer.readNbt());
        return new CivilisationSyncPacket(data);
    }

    /**
     * Traite le packet reçu (côté client ou serveur)
     * @param packet Le packet reçu
     * @param context Le contexte réseau
     */
    public static void handle(CivilisationSyncPacket packet, Supplier<NetworkEvent.Context> context) {
        context.get().enqueueWork(() -> {
            // TODO: Implémenter la mise à jour des données de civilisation
            // côté client ou serveur selon le contexte
        });
        context.get().setPacketHandled(true);
    }
}

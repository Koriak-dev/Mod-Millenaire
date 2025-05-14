/**
 * FICHIER: VillageUpdatePacket.java
 * DESCRIPTION: Packet réseau pour les mises à jour de village
 * RESPONSABILITES:
 * - Transmettre les données d'un village entre client et serveur
 * - Sérialiser/désérialiser les données via NBT
 * - Gérer la synchronisation des villages
 */
package com.millenaire.network.packets;

import com.millenaire.civilisations.village.VillageData;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class VillageUpdatePacket {
    // Données du village à synchroniser
    private final VillageData villageData;

    /**
     * Constructeur - Crée un nouveau packet de mise à jour
     * @param villageData Les données du village à synchroniser
     */
    public VillageUpdatePacket(VillageData villageData) {
        this.villageData = villageData;
    }

    /**
     * Encode les données du village dans le buffer réseau
     * @param packet Le packet à encoder
     * @param buffer Le buffer de sortie
     */
    public static void encode(VillageUpdatePacket packet, FriendlyByteBuf buffer) {
        buffer.writeNbt(packet.villageData.serializeNBT());
    }

    /**
     * Décode les données du village depuis le buffer réseau
     * @param buffer Le buffer d'entrée
     * @return Un nouveau packet avec les données décodées
     */
    public static VillageUpdatePacket decode(FriendlyByteBuf buffer) {
        VillageData data = new VillageData(BlockPos.ZERO, "Unnamed Village", null);
        data.deserializeNBT(buffer.readNbt());
        return new VillageUpdatePacket(data);
    }

    /**
     * Traite le packet reçu (côté client ou serveur)
     * @param packet Le packet reçu
     * @param context Le contexte réseau
     */
    public static void handle(VillageUpdatePacket packet, Supplier<NetworkEvent.Context> context) {
        context.get().enqueueWork(() -> {
            // TODO: Implémenter la mise à jour des données du village
            // côté client ou serveur selon le contexte
        });
        context.get().setPacketHandled(true);
    }
}

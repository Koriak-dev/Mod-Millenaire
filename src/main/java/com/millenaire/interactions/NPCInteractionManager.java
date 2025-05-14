/**
 * FICHIER: NPCInteractionManager.java
 * DESCRIPTION: Gestionnaire central des interactions avec les PNJs
 * RESPONSABILITES:
 * - Gérer les différents types d'interactions (maires, marchands, etc.)
 * - Prévenir le spam d'interactions
 * - Coordonner avec les autres systèmes (quêtes, économie)
 */
package com.millenaire.interactions;

import com.millenaire.civilisations.village.AbstractVillage;
import com.millenaire.entity.NPCEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class NPCInteractionManager {
    private final AbstractVillage village;
    private final Map<UUID, Long> lastInteractionTimes = new HashMap<>();

    /**
     * Constructeur du gestionnaire d'interactions
     * @param village Le village associé à ce gestionnaire
     * Initialise:
     * - Le système de suivi des interactions
     * - La référence au village parent
     */
    public NPCInteractionManager(AbstractVillage village) {
        this.village = village;
    }

    public void handleInteraction(Player player, NPCEntity npc) {
        UUID playerId = player.getUUID();
        long currentTime = System.currentTimeMillis();
        
        // Prevent spam interactions
        if (currentTime - lastInteractionTimes.getOrDefault(playerId, 0L) < 5000) {
            return;
        }
        lastInteractionTimes.put(playerId, currentTime);

        // Handle different interaction types based on NPC role
        switch (npc.getRole()) {
            case "mayor":
                handleMayorInteraction(player, npc);
                break;
            case "merchant":
                handleMerchantInteraction(player, npc);
                break;
            case "quest_giver":
                handleQuestGiverInteraction(player, npc);
                break;
            default:
                handleDefaultInteraction(player, npc);
        }
    }

    /**
     * Gère les interactions avec le maire du village
     * @param player Le joueur en interaction
     * @param npc Le PNJ maire
     * Actions:
     * - Propose de nouvelles quêtes via QuestSystem
     */
    private void handleMayorInteraction(Player player, NPCEntity npc) {
        // Village management interactions
        village.getQuestSystem().offerNewQuests(player);
    }

    /**
     * Gère les interactions avec les marchands
     * @param player Le joueur en interaction
     * @param npc Le PNJ marchand
     * Actions:
     * - Traite les échanges d'items
     * - Utilise EconomyManager pour valider les transactions
     */
    private void handleMerchantInteraction(Player player, NPCEntity npc) {
        // Trade interactions
        ItemStack offeredItem = player.getMainHandItem();
        ItemStack requestedItem = npc.getTradeOffer(); // Méthode corrigée
        if (requestedItem != null && !offeredItem.isEmpty()) {
            village.getEconomyManager().processTrade(offeredItem, requestedItem);
        }
    }

    /**
     * Gère les interactions avec les donneurs de quêtes
     * @param player Le joueur en interaction
     * @param npc Le PNJ donneur de quêtes
     * Actions:
     * - Propose de nouvelles quêtes via QuestSystem
     * - Vérifie la complétion des quêtes existantes
     */
    private void handleQuestGiverInteraction(Player player, NPCEntity npc) {
        // Quest interactions
        village.getQuestSystem().offerNewQuests(player);
    }

    /**
     * Gère les interactions par défaut avec les PNJs
     * @param player Le joueur en interaction
     * @param npc Le PNJ standard
     * Actions:
     * - Affiche un message de salutation
     * - Gère les dialogues basiques
     */
    private void handleDefaultInteraction(Player player, NPCEntity npc) {
        // Basic greetings and small talk
        npc.displayGreeting(player);
    }

    public void dailyUpdate() {
        // Clear old interaction timers
        long currentTime = System.currentTimeMillis();
        lastInteractionTimes.entrySet().removeIf(entry -> 
            currentTime - entry.getValue() > 86400000 // 24 hours
        );
    }
}

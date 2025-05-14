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

    private void handleMayorInteraction(Player player, NPCEntity npc) {
        // Village management interactions
        village.getQuestSystem().offerNewQuests(player);
    }

    private void handleMerchantInteraction(Player player, NPCEntity npc) {
        // Trade interactions
        ItemStack offeredItem = player.getMainHandItem();
        ItemStack requestedItem = npc.getTradeOffer(); // Méthode corrigée
        if (requestedItem != null && !offeredItem.isEmpty()) {
            village.getEconomyManager().processTrade(offeredItem, requestedItem);
        }
    }

    private void handleQuestGiverInteraction(Player player, NPCEntity npc) {
        // Quest interactions
        village.getQuestSystem().offerNewQuests(player);
    }

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

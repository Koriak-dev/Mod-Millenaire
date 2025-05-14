package com.millenaire.interactions;

import net.minecraft.world.entity.player.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * FICHIER: ReputationSystem.java
 * DESCRIPTION: Système de gestion de réputation des joueurs
 * RESPONSABILITES:
 * - Suivi des réputations par joueur
 * - Calcul des niveaux de réputation
 * - Décroissance naturelle de la réputation
 */
public class ReputationSystem {
    private final Map<UUID, Integer> playerReputations = new HashMap<>();

    /**
     * Seuils de réputation:
     * - HOSTILE: -100 (attaqué à vue)
     * - NEUTRAL: 0 (comportement par défaut)
     * - FRIENDLY: 50 (accès aux quêtes basiques)
     * - HONORED: 100 (accès aux quêtes avancées)
     * - EXALTED: 200 (accès aux bonus exclusifs)
     */
    public static final int HOSTILE = -100;
    public static final int NEUTRAL = 0;
    public static final int FRIENDLY = 50;
    public static final int HONORED = 100;
    public static final int EXALTED = 200;

    public ReputationSystem() {
    }

    public int getReputation(UUID playerId) {
        return playerReputations.getOrDefault(playerId, NEUTRAL);
    }

    public int getReputation(Player player) {
        return getReputation(player.getUUID());
    }

    public void addReputation(UUID playerId, int amount) {
        int current = getReputation(playerId);
        playerReputations.put(playerId, clampReputation(current + amount));
    }

    public void addReputation(Player player, int amount) {
        addReputation(player.getUUID(), amount);
    }

    /**
     * Obtient le niveau textuel de réputation d'un joueur
     * @param playerId UUID du joueur
     * @return Niveau de réputation sous forme de chaîne:
     * - "hostile" (<= -100)
     * - "unfriendly" (-99 à 0)
     * - "neutral" (1 à 50)
     * - "friendly" (51 à 100)
     * - "honored" (101 à 200)
     * - "exalted" (> 200)
     */
    public String getReputationLevel(UUID playerId) {
        int rep = getReputation(playerId);
        if (rep <= HOSTILE) return "hostile";
        if (rep <= NEUTRAL) return "unfriendly";
        if (rep <= FRIENDLY) return "neutral";
        if (rep <= HONORED) return "friendly";
        if (rep <= EXALTED) return "honored";
        return "exalted";
    }

    public void dailyUpdate() {
        // Slight decay towards neutral over time
        playerReputations.replaceAll((playerId, rep) -> {
            if (rep > NEUTRAL) return Math.max(NEUTRAL, rep - 1);
            if (rep < NEUTRAL) return Math.min(NEUTRAL, rep + 1);
            return rep;
        });
    }

    private int clampReputation(int value) {
        return Math.max(-500, Math.min(500, value));
    }
}

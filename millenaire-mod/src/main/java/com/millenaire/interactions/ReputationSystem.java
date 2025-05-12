package com.millenaire.interactions;

import com.millenaire.civilisations.village.AbstractVillage;
import net.minecraft.world.entity.player.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ReputationSystem {
    private final AbstractVillage village;
    private final Map<UUID, Integer> playerReputations = new HashMap<>();

    // Reputation thresholds
    public static final int HOSTILE = -100;
    public static final int NEUTRAL = 0;
    public static final int FRIENDLY = 50;
    public static final int HONORED = 100;
    public static final int EXALTED = 200;

    public ReputationSystem(AbstractVillage village) {
        this.village = village;
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

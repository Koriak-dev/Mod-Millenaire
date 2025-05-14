package com.millenaire.civilisations.quest;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public abstract class Quest {
    protected final String id;
    protected final String name;
    protected final String description;
    
    public Quest(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public abstract boolean isComplete(Player player);
    public abstract ItemStack getReward();
    public abstract int getReputationReward();
    public abstract boolean isExpired();
    public abstract void onExpire();
}

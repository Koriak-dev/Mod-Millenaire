package com.millenaire.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;

public class NPCEntity extends PathfinderMob {
    public NPCEntity(EntityType<? extends PathfinderMob> type, Level world) {
        super(type, world);
    }

    public String getRole() {
        return "villager";
    }

    public void displayGreeting(Player player) {
        // TODO: Implémenter l'affichage du message de bienvenue
    }

    // Add NPC-specific behavior here
    
    public ItemStack getTradeOffer() {
        // TODO: Implémenter la logique pour retourner l'item demandé en échange
        // Pour l'instant, retourne un stack vide
        return ItemStack.EMPTY;
    }
}

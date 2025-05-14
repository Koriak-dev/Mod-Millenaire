/**
 * FICHIER: NPCEntity.java
 * DESCRIPTION: Entité de base pour les PNJs du mod
 * RESPONSABILITES:
 * - Gérer le comportement des PNJs
 * - Gérer les interactions avec les joueurs
 * - Contrôler les attributs et compétences
 */
package com.millenaire.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;

public class NPCEntity extends PathfinderMob {
    /**
     * Définit les attributs de base des PNJs
     * @return Builder avec les attributs par défaut:
     * - 20 points de vie maximum
     * - Vitesse de déplacement de 0.25
     * - Portée de suivi de 32 blocs
     */
    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 20.0D)
            .add(Attributes.MOVEMENT_SPEED, 0.25D)
            .add(Attributes.FOLLOW_RANGE, 32.0D);
    }

    public NPCEntity(EntityType<? extends PathfinderMob> type, Level world) {
        super(type, world);
    }

    /**
     * @return Le rôle du PNJ (par défaut "villager")
     * Les rôles possibles incluent:
     * - "villager" : Habitant standard
     * - "merchant" : Marchand
     * - "guard" : Garde
     */
    public String getRole() {
        return "villager";
    }

    /**
     * Affiche un message de bienvenue au joueur
     * @param player Le joueur à qui s'adresser
     * TODO: Implémenter selon la culture du PNJ
     */
    public void displayGreeting(Player player) {
        // TODO: Implémenter l'affichage du message de bienvenue
    }

    // Add NPC-specific behavior here
    
    /**
     * Retourne l'item que le PNJ demande en échange
     * @return ItemStack représentant l'item demandé
     * TODO: Implémenter selon:
     * - Le rôle du PNJ
     * - La civilisation
     * - L'économie du village
     */
    public ItemStack getTradeOffer() {
        // TODO: Implémenter la logique pour retourner l'item demandé en échange
        // Pour l'instant, retourne un stack vide
        return ItemStack.EMPTY;
    }
}

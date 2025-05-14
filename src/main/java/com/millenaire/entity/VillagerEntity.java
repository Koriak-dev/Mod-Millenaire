/**
 * FICHIER: VillagerEntity.java  
 * DESCRIPTION: Entité personnalisée pour les villageois du mod
 * RESPONSABILITES:
 * - Gérer le comportement spécifique des villageois
 * - Implémenter les interactions avec les joueurs
 * - Contrôler les mécaniques liées au village
 */
package com.millenaire.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.level.Level;

public class VillagerEntity extends Villager {
    /**
     * Constructeur du villageois personnalisé
     * @param type Le type d'entité (hérité de Villager)
     * @param world Le monde dans lequel le villageois est créé
     * Initialise:
     * - Le comportement de base du villageois
     * - Les attributs spécifiques
     */
    public VillagerEntity(EntityType<? extends Villager> type, Level world) {
        super(type, world);
    }

    // Add custom villager behavior here
}

/**
 * FICHIER: Quest.java
 * DESCRIPTION: Classe abstraite représentant une quête
 * FONCTIONNALITES:
 * - Gestion des informations de base (ID, nom, description)
 * - Vérification de l'état d'avancement
 * - Gestion des récompenses
 * - Expiration des quêtes
 */
package com.millenaire.civilisations.quest;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public abstract class Quest {
    // Identifiant unique de la quête
    protected final String id;
    
    // Nom affiché de la quête
    protected final String name;
    
    // Description détaillée
    protected final String description;
    
    /**
     * Constructeur de base d'une quête
     * @param id Identifiant unique
     * @param name Nom affiché
     * @param description Texte descriptif
     */
    public Quest(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    // Méthodes d'accès basiques
    public String getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }

    /**
     * Vérifie si la quête est terminée
     * @param player Le joueur concerné
     * @return true si la quête est complétée
     */
    public abstract boolean isComplete(Player player);
    
    /**
     * Obtient la récompense d'objets
     * @return La pile d'objets à donner
     */
    public abstract ItemStack getReward();
    
    /**
     * Obtient la récompense en réputation
     * @return Le nombre de points de réputation
     */
    public abstract int getReputationReward();
    
    /**
     * Vérifie si la quête a expiré
     * @return true si la quête n'est plus disponible
     */
    public abstract boolean isExpired();
    
    /**
     * Exécuté lorsque la quête expire
     */
    public abstract void onExpire();
}

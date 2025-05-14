/**
 * FICHIER: QuestSystem.java  
 * DESCRIPTION: Système de gestion des quêtes
 * RESPONSABILITES:
 * - Gestion des quêtes actives et complétées
 * - Distribution des récompenses
 * - Mise à jour quotidienne des quêtes
 * - Interaction avec le système de réputation
 */
package com.millenaire.interactions;

import com.millenaire.civilisations.village.AbstractVillage;
import com.millenaire.civilisations.quest.Quest;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class QuestSystem {
    // Référence au village associé
    private final AbstractVillage village;
    
    // Liste des quêtes en cours
    private final List<Quest> activeQuests = new ArrayList<>();
    
    // Liste des quêtes terminées
    private final List<Quest> completedQuests = new ArrayList<>();

    /**
     * Crée un nouveau système de quêtes pour un village
     * @param village Le village propriétaire des quêtes
     */
    public QuestSystem(AbstractVillage village) {
        this.village = village;
    }

    /**
     * Propose de nouvelles quêtes au joueur
     * @param player Le joueur à qui proposer des quêtes
     */
    public void offerNewQuests(Player player) {
        // TODO: Générer des quêtes selon:
        // - Niveau du village
        // - Réputation du joueur
        // - Événements en cours
    }

    /**
     * Accepte une quête pour le joueur
     * @param player Le joueur acceptant la quête
     * @param quest La quête à accepter
     * @return true si la quête a été ajoutée avec succès
     */
    public boolean acceptQuest(Player player, Quest quest) {
        if (!activeQuests.contains(quest)) {
            activeQuests.add(quest);
            return true;
        }
        return false;
    }

    /**
     * Complete une quête pour le joueur
     * @param player Le joueur complétant la quête
     * @param quest La quête à compléter
     * @param items Items optionnels requis pour la quête
     * @return true si la quête a été complétée avec succès
     */
    public boolean completeQuest(Player player, Quest quest, ItemStack... items) {
        if (activeQuests.contains(quest) && quest.isComplete(player)) {
            activeQuests.remove(quest);
            completedQuests.add(quest);
            giveReward(player, quest);
            return true;
        }
        return false;
    }

    /**
     * Donne les récompenses de quête au joueur
     * @param player Le joueur à récompenser
     * @param quest La quête complétée
     */
    private void giveReward(Player player, Quest quest) {
        // Donne les objets de récompense
        player.addItem(quest.getReward());
        
        // Ajoute la réputation
        village.getReputationSystem().addReputation(
            player.getUUID(), 
            quest.getReputationReward()
        );
    }

    /**
     * Mise à jour quotidienne du système de quêtes
     * - Vérifie les quêtes expirées
     * - Nettoie les quêtes terminées
     */
    public void dailyUpdate() {
        activeQuests.removeIf(quest -> {
            if (quest.isExpired()) {
                quest.onExpire();
                return true;
            }
            return false;
        });
    }

    /**
     * Obtient la liste des quêtes disponibles
     * @return Liste des quêtes actives
     */
    public List<Quest> getAvailableQuests() {
        return activeQuests;
    }
}

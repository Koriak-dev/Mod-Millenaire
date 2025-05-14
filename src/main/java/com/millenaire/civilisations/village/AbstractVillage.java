/**
 * FICHIER: AbstractVillage.java
 * DESCRIPTION: Classe abstraite de base pour tous les villages
 * RESPONSABILITES:
 * - Définit l'interface commune pour tous les villages
 * - Fournit les méthodes de base pour la gestion des villages
 * - Définit le contrat pour les implémentations spécifiques
 */
package com.millenaire.civilisations.village;

import net.minecraft.core.BlockPos;
import com.millenaire.civilisations.AbstractCivilisation;
import com.millenaire.economy.EconomyManager;
import com.millenaire.interactions.QuestSystem;
import com.millenaire.interactions.ReputationSystem;

public abstract class AbstractVillage {
    public QuestSystem getQuestSystem() {
        return new QuestSystem(this);
    }

    public EconomyManager getEconomyManager() {
        return new EconomyManager();
    }

    public ReputationSystem getReputationSystem() {
        return new ReputationSystem();
    }
    
    public abstract String getName();
    public abstract BlockPos getCenterPos();
    public abstract AbstractCivilisation getCivilisation();
}

/**
 * FICHIER: AbstractCivilisation.java
 * DESCRIPTION: Classe abstraite de base pour toutes les civilisations
 * RESPONSABILITES:
 * - Définit l'interface commune pour toutes les civilisations
 * - Fournit les méthodes de base pour la gestion des civilisations
 * - Définit le contrat pour les implémentations spécifiques
 */
package com.millenaire.civilisations;

import com.millenaire.civilisations.village.VillageData;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

public abstract class AbstractCivilisation {
    protected Level world;

    public Level getWorld() {
        return world;
    }

    public void setWorld(Level world) {
        this.world = world;
    }
    protected final ResourceLocation civilisationId;
    protected final String name;
    protected final String description;

    public AbstractCivilisation(ResourceLocation civilisationId, String name, String description) {
        this.civilisationId = civilisationId;
        this.name = name;
        this.description = description;
    }

    public ResourceLocation getCivilisationId() {
        return civilisationId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    /**
     * Crée un nouveau village pour cette civilisation
     * @param centerPos Position centrale du village
     * @param villageName Nom du village
     * @return Les données initialisées du village
     */
    public abstract VillageData createNewVillage(BlockPos centerPos, String villageName);

    /**
     * Génère les structures spécifiques au village
     * @param villageData Données du village à générer
     * Doit implémenter :
     * - La génération des bâtiments principaux
     * - L'organisation spatiale du village
     * - Les structures caractéristiques de la civilisation
     */
    public abstract void generateVillageStructures(VillageData villageData);

    /**
     * Met à jour l'état du village
     * @param villageData Données du village à mettre à jour
     * Doit implémenter :
     * - La vérification de l'intégrité des structures
     * - La réparation des bâtiments endommagés
     * - L'évolution du village au fil du temps
     */
    public abstract void updateVillage(VillageData villageData);
}

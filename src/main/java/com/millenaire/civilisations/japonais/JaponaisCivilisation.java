/**
 * FICHIER: JaponaisCivilisation.java
 * DESCRIPTION: Implémentation de la civilisation japonaise
 * CARACTERISTIQUES:
 * - Architecture traditionnelle japonaise
 * - Culture shintoïste
 * - Système de clans
 * - Agriculture rizicole
 */
package com.millenaire.civilisations.japonais;

import com.millenaire.civilisations.AbstractCivilisation;
import com.millenaire.civilisations.village.VillageData;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;

public class JaponaisCivilisation extends AbstractCivilisation {
    // Identifiant unique de la civilisation
    public static final ResourceLocation ID = new ResourceLocation("millenaire", "japonais");

    /**
     * Constructeur de la civilisation japonaise
     */
    public JaponaisCivilisation() {
        super(ID, "Japonais", "EastAsian");
    }

    public String getId() {
        return "japonais";
    }

    public String getDisplayName() {
        return "Japonais";
    }

    public ResourceLocation getIcon() {
        return new ResourceLocation("millenaire", "textures/items/japonais_icon.png");
    }

    @Override
    public VillageData createNewVillage(BlockPos centerPos, String villageName) {
        return new VillageData(centerPos, villageName, this);
    }

    @Override
    public void generateVillageStructures(VillageData villageData) {
        // TODO: Implémenter la génération des structures japonaises:
        // - Temples shinto
        // - Maisons traditionnelles
        // - Champs de riz
        // - Forteresses de clan
    }

    @Override 
    public void updateVillage(VillageData villageData) {
        // TODO: Implémenter la mise à jour du village:
        // - Cérémonies saisonnières
        // - Gestion des clans
        // - Expansion territoriale
    }
}

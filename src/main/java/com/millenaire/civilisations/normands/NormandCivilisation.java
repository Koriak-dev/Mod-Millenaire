/**
 * FICHIER: NormandCivilisation.java
 * DESCRIPTION: Implémentation de la civilisation normande
 * CARACTERISTIQUES:
 * - Architecture viking/normande
 * - Spécialisée en construction navale
 * - Culture guerrière et maritime
 */
package com.millenaire.civilisations.normands;

import com.millenaire.civilisations.AbstractCivilisation;
import com.millenaire.civilisations.village.VillageData;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;

public class NormandCivilisation extends AbstractCivilisation {
    public static final ResourceLocation ID = new ResourceLocation("millenaire", "normand");

    public NormandCivilisation() {
        super(ID, "Normand", "European");
    }

    public String getId() {
        return "normand";
    }

    public String getDisplayName() {
        return "Normand";
    }

    public ResourceLocation getIcon() {
        return new ResourceLocation("millenaire", "textures/items/normand_icon.png");
    }

    @Override
    public VillageData createNewVillage(BlockPos centerPos, String villageName) {
        return new VillageData(centerPos, villageName, this);
    }

    @Override
    public void generateVillageStructures(VillageData villageData) {
        // TODO: Implémenter la génération des structures normandes
    }

    @Override 
    public void updateVillage(VillageData villageData) {
        // TODO: Implémenter la mise à jour du village
    }
}

package com.millenaire.civilisations.azteques;

import com.millenaire.civilisations.AbstractCivilisation;
import com.millenaire.civilisations.village.VillageData;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;

public class AztequeCivilisation extends AbstractCivilisation {
    public static final ResourceLocation ID = new ResourceLocation("millenaire", "azteque");

    public AztequeCivilisation() {
        super(ID, "Aztèque", "Mesoamerican");
    }

    public String getId() {
        return "azteque";
    }

    public String getDisplayName() {
        return "Azteque";
    }

    public ResourceLocation getIcon() {
        return new ResourceLocation("millenaire", "textures/items/azteque_icon.png");
    }

    @Override
    public VillageData createNewVillage(BlockPos centerPos, String villageName) {
        return new VillageData(centerPos, villageName, this);
    }

    @Override
    public void generateVillageStructures(VillageData villageData) {
        // TODO: Implémenter la génération des structures aztèques
    }

    @Override 
    public void updateVillage(VillageData villageData) {
        // TODO: Implémenter la mise à jour du village
    }
}

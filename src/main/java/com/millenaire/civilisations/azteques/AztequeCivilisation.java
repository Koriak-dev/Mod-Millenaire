package com.millenaire.civilisations.azteques;

import com.millenaire.civilisations.AbstractCivilisation;
import net.minecraft.resources.ResourceLocation;

public class AztequeCivilisation extends AbstractCivilisation {
    public static final ResourceLocation ID = new ResourceLocation("millenaire", "azteque");

    public AztequeCivilisation() {
        super(ID, "Aztèque", "Mesoamerican");
    }

    @Override
    public String getLanguageCode() {
        return "nah";
    }

    @Override
    public String getBuildingStyle() {
        return "Aztec";
    }

    @Override
    public String getClothingStyle() {
        return "Aztec";
    }
}

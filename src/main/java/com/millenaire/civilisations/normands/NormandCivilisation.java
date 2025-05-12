package com.millenaire.civilisations.normands;

import com.millenaire.civilisations.AbstractCivilisation;
import net.minecraft.resources.ResourceLocation;

public class NormandCivilisation extends AbstractCivilisation {
    public static final ResourceLocation ID = new ResourceLocation("millenaire", "normand");

    public NormandCivilisation() {
        super(ID, "Normand", "European");
    }

    @Override
    public String getLanguageCode() {
        return "fr";
    }

    @Override
    public String getBuildingStyle() {
        return "Norman";
    }

    @Override
    public String getClothingStyle() {
        return "MedievalEuropean";
    }
}

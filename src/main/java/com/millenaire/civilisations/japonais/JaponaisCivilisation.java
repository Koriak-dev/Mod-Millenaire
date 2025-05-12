package com.millenaire.civilisations.japonais;

import com.millenaire.civilisations.AbstractCivilisation;
import net.minecraft.resources.ResourceLocation;

public class JaponaisCivilisation extends AbstractCivilisation {
    public static final ResourceLocation ID = new ResourceLocation("millenaire", "japonais");

    public JaponaisCivilisation() {
        super(ID, "Japonais", "Asian");
    }

    @Override
    public String getLanguageCode() {
        return "ja";
    }

    @Override
    public String getBuildingStyle() {
        return "Japanese";
    }

    @Override
    public String getClothingStyle() {
        return "Japanese";
    }
}

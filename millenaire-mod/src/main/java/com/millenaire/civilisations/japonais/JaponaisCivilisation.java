package com.millenaire.civilisations.japonais;

import com.millenaire.civilisations.AbstractCivilisation;
import com.millenaire.registries.ModItems;
import net.minecraft.world.item.ItemStack;

public class JaponaisCivilisation extends AbstractCivilisation {
    public JaponaisCivilisation() {
        super(ModConstants.JAPONAIS_CIVILISATION, "Japanese");
    }

    @Override
    public ItemStack getVillageMarkerItem() {
        return new ItemStack(ModItems.JAPANESE_VILLAGE_MARKER.get());
    }

    @Override
    public String getLanguageCode() {
        return "japanese";
    }
}

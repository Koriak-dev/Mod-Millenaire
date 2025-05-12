package com.millenaire.civilisations.normands;

import com.millenaire.civilisations.AbstractCivilisation;
import com.millenaire.registries.ModItems;
import net.minecraft.world.item.ItemStack;

public class NormandCivilisation extends AbstractCivilisation {
    public NormandCivilisation() {
        super(ModConstants.NORMAND_CIVILISATION, "Normand");
    }

    @Override
    public ItemStack getVillageMarkerItem() {
        return new ItemStack(ModItems.NORMAND_VILLAGE_MARKER.get());
    }

    @Override
    public String getLanguageCode() {
        return "normand";
    }
}

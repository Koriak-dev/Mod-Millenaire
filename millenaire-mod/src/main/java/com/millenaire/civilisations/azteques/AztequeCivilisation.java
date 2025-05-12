package com.millenaire.civilisations.azteques;

import com.millenaire.civilisations.AbstractCivilisation;
import com.millenaire.registries.ModItems;
import net.minecraft.world.item.ItemStack;

public class AztequeCivilisation extends AbstractCivilisation {
    public AztequeCivilisation() {
        super(ModConstants.AZTEC_CIVILISATION, "Aztec");
    }

    @Override
    public ItemStack getVillageMarkerItem() {
        return new ItemStack(ModItems.AZTEC_VILLAGE_MARKER.get());
    }

    @Override
    public String getLanguageCode() {
        return "aztec";
    }
}

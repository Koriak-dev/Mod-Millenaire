package com.millenaire.civilisations;

import com.millenaire.civilisations.village.VillageData;
import net.minecraft.resources.ResourceLocation;

public abstract class AbstractCivilisation {
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

    public abstract VillageData createNewVillage(BlockPos centerPos, String villageName);

    public abstract void generateVillageStructures(VillageData villageData);

    public abstract void updateVillage(VillageData villageData);
}

package com.millenaire.civilisations;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.util.INBTSerializable;

public class CivilisationData implements INBTSerializable<CompoundTag> {
    private ResourceLocation civilisationId;
    private String name;
    private String description;

    public CivilisationData() {}

    public CivilisationData(ResourceLocation civilisationId, String name, String description) {
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

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        tag.putString("civilisationId", civilisationId.toString());
        tag.putString("name", name);
        tag.putString("description", description);
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag tag) {
        civilisationId = new ResourceLocation(tag.getString("civilisationId"));
        name = tag.getString("name");
        description = tag.getString("description");
    }
}

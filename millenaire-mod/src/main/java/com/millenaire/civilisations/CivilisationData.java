package com.millenaire.civilisations;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;

public class CivilisationData {
    private ResourceLocation civilisationId;
    private String name;
    private int reputation;
    private boolean discovered;

    public CivilisationData() {
    }

    public CivilisationData(ResourceLocation civilisationId, String name) {
        this.civilisationId = civilisationId;
        this.name = name;
        this.reputation = 0;
        this.discovered = false;
    }

    public ResourceLocation getCivilisationId() {
        return civilisationId;
    }

    public String getName() {
        return name;
    }

    public int getReputation() {
        return reputation;
    }

    public boolean isDiscovered() {
        return discovered;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    public void setDiscovered(boolean discovered) {
        this.discovered = discovered;
    }

    public CompoundTag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        tag.putString("civilisationId", civilisationId.toString());
        tag.putString("name", name);
        tag.putInt("reputation", reputation);
        tag.putBoolean("discovered", discovered);
        return tag;
    }

    public void deserializeNBT(CompoundTag tag) {
        civilisationId = new ResourceLocation(tag.getString("civilisationId"));
        name = tag.getString("name");
        reputation = tag.getInt("reputation");
        discovered = tag.getBoolean("discovered");
    }
}

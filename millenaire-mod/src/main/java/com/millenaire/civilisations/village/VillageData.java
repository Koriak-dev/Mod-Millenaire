package com.millenaire.civilisations.village;

import com.millenaire.civilisations.CivilisationData;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;

public class VillageData {
    private ResourceLocation villageId;
    private String name;
    private BlockPos centerPos;
    private CivilisationData civilisation;
    private int population;
    private int wealthLevel;

    public VillageData() {
    }

    public VillageData(ResourceLocation villageId, String name, BlockPos centerPos, CivilisationData civilisation) {
        this.villageId = villageId;
        this.name = name;
        this.centerPos = centerPos;
        this.civilisation = civilisation;
        this.population = 0;
        this.wealthLevel = 0;
    }

    public ResourceLocation getVillageId() {
        return villageId;
    }

    public String getName() {
        return name;
    }

    public BlockPos getCenterPos() {
        return centerPos;
    }

    public CivilisationData getCivilisation() {
        return civilisation;
    }

    public int getPopulation() {
        return population;
    }

    public int getWealthLevel() {
        return wealthLevel;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setWealthLevel(int wealthLevel) {
        this.wealthLevel = wealthLevel;
    }

    public CompoundTag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        tag.putString("villageId", villageId.toString());
            buildingCoords[i++] = pos.getY();
            buildingCoords[i++] = pos.getZ();
        }
        tag.putIntArray("Buildings", buildingCoords);

        return tag;
    }

    public static VillageData load(CompoundTag tag) {
        VillageData data = new VillageData(
            new ResourceLocation(tag.getString("CivilisationId")),
            new BlockPos(
                tag.getInt("CenterX"),
                tag.getInt("CenterY"), 
                tag.getInt("CenterZ")),
            tag.getString("VillageName")
        );
        data.setReputation(tag.getInt("Reputation"));

        int[] buildingCoords = tag.getIntArray("Buildings");
        for (int i = 0; i < buildingCoords.length; i += 3) {
            data.addBuilding(new BlockPos(
                buildingCoords[i],
                buildingCoords[i+1],
                buildingCoords[i+2]
            ));
        }

        return data;
    }
}

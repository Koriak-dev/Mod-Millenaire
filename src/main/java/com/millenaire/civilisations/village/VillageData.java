package com.millenaire.civilisations.village;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.resources.ResourceLocation;
import com.millenaire.civilisations.AbstractCivilisation;
import com.millenaire.civilisations.CivilisationRegistry;
import net.minecraftforge.common.util.INBTSerializable;

public class VillageData implements INBTSerializable<CompoundTag> {
    private BlockPos centerPos;
    private String name;
    private AbstractCivilisation civilisation;

    public VillageData() {
        // For NBT deserialization
    }

    public VillageData(BlockPos centerPos, String name, AbstractCivilisation civilisation) {
        this.centerPos = centerPos;
        this.name = name;
        this.civilisation = civilisation;
    }

    public BlockPos getCenterPos() {
        return centerPos;
    }

    public String getName() {
        return name;
    }

    public AbstractCivilisation getCivilisation() {
        return civilisation;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        tag.put("centerPos", NbtUtils.writeBlockPos(centerPos));
        tag.putString("name", name);
        tag.putString("civilisationId", civilisation.getCivilisationId().toString());
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag tag) {
        this.centerPos = NbtUtils.readBlockPos(tag.getCompound("centerPos"));
        this.name = tag.getString("name");
        ResourceLocation civId = new ResourceLocation(tag.getString("civilisationId"));
        this.civilisation = CivilisationRegistry.getCivilisation(civId);
        if (this.civilisation == null) {
            throw new IllegalStateException("Unknown civilisation ID: " + civId);
        }
    }
}

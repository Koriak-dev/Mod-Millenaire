j'ai une erreur 

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.resources.ResourceLocation;
import com.millenaire.civilisations.AbstractCivilisation;
import net.minecraftforge.common.util.INBTSerializable;

public class VillageData implements INBTSerializable<CompoundTag> {
    private final BlockPos centerPos;
    private final String name;
    private final AbstractCivilisation civilisation;

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
        // Note: Since fields are final, this should only be called during construction
        // via the no-arg constructor + NBT deserialization
        BlockPos pos = NbtUtils.readBlockPos(tag.getCompound("centerPos"));
        String villageName = tag.getString("name");
        ResourceLocation civId = new ResourceLocation(tag.getString("civilisationId"));
        
        // Would need access to CivilisationRegistry to reconstruct civilisation
        // This shows the limitation of the current design
    }
}

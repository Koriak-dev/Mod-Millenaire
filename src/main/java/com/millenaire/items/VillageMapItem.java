package com.millenaire.items;

import com.millenaire.civilisations.village.VillageData;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class VillageMapItem extends Item {
    public VillageMapItem(Properties properties) {
        super(properties);
    }

    public static void setVillage(ItemStack stack, VillageData village) {
        CompoundTag tag = stack.getOrCreateTag();
        tag.put("village", village.serializeNBT());
    }

    public static VillageData getVillage(ItemStack stack) {
        if (!stack.hasTag() || !stack.getTag().contains("village")) {
            return null;
        }
        VillageData data = new VillageData(BlockPos.ZERO, "Unnamed Village", null);
        data.deserializeNBT(stack.getTag().getCompound("village"));
        return data;
    }
}

package com.millenaire.items;

import com.millenaire.civilisations.CivilisationData;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class CivilisationScrollItem extends Item {
    public CivilisationScrollItem(Properties properties) {
        super(properties);
    }

    public static void setCivilisation(ItemStack stack, CivilisationData civilisation) {
        CompoundTag tag = stack.getOrCreateTag();
        tag.put("civilisation", civilisation.serializeNBT());
    }

    public static CivilisationData getCivilisation(ItemStack stack) {
        if (!stack.hasTag() || !stack.getTag().contains("civilisation")) {
            return null;
        }
        CivilisationData data = new CivilisationData();
        data.deserializeNBT(stack.getTag().getCompound("civilisation"));
        return data;
    }
}

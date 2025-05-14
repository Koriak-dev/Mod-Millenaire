/**
 * FICHIER: VillageMapItem.java
 * DESCRIPTION: Item représentant une carte de village
 * RESPONSABILITES:
 * - Stocker les données d'un village dans un item
 * - Permettre la lecture/écriture des données via NBT
 * - Maintenir l'intégrité des données sauvegardées
 */
package com.millenaire.items;

import com.millenaire.civilisations.village.VillageData;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class VillageMapItem extends Item {
    /**
     * Constructeur - Initialise une nouvelle carte de village
     * @param properties Propriétés de base de l'item
     */
    public VillageMapItem(Properties properties) {
        super(properties);
    }

    /**
     * Enregistre un village dans la carte
     * @param stack L'item stack contenant la carte
     * @param village Les données du village à sauvegarder
     */
    public static void setVillage(ItemStack stack, VillageData village) {
        CompoundTag tag = stack.getOrCreateTag();
        tag.put("village", village.serializeNBT());
    }

    /**
     * Récupère le village stocké dans la carte
     * @param stack L'item stack contenant la carte
     * @return Les données du village ou null si invalide
     */
    public static VillageData getVillage(ItemStack stack) {
        CompoundTag tag = stack.getTag();
        if (tag == null || !tag.contains("village")) {
            return null;
        }
        VillageData data = new VillageData(BlockPos.ZERO, "Unnamed Village", null);
        data.deserializeNBT(tag.getCompound("village"));
        return data;
    }
}

/**
 * FICHIER: CivilisationScrollItem.java
 * DESCRIPTION: Item représentant un parchemin de civilisation
 * RESPONSABILITES:
 * - Stocker les données d'une civilisation dans un item
 * - Permettre la lecture/écriture des données via NBT
 * - Maintenir l'intégrité des données sauvegardées
 */
package com.millenaire.items;

import com.millenaire.civilisations.CivilisationData;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class CivilisationScrollItem extends Item {
    /**
     * Constructeur - Initialise un nouveau parchemin de civilisation
     * @param properties Propriétés de base de l'item
     */
    public CivilisationScrollItem(Properties properties) {
        super(properties);
    }

    /**
     * Enregistre une civilisation dans le parchemin
     * @param stack L'item stack contenant le parchemin
     * @param civilisation Les données de civilisation à sauvegarder
     */
    public static void setCivilisation(ItemStack stack, CivilisationData civilisation) {
        CompoundTag tag = stack.getOrCreateTag();
        tag.put("civilisation", civilisation.serializeNBT());
    }

    /**
     * Récupère la civilisation stockée dans le parchemin
     * @param stack L'item stack contenant le parchemin
     * @return Les données de civilisation ou null si invalide
     */
    public static CivilisationData getCivilisation(ItemStack stack) {
        CompoundTag tag = stack.getTag();
        if (tag == null || !tag.contains("civilisation")) {
            return null;
        }
        CivilisationData data = new CivilisationData();
        data.deserializeNBT(tag.getCompound("civilisation"));
        return data;
    }
}

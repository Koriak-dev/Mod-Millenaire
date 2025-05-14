/**
 * FICHIER: MarketLogic.java
 * DESCRIPTION: Logique de marché et fixation des prix
 * RESPONSABILITES:
 * - Calculer les prix basés sur l'offre et la demande
 * - Gérer les fluctuations de marché
 * - Appliquer les effets économiques globaux
 */
package com.millenaire.economy;

import java.util.HashMap;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class MarketLogic {
    private static HashMap<Item, Integer> marketPrices = new HashMap<>();

    /**
     * Met à jour le prix d'un item sur le marché
     * @param item L'item à mettre à jour
     * @param price Nouveau prix unitaire
     */
    public static void updateMarketPrice(Item item, int price) {
        marketPrices.put(item, price);
    }

    /**
     * Obtient le prix actuel d'un stack d'items sur le marché
     * @param stack Le stack d'items à évaluer
     * @return Prix total (prix unitaire * quantité)
     */
    public static int getMarketPrice(ItemStack stack) {
        return marketPrices.getOrDefault(stack.getItem(), 1) * stack.getCount();
    }
}

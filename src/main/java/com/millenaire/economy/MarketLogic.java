package com.millenaire.economy;

import java.util.HashMap;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class MarketLogic {
    private static HashMap<Item, Integer> marketPrices = new HashMap<>();

    public static void updateMarketPrice(Item item, int price) {
        marketPrices.put(item, price);
    }

    public static int getMarketPrice(ItemStack stack) {
        return marketPrices.getOrDefault(stack.getItem(), 1) * stack.getCount();
    }
}

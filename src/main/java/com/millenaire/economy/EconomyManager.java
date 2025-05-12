package com.millenaire.economy;

import com.millenaire.civilisations.village.AbstractVillage;
import net.minecraft.world.item.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class EconomyManager {
    private final AbstractVillage village;
    private final Map<String, Integer> resources = new HashMap<>();
    private int wealth;

    public EconomyManager(AbstractVillage village) {
        this.village = village;
        initializeEconomy();
    }

    private void initializeEconomy() {
        // Starting resources based on civilisation type
        resources.put("food", 100);
        resources.put("wood", 50);
        resources.put("stone", 30);
        wealth = 100;
    }

    public void addResource(String resource, int amount) {
        resources.merge(resource, amount, Integer::sum);
    }

    public boolean consumeResource(String resource, int amount) {
        if (resources.getOrDefault(resource, 0) >= amount) {
            resources.put(resource, resources.get(resource) - amount);
            return true;
        }
        return false;
    }

    public int getResourceCount(String resource) {
        return resources.getOrDefault(resource, 0);
    }

    public void processTrade(ItemStack offered, ItemStack requested) {
        // Process trade logic between player and village
    }

    public void updateMarketPrices() {
        // Update prices based on supply/demand
    }

    public void dailyUpdate() {
        // Daily resource production/consumption
        updateMarketPrices();
    }

    public int getWealth() {
        return wealth;
    }
}

/**
 * FICHIER: EconomyManager.java
 * DESCRIPTION: Gestionnaire central de l'économie des villages
 * RESPONSABILITES:
 * - Gérer les ressources et richesses
 * - Contrôler les échanges commerciaux
 * - Mettre à jour les prix du marché
 */
package com.millenaire.economy;

import net.minecraft.world.item.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class EconomyManager {
    private final Map<String, Integer> resources = new HashMap<>();
    private int wealth;

    public EconomyManager() {
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

    /**
     * Consomme une quantité d'une ressource si disponible
     * @param resource Type de ressource à consommer
     * @param amount Quantité requise
     * @return true si la ressource était disponible et a été consommée, false sinon
     */
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

    /**
     * Traite un échange commercial entre joueur et village
     * @param offered Item proposé par le joueur
     * @param requested Item demandé par le village
     */
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

package com.millenaire.world.normands;

import com.millenaire.civilisations.normands.NormandCivilisation;
import com.millenaire.economy.EconomyManager;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

public class NormandVillage {
    private final NormandCivilisation civilisation;
    private final BlockPos centerPos;
    private final Level world;
    private final EconomyManager economy;

    public NormandVillage(NormandCivilisation civilisation, Level world, BlockPos centerPos) {
        this.civilisation = civilisation;
        this.world = world;
        this.centerPos = centerPos;
        this.economy = new EconomyManager(civilisation);
    }

    public void generateVillage() {
        // Vérifier les ressources nécessaires
        if (economy.consumeResource("bois", 20) && 
            economy.consumeResource("pierre", 10)) {
            
            // Générer les bâtiments du village
            generateTownHall();
            generateHouses();
            generateSpecialBuildings();
        }
    }

    private void generateTownHall() {
        String townHallType = "abbey_A"; // À adapter selon le type de village
        NormandStructureGenerator generator = new NormandStructureGenerator(civilisation, townHallType);
        generator.generateStructure(world, centerPos);
    }

    private void generateHouses() {
        // Générer les maisons autour du centre
    }

    private void generateSpecialBuildings() {
        // Générer les bâtiments spéciaux (église, forge, etc.)
    }

    public EconomyManager getEconomy() {
        return economy;
    }
}

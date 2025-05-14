/**
 * FICHIER: MillenaireMod.java
 * DESCRIPTION: Classe principale du mod Millénaire
 * RESPONSABILITES:
 * - Initialisation du mod
 * - Enregistrement des blocs/items
 * - Gestion des événements
 * - Compatibilités
 */
package com.millenaire;

import com.millenaire.core.ModConstants;
import com.millenaire.registries.ModBlocks;
import com.millenaire.registries.ModItems;
import com.millenaire.util.CompatibilityManager;
import com.millenaire.util.LogHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ModConstants.MOD_ID)
public class MillenaireMod {
    /**
     * Constructeur principal du mod
     * - Initialise les systèmes de base
     * - Enregistre les composants
     */
    public MillenaireMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Enregistrement des blocs et items
        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);

        // Configuration initiale
        modEventBus.addListener(this::setup);

        // Enregistrement pour les événements du jeu
        MinecraftForge.EVENT_BUS.register(this);
    }

    /**
     * Méthode d'initialisation du mod
     * @param event Événement de setup de Forge
     */
    private void setup(final FMLCommonSetupEvent event) {
        LogHelper.info("Initialisation du mod Millénaire");
        CompatibilityManager.checkCompatibilities();
        
        // TODO: Initialisation du réseau (si nécessaire)
    }
}

/**
 * FICHIER: WorldGenHandler.java
 * DESCRIPTION: Gestionnaire spécialisé de génération de monde pour les civilisations
 * RESPONSABILITES:
 * - Écouter les événements de chargement du monde
 * - Coordonner la génération spécifique aux civilisations
 * - Complémenter la génération principale (dans world/WorldGenHandler)
 * 
 * NOTE: Cette version est spécifique aux civilisations, voir aussi world/WorldGenHandler
 */
package com.millenaire.worldgen;

import net.minecraftforge.event.level.LevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class WorldGenHandler {
    /**
     * Événement déclenché lors du chargement d'un monde
     * @param event L'événement de chargement contenant le contexte du monde
     */
    @SubscribeEvent
    public static void onWorldLoad(LevelEvent.Load event) {
        // TODO: Implémenter la génération spécifique aux civilisations
    }
}

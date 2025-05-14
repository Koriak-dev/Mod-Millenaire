/**
 * FICHIER: WorldGenHandler.java
 * DESCRIPTION: Gestionnaire principal de génération de monde pour le mod Millénaire
 * RESPONSABILITES:
 * - Écouter les événements de chargement du monde
 * - Coordonner la génération des structures et villages
 * - Initialiser les systèmes de génération
 */
package com.millenaire.world;

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
        // TODO: Implémenter la génération des structures et villages
    }
}

/**
 * FICHIER: ClientSetupHandler.java
 * DESCRIPTION: Gère l'initialisation côté client
 * RESPONSABILITES:
 * - Enregistrement des renderers d'entités
 * - Configuration des modèles 3D
 * - Initialisation des textures
 */
package com.millenaire.client;

import com.millenaire.entity.renderer.JaponaisNPCRenderer;
import com.millenaire.registries.ModEntities;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = "millenaire", bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetupHandler {
    /**
     * Callback pour l'initialisation côté client
     * @param event L'événement de setup client
     * Responsabilités:
     * - Enregistre tous les renderers d'entités
     * - Configure les modèles 3D
     * - Initialise les systèmes client
     */
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        EntityRenderers.register(ModEntities.JAPONAIS_NPC.get(), JaponaisNPCRenderer::new);
    }
}

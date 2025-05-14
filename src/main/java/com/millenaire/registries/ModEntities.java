/**
 * FICHIER: ModEntities.java
 * DESCRIPTION: Registre des entités du mod Millénaire
 * RESPONSABILITES:
 * - Maintenir la liste de toutes les entités du mod
 * - Enregistrer les entités auprès de Minecraft
 * - Fournir un accès centralisé aux entités
 */
package com.millenaire.registries;

import com.millenaire.civilisations.japonais.JaponaisNPCEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    /**
     * Registre différé pour les entités du mod.
     * Les entités doivent être enregistrées via cette instance.
     */
    public static final DeferredRegister<EntityType<?>> ENTITIES =
        DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, "millenaire");

    /**
     * Entité NPC de la civilisation japonaise
     * - Taille: 0.6x1.8 blocs
     * - Catégorie: CREATURE
     */
    public static final RegistryObject<EntityType<JaponaisNPCEntity>> JAPONAIS_NPC = ENTITIES.register("japonais_npc",
        () -> EntityType.Builder.of(JaponaisNPCEntity::new, MobCategory.CREATURE)
            .sized(0.6f, 1.8f)
            .build("japonais_npc"));

    // Ajouter ici les autres entités du mod via ENTITIES.register()
}

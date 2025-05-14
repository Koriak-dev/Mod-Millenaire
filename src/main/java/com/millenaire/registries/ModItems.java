/**
 * FICHIER: ModItems.java
 * DESCRIPTION: Registre des items du mod Millénaire
 * RESPONSABILITES:
 * - Maintenir la liste de tous les items du mod
 * - Enregistrer les items auprès de Minecraft
 * - Fournir un accès centralisé aux items
 */
package com.millenaire.registries;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    /**
     * Registre différé pour les items du mod.
     * Les items doivent être enregistrés via cette instance.
     */
    public static final DeferredRegister<Item> ITEMS =
        DeferredRegister.create(ForgeRegistries.ITEMS, "millenaire");

    // Les items du mod sont enregistrés ici via ITEMS.register()
}

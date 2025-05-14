/**
 * FICHIER: StructureRegistry.java
 * DESCRIPTION: Registre central des structures du mod
 * RESPONSABILITES:
 * - Enregistrer les structures pour la génération mondiale
 * - Maintenir les références aux générateurs de structures
 */
package com.millenaire.world;

import com.millenaire.civilisations.azteques.AztequeStructureGenerator;
import com.millenaire.civilisations.japonais.JaponaisStructureGenerator;
import com.millenaire.civilisations.normands.NormandStructureGenerator;

public class StructureRegistry {
    /**
     * Enregistre toutes les structures du mod
     */
    public static void registerStructures() {
        // Enregistrer les structures aztèques
        AztequeStructureGenerator.register();
        
        // Enregistrer les structures japonaises
        JaponaisStructureGenerator.register();
        
        // Enregistrer les structures normandes
        NormandStructureGenerator.register();
    }
}

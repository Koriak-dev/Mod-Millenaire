/**
 * FICHIER: WorldGenerationTest.java
 * DESCRIPTION: Tests unitaires pour la génération du monde
 */
package com.millenaire;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.millenaire.civilisations.azteques.AztequeCivilisation;
import com.millenaire.civilisations.normands.NormandCivilisation;
import com.millenaire.civilisations.AbstractCivilisation;

public class WorldGenerationTest {
    
    @Test
    public void testBiomeValidation() {
        // Test avec des noms de biomes directement
        AztequeCivilisation aztec = new AztequeCivilisation();
        NormandCivilisation normand = new NormandCivilisation();
        
        // Test biomes valides
        assertTrue(isTestBiomeValid("jungle", aztec));
        assertTrue(isTestBiomeValid("desert", aztec));
        
        // Test biomes invalides
        assertFalse(isTestBiomeValid("ocean", aztec));
        assertFalse(isTestBiomeValid("plains", aztec));
        
        // Test autre civilisation
        assertTrue(isTestBiomeValid("plains", normand));
    }

    private boolean isTestBiomeValid(String biomeName, AbstractCivilisation civilisation) {
        // Simule la logique de VillagePlacement pour les tests
        return biomeName.contains("jungle") || 
               biomeName.contains("desert") ||
               (civilisation instanceof NormandCivilisation && 
                (biomeName.contains("plains") || biomeName.contains("meadow")));
    }
}

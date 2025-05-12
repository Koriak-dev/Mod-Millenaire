package com.millenaire.civilisations.azteques;

import com.millenaire.civilisations.AbstractCivilisation;
import com.millenaire.world.StructureGenerator;

public class AztequeStructureGenerator extends StructureGenerator {
    private final AztequeCivilisation civilisation;

    public AztequeStructureGenerator(AztequeCivilisation civilisation) {
        this.civilisation = civilisation;
    }

    @Override
    public void generateVillageStructures(AztequeVillage village) {
        // Implémentation spécifique aux structures aztèques
    }
}

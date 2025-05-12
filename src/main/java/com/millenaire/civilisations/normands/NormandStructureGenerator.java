package com.millenaire.civilisations.normands;

import com.millenaire.civilisations.AbstractCivilisation;
import com.millenaire.world.StructureGenerator;

public class NormandStructureGenerator extends StructureGenerator {
    private final NormandCivilisation civilisation;

    public NormandStructureGenerator(NormandCivilisation civilisation) {
        this.civilisation = civilisation;
    }

    @Override
    public void generateVillageStructures(NormandVillage village) {
        // Implémentation spécifique aux structures normandes
    }
}

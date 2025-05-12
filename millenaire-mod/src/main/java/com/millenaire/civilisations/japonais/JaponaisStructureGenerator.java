package com.millenaire.civilisations.japonais;

import com.millenaire.civilisations.AbstractCivilisation;
import com.millenaire.world.StructureGenerator;

public class JaponaisStructureGenerator extends StructureGenerator {
    private final JaponaisCivilisation civilisation;

    public JaponaisStructureGenerator(JaponaisCivilisation civilisation) {
        this.civilisation = civilisation;
    }

    @Override
    public void generateVillageStructures(JaponaisVillage village) {
        // Implémentation spécifique aux structures japonaises
    }
}

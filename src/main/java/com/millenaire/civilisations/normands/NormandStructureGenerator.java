/**
 * FICHIER: NormandStructureGenerator.java
 * DESCRIPTION: Générateur de structures normandes
 * STRUCTURES:
 * - Longships (bateaux vikings)
 * - Halls communautaires
 * - Forges
 * - Bâtiments défensifs
 */
package com.millenaire.civilisations.normands;

import com.millenaire.world.StructureGenerator;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

public class NormandStructureGenerator extends StructureGenerator {
    /**
     * Constructeur du générateur de structures normandes
     * @param civilisation La civilisation normande associée
     */
    public NormandStructureGenerator(NormandCivilisation civilisation) {
        super(civilisation, "normand");
    }

    @Override
    public void generateStructure(Level level, BlockPos pos) {
        // Implémentation spécifique aux structures normandes
    }
}

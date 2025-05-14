package com.millenaire.civilisations.normands;

import com.millenaire.world.StructureGenerator;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

public class NormandStructureGenerator extends StructureGenerator {
    public NormandStructureGenerator(NormandCivilisation civilisation) {
        super(civilisation, "normand");
    }

    @Override
    public void generateStructure(Level level, BlockPos pos) {
        // Implémentation spécifique aux structures normandes
    }
}

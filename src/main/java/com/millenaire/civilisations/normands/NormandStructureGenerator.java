package com.millenaire.civilisations.normands;

import com.millenaire.civilisations.AbstractCivilisation;
import com.millenaire.world.StructureGenerator;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

public class NormandStructureGenerator extends StructureGenerator {
    private final NormandCivilisation civilisation;

    public NormandStructureGenerator(NormandCivilisation civilisation) {
        super(civilisation, "normand");
        this.civilisation = civilisation;
    }

    @Override
    public void generateStructure(Level level, BlockPos pos) {
        // Implémentation spécifique aux structures normandes
    }
}

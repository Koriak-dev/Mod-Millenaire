package com.millenaire.civilisations.japonais;

import com.millenaire.civilisations.AbstractCivilisation;
import com.millenaire.world.StructureGenerator;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

public class JaponaisStructureGenerator extends StructureGenerator {
    private final JaponaisCivilisation civilisation;

    public JaponaisStructureGenerator(JaponaisCivilisation civilisation) {
        super(civilisation, "japonais");
        this.civilisation = civilisation;
    }

    @Override
    public void generateStructure(Level level, BlockPos pos) {
        // Implémentation spécifique aux structures japonaises
    }
}

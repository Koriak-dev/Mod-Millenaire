package com.millenaire.civilisations.japonais;

import com.millenaire.civilisations.AbstractCivilisation;
import com.millenaire.civilisations.village.AbstractVillage;
import com.millenaire.civilisations.village.VillageData;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

public class JaponaisVillage extends AbstractVillage {
    private final VillageData villageData;
    private final JaponaisCivilisation civilisation;

    public JaponaisVillage(VillageData villageData, JaponaisCivilisation civilisation) {
        this.villageData = villageData;
        this.civilisation = civilisation;
    }

    @Override
    public String getName() {
        return villageData.getName();
    }

    @Override
    public BlockPos getCenterPos() {
        return villageData.getCenterPos();
    }

    @Override
    public AbstractCivilisation getCivilisation() {
        return civilisation;
    }

    public void generateStructures() {
        BlockPos center = villageData.getCenterPos();
        Level level = civilisation.getWorld();
        
        // Temple central
        generateTemple(level, center);
        
        // Maisons traditionnelles
        generateHouses(level, center);
        
        // Jardin zen
        generateGarden(level, center);
    }
    
    private void generateTemple(Level level, BlockPos pos) {
        // Base du temple (7x7)
        for (int x = -3; x <= 3; x++) {
            for (int z = -3; z <= 3; z++) {
                level.setBlock(pos.offset(x, 0, z), Blocks.DARK_OAK_PLANKS.defaultBlockState(), 3);
            }
        }
        
        // Colonnes et toit
        for (int y = 1; y <= 4; y++) {
            level.setBlock(pos.offset(-3, y, -3), Blocks.STRIPPED_DARK_OAK_LOG.defaultBlockState(), 3);
            level.setBlock(pos.offset(3, y, -3), Blocks.STRIPPED_DARK_OAK_LOG.defaultBlockState(), 3);
            level.setBlock(pos.offset(-3, y, 3), Blocks.STRIPPED_DARK_OAK_LOG.defaultBlockState(), 3);
            level.setBlock(pos.offset(3, y, 3), Blocks.STRIPPED_DARK_OAK_LOG.defaultBlockState(), 3);
            
            if (y == 4) {
                for (int x = -3; x <= 3; x++) {
                    for (int z = -3; z <= 3; z++) {
                        level.setBlock(pos.offset(x, y, z), Blocks.DARK_OAK_SLAB.defaultBlockState(), 3);
                    }
                }
            }
        }
    }
    
    private void generateHouses(Level level, BlockPos center) {
        // Génère 6 maisons autour du temple
        for (int i = 0; i < 6; i++) {
            double angle = i * Math.PI / 3;
            int x = (int) (15 * Math.cos(angle));
            int z = (int) (15 * Math.sin(angle));
            
            BlockPos housePos = center.offset(x, 0, z);
            
            // Structure de la maison (3x3x2)
            for (int dx = -1; dx <= 1; dx++) {
                for (int dz = -1; dz <= 1; dz++) {
                    level.setBlock(housePos.offset(dx, 0, dz), Blocks.OAK_PLANKS.defaultBlockState(), 3);
                    level.setBlock(housePos.offset(dx, 1, dz), Blocks.OAK_PLANKS.defaultBlockState(), 3);
                    
                    if (dx == 0 && dz == 0) {
                        level.setBlock(housePos.offset(0, 1, 0), Blocks.OAK_DOOR.defaultBlockState(), 3);
                    }
                }
            }
            
            // Toit en pente
            level.setBlock(housePos.offset(0, 2, 0), Blocks.OAK_STAIRS.defaultBlockState(), 3);
        }
    }
    
    private void generateGarden(Level level, BlockPos center) {
        // Jardin zen (9x9)
        for (int x = -4; x <= 4; x++) {
            for (int z = -4; z <= 4; z++) {
                if (Math.abs(x) == 4 || Math.abs(z) == 4) {
                    // Bordure en pierre
                    level.setBlock(center.offset(x, 0, z), Blocks.STONE.defaultBlockState(), 3);
                } else {
                    // Sable et motifs
                    level.setBlock(center.offset(x, 0, z), Blocks.SAND.defaultBlockState(), 3);
                    
                    // Motifs de jardin
                    if ((x + z) % 3 == 0) {
                        level.setBlock(center.offset(x, 1, z), Blocks.MOSS_BLOCK.defaultBlockState(), 3);
                    }
                }
            }
        }
    }

    public void update() {
        Level level = civilisation.getWorld();
        BlockPos center = villageData.getCenterPos();
        
        // Vérifie le temple central
        if (level.getBlockState(center).isAir()) {
            generateTemple(level, center);
        }
        
        // Vérifie les maisons
        for (int i = 0; i < 6; i++) {
            double angle = i * Math.PI / 3;
            BlockPos housePos = center.offset(
                (int)(15 * Math.cos(angle)),
                0,
                (int)(15 * Math.sin(angle))
            );
            
            if (level.getBlockState(housePos).isAir()) {
                generateHouses(level, center);
                break;
            }
        }
    }
}

package com.millenaire.civilisations.normands;

import com.millenaire.civilisations.AbstractCivilisation;
import com.millenaire.civilisations.village.AbstractVillage;
import com.millenaire.civilisations.village.VillageData;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

public class NormandVillage extends AbstractVillage {
    private final VillageData villageData;
    private final NormandCivilisation civilisation;

    public NormandVillage(VillageData villageData, NormandCivilisation civilisation) {
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
        
        // Château central
        generateCastle(level, center);
        
        // Maisons de village
        generateHouses(level, center);
        
        // Fermes et champs
        generateFarms(level, center);
    }
    
    private void generateCastle(Level level, BlockPos pos) {
        // Tour centrale (5x5)
        for (int y = 0; y < 6; y++) {
            for (int x = -2; x <= 2; x++) {
                for (int z = -2; z <= 2; z++) {
                    if (Math.abs(x) == 2 || Math.abs(z) == 2 || y == 0 || y == 5) {
                        level.setBlock(pos.offset(x, y, z), Blocks.STONE_BRICKS.defaultBlockState(), 3);
                    }
                }
            }
        }
        
        // Murailles
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            for (int i = 1; i <= 3; i++) {
                BlockPos wallPos = pos.relative(direction, 10);
                for (int y = 0; y < 4; y++) {
                    level.setBlock(wallPos.offset(0, y, 0), Blocks.STONE_BRICKS.defaultBlockState(), 3);
                }
            }
        }
    }
    
    private void generateHouses(Level level, BlockPos center) {
        // Génère 8 maisons autour du château
        for (int i = 0; i < 8; i++) {
            double angle = i * Math.PI / 4;
            int x = (int) (12 * Math.cos(angle));
            int z = (int) (12 * Math.sin(angle));
            
            BlockPos housePos = center.offset(x, 0, z);
            
            // Structure de la maison (3x3x3)
            for (int dy = 0; dy < 3; dy++) {
                for (int dx = -1; dx <= 1; dx++) {
                    for (int dz = -1; dz <= 1; dz++) {
                        if (dy == 0 || Math.abs(dx) == 1 || Math.abs(dz) == 1) {
                            level.setBlock(housePos.offset(dx, dy, dz), Blocks.OAK_PLANKS.defaultBlockState(), 3);
                        }
                    }
                }
            }
            
            // Toit en pente
            level.setBlock(housePos.offset(0, 3, 0), Blocks.SPRUCE_STAIRS.defaultBlockState(), 3);
        }
    }
    
    private void generateFarms(Level level, BlockPos center) {
        // Champs cultivés autour du village
        for (int x = -15; x <= 15; x += 5) {
            for (int z = -15; z <= 15; z += 5) {
                if (Math.abs(x) < 10 && Math.abs(z) < 10) continue;
                
                BlockPos farmPos = center.offset(x, 0, z);
                
                // Terre labourée
                for (int dx = -2; dx <= 2; dx++) {
                    for (int dz = -2; dz <= 2; dz++) {
                        level.setBlock(farmPos.offset(dx, 0, dz), Blocks.FARMLAND.defaultBlockState(), 3);
                        level.setBlock(farmPos.offset(dx, 1, dz), Blocks.WHEAT.defaultBlockState(), 3);
                    }
                }
            }
        }
    }

    public void update() {
        Level level = civilisation.getWorld();
        BlockPos center = villageData.getCenterPos();
        
        // Vérifie le château
        if (level.getBlockState(center).isAir()) {
            generateCastle(level, center);
        }
        
        // Vérifie les maisons
        for (int i = 0; i < 8; i++) {
            double angle = i * Math.PI / 4;
            BlockPos housePos = center.offset(
                (int)(12 * Math.cos(angle)),
                0,
                (int)(12 * Math.sin(angle))
            );
            
            if (level.getBlockState(housePos).isAir()) {
                generateHouses(level, center);
                break;
            }
        }
    }
}

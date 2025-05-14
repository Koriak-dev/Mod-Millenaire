package com.millenaire.civilisations.japonais;
import com.millenaire.civilisations.AbstractCivilisation;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
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
                for (int tx = -3; tx <= 3; tx++) {
                    for (int tz = -3; tz <= 3; tz++) {
                        level.setBlock(pos.offset(tx, y, tz), Blocks.DARK_OAK_SLAB.defaultBlockState(), 3);
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
                        // Création de la porte avec la méthode dédiée
                        BlockPos doorPos = housePos.offset(dx, 1, dz);
                        DoorBlock door = (DoorBlock)Blocks.OAK_DOOR;
                        level.setBlock(doorPos, Blocks.OAK_DOOR.defaultBlockState()
                            .setValue(DoorBlock.FACING, Direction.NORTH)
                            .setValue(DoorBlock.OPEN, false), 3);
                    }
                }
            }
            
            // Toit en pente
            level.setBlock(housePos.offset(0, 2, 0), Blocks.OAK_STAIRS.defaultBlockState(), 3);
        }
    }
    
    private void generateGarden(Level level, BlockPos center) {
        // Jardin zen (15x15)
        for (int x = -7; x <= 7; x++) {
            for (int z = -7; z <= 7; z++) {
                if (Math.abs(x) == 7 || Math.abs(z) == 7) {
                    // Bordure en andésite polie
                    level.setBlock(center.offset(x, 0, z), Blocks.POLISHED_ANDESITE.defaultBlockState(), 3);
                } else {
                    // Base de sable et gravier
                    level.setBlock(center.offset(x, 0, z), 
                        Math.random() > 0.7 ? Blocks.GRAVEL.defaultBlockState() : Blocks.SAND.defaultBlockState(), 3);
                    
                    // Motifs de jardin plus élaborés
                    if ((x * x + z * z) < 25) { // Zone centrale
                        // Pont en bois
                        if (x == 0 && z % 2 == 0) {
                            level.setBlock(center.offset(x, 1, z), Blocks.OAK_PLANKS.defaultBlockState(), 3);
                        }
                        
                        // Rochers et lanternes
                        if ((x + z) % 5 == 0) {
                            level.setBlock(center.offset(x, 1, z), 
                                Math.random() > 0.5 ? Blocks.MOSSY_COBBLESTONE.defaultBlockState() 
                                                   : Blocks.STONE.defaultBlockState(), 3);
                            if (Math.random() > 0.7) {
                                level.setBlock(center.offset(x, 2, z), Blocks.LANTERN.defaultBlockState(), 3);
                            }
                        }
                    }
                    
                    // Cerisier au centre
                    if (x == 0 && z == 0) {
                        for (int y = 1; y <= 5; y++) {
                            level.setBlock(center.offset(0, y, 0), Blocks.CHERRY_LOG.defaultBlockState(), 3);
                            if (y == 5) {
                                for (int tx = -2; tx <= 2; tx++) {
                                    for (int tz = -2; tz <= 2; tz++) {
                                        if (Math.abs(tx) + Math.abs(tz) < 4) {
                                            level.setBlock(center.offset(tx, y, tz), Blocks.CHERRY_LEAVES.defaultBlockState(), 3);
                                        }
                                    }
                                }
                            }
                        }
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

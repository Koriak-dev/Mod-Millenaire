/**
 * FICHIER: VillagePlacement.java
 * DESCRIPTION: Utilitaire pour le placement des villages
 * RESPONSABILITES:
 * - Vérifier la validité des emplacements pour les villages
 * - Définir l'espacement entre les villages
 * - Appliquer les règles de placement spécifiques
 */
package com.millenaire.world;

import com.millenaire.civilisations.AbstractCivilisation;
import com.millenaire.civilisations.azteques.AztequeCivilisation;
import com.millenaire.civilisations.japonais.JaponaisCivilisation;
import com.millenaire.civilisations.normands.NormandCivilisation;
import com.millenaire.civilisations.CivilisationRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;
import com.millenaire.civilisations.village.VillageData;

public class VillagePlacement {
    /**
     * Vérifie si un emplacement est valide pour un village
     * @param world Le monde à vérifier
     * @param pos La position à vérifier
     * @return true si l'emplacement est valide
     */
    public static boolean isValidVillageLocation(Level world, BlockPos pos, AbstractCivilisation civilisation) {
        int spacing = getVillageSpacing();
        int chunkX = pos.getX() >> 4;
        int chunkZ = pos.getZ() >> 4;
        
        // Vérifier l'espacement minimum
        if (!((chunkX % spacing == 0) && (chunkZ % spacing == 0))) {
            return false;
        }

        // Vérifier que le biome est approprié
        Biome biome = world.getBiome(pos).value();
        return isBiomeValidForCivilisation(biome, civilisation);
    }

    private static boolean isBiomeValidForCivilisation(Biome biome, AbstractCivilisation civilisation) {
        String biomeName = ForgeRegistries.BIOMES.getKey(biome).getPath();
        
        // Logique des biomes par civilisation
        if (civilisation instanceof AztequeCivilisation) {
            return biomeName.contains("jungle") || 
                   biomeName.contains("badlands") ||
                   biomeName.contains("desert");
        } 
        else if (civilisation instanceof JaponaisCivilisation) {
            return biomeName.contains("forest") ||
                   biomeName.contains("plains") ||
                   biomeName.contains("cherry");
        }
        else if (civilisation instanceof NormandCivilisation) {
            return biomeName.contains("plains") ||
                   biomeName.contains("taiga") ||
                   biomeName.contains("meadow");
        }
        return false;
    }
    
    /**
     * @return L'espacement minimum entre les villages (en chunks)
     */
    public static int getVillageSpacing() {
        return 20; // 20 chunks = 320 blocs
    }
    
    /**
     * Initialise la génération des villages dans le monde
     * @param world Le monde à initialiser
     */
    public static void initializeVillageGeneration(net.minecraft.world.level.LevelAccessor world) {
        // Générer les villages pour chaque civilisation
        CivilisationRegistry.getCivilisations().forEach(civilisation -> {
            BlockPos spawnPos = findValidSpawn(world, civilisation);
            if (spawnPos != null) {
                // Créer le village (enregistrement à implémenter)
                new VillageData(spawnPos, 
                    civilisation.getName() + " Village", 
                    civilisation);
            }
        });
    }

    private static BlockPos findValidSpawn(LevelAccessor world, AbstractCivilisation civilisation) {
        // Chercher un spawn valide dans un rayon de 2000 blocs autour du spawn monde
        BlockPos worldSpawn = new BlockPos(world.getLevelData().getXSpawn(), 
                                         world.getLevelData().getYSpawn(),
                                         world.getLevelData().getZSpawn());
        
        for (int i = 0; i < 100; i++) {
            BlockPos testPos = worldSpawn.offset(
                world.getRandom().nextInt(2000) - 1000,
                0,
                world.getRandom().nextInt(2000) - 1000
            );
            
            if (world instanceof Level && isValidVillageLocation((Level)world, testPos, civilisation)) {
                return testPos;
            }
        }
        return null;
    }
}

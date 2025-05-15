package com.millenaire.commands;

import com.millenaire.civilisations.AbstractCivilisation;
import com.millenaire.civilisations.CivilisationRegistry;
import com.millenaire.world.VillagePlacement;
import com.millenaire.civilisations.village.VillageData;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;

/**
 * =============================================
 * COMMANDES DU MOD MILLENAIRE
 * =============================================
 * 
 * Ce module gère toutes les commandes disponibles pour interagir avec
 * les villages et structures du mod Millenaire.
 * 
 * Commandes disponibles :
 * 1. /millenaire villages list
 * 2. /millenaire villages generate [civilisation]
 * 3. /millenaire structures generate [structure]
 */
public class ModCommands {

    /**
     * =============================================
     * ENREGISTREMENT DES COMMANDES
     * =============================================
     * 
     * @param dispatcher Le gestionnaire de commandes Minecraft
     */
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("millenaire")
            .then(Commands.literal("villages")
                .then(Commands.literal("list")
                    .executes(context -> listCivilisations(context.getSource())))
                .then(Commands.literal("generate")
                    .then(Commands.argument("civilisation", StringArgumentType.string())
                        .suggests((ctx, builder) -> {
                            for (AbstractCivilisation civ : CivilisationRegistry.getCivilisations()) {
                                builder.suggest(civ.getName());
                            }
                            return builder.buildFuture();
                        })
                        .executes(context -> generateVillage(
                            context.getSource(),
                            StringArgumentType.getString(context, "civilisation")
                        ))
                    )
                )
            )
            .then(Commands.literal("structures")
                .then(Commands.literal("generate")
                    .then(Commands.argument("structureId", StringArgumentType.string())
                        .executes(context -> generateStructure(
                            context.getSource(),
                            StringArgumentType.getString(context, "structureId")
                        ))
                    )
                )
            )
        );
    }

    /**
     * =============================================
     * LISTE DES CIVILISATIONS
     * =============================================
     * Affiche la liste des civilisations disponibles
     * 
     * @param source La source de la commande (joueur/console)
     * @return 1 si succès, 0 si échec
     */
    private static int listCivilisations(CommandSourceStack source) {
        source.sendSuccess(() -> Component.literal("Civilisations disponibles:"), false);
        for (AbstractCivilisation civ : CivilisationRegistry.getCivilisations()) {
            source.sendSuccess(() -> Component.literal("- " + civ.getName()), false);
        }
        return 1;
    }

    /**
     * =============================================
     * GENERATION DE VILLAGE
     * =============================================
     * Crée un nouveau village pour la civilisation spécifiée
     * 
     * @param source La source de la commande
     * @param civilisationName Le nom de la civilisation
     * @return 1 si succès, 0 si échec
     */
    private static int generateVillage(CommandSourceStack source, String civilisationName) {
        Level world = source.getLevel();
        BlockPos pos = BlockPos.containing(source.getPosition());
        
        AbstractCivilisation civilisation = CivilisationRegistry.getCivilisations().stream()
            .filter(c -> c.getName().equalsIgnoreCase(civilisationName))
            .findFirst()
            .orElse(null);

        if (civilisation == null) {
            source.sendFailure(Component.literal("Civilisation inconnue: " + civilisationName));
            return 0;
        }

        if (!VillagePlacement.isValidVillageLocation(world, pos, civilisation)) {
            source.sendFailure(Component.literal("Emplacement invalide pour cette civilisation"));
            return 0;
        }

        civilisation.createNewVillage(pos, civilisation.getName() + " Village");
        source.sendSuccess(() -> Component.literal("Village " + civilisationName + " généré !"), true);
        return 1;
    }

    /**
     * =============================================
     * GENERATION DE STRUCTURES
     * =============================================
     * Génère les structures d'un village
     * 
     * @param source La source de la commande
     * @param structureId L'ID de la structure
     * @return 1 si succès, 0 si échec
     */
    /**
     * FICHIER: ModCommands.java
     * DESCRIPTION: Génère les structures d'un village Millenaire
     * FONCTIONNALITES:
     * - Vérifie la validité de l'emplacement
     * - Crée un nouveau village
     * - Génère les structures spécifiques
     */
    private static int generateStructure(CommandSourceStack source, String structureId) {
        Level world = source.getLevel();
        BlockPos pos = BlockPos.containing(source.getPosition());
        
        // Vérifie que la position est dans un chunk chargé
        if (!world.isLoaded(pos)) {
            source.sendFailure(Component.literal("Position non chargée - veuillez vous approcher"));
            return 0;
        }
        
        AbstractCivilisation civilisation = CivilisationRegistry.getCivilisations().stream()
            .filter(c -> c.getName().equalsIgnoreCase(structureId))
            .findFirst()
            .orElse(null);

        if (civilisation == null) {
            source.sendFailure(Component.literal("Civilisation inconnue: " + structureId));
            return 0;
        }

        VillageData village = civilisation.createNewVillage(pos, "Village " + structureId);
        civilisation.generateVillageStructures(village);
        source.sendSuccess(() -> Component.literal("Structures de " + structureId + " générées !"), true);
        return 1;
    }
}

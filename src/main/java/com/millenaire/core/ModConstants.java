/**
 * FICHIER: ModConstants.java
 * DESCRIPTION: Contient toutes les constantes globales du mod
 * RESPONSABILITES:
 * - Centraliser les identifiants et chemins
 * - Maintenir la cohérence des valeurs constantes
 * - Faciliter les mises à jour globales
 */
package com.millenaire.core;

public class ModConstants {
    /**
     * Identifiant technique unique du mod
     * Utilisé pour:
     * - Les registres
     * - Les chemins de ressources
     * - La configuration
     */
    public static final String MOD_ID = "millenaire";
    
    /**
     * Nom affichable du mod
     * Utilisé dans:
     * - L'interface utilisateur
     * - Les messages système
     * - La documentation
     */
    public static final String MOD_NAME = "Millénaire Mod";
    
    /**
     * Version du protocole réseau
     * Format: Major.Minor
     * Utilisé pour:
     * - La compatibilité client/serveur
     * - Le versioning des packets
     */
    public static final String NETWORK_PROTOCOL = "1.0";
    
    /**
     * Chemin des fichiers de configuration
     * Relatif au dossier .minecraft
     */
    public static final String CONFIG_PATH = "config/millenaire/";
    
    /**
     * Chemin des données persistantes
     * Relatif au dossier .minecraft
     */
    public static final String DATA_PATH = "data/millenaire/";
    
    /**
     * ID de la civilisation normande
     * Utilisé pour:
     * - Les registres
     * - La génération
     * - Les sauvegardes
     */
    public static final String NORMAND_CIVILISATION_ID = "normand";
    
    /**
     * ID de la civilisation aztèque
     * Utilisé pour:
     * - Les registres
     * - La génération
     * - Les sauvegardes
     */
    public static final String AZTEQUE_CIVILISATION_ID = "azteque";
    
    /**
     * ID de la civilisation japonaise
     * Utilisé pour:
     * - Les registres
     * - La génération
     * - Les sauvegardes
     */
    public static final String JAPONAIS_CIVILISATION_ID = "japonais";
    
    /**
     * Chemin des textures
     * Relatif au dossier assets/millenaire/
     */
    public static final String TEXTURE_PATH = "textures/";
    
    /**
     * Chemin des modèles 3D
     * Relatif au dossier assets/millenaire/
     */
    public static final String MODEL_PATH = "models/";
    
    /**
     * Chemin des fichiers de langue
     * Relatif au dossier assets/millenaire/
     */
    public static final String LANG_PATH = "lang/";
}

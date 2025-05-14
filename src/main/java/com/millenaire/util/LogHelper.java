/**
 * FICHIER: LogHelper.java
 * DESCRIPTION: Utilitaire de logging pour le mod Millénaire
 * RESPONSABILITES:
 * - Fournir une interface simplifiée pour le logging
 * - Standardiser les messages de log avec un préfixe
 * - Centraliser la configuration du logging
 */
package com.millenaire.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogHelper {
    /**
     * Logger principal du mod, configuré via log4j
     */
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * Log un message de niveau INFO
     * @param message Le message à logger
     */
    public static void info(String message) {
        LOGGER.info("[Millenaire] " + message);
    }

    /**
     * Log un message de niveau WARN
     * @param message Le message à logger
     */
    public static void warn(String message) {
        LOGGER.warn("[Millenaire] " + message);
    }

    /**
     * Log un message de niveau ERROR
     * @param message Le message à logger
     */
    public static void error(String message) {
        LOGGER.error("[Millenaire] " + message);
    }

    /**
     * Log un message de niveau DEBUG
     * @param message Le message à logger
     */
    public static void debug(String message) {
        LOGGER.debug("[Millenaire] " + message);
    }
}

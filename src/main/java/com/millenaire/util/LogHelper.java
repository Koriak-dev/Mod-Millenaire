package com.millenaire.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogHelper {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void info(String message) {
        LOGGER.info("[Millenaire] " + message);
    }

    public static void warn(String message) {
        LOGGER.warn("[Millenaire] " + message);
    }

    public static void error(String message) {
        LOGGER.error("[Millenaire] " + message);
    }

    public static void debug(String message) {
        LOGGER.debug("[Millenaire] " + message);
    }
}

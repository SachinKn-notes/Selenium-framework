package libs.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtils {
    private LoggerUtils() {

    }

    private static final Logger LOGGER = LogManager.getLogger(LoggerUtils.class.getName());

    public static void logError(String message, Exception ex) {
        LOGGER.error(message, ex);
    }

    public static void logError(String message) {
        LOGGER.error(message);
    }

    public static void logInfo(String message) {
        LOGGER.info(message);
    }
}

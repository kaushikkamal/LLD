package LoggingSystem;

import LoggingSystem.Log.*;

public class LoggingSystemDriver {
    public static void execute() {
        // chain of responsibilities
        Logger logger = new InfoLogger(new DebugLogger(new ErrorLogger(null)));

        logger.log(LoggerType.DEBUG, "debug message");
        logger.log(LoggerType.INFO, "info message");
        logger.log(LoggerType.ERROR, "error message");
    }
}

package LoggingSystem.Log;

public class Logger implements LoggerInterface {
    private final Logger nextLogger;

    public Logger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void log(LoggerType loggerType, String message) {
        if (nextLogger != null) {
            nextLogger.log(loggerType, message);
        }
    }
}

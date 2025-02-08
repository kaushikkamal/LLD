package LoggingSystem.Log;

public class DebugLogger extends Logger implements LoggerInterface {
    public DebugLogger(Logger nextLogger) {
        super(nextLogger);
    }

    public void log(LoggerType loggerType, String message) {
        if (loggerType == LoggerType.DEBUG) {
            System.out.println("DEBUG: " + message);
            return;
        }
        super.log(loggerType, message);
    }
}

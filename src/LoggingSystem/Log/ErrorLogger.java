package LoggingSystem.Log;

public class ErrorLogger extends Logger {
    public ErrorLogger(Logger nextLogger) {
        super(nextLogger);
    }

    public void log(LoggerType loggerType, String message) {
        if (loggerType == LoggerType.ERROR) {
            System.out.println("ERROR: " + message);
            return;
        }
        super.log(loggerType, message);
    }
}

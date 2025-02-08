package LoggingSystem.Log;

public class InfoLogger extends Logger {
    public InfoLogger(Logger nextLogger) {
        super(nextLogger);
    }

    public void log(LoggerType loggerType, String message) {
        if (loggerType == LoggerType.INFO) {
            System.out.println("INFO: " + message);
            return;
        }
        super.log(loggerType, message);
    }
}

package LoggingSystem.Log;

@FunctionalInterface
public interface LoggerInterface {
    void log(LoggerType loggerType, String message);
}

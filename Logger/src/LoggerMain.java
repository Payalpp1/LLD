import models.LoggerClient;
import models.LoggerImplementation;

public class LoggerMain {
    public static void main( String[] args ){
        LoggerImplementation logger = LoggerImplementation.loggerInstance();
        logger.start("A");
        logger.start("B");
        logger.end("A");
        logger.end("B");
        logger.poll();
        logger.poll();
    }
}

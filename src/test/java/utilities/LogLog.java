package utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import tests.testCases.TestCase1;

public class LogLog {

    //I used logger for each class because to log class name to log file
    static Logger logger = Logger.getLogger(TestCase1.class);

    //This constructor to configure log4j.xml file
    public LogLog() {
        DOMConfigurator.configure("log4j.xml");
    }

    public static void info(String message){
        logger.info(message);
    }

    public static void error(String message){
        logger.error(message);
    }
}

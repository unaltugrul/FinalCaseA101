package utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import tests.testCases.TestCase1;
import tests.testCases.TestCase2;

public class LogLog {

    //I used logger for each class because to log class name to log file
    static Logger logger1 = Logger.getLogger(TestCase1.class);
    static Logger logger2 = Logger.getLogger(TestCase2.class);

    //This constructor to configure log4j.xml file
    public LogLog() {
        DOMConfigurator.configure("log4j.xml");
    }

    public static void info1(String message){
        logger1.info(message);
    }

    public static void error1(String message){
        logger1.error(message);
    }

    public static void info2(String message){
        logger2.info(message);
    }

    public static void error2(String message){
        logger2.info(message);
    }
}

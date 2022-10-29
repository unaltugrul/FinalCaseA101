package utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import tests.testCases.TestCase1;
import tests.testCases.TestCase2;

public class LogLog {

    //I used logger for each class because to log class name clearly to log file
    Logger loggerForListener = Logger.getLogger(ListenerClass.class);
     Logger logger1 = Logger.getLogger(TestCase1.class);
     Logger logger2 = Logger.getLogger(TestCase2.class);

    //This constructor to configure log4j.xml file
    public LogLog() {
        DOMConfigurator.configure("log4j.xml");
    }

    //--------------> for listener class
    public void info(String message){
        loggerForListener.info(message);
    }

    public void error(String message){
        loggerForListener.error(message);
    }
    //---------------------

    //--------------> for TestCase1 Class
    public void info1(String message){
        logger1.info(message);
    }

    public void error1(String message){
        logger1.error(message);
    }
    //---------------------

    //--------------> for TestCase2 Class

    public void info2(String message){
        logger2.info(message);
    }

    public void error2(String message){
        logger2.info(message);
    }
    //---------------------

}

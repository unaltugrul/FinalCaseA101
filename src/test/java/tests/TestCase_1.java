package tests;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import tests.base.TestBase;

public class TestCase_1 extends TestBase {

    Logger logger = Logger.getLogger(TestCase_1.class);

    public TestCase_1(){
        DOMConfigurator.configure("log4j.xml");
    }



}

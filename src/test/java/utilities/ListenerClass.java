package utilities;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class ListenerClass extends TestListenerAdapter {

    LogLog logLog = new LogLog();
    @Override
    public void onTestSuccess(ITestResult tr) {
        super.onTestSuccess(tr);
        logLog.info("TEST that named " + tr.getName() + " EXECUTED SUCCESSFULLY!");
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        super.onTestFailure(tr);
        logLog.error("TEST" + tr.getName() + "FAILED!");
    }

    @Override
    public void onStart(ITestContext testContext) {
        super.onStart(testContext);
        logLog.info("Welcome to the test execution of this web application. I will be testing two scenarios. Please wait, loading...");
    }

    @Override
    public void onFinish(ITestContext testContext) {
        super.onFinish(testContext);
        logLog.info("FINISHED...");
    }
}

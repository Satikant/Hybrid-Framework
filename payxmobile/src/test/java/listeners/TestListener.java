package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;
import reportManagement.ExtentManager;

public class TestListener implements ITestListener {



    public void onTestStart(ITestResult result) {
        System.out.println("Starting Test:" +result.getMethod().getMethodName());
        System.out.println("bbb"+result.getName());
        System.out.println("ccc"+result.getMethod().getId());
//        ExtentManager.getTest().info("Starting Test :"+result.getMethod().getMethodName());
    }


    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed");
    }


    public void onTestFailure(ITestResult result) {

    }


    public void onTestSkipped(ITestResult result) {

    }


    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }


    public void onStart(ITestContext context) {

    }


    public void onFinish(ITestContext context) {

    }
}

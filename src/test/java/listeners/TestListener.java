package listeners;

import org.testng.*;
import reporting.ExtentManager;
import reporting.ExtentTestManager;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        ExtentManager.getReport();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTestManager.setTest(
                ExtentManager.getReport().createTest(result.getMethod().getMethodName())
        );
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        if (ExtentTestManager.getTest() != null) {
            ExtentTestManager.getTest().pass("Test Passed");
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        if (ExtentTestManager.getTest() != null) {
            String path = ScreenshotUtil.capture(result.getName());
            ExtentTestManager.getTest()
                    .fail(result.getThrowable())
                    .addScreenCaptureFromPath(path);
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentManager.getReport().flush();
    }
}

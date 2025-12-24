package listeners;

import org.slf4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;

import base.Base;
import utils.LoggerHelper;
import utils.ScreenshotUtil;

public class TestListener extends Base implements ITestListener {

	private static final Logger logger = LoggerHelper.getLogger(TestListener.class);

	@Override
	public void onTestStart(ITestResult testResult) {
		logger.info(">>> Starting test: " + testResult.getName());
		extentTest = extentReports.createTest(testResult.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult testResult) {
		logger.info("✔ Passed: " + testResult.getName());
		extentTest.pass(testResult.getName() + " is passed");
	}

	@Override
	public void onTestFailure(ITestResult failedTest) {
		logger.info("✘ Failed: " + failedTest.getName());
		if (failedTest.getStatus() == ITestResult.FAILURE) {
			String screenshotPath = null;
			screenshotPath = ScreenshotUtil.CaptureScreenshot(failedTest.getName() + ".png");
			// extentTest.addScreenCaptureFromPath(screenshotPath);
			extentTest.fail(failedTest.getThrowable(),
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			extentTest.fail(failedTest.getName() + " is failed");
		}
//		System.out.println("✘ Failed: " + failedTest.getName());
//		if (failedTest.getThrowable() != null) {
//			System.out.println("Reason: " + failedTest.getThrowable().getMessage());
//		}
//		ScreenshotUtil.CaptureScreenshot(failedTest.getTestContext().getName()+"_"+failedTest.getName() + ".jpg");
	}

	@Override
	public void onTestSkipped(ITestResult skippedTest) {
		logger.info("↷ Skipped: " + skippedTest.getName());
		extentTest.skip(skippedTest.getName() + " is skipped");
		if (skippedTest.getThrowable() != null) {
			System.out.println("Skip reason: " + skippedTest.getThrowable().getMessage());
		}
	}

	@Override
	public void onStart(ITestContext testContext) {
		logger.info("=== Starting test group: " + testContext.getName() + " ===");
		// extentTest = extentReports.createTest(testContext.getName());
		// -- this for extent reports per class
	}

	@Override
	public void onFinish(ITestContext testContext) {
		logger.info("=== Finished test group: " + testContext.getName() + " ===");
	}

}

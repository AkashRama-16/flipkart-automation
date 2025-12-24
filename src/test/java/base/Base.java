package base;

import java.time.Duration;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.LoggerHelper;

public class Base {
	// private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	public static WebDriver driver;
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;
	private static final Logger logger = LoggerHelper.getLogger(Base.class);

	@BeforeClass
//	public void setUp(String browser) throws Exception {
//		switch (browser.toLowerCase()) {
//		case "chrome":
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//			driver.manage().window().maximize();
//			break;
//		case "edge":
//			WebDriverManager.edgedriver().setup();
//			driver = new EdgeDriver();
//			driver.manage().window().maximize();
//			break;
//		case "firefox":
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//			driver.manage().window().maximize();
//			break;
//		default:
//			throw new Exception("Invalid browser name");
//		}
//	}
	public void setUp(ITestContext context) {
		WebDriverManager.chromedriver().setup();
//		WebDriver webDriver = new ChromeDriver();
//		webDriver.manage().window().maximize();
//		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();

		driver = RemoteWebDriver.builder().address("http://localhost:4444").oneOf(options).build();
		logger.info("Browser initiated");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Store in thread-local storage
		// driver.set(webDriver);
		Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities();
		extentReports.setSystemInfo("Browser", capabilities.getBrowserName() + " "
				+ capabilities.getBrowserVersion().substring(0, capabilities.getBrowserVersion().indexOf(".")));
		driver.get("https://www.flipkart.com/");
		logger.info("Navigated to Flipkart URL");
		// Create a setup-level log (optional)
//	    ExtentTest setupLog = extentReports.createTest(context.getName() + " - Setup");
//	    setupLog.info("Browser launched and navigated to Flipkart homepage.");
		// extentTest.info("Navigated to Flipkart page");
		// Open URL
		// getDriver().get("https://www.flipkart.com/");
	}

	// Get driver for current thread
//	public static WebDriver getDriver() {
//		return driver.get();
//	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		logger.info("Browser closed");
//		if (getDriver() != null) {
//			getDriver().quit();
//			driver.remove(); // clean up thread-local
//		}
	}

//	@BeforeSuite
//	public void initializeExtentReports() throws IOException {
//		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("Report.html");
//		sparkReporter.loadJSONConfig(new File("./src/test/java/utils/extent-config.json"));
//		extentReports = new ExtentReports();
//		extentReports.attachReporter(sparkReporter);
//		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
//		extentReports.setSystemInfo("Java version", System.getProperty("java.version"));
//		extentReports.setSystemInfo("Tester", "Akash G");
//		extentReports.setSystemInfo("Framework", "Selenium TestNG POM");
//	}
//
//	@AfterSuite
//	public void generateExtentReports() throws IOException {
//		extentReports.flush();
//		Desktop.getDesktop().browse(new File("Report.html").toURI());
//	}

//	@BeforeMethod
//	public void startTest(ITestContext context) {
//		extentTest = extentReports.createTest(context.getName());
//		
//	}

//	@AfterMethod()
//	public void checkStatus(Method m, ITestResult result) {
//		if (result.getStatus() == ITestResult.FAILURE) {
//			String screenshotPath = null;
//			screenshotPath = ScreenshotUtil.CaptureScreenshot(result.getName() + ".png");
//			// extentTest.addScreenCaptureFromPath(screenshotPath);
//			extentTest.fail(result.getThrowable(),
//					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
////			extentTest.fail(MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
////			extentTest.fail(result.getThrowable());
//		} else if (result.getStatus() == ITestResult.SUCCESS) {
//			extentTest.pass(m.getName() + " is passed");
//		}
//	}
}

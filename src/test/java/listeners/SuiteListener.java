package listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.testng.ISuite;
import org.testng.ISuiteListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import base.Base;
import utils.LoggerHelper;

public class SuiteListener extends Base implements ISuiteListener {

	private static final Logger logger = LoggerHelper.getLogger(SuiteListener.class);

	@Override
	public void onStart(ISuite suite) {
		logger.info(">>> Starting Suite: " + suite.getName());
		ExtentSparkReporter spark = new ExtentSparkReporter("Report.html");
		try {
			spark.loadJSONConfig(new File("./src/test/java/resources/extent-config.json"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentReports = new ExtentReports();
		extentReports.attachReporter(spark);
		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
		extentReports.setSystemInfo("Java version", System.getProperty("java.version"));
		extentReports.setSystemInfo("Tester", "Akash G");
		extentReports.setSystemInfo("Framework", "Selenium TestNG POM");
	}

	@Override
	public void onFinish(ISuite suite) {
		logger.info("<<< Finishing Suite: " + suite.getName());
		extentReports.flush();
		try {
			Desktop.getDesktop().browse(new File("Report.html").toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
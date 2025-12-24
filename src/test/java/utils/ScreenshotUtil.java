package utils;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;

import base.Base;

public class ScreenshotUtil extends Base{
	private static final Logger logger = LoggerHelper.getLogger(ScreenshotUtil.class);
	private static String screenShotSubFolder = null;
	static String path = null;

	public static String CaptureScreenshot(String fileName) {
		// Get driver from Base class (thread-safe)
		//WebDriver driver = Base.getDriver();
		if (driver == null) {
			throw new RuntimeException("WebDriver is null. Cannot take screenshot!");
		}
		if (screenShotSubFolder == null) {
			LocalDateTime now = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
			screenShotSubFolder = now.format(formatter);
		}
		try {
			TakesScreenshot takescreenshot = (TakesScreenshot) driver;
			File src = takescreenshot.getScreenshotAs(OutputType.FILE);
			path = "./Screenshots/" + screenShotSubFolder + "/" + fileName;
			File des = new File(path);
			FileUtils.copyFile(src, des);
			logger.info("📸 Screenshot saved at: " + path);
		} catch (Exception e) {
			logger.info("❌ Error while saving screenshot: " + e.getMessage());
		}
		return path;
	}
}

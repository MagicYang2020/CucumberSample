package Common;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Common.genericFunctions.getDriversDirectory;
import static java.lang.System.*;

public class driver {
	public static int TimeoutSmall = 3; 
	public static int TimeoutMedium = 30; 
	public static int TimeoutLarge = 60; 

	public enum BrowserType {
		/**
			Chrome
		 */
		CHROME,
		/**
		 Firefox
		 */
		FIREFOX
	}

	private static final Logger LOGGER = Logger.getLogger(driver.class.getName());
	public static WebDriver driver;

	public synchronized static WebDriver getCurrentDriver() {
		if (driver == null) {
			try {
				BrowserType browserType = BrowserType
						.valueOf(genericFunctions.readProper("config.properties", "browser_type"));
				switch (browserType) {
				case FIREFOX:
					setProperty("webdriver.firefox.driver", getDriversDirectory()+"\\geckodriver.exe");
					FirefoxOptions firefoxOptions = new FirefoxOptions();
					driver = new FirefoxDriver(firefoxOptions);
					break;

				case CHROME:
					setProperty("webdriver.chrome.driver", getDriversDirectory()+"\\chromedriver.exe");
					ChromeOptions chromeoptions = new ChromeOptions();
					chromeoptions.addArguments("--disable-application-cache");
					chromeoptions.addArguments("--disable-cache-size=0");
					chromeoptions.addArguments("--aggressive-cache-discard");
					chromeoptions.addArguments("--incognito");
					chromeoptions.addArguments("--disable-cache");
					chromeoptions.addArguments("--start-maximized");
					driver = new ChromeDriver(chromeoptions);
					break;

					default:
						throw new IllegalStateException("Unexpected value: " + browserType);
				}

			} finally {
				Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
			}
		}
		return driver;
	}

	private static class BrowserCleanup implements Runnable {
		public void run() {
			LOGGER.info("Closing the browser");
			close();
		}
	}

	public static void close() {
		try {
			getCurrentDriver().quit();
			driver = null;
			LOGGER.info("closing the browser");
		} catch (UnreachableBrowserException e) {
			LOGGER.info("cannot close browser: unreachable browser");
		}
	}

	public static void takeScreenShot() {
		if (driver == null || driver.getWindowHandles() == null) {
			return;
		}

		String screenshotName = genericFunctions.getCurrentStringDate() + ".png";
		String screenshotPath = genericFunctions.getScreenshotsDirectory();
		TakesScreenshot screenshotImage = ((TakesScreenshot) driver);
		File image = screenshotImage.getScreenshotAs(OutputType.FILE);
		File targetFile = new File(String.format("%s\\%s", screenshotPath, screenshotName));
		try {
			FileUtils.copyFile(image, targetFile);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		report.insertScreenshot(screenshotPath + "\\" + screenshotName);
	}

	public static void loadPage(String url) {
		getCurrentDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		getCurrentDriver().manage().deleteAllCookies();
		getCurrentDriver().get(url);

	}

	public static void waitForPageElementVisible(WebElement element) {
		WebDriverWait waitForElement = new WebDriverWait(getCurrentDriver(), TimeoutSmall);
		waitForElement.until(ExpectedConditions.visibilityOf(element));
	}

	public static Boolean isElementvisible(WebElement element) {
		try {
			waitForPageElementVisible(element);
			return true;
		} catch (WebDriverException e) {
			return false;
		}
	}

	public static void hoverOverElement(WebElement element) {
		Actions action = new Actions(getCurrentDriver());
		action.moveToElement(element).perform();

	}

	public static void clickWebElement(WebElement element) {
		if (element != null) {
			element.click();
		}
	}
	
	public static String getWebElementText(WebElement element) {
		if (element != null) {
			return element.getText();
		}
		return null;
		
	}

	public static void FillTextToWebElement(WebElement element, String text) {
		if (element != null) {
			element.sendKeys(text);

		}
	}

}
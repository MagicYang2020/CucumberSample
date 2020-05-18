package Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import Common.driver;
import Common.genericFunctions;
import Common.report;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class baseTest {

	public static String ReportPath;

	@Before
	public static void BeforeAllTestSetup() {
		// Initialize report
		ReportPath = genericFunctions.getExtentReportsDirectory() + "\\TestReport_" + genericFunctions.getCurrentStringDate() + ".html";
		ExtentHtmlReporter htmlReport = new ExtentHtmlReporter(ReportPath);
		// htmlReport.loadConfig(genericFunctions.GetProjectDirectory() +
		// "\\extent-config.xml");
		report.Extent = new ExtentReports();
		report.Extent.attachReporter(htmlReport);
	}

	@Before
	public static void BeforeScenarioSetup(Scenario scenario) {
		// Initialize driver
		driver.getCurrentDriver();
		// Driver.Initialise(ConfigurationManager.AppSettings.Get("ExecutionBrowserType"));
		report.Test = report.Extent.createTest("Scenario: " + scenario.getName());
	}
	
	@After
	public static void Teardown() {
		report.Extent.flush();
	}
	
}

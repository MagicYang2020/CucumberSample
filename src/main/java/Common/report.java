package Common;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import cucumber.api.Scenario;

public class report {

	public static ExtentReports Extent;
	public static ExtentTest Test;

	public static void stepBegins(Scenario scenario) {
		Test.log(Status.INFO, "Commence: " + scenario.getName());
	}

	public static void pass(String message) {
		Test.log(Status.PASS, message);
	}

	public static void fail(String message) {
		Test.log(Status.FAIL, message);
	}

	public static void error(String message) {
		message = message.replace("<", "&lt;");
		message = message.replace(">", "&gt;");
		Test.log(Status.ERROR, String.format("Error: {0}", message));
	}
	
    public static void insertScreenshot(String screenshotName)
    {
       
       try {
		Test.log(Status.INFO, "", MediaEntityBuilder.createScreenCaptureFromPath(screenshotName).build());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
    }
}

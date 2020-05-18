package Common;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;


public class genericFunctions {
	public static String getProjectDirectory() {
		File directory = new File("");
		String projectDirectory = null;
		try {
			projectDirectory = directory.getCanonicalPath();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return projectDirectory;
	}

	public static String getDriversDirectory() {
		String projectDirectory = getProjectDirectory();
		String driversDirectory = projectDirectory + "\\Static\\Drivers";
		File directory = new File(driversDirectory);
		if (!directory.exists() && !directory.isDirectory()) {
			directory.mkdir();
		}
		return driversDirectory;
	}
	public static String getExtentReportsDirectory() {
		String projectDirectory = getProjectDirectory();
		String extentReportsDirectory = projectDirectory + "\\TestResults\\ExtentReports";
		File directory = new File(extentReportsDirectory);
		if (!directory.exists() && !directory.isDirectory()) {
			directory.mkdir();
		}
		return extentReportsDirectory;
	}

	public static String getScreenshotsDirectory() {
		String projectDirectory = getProjectDirectory();
		String screenshotsDirectory = projectDirectory + "\\TestResults\\Screenshots";
		File directory = new File(screenshotsDirectory);
		if (!directory.exists() && !directory.isDirectory()) {
			directory.mkdir();
		}
		return screenshotsDirectory;
	}

	public static String readProper(String properties, String name) {
		InputStream inputStream = null;
		try {
			inputStream = new BufferedInputStream(new FileInputStream(getProjectDirectory()+ "\\" + properties));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties p = new Properties();
		try {
			assert inputStream != null;
			p.load(inputStream);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return p.getProperty(name);
	}

	public static String getCurrentStringDate() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		return formatter.format(currentTime);
	}	

}

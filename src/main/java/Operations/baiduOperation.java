package Operations;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.support.PageFactory;

import Common.driver;
import Common.genericFunctions;
import Common.report;
import Pages.baiduPage;

public class baiduOperation {

	static baiduPage baiduPage = PageFactory.initElements(driver.getCurrentDriver(), baiduPage.class);

	public static void i_navigate_to_url(String url) throws Exception {

		try {
			driver.loadPage(genericFunctions.readProper("config.properties", url));
			report.pass("Directing browser to: " + genericFunctions.readProper("config.properties", url));
			driver.takeScreenShot();
		} catch (Exception e) {
			report.fail(e.getMessage());
			driver.takeScreenShot();
			throw e;
		}

	}

	public static void i_send_keyword_into_searchbox(String keyword) throws Exception {

		try {
			driver.FillTextToWebElement(baiduPage.searchBox, keyword);
			report.pass("I send " + keyword + " into searchbox");
			driver.takeScreenShot();
		} catch (Exception e) {
			report.fail(e.getMessage());
			driver.takeScreenShot();
			throw e;
		}

	}

	public static void i_click_search_button() throws Exception {

		try {
			driver.clickWebElement(baiduPage.searchButton);
			report.pass("The search button is clicked.");
			driver.takeScreenShot();
		} catch (Exception e) {
			report.fail(e.getMessage());
			driver.takeScreenShot();
			throw e;
		}

	}

	public static void the_correct_search_result_is_returned() {

		try {
			assertTrue("The search result is not returned", driver.isElementvisible(baiduPage.returnedResult));
			report.pass("The correct search result is returned");
			driver.takeScreenShot();
		} catch (AssertionError e) {
			report.fail(e.getMessage());
			driver.takeScreenShot();
			throw e;
		}

	}

}

package Test;

import Operations.baiduOperation;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class test {

	@Given("^I navigate to \"([^\"]*)\"$")
	public void i_navigate_to(String url) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		baiduOperation.i_navigate_to_url(url);
	}

	@When("^I send \"([^\"]*)\" into searchbox$")
	public void i_send_into_searchbox(String keyword) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		baiduOperation.i_send_keyword_into_searchbox(keyword);
	}
	

	@When("^I click search button$")
	public void i_click_search_button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		baiduOperation.i_click_search_button();
	}

	@Then("^The correct search result is returned$")
	public void the_correct_search_result_is_returned() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		baiduOperation.the_correct_search_result_is_returned();
	}

}

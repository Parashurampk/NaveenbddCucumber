package Stepdeff;

import java.util.List;
import DriverFactory.DriverFactory;
import Pages.LoginPageDDTPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageDDTSteps {

	private static String title;
	LoginPageDDTPage loginPageDDTPage = new LoginPageDDTPage(DriverFactory.getDriver());

	@Given("user is already on Login Page")
	public void user_is_already_on_login_page() {
		DriverFactory.getDriver().get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
	}

	@When("title of login page is Account Login")
	public void title_of_login_page_is_account_login() {
		title = loginPageDDTPage.getLoginPageTitle();
		System.out.println("Page title is: " + title);
	}

	@Then("^user enters \"(.*)\" and \"(.*)\"$")
//  @Then("user enters {string} and {string}")
	public void user_enters_and(String username, String password) {
		loginPageDDTPage.enterUserName(username);
		loginPageDDTPage.enterPassword(password);
	}

	// For DataTable login purpose
	@Then("user enters username and password")
	public void user_enters_username_and_password(DataTable credential) {
		List<List<String>> data = credential.asLists();
		loginPageDDTPage.enterUserName(data.get(0).get(0));
		loginPageDDTPage.enterPassword(data.get(0).get(1));
//		String username = data.get(0).get(0);
//		String password = data.get(0).get(1);

	}

	@Then("user clicks on login button")
	public void user_clicks_on_login_button() throws InterruptedException {
		Thread.sleep(3000);
		loginPageDDTPage.clickOnLogin();
	}

	@Then("user is on home page")
	public void user_is_on_home_page() {
		title = loginPageDDTPage.getLoginPageTitle();
		System.out.println("Page title is: " + title);
	}

}

package Stepdeff;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import DriverFactory.DriverFactory;
import Pages.AccountPage;
import Pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountPageSteps {

	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountPage accountPage;

	@Given("user has alredy logged in to application")
	public void user_has_alredy_logged_in_to_application(DataTable cerdTable) throws InterruptedException {
		List<Map<String, String>> credList = cerdTable.asMaps();
		String userName = credList.get(0).get("username");
		String Password = credList.get(0).get("password");
		
		DriverFactory.getDriver().get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		loginPage.doLogin(userName, Password);
	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
		accountPage = new AccountPage(DriverFactory.getDriver());
		String title = accountPage.getAccountPageTitle();
		System.out.println("Account page Title: "+title);

	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable sectiontable) {
		List<String> expAccountSectionList = sectiontable.asList();
		System.out.println("Expected Account Section List: " + expAccountSectionList);

		List<String> actualAccountSectionList = accountPage.getAccountSectionList();
		System.out.println("Actual Account Section List: " + actualAccountSectionList);

		Assert.assertTrue(expAccountSectionList.containsAll(actualAccountSectionList));
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedSectionCount) {
	    Assert.assertEquals(expectedSectionCount, Integer.valueOf(accountPage.getAccountSectionCount()));
	}


}

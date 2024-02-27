package Stepdeff;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import DriverFactory.DriverFactory;
import Pages.IndexPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class IndexPageSteps {

	IndexPage indexPage = new IndexPage(DriverFactory.getDriver());
	
	@Given("user is on index page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver().get("https://naveenautomationlabs.com/opencart/index.php?route=common/home");
	}


	@Then("user gets the menu features name")
	public void user_gets_the_menu_features_name(DataTable featureTable) {

		List<String> expectedFeatureList = featureTable.asList();
		System.out.println("Expected Feature List: " + expectedFeatureList);

		List<WebElement> actualFeatureElements = indexPage.getMenuList();
		List<String> actualFeatureList = actualFeatureElements.stream().map(WebElement::getText)
				.collect(Collectors.toList());
		System.out.println("Actual Feature List: " + actualFeatureList);

		Assert.assertTrue(actualFeatureList.containsAll(expectedFeatureList));
	}

	@Then("user gets the menu features Products name")
	public void user_gets_the_menu_features_Products_name(DataTable featureTable) {
		

		List<String> expectedFeatureProductList = featureTable.asList();
		System.out.println("Expected Feature List: " + expectedFeatureProductList);

		List<WebElement> actualFeatureElements = indexPage.getprouductsName();
		List<String> actualFeatureProductList = actualFeatureElements.stream().map(WebElement::getText)
				.collect(Collectors.toList());
		System.out.println("Actual Feature List: " + actualFeatureProductList);

		Assert.assertTrue(actualFeatureProductList.containsAll(expectedFeatureProductList));
	}

	@Then("menu features count should be {int}")
	public void menu_features_count_should_be(Integer expectedFeatureCount) {
		Assert.assertEquals(expectedFeatureCount, Integer.valueOf(indexPage.geFeatureCount()));
	}

	@Then("menu features products count should be {int}")
	public void menu_features_products_count_should_be(Integer expectedProductFeatureCount) {
		Assert.assertEquals(expectedProductFeatureCount, Integer.valueOf(indexPage.geFeatureProductsCount()));
	}
}

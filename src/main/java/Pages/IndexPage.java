package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IndexPage {
	private WebDriver driver;

	// 1. By Locators: OR
	private By indexElements = By.xpath("//ul[@class='nav navbar-nav']/li");
	private By prouductsName = By.xpath("//div[@class='row']//h4//a");
	private By prouductsPrice = By.xpath("//p[@class='price']]");

	// 2. Constructor of the page class:
	public IndexPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. page actions: features(behavior) of the page the form of methods:

	public List<WebElement> getMenuList() {
		return driver.findElements(indexElements);

	}
	
	public int geFeatureCount() {
	    List<WebElement> featureCount = driver.findElements(indexElements);
	    return featureCount.size();
	}

	public List<WebElement> getprouductsName() {
		return driver.findElements(prouductsName);
	}
	
	public int geFeatureProductsCount() {
	    List<WebElement> featureCount = driver.findElements(prouductsName);
	    return featureCount.size();
	}

	public List<WebElement> getprouductsPrice() {
		return driver.findElements(prouductsPrice);
	}

}
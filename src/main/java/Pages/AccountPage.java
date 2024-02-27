package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {

	private WebDriver driver;

	// 1. By Locators: OR
	private By accountSection = By.xpath("//div[@class=\"list-group\"]//a");

	// 2. Constructor of the page class:
	public AccountPage(WebDriver driver) {
		this.driver = driver;

	}

	// 3. page actions: features(behavior) of the page the form of methods:
	public String getAccountPageTitle() {
		return driver.getTitle();
	}

	public int getAccountSectionCount() {
	    List<WebElement> accountSections = driver.findElements(accountSection);
	    return accountSections.size();
	}


	public List<String> getAccountSectionList() {
		List<String> accountList = new ArrayList<>();
		List<WebElement> accountHeaderList = driver.findElements(accountSection);

		for (WebElement e : accountHeaderList) {
			String text = e.getText();
			accountList.add(text);
		}
		return accountList;
	}
}
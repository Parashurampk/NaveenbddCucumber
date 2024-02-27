package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageDDTPage {
	private WebDriver driver;

	// 1. By Locators: OR
	private By emailID = By.id("input-email");
	private By password = By.id("input-password");
	private By loginButton = By.xpath("//input[@value='Login']");

	// 2. Constructor of the page class:
	public LoginPageDDTPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. page actions: features(behavior) of the page the form of methods:

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public void enterUserName(String username) {
		driver.findElement(emailID).sendKeys(username);
	}

	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}

	public void clickOnLogin() {
		driver.findElement(loginButton).click();
	}

	public AccountPage doLogin(String un, String pwd) {
		System.out.println("loginButton with: " + un + "and" + pwd);
		driver.findElement(emailID).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginButton).click();
		return new AccountPage(driver);
	}
}

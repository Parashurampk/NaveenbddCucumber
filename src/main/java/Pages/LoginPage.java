package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
		private WebDriver driver;

		// 1. By Locators: OR
		 private By emailID=By.id("input-email");
		 private By password=By.id("input-password");
		 private By loginButton=By.xpath("//input[@value='Login']");
		 private By forgotPWDLink=By.xpath("(//a[normalize-space()='Forgotten Password'])[1]");

		// 2. Constructor of the page class:
		public LoginPage(WebDriver driver) {
			this.driver = driver;
		}

		// 3. page actions: features(behavior) of the page the form of methods:

		public String getLoginPageTitle() {
			return driver.getTitle();
		}

		public boolean isForgotPwdLinkExist() {
			return driver.findElement(forgotPWDLink).isDisplayed();
		}

		public void enterUserName(String username) {
		     driver.findElement(emailID).sendKeys(username);
		}

		public void enterPassword(String pwd) {
			driver.findElement(password).sendKeys(pwd);
		}

		public void clickOnLogin()  {
			driver.findElement(loginButton).click();
		}
		
		public AccountPage doLogin(String un, String pwd) throws InterruptedException {
			System.out.println("loginButton with: " + un + "and" + pwd);
			 driver.findElement(emailID).sendKeys(un);
			 driver.findElement(password).sendKeys(pwd);
			 Thread.sleep(5000);
			 driver.findElement(loginButton).click();
			 return new AccountPage(driver);
		}
	}
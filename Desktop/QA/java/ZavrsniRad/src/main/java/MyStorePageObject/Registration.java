package MyStorePageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Registration {
	
	public static final String REG_URL = "http://automationpractice.com/index.php?controller=authentication&multi-shipping=0&display_guest_checkout=0&back=http%3A%2F%2Fautomationpractice.com%2Findex.php%3Fcontroller%3Dorder%26step%3D1%26multi-shipping%3D0";
	WebDriverWait wait;
	
	static By createEmail = By.id("email_create");
	static By buttonCreateEmail = By.id("SubmitCreate");
	static By titleMrs = By.id("id_gender2");
	static By titleMr = By.id("id_gender1");
	static By firstName = By.id("customer_firstname");
	static By lastName = By.id("customer_lastname");
	static By password = By.id("passwd");
	//static By day = By.id("days");
	//static By month = By.id("months");
	static By fnAddress = By.id("firstname");
	static By lnAddress = By.id("lastname");
	static By address = By.id("address1");
	static By city = By.id("city");
	static By state = By.id("id_state");
	static By zipCode = By.id("postcode");
	static By country = By.id("id_country");
	//static By additional = By.id("other");
	static By mobilePhone = By.id("phone_mobile");
	static By addresAlias = By.id("alias");
	static By registerSubmit = By.id("submitAccount");
	
    public static By account = By.xpath("//a[@title='View my customer account']");

	
	public static void EmailInput(WebDriver driver, String textEmail) {
		WebElement element = driver.findElement(createEmail); 
		element.sendKeys(textEmail);
	}
	
	public static void clickCreate(WebDriver driver) {
		WebElement element = driver.findElement(buttonCreateEmail);
		element.click();
	}
	
	public static void clickMr(WebDriver driver) {
		WebElement element = driver.findElement(titleMr);
		element.click();
	}
	
	public static void clickMrs(WebDriver driver) {
		WebElement element = driver.findElement(titleMrs);
		element.click();
	}
	
	public static void firstNameInput(WebDriver driver, String textFirstName) {
		WebElement element = driver.findElement(firstName); 
		element.sendKeys(textFirstName);
	}
	
	public static void lastNameInput(WebDriver driver, String textLastName) {
		WebElement element = driver.findElement(lastName); 
		element.sendKeys(textLastName);
	}
	
	public static void inputPassword(WebDriver driver, String textPassword) {
		WebElement element = driver.findElement(password); 
		
		if(textPassword.length() >= 5) {
			element.sendKeys(textPassword);
		}
		
	}
	
	public static void addressFirstNameInput(WebDriver driver, String textFirstName) {
		WebElement element = driver.findElement(fnAddress); 
		element.sendKeys(textFirstName);
	}
	
	public static void addressLastNameInput(WebDriver driver, String textLastName) {
		WebElement element = driver.findElement(lnAddress); 
		element.sendKeys(textLastName);
	}
	
	public static void addressInput(WebDriver driver, String textAddress) {
		WebElement element = driver.findElement(address); 
		element.sendKeys(textAddress);
	}
	
	public static void cityInput(WebDriver driver, String textCity) {
		WebElement element = driver.findElement(city); 
		element.sendKeys(textCity);
	}
	
	public static void selectState(WebDriver driver, String stateValue) {
		Select chooseState = new Select(driver.findElement(state)); 
		//WebElement element = driver.findElement(selectSize); 
		chooseState.selectByVisibleText(stateValue);
	}
	
	public static void zipCodeInput(WebDriver driver, String textZipCode) {
		WebElement element = driver.findElement(zipCode); 
		element.sendKeys(textZipCode);
	}
	
	public static void selectCountry(WebDriver driver, String countryValue) {
		
		Select chooseState = new Select(driver.findElement(country));  
		chooseState.selectByVisibleText(countryValue);
	}
	
//	public static void additionalInformationInput(WebDriver driver, String text) {
//		WebElement element = driver.findElement(additional); 
//		element.sendKeys(text);
//	}
	
	public static void mobilePhoneInput(WebDriver driver, String textMobilePhone) {
		WebElement element = driver.findElement(mobilePhone); 
		element.sendKeys(textMobilePhone);
	}
	
	public static void aliasAdressInput(WebDriver driver, String textAlias) {
		WebElement element = driver.findElement(addresAlias); 
		element.sendKeys(textAlias);
	}
	
	public static void clickRegister(WebDriver driver) {
		WebElement element = driver.findElement(registerSubmit);
		element.click();
	}
	
	public void waitMrElement(WebDriver driver) {
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(titleMr)); 
	}
	
	public static void clickOnAccount(WebDriver driver) {
		WebElement element = driver.findElement(account);
		element.click();
	}
	
	
	
	
	
}

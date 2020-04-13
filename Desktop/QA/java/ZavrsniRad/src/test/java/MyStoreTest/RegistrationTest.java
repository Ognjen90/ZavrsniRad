package MyStoreTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import MyStorePageObject.Registration;

public class RegistrationTest {

	WebDriver driver;
	Registration regist;
	
	@BeforeClass
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/itbootcamp/selenium/resources/chromedriver.exe"); 
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();		
	}
	
	@Test (priority = 1)
	public void testRegLink() {
		
		driver.get(Registration.REG_URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Registration.EmailInput(driver, "asdew22@fiuk.com");
		Registration.clickCreate(driver);
		
		String currentURL = driver.getCurrentUrl();
		String expectedURL = "http://automationpractice.com/index.php?controller=authentication&multi-shipping=0&display_guest_checkout=0&back=http%3A%2F%2Fautomationpractice.com%2Findex.php%3Fcontroller%3Dorder%26step%3D1%26multi-shipping%3D0#account-creation";
		//Assert.assertEquals(currentURL, expectedURL);
		Assert.assertTrue(expectedURL.contains(currentURL));
	}
	@Test(priority = 2)
	public void fillTheRegisterForm() {
		//regist.waitMrElement(driver);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		Registration.clickMr(driver);
		Registration.firstNameInput(driver, "Muhamed");
		Registration.lastNameInput(driver, "Ali");
		Registration.inputPassword(driver, "a12345");
		Registration.addressFirstNameInput(driver, "Muhamed");
		Registration.addressLastNameInput(driver, "Ali");
		Registration.addressInput(driver, "Manila 1");
		Registration.cityInput(driver, "Philadelfia");
		Registration.selectState(driver, "Ohio");
		Registration.zipCodeInput(driver, "89324");
		Registration.selectCountry(driver, "United States");
		Registration.mobilePhoneInput(driver, "0605522233");
		Registration.aliasAdressInput(driver, "Severni bulevar 25");
		Registration.clickRegister(driver);
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Registration.clickOnAccount(driver);
		String expectedURL ="http://automationpractice.com/index.php?controller=my-account";
		String currentURL = driver.getCurrentUrl();
		Assert.assertEquals(currentURL, expectedURL);
		
	}
}

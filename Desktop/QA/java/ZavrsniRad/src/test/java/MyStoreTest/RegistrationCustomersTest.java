package MyStoreTest;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import MyStorePageObject.CustomersDataConfig;
import MyStorePageObject.Registration;

public class RegistrationCustomersTest {
    
	WebElement IsSignedIn;
	WebElement signOut;
	WebDriver driver;
	Registration regist;
	CustomersDataConfig customers = new CustomersDataConfig("C:\\Users\\user\\Desktop\\Customers.xlsx");
	
	@BeforeClass
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/itbootcamp/selenium/resources/chromedriver.exe"); 
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get(Registration.REG_URL);
		
	}
	
	@Test 
	public void testRegLink() {
		for(int i = 1;i<=30;i++) {
		SoftAssert softAssertion= new SoftAssert();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Registration.EmailInput(driver, customers.getCustomers( i, 13));
		Registration.clickCreate(driver);	
//		String currentURL = driver.getCurrentUrl();
//		String expectedURL = "http://automationpractice.com/index.php?controller=authentication&multi-shipping=0&display_guest_checkout=0&back=http%3A%2F%2Fautomationpractice.com%2Findex.php%3Fcontroller%3Dorder%26step%3D1%26multi-shipping%3D0#account-creation";
		
		//softAssertion.assertEquals(currentURL, expectedURL);
		
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String mrs = "Mrs";
		if(customers.getCustomers( i, 0).contentEquals(mrs)) {
			Registration.clickMrs(driver);
		}else {
		Registration.clickMr(driver);
		}
		Registration.firstNameInput(driver, customers.getCustomers( i, 1));
		Registration.lastNameInput(driver, customers.getCustomers( i, 2));
		Registration.inputPassword(driver, customers.getCustomers( i, 3));
		Registration.addressFirstNameInput(driver, customers.getCustomers( i, 4));
		Registration.addressLastNameInput(driver, customers.getCustomers( i, 5));
		Registration.addressInput(driver, customers.getCustomers( i, 6));
		Registration.cityInput(driver, customers.getCustomers( i, 7));
		Registration.selectState(driver, customers.getCustomers( i, 8));
		Registration.zipCodeInput(driver, customers.getCustomers( i, 9));
		Registration.selectCountry(driver, customers.getCustomers( i, 10));
		Registration.mobilePhoneInput(driver,customers.getCustomers( i, 11));
		Registration.aliasAdressInput(driver, customers.getCustomers( i, 12));
		Registration.clickRegister(driver);
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Registration.clickOnAccount(driver);
		IsSignedIn = driver.findElement(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a/span"));
		softAssertion.assertEquals(true,IsSignedIn.isDisplayed());
		softAssertion.assertAll();
     	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		signOut = driver.findElement(By.xpath("//a[@title='Log me out']"));
		signOut.click();
		
		}
	}
	
	@AfterClass
	public void closeBrowser() {		
		driver.quit();
	}
}

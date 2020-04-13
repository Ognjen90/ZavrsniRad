package MyStoreTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import MyStorePageObject.CustomersDataConfig;
import MyStorePageObject.SignIn;

public class SignInTest {
	
	CustomersDataConfig customers = new CustomersDataConfig("C:\\Users\\user\\Desktop\\Customers.xlsx");
	WebDriver driver;
	WebElement signOut;
	
	@BeforeClass
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/itbootcamp/selenium/resources/chromedriver.exe"); 
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get(SignIn.signInURL);
		
	}
	@Test
	public void testSignIn() {
		for(int i = 1;i<=30;i++) {
			SoftAssert softAssertion= new SoftAssert();
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			SignIn.emailInput(driver, customers.getCustomers( i, 13));
			SignIn.passwordInput(driver, customers.getCustomers( i, 3));
			SignIn.clicksignIn(driver);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			signOut = driver.findElement(By.xpath("//a[@title='Log me out']"));
			softAssertion.assertEquals(true, signOut.isDisplayed());
			signOut.click();
			
		}
	}
	
	@AfterClass
	public void closeBrowser() {		
		driver.quit();
	}
	
}

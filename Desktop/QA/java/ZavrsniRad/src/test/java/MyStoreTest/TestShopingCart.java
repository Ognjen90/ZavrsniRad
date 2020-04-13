package MyStoreTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import MyStorePageObject.ShopingCart;

public class TestShopingCart {
	
	WebDriver driver;
	
	

	@BeforeClass
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/itbootcamp/selenium/resources/chromedriver.exe"); 
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();		
	}
	
	@Test (priority = 1)
	public void testSummerDressLink() {
		// postavlja url u browser
		driver.get(ShopingCart.summerDressURL);
		//SoftAssert softAssert = new SoftAssert();
		// prelazi preko slike
		ShopingCart.hoverOnMenuWomanElement(driver);
		ShopingCart.clickOnDressesSummerDresses(driver);
		
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = "http://automationpractice.com/index.php?id_product=5&controller=product"; 
		Assert.assertEquals(currentUrl, expectedUrl);
		
		
	}
	
	@Test (priority = 2)
	public void addToCart() {
		
	    ShopingCart.inputQuantity(driver,"2");
		ShopingCart.selectSize(driver,"M");
		ShopingCart.clickOnBlueColor(driver);
		ShopingCart.clickOnAddToCartButton(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		ShopingCart.clickOnCloseShopingSummary(driver);
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = "http://automationpractice.com/index.php?id_product=5&controller=product#/color-blue/size-m"; 
		Assert.assertEquals(currentUrl, expectedUrl);
		
				
	}
	@Test (priority = 3)
	public void checkingShopingCart() {

		    ShopingCart.clickOnCheckShopingCart(driver);
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   
		    ShopingCart.clickOnProceedToCheckout(driver);
		   
		    String currentUrl = driver.getCurrentUrl();
		    String expectedUrl = "http://automationpractice.com/index.php?controller=authentication&multi-shipping=0&display_guest_checkout=0&back=http%3A%2F%2Fautomationpractice.com%2Findex.php%3Fcontroller%3Dorder%26step%3D1%26multi-shipping%3D0";
		    Assert.assertEquals(currentUrl, expectedUrl);	
	}
	@AfterClass
	public void closeBrowser() {		
		driver.quit();
	}
}

package MyStoreTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import MyStorePageObject.HomePage;


public class TestHomePage {
	WebDriver driver;
	
	@BeforeClass
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/itbootcamp/selenium/resources/chromedriver.exe"); 
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();		
	}
	@Test (priority = 1)
	public void testWomanLink() {//testiranje ucitavanja summer dresses preko nav woman
		// postavlja url u browser
		driver.get(HomePage.HOME_URL);
		
		// prelazi preko menu-a
		HomePage.hoverOnMenuWomanElement(driver);
		HomePage.waitDressesElement(driver);
		HomePage.clickOnWomanDressesSummerDresses(driver);
		
		
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = "http://automationpractice.com/index.php?id_category=11&controller=category"; 
		Assert.assertEquals(currentUrl, expectedUrl);
		//Assert.assertTrue(currentUrl.contains(expectedUrl));
		
	}
	@Test (priority = 2)
	public void testDressesLink() {////testiranje ucitavanja summer dresses preko nav dresses
		try {
			//driver.navigate().to(HomePage.HOME_URL);//get(HomePage.HOME_URL);
			HomePage.waitDressesElement(driver);
			// prelazi preko menu-a
			HomePage.hoverOnMenuDressesElement(driver);
			HomePage.waitDressesElement(driver);
			HomePage.clickOnDressesSummerDresses(driver);
//		
			
			String currentUrl = driver.getCurrentUrl();
			String expectedUrl = "http://automationpractice.com/index.php?id_category=11&controller=category"; 
			Assert.assertEquals(currentUrl, expectedUrl);
			//Assert.assertTrue(currentUrl.contains(expectedUrl));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDoesLinksEquals() {
		String womanLink = "http://automationpractice.com/index.php?id_category=11&controller=category";
		String dressesLink = "http://automationpractice.com/index.php?id_category=11&controller=category";
		Assert.assertEquals(womanLink,dressesLink);
	}
	
	@AfterClass
	public void closeBrowser() {		
		driver.quit();
	}
	
}

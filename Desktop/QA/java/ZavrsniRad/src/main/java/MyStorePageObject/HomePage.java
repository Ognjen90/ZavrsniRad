package MyStorePageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	public static String HOME_URL = "http://automationpractice.com/index.php"; 
    public static By woman = By.xpath("//a[@title='Women']") ;
    public static By dresses = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a"); //("//a[@title='Dresses']");
    public static By summerD = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[3]/a"); //("//a[@title='Summer Dresses']");
    public static By summerDW = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[2]/ul/li[3]/a");
    public static WebDriverWait wait;
    
	public static void hoverOnMenuWomanElement(WebDriver driver) {
		Actions action = new Actions(driver);
		WebElement womanLink = driver.findElement(woman); 
		action.moveToElement(womanLink).perform();
	}
	public static void hoverOnMenuDressesElement(WebDriver driver) {
		Actions action = new Actions(driver);
		WebElement dressesLink = driver.findElement(dresses); 
		action.moveToElement(dressesLink).perform();
	}
    
	public static void clickOnDressesSummerDresses(WebDriver driver) {
		
		WebElement sdLink = driver.findElement(summerD); 
		sdLink.click();
	}
    public static void clickOnWomanDressesSummerDresses(WebDriver driver) {
		
		WebElement sdLink = driver.findElement(summerDW); 
		sdLink.click();
	}

	public static void waitDressesElement(WebDriver driver) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(dresses)); 
	}
	
}

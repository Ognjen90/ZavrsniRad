package MyStorePageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ShopingCart {

	public static String summerDressURL = "http://automationpractice.com/index.php?id_category=11&controller=category";
	public static By firstDress = By.xpath("//*[@id=\'center_column\']/ul/li[1]");
	public static By buttonMore = By.xpath("//*[@id='center_column']/ul/li[1]/div/div[2]/div[2]/a[2]");
    public static By inputQuantity = By.name("qty");
    public static By selectSize = By.id("group_1");
	//private By selectSizea = By.xpath("//*[@id=\'uniform-group_1\']/span");
    public static By blueColor = By.xpath("//*[@id=\'color_14\']");
    public static By addToCartButton = By.xpath("//*[@id=\'add_to_cart\']/button");
    public static By x = By.xpath("//span[@title='Close window']") ;
    public static By checkShopingCart = By.xpath("//a[@title='View my shopping cart']") ;
    public static By proceed = By.xpath("//a[@title='Proceed to checkout']");
    public static By proceedA = By.xpath("//*[@id=\'center_column\']/p[2]/a[1]");
    
	public static void hoverOnMenuWomanElement(WebDriver driver) {
		
		Actions action = new Actions(driver);
		WebElement firstDressLink = driver.findElement(firstDress); 
		action.moveToElement(firstDressLink).perform();
	}
   
	public static void clickOnDressesSummerDresses(WebDriver driver) {
		
		WebElement bm = driver.findElement(buttonMore); 
		bm.click();
	}
	
	public static void inputQuantity(WebDriver driver, String quantity) {
		WebElement element = driver.findElement(inputQuantity); 
		element.clear();
		element.sendKeys(quantity);
	}
	
	public static void selectSize(WebDriver driver, String size) {
		Select chooseSize = new Select(driver.findElement(selectSize)); 
		//WebElement element = driver.findElement(selectSize); 
		chooseSize.selectByVisibleText(size);
	}
	
	public static void clickOnBlueColor(WebDriver driver) {
		WebElement bc = driver.findElement(blueColor);
		bc.click();
    }
	
	public static void clickOnAddToCartButton(WebDriver driver) {
		WebElement atcb = driver.findElement(addToCartButton);
		atcb.click();
	}
//	public static void hoverOnCheckShopingCart(WebDriver driver) {
//		Actions action = new Actions(driver);
//		WebElement cscLink = driver.findElement(checkShopingCartA); 
//		action.moveToElement(cscLink).perform();
//	}
    public static void clickOnCloseShopingSummary(WebDriver driver) {
		
		WebElement close = driver.findElement(x); 
		close.click();
	}
    
    public static void clickOnCheckShopingCart(WebDriver driver) {
		
		WebElement csc = driver.findElement(checkShopingCart); 
		csc.click();
	}
    
    public static void clickOnProceedToCheckout(WebDriver driver) {
		
		WebElement coptc = driver.findElement(proceedA); 
		coptc.click();
	}
	
}

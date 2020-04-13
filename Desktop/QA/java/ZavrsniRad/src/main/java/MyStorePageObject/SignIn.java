package MyStorePageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignIn {
    public static String signInURL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	public static By email = By.id("email");
	public static By pasword = By.id("passwd");
    public static By signIn =By.id("SubmitLogin"); 
    
	
    public static void passwordInput(WebDriver driver, String passwordText) {
		WebElement element = driver.findElement(pasword); 
		element.sendKeys(passwordText);
	}
    
    public static void emailInput(WebDriver driver, String emailText) {
		WebElement element = driver.findElement(email); 
		element.sendKeys(emailText);
	}
    
	public static void clicksignIn(WebDriver driver) {
		WebElement element = driver.findElement(signIn);
		element.click();
	}
}

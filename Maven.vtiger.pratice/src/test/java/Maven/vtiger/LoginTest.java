package Maven.vtiger;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	
	@Test
	public void logInToApp() {
		String url= System.getProperty("url");
		String browser= System.getProperty("browser");
		String username= System.getProperty("username");
		String password= System.getProperty("password");
		//validate 
		WebDriver driver= null;
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
		}
		// log in browser 
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		//log out
		 WebElement wb =driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
 		Actions act = new Actions(driver);
 		act.moveToElement(wb).perform();
 		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();
			 
	}	

}


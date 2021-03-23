package package1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {
	
	String baseURL="https://opensource-demo.orangehrmlive.com/index.php/auth/login";
	WebDriver driver;
	
	By userName=By.id("txtUsername");
	By password=By.id("txtPassword");
	By loginBtn=By.id("btnLogin");
	By dashboard=By.xpath("//h1[contains(text(),'Dashboard')]");
	By forgetPassword=By.xpath("//a[contains(text(),'Forgot your password?')]");
	
	@Test
	public void verifyForgetPassword() {
		String actualLinkText = driver.findElement(forgetPassword).getText();
		String expectedLinkText = "Forgot your password?";
		Assert.assertEquals(actualLinkText, expectedLinkText);
	}
	@Test
	public void verifyPageTitle() {
		
		String expectedTitle="OrangeHRM";
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	@Test
	public void login() {
		
		driver.findElement(userName).sendKeys("Admin");
		driver.findElement(password).sendKeys("admin123");
		driver.findElement(loginBtn).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(driver.findElement(dashboard).isDisplayed());
		
		
	}
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(baseURL);
	}
	@AfterMethod
	public void terminateBrowser() {
		driver.close();
	}

}

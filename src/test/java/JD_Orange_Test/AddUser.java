package JD_Orange_Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddUser {
	@Test
	public void SignOn() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login"); // navigate() remembers
																								// history and cookies ,
																								// get() does not
		Thread.sleep(10000);
		driver.manage().window().maximize();
		driver.findElement(By.name("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.linkText("Dashboard")).isDisplayed();
		WebElement admin = driver.findElementById("menu_admin_viewAdminModule");

		Actions action = new Actions(driver);

		action.moveToElement(admin).build().perform();
		WebElement usermanagement = driver.findElementByLinkText("User Management");
		action.moveToElement(usermanagement).build().perform();
		// Thread.sleep(5000);
		driver.findElementByLinkText("Users").click();
		driver.findElementById("btnAdd").click();
		Select userRole = new Select(driver.findElementById("systemUser_userType"));
//		userRole.selectByVisibleText("Admin");
//		userRole.selectByValue("1");
		userRole.selectByIndex(1);
		Thread.sleep(500);
		driver.findElementById("systemUser_employeeName_empName").sendKeys("Priyanka");
		driver.findElementById("systemUser_userName").sendKeys("Priya");;		
		Select status = new Select(driver.findElementById("systemUser_status"));
		status.selectByIndex(1);
		
		driver.findElementById("systemUser_password").sendKeys("PrayanPriyanka");
		driver.findElementById("systemUser_confirmPassword").sendKeys("PrayanPriyanka");
		driver.findElementById("btnSave").click();
		Thread.sleep(500);
		
	}

	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
	}

}

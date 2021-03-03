package SingleExtentReport;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login_Key_Operations {
	ChromeDriver driver = null;
  @Test
  public void Login() {
	  driver.findElement(By.name("txtUsername")).sendKeys("Admin",Keys.TAB,"admin123",Keys.ENTER);
		driver.findElement(By.linkText("Dashboard")).isDisplayed();	  
  }
  @BeforeTest
	public void beforeTest() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		Thread.sleep(10000);
	}
	  @AfterTest
	  public void afterTest() {
		// driver.close();//Close the Current Browser
				driver.quit();// Close All the browser opened by Selenium
	  }
	  @Test(priority=1)
	  public void Logout() throws InterruptedException {

		  driver.findElement(By.id("welcome")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.linkText("Logout")).click();
	  }
}

package JD_Orange_Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Login_headless_browser {
	//ChromeDriver driver = null;
	EdgeDriver driver = null;
  @Test
  public void Login_Test() throws Exception {	 
	  //beforeTest();
      driver.findElement(By.name("txtUsername")).sendKeys("admin");
      driver.findElement(By.id("txtPassword")).sendKeys("admin123");
      driver.findElement(By.id("btnLogin")).click();
      driver.findElement(By.linkText("Dashboard")).isDisplayed();
      //afterTest();
  }
  @Test
  public void Logout_Test()
  {
	  
  }
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  
//	  WebDriverWait wait = new WebDriverWait(driver, 60);
//	  WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Logout")));
//	  String ActText=element.getText();
//	  System.out.println(ActText);
//	  element.click();

	  WebDriverManager.edgedriver().setup();
	  //ChromeOptions options = new ChromeOptions();
	 // options.setHeadless(false);
	  //options.addArguments("incognito");
	  //driver = new ChromeDriver(options);
	  driver = new EdgeDriver();
	  driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	  driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	  Thread.sleep(10000);
  }

  @AfterTest
  public void afterTest() {
      driver.quit();
  }

}

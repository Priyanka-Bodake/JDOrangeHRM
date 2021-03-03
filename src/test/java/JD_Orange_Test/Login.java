package JD_Orange_Test;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Login {
  @Test
 // public void Login_Test() throws Exception {	 
	 // WebDriverManager.chromedriver().setup();
	// ChromeDriver driver = new ChromeDriver();
	  //WebDriverManager.edgedriver().setup();
	  //EdgeDriver driver = new EdgeDriver();
	//  driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	//  Thread.sleep(10000);
    //  driver.findElement(By.name("txtUsername")).sendKeys("admin");
     // driver.findElement(By.id("txtPassword")).sendKeys("admin123");
    //  driver.findElement(By.id("btnLogin")).click();
    //  driver.findElement(By.linkText("Dashboard")).isDisplayed();
      //driver.quit();
 // }
  
 public void Login_Test() throws Exception {
	  
	  
	  WebDriverManager.chromedriver().setup();
	  ChromeDriver driver = new ChromeDriver();
	  driver.switchTo().frame("login_page");

	 // WebDriverManager.edgedriver().setup();
	  //EdgeDriver driver = new EdgeDriver();
	  driver.navigate().to(" https://netbanking.hdfcbank.com/netbanking/");
	  //Thread.sleep(10000);
	  driver.findElement(By.name("fldLoginUserId")).sendKeys("123");
	  //driver.findElement(By.linkText("javascript:void(0)")).click();
	  driver.findElementByXPath("//tbody/tr/td/a/img[1]").click();
	  driver.switchTo().defaultContent();
	  driver.switchTo().frame(1);
	  driver.findElementByLinkText("Terms and Conditions").click();
	 // driver.findElement(By.id("txtPassword")).sendKeys("admin123");
//	  driver.findElement(By.id("btnLogin")).click();
//	  driver.findElement(By.linkText("Dashboard")).isDisplayed();
	  driver.quit();
 }
 
  @BeforeTest
  public void beforeTest() {

  }

  @AfterTest
  public void afterTest() {

  }

}

package SingleExtentReport;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Double_Click {
	ChromeDriver driver = null;
  @Test
  public void DragDrop() throws InterruptedException {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
			 
	  driver.navigate().to("https://www.testandquiz.com/selenium/testing.html");
	  Thread.sleep(10000);
	  Actions action = new Actions(driver);
	  WebElement doubleClick = driver.findElement(By.id("dblClkBtn"));
	  action.doubleClick(doubleClick).build().perform();
	  driver.switchTo().alert().accept();
	  //Thread.sleep(100);	
	 // action.contextClick(doubleClick).doubleClick();

  }
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}

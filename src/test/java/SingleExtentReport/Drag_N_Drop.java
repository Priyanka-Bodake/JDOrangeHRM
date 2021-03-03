package SingleExtentReport;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Drag_N_Drop {
	ChromeDriver driver = null;
  @Test
  public void DragDrop() throws InterruptedException {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
			 
	  driver.navigate().to("https://jqueryui.com/resources/demos/droppable/default.html");
	  Thread.sleep(10000);
	  Actions action = new Actions(driver);
	  WebElement drag = driver.findElement(By.id("draggable"));
	  WebElement drop = driver.findElement(By.id("droppable"));
	  action.dragAndDrop(drag, drop).build().perform();
	  Thread.sleep(100);		  

  }
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}

package JD_Orange_Test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Handling_Different_Objects {
	//ChromeDriver driver;
	EdgeDriver driver;
  @Test(priority=7)
  public void RadioButton() {
	  driver.findElementById("female").click();
	  boolean actualVaL = driver.findElementById("female").isSelected();
	  Assert.assertEquals(actualVaL, true);
  }
  @Test(priority=2)
  public void CheckBox() {
	  //driver.findElementByClassName("Automation").click();
	  driver.findElementByClassName("Performance").click();	
	  
  }
  @Test(priority=3)
  public void SelectDropDown() throws InterruptedException {
	  Select testingType = new Select(driver.findElementById("testingDropdown"));
	  testingType.selectByValue("Performance");
	  Thread.sleep(100);
  }
  @Test(priority=4)
  public void DoubleClick() throws InterruptedException {
	  Actions action = new Actions(driver);
	  WebElement element = driver.findElementById("dblClkBtn");
	  action.doubleClick(element).build().perform();
	  String errorMsg = driver.switchTo().alert().getText();
	  String expectedErrorMsg = "hi, JavaTpoint Testing";
	  Assert.assertEquals(errorMsg, expectedErrorMsg);
	  driver.switchTo().alert().accept();
	  driver.switchTo().defaultContent();
	  Thread.sleep(100);
  }
  @Test(priority=5)
  public void GenerateAlertBox() throws InterruptedException
  {
	  driver.findElementByXPath("//button[normalize-space()='Generate Alert Box']").click();
	  driver.switchTo().alert().accept();
	  Thread.sleep(100);
  }
  @Test(priority=6)
  public void GenerateConfirmBox() throws InterruptedException {
	  driver.findElementByXPath("//button[normalize-space()='Generate Confirm Box']").click();
	  driver.switchTo().alert().dismiss();
	  
	  WebElement element = driver.findElementByXPath("//p[@id='demo']");
	  String actual = element.getText();
	  Assert.assertEquals(actual, "You pressed Cancel!");
	  Thread.sleep(100);
  }
  @Test//(priority=1)
  public void DragNDrop() throws InterruptedException {
	  Actions action = new Actions(driver);
	  WebElement drag = driver.findElementByXPath("//img[@id='sourceImage']");
	  WebElement drop = driver.findElementById("targetDiv");
	  action.dragAndDrop(drag,drop).build().perform();
	  Thread.sleep(100);	  
  }
  
  @BeforeTest
  public void beforeTest() throws InterruptedException {
		//WebDriverManager.chromedriver().setup();
		//driver = new ChromeDriver();
	  	WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.testandquiz.com/selenium/testing.html");
		Thread.sleep(5000);
  }
  @AfterTest
  public void afterTest() {
	  //driver.quit();
  }
}

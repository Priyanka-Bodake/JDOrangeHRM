package JD_Orange_Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login_AllTestCase_Scenarios extends TestData {
	WebDriver driver;

	// ChromeDriver driver;
	@BeforeTest
	public void LaunchBrowser() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		// WebDriverManager.firefoxdriver().setup();
		// WebDriverManager.edgedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		Thread.sleep(10000);
	}

	@AfterTest
	public void CloseBrowser() {
		// driver.close();//Close will close only current chrome browser
		driver.quit();
	}

	/*
	 * @Test(dataProvider="Login") public void LoginToOrangeHRM(String Uname, String
	 * Upass) throws InterruptedException { //
	 * driver.manage().window().fullscreen(); // This will wait for Page to load
	 * 
	 * driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	 * Thread.sleep(10000); // This will store or remember the cookies or navigation
	 * in terms of // // back and forward
	 * 
	 * driver.findElement(By.name("txtUsername")).sendKeys(Uname);
	 * driver.findElement(By.name("txtPassword")).sendKeys(Upass);
	 * driver.findElement(By.id("btnLogin")).click(); // Verify that Dashboard page
	 * displayed String ActElement =
	 * driver.findElement(By.linkText("Dashboard")).getText(); String ExpElement =
	 * "Dashboard"; Assert.assertEquals(ActElement, ExpElement);
	 * System.out.println(ActElement); // ----------------To Verify Logout
	 * Function----------------
	 * 
	 * driver.findElement(By.id("welcome")).click(); Thread.sleep(3000);
	 * driver.findElement(By.linkText("Logout")).click(); String ActLogpanel =
	 * driver.findElement(By.id("logInPanelHeading")).getText(); String
	 * ExpLogpanel="LOGIN Panel"; Assert.assertEquals(ActLogpanel, ExpLogpanel);
	 * System.out.println(ActLogpanel);
	 * 
	 * // ----------------To Verify Logout Function without using //
	 * Assert---------------- Thread.sleep(3000);
	 * driver.findElement(By.id("welcome")).click(); Thread.sleep(3000);
	 * driver.findElement(By.linkText("Logout")).click();
	 * driver.findElement(By.id("logInPanelHeading")).isDisplayed(); }
	 */

	@Test(dataProvider = "LoginScenario")
	public void LoginAllCases(String uName, String uPassword, String expectedMessage) throws InterruptedException {

		driver.findElement(By.name("txtUsername")).clear();
		driver.findElement(By.name("txtUsername")).sendKeys(uName);
		driver.findElement(By.name("txtPassword")).clear();
		driver.findElement(By.name("txtPassword")).sendKeys(uPassword);
		driver.findElement(By.name("Submit")).click();

		try {

			Boolean boolDisplayed = driver.findElement(By.linkText("Dashboard")).isDisplayed();

			if (boolDisplayed) {
				System.out.println("Successfull Login");
				String strCurrDashboardLabel = driver.findElement(By.xpath("//h1[contains(text(),'Dashboard')]")).getText();
				Assert.assertEquals(expectedMessage, strCurrDashboardLabel);
				// Logout
				driver.findElement(By.partialLinkText("Welcome")).click();
				Thread.sleep(3000);
				driver.findElement(By.linkText("Logout")).isDisplayed();
				driver.findElement(By.linkText("Logout")).click();
				driver.findElement(By.name("Submit")).isDisplayed();
			} else {
				System.out.println("Unsuccessfull Login");
				String strInvalidLoginMessage = driver.findElement(By.id("spanMessage")).getText();
				Assert.assertEquals(expectedMessage, strInvalidLoginMessage);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

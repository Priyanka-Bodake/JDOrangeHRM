package JD_Orange_Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleAuthentication {

    WebDriver driver;
      @Test
      public void HTTPAuth() throws InterruptedException {
          driver.navigate().to("http://the-internet.herokuapp.com/basic_auth"); //handled authentication directly
          Thread.sleep(10000);
          driver.navigate().to("http://admin:admin@the-internet.herokuapp.com/basic_auth"); //handled authentication directly
          Thread.sleep(5000);
     
          //driver.navigate().to("http://the-internet.herokuapp.com/basic_auth"); //generally we open this website and it will popup the window for username and password
          
          String confmsg=driver.findElement(By.xpath("//*[@id='content']/div/p")).getText();
          System.out.println(confmsg);
        
      }
      @BeforeTest
      public void LaunchBrowser() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
      }

 

      @AfterTest
      public void CloseBrowser() {
            driver.quit();
      }

}

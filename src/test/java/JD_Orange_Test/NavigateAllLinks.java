package JD_Orange_Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigateAllLinks {
	@Test
	public void NavigateLinks() throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.navigate().to("https://www.google.co.in/");
	Thread.sleep(10000);
	//WebElement element =
	List<WebElement> linksize = driver.findElements(By.tagName("a"));
	
	int linksCount = linksize.size();
	System.out.println("Total no of links Available:" + linksCount);
	// Create String array of total linkcount
	String[] links = new String[linksCount];
	System.out.println("List of links Available:");
	// print all the links from webpage
	for (int i = 0; i < linksCount; i++) {

		links[i] = linksize.get(i).getAttribute("href");
		System.out.println(linksize.get(i).getAttribute("href"));
	}
	// navigate to each Link on the webpage
	for (int j = 0; j < linksCount; j++) {
		driver.navigate().to(links[j]);
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		//driver.navigate().back();

	}
	driver.close();
	}
}


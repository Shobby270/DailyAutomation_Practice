package handlingPannelMenuFElemts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HandleMenuPannel {
	
	
	
	
	
	WebDriver driver;
	//WebElement first;

	@BeforeMethod
	public void setUp() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.tutorialspoint.com/selenium/practice/menu.php");

	}

	
	
	
	@Test
	public void leftMenu() throws InterruptedException {
		
	    List<WebElement> all = driver.findElements(By.xpath("//div[@class='accordion-item']"));
	    all.get(1).click();
		Thread.sleep(Duration.ofSeconds(5));
		
		//Thread.sleep(Duration.ofSeconds(5));
		
		all.get(2).click();
 
		

	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		
		Thread.sleep(Duration.ofSeconds(2));
		driver.quit();
	}

}




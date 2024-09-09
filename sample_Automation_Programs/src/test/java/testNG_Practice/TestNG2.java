package testNG_Practice;

import java.awt.Window;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestNG2 {
	
	
	@Test
	void test3() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get("https://www.youtube.com/watch?v=bkfwZFjQf8U");
		
	//	Thread.sleep(5000);
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,600)");
		Thread.sleep(8000);
//		Actions action = new Actions(driver);
//		action.moveToElement(driver.findElement(By.xpath("//*[@id='header']/ytd-comments-header-renderer"))).perform();
		
		
		
		WebElement comments = driver.findElement(By.xpath("//*[@id='contents']/ytd-comment-thread-renderer[1]"));
		//driver.findElement(By.xpath("//*[@id='more-replies']/yt-button-shape/button/yt-touch-feedback-shape/div/div[1]")).click();
		wait.until(ExpectedConditions.visibilityOf(comments));
		System.out.println(comments.getText());
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id='more-replies']/yt-button-shape/button")).click();
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,700)");
		Thread.sleep(3000);
		List<WebElement> rpls = driver.findElements(By.xpath("//div[@id='contents']/ytd-comment-view-model"));
		
		for(WebElement rep:rpls)
		{
			System.out.println(rep.getText());
		}
		
		
		
	}

}

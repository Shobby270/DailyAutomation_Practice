package seleniumPractice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GetAllLinksAndVerify {
	
	//WebDriver driver;
	
	
	@Test
	public void getLinks() throws URISyntaxException
	{
		WebDriver driver= new ChromeDriver();
	
	driver.get("https://www.amazon.in/");
	List<WebElement> allLinks = driver.findElements(By.tagName("a"));
	System.out.println("Total links present ---> "+allLinks.size());
	
	  for(WebElement link : allLinks) 
	  { 
		  String url = link.getAttribute("href"); 
		  GetAllLinksAndVerify.verifyLinks(url);
		  
	  
	  }
	 	
	
	}
	
	public static void verifyLinks(String urlLinks) throws URISyntaxException
	{
		try {
			
			//URL url = new URI(urlLinks).toURL();
			
			URL url = new URL(urlLinks);
		HttpURLConnection httpURLConection = (HttpURLConnection) url.openConnection();
			httpURLConection.setRequestMethod("HEAD");
			httpURLConection.connect();
			
			if(httpURLConection.getResponseCode()>=400)
			{
				System.out.println(urlLinks +"-------->"+httpURLConection.getResponseMessage()+"-----" +"broken Link");
			}
			else
			{
				System.out.println(urlLinks +"-------->"+httpURLConection.getResponseMessage()+"--------" +"working Link");
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
}



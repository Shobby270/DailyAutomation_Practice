package seleniumPractice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyBrokenLinksParallel {

	public static void main(String[] args) {
	
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println("Total links present ---> "+allLinks.size());
		
		
		List<String> urlList = new ArrayList<String>();
		
		  for(WebElement e : allLinks) 
		  { 
			  String url = e.getAttribute("href"); 
			  urlList.add(url);
			 // GetAllLinksAndVerify.verifyLinks(url);
			  
		  
		  }
		
		  urlList.parallelStream().forEach(e -> checkBrokenLinks(e));
			
			
		

	}
	
	
	
	public static void checkBrokenLinks(String urlLink )
	{
		
		try {
			URL url = new URL(urlLink);
			HttpURLConnection httpUrlConnection = (HttpURLConnection)url.openConnection();
			httpUrlConnection.setConnectTimeout(5000);
			httpUrlConnection.connect();
			
			if(httpUrlConnection.getResponseCode()>=400)
			{
				System.out.println(urlLink +"-------->"+httpUrlConnection.getResponseMessage()+"-----" +"broken Link");
			}
			else
			{
				System.out.println(urlLink +"-------->"+httpUrlConnection.getResponseMessage()+"--------" +"working Link");
			}
			
			
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

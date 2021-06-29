package GrpIDPkg.E2E;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.*;

public class Test6_LinksAndBrokenLinks extends Init {
	
	public WebDriver driver;
	Page1 p1;
	
	@BeforeClass(alwaysRun=true)
	public void startUp() throws IOException {
		driver = initializeDriver();
		p1 = new Page1(driver);
		driver.navigate().to(prop2.getProperty("url2"));
	}
		
	@Test
	public void validateSampleString() throws MalformedURLException, IOException {
		int numberOfLinks = driver.findElements(By.tagName("a")).size();
		System.out.println("numberOfLinks are: "+numberOfLinks);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1600)");
		
		System.out.println("numberOfFooterURLs are: "+p1.getFooterLinks().size());
		
//		for (WebElement link : p1.getFooterLinks()) {
//			String footerURL = link.getAttribute("href");
//			
//	        HttpURLConnection  conn= (HttpURLConnection)new URL(footerURL).openConnection();
//	        conn.setRequestMethod("HEAD");
//	        conn.connect();
//	        int respCode = conn.getResponseCode();
//	        
//	        if(respCode>400) {
//	        	System.out.println("respCode for "+footerURL+" is "+respCode);
//	        }
//		}
		
		for (int i=0;i<p1.getFooterLinks().size()-1;i++) {
			String clickOnClick = Keys.chord(Keys.CONTROL, Keys.ENTER);
			p1.getFooterLinks().get(i).sendKeys(clickOnClick);

//same can be handled using Actions class as well
//			Actions a = new Actions(driver);
//			a.moveToElement(p1.getFooterLinks().get(i)).keyDown(Keys.CONTROL).click().build().perform();
		}
		
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> it = windowHandles.iterator();
		while(it.hasNext()) {
			driver.switchTo().window(it.next());
			String pageTitle = driver.getTitle();
			if(pageTitle.contains("404")) {
				System.out.println(pageTitle+ " is broken");
			}
		}
	        		
	}
	

	@AfterClass(alwaysRun=true)
	public void method3b() {
		driver.quit();
	}
	
}
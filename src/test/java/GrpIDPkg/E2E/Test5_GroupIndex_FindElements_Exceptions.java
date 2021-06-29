package GrpIDPkg.E2E;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.annotations.Test;


public class Test5_GroupIndex_FindElements_Exceptions extends Init
{
	WebDriver driver;

    @Test
    public void method5() throws InterruptedException, IOException
    {
        driver=initializeDriver();    	
    	driver.navigate().to("https://www.tripodeal.com/");
    	
    	WebDriverWait ww = new WebDriverWait(driver, 6);
    	ww.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@id='origin']"))));
    	
    	try {
    		ww.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='origin2']")));
		} catch (Exception e) {
			System.out.println(e+"element not visible in 2 seconds");
		}
    	
    	System.out.println("findElements");
    	
    	List<WebElement> elements = driver.findElements(By.xpath("//inputt[@test='incorrectXpath']"));
    	elements.size();
    	
    	driver.findElement(By.xpath("(//input[@name='return_date_new'])[1]")).click();     // Group index concept here
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("(//input[@name='return_date_new'])[2]")).click();
    	
    	int count=driver.findElements(By.xpath("//input[@name='xx']")).size();
    	System.out.println(count);
    	if(count==0) {
    		System.out.println("count of number of elements is "+count);
    	}
    	
    	String xpathFile3 = System.getProperty("user.dir")+"\\src\\main\\java\\GrpIDPkg\\E2E\\xpaths3.properties";
		try {
			FileInputStream fis3 = new FileInputStream(xpathFile3);
			prop.load(fis3);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @AfterClass
    public void method5_b() {
    	System.out.println("After Class method 5_b");
    	System.out.println(getClass());
    	driver.close();
    }
    
    


}
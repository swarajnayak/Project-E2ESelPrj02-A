package GrpIDPkg.E2E;


import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Init 
{
	public WebDriver driver;
	
    Properties prop = new Properties();
	String xpathFile1 = System.getProperty("user.dir")+"\\src\\main\\java\\GrpIDPkg\\E2E\\xpaths1.properties";
	String xpathFile2 = System.getProperty("user.dir")+"\\src\\main\\java\\GrpIDPkg\\E2E\\xpaths2.properties";  
	
	String browserName = System.getProperty("browser");
	//String browserName = "chrome";
    
    public WebDriver initializeDriver()
    {
    	System.out.println(browserName);
    	
    	if(browserName.contains("chrome")) {  		
    		String driverLocation = System.getProperty("user.dir")+"\\chromedriver.exe";
    		System.setProperty("webdriver.chrome.driver", driverLocation);
    		ChromeOptions options = new ChromeOptions();
    		if(browserName.contains("headless")) {
    			options.addArguments("--headless");
    		}
    		driver = new ChromeDriver(options);
    	}
    	
    	else if(browserName.equalsIgnoreCase("firefox")) {
    		String driverLocation = System.getProperty("user.dir")+"\\geckodriver.exe";
    		System.setProperty("webdriver.gecko.driver", driverLocation);
    		driver = new FirefoxDriver();
    	}
    	
    	
        System.out.println( "Hello from initializeDriver in: "+getClass().getName()+"-class");        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://facebook.com");
        
        return driver;

    }
    
    public void takeScreenshot(WebDriver driver, String testCaseName ) throws IOException {
    	TakesScreenshot ts = (TakesScreenshot) driver;
    	File source = ts.getScreenshotAs(OutputType.FILE);
    	String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
    	FileUtils.copyFile(source, new File(destinationFile));
    	
    }
}

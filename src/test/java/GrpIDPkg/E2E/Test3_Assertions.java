package GrpIDPkg.E2E;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.*;

public class Test3_Assertions extends Init {
	
	public WebDriver driver;
	Page1 p1;
	
	@BeforeClass(alwaysRun=true)
	public void startUp() throws IOException {
		driver = initializeDriver();
		p1 = new Page1(driver);
	}
	
	@BeforeMethod(alwaysRun=true)
	public void launchUrl() {
		driver.navigate().to(prop2.getProperty("url1"));
		driver.manage().window().maximize();
	}
	
	@Test(groups= {"Regression"})
	public void validateSampleString() {
			
		Assert.assertEquals("Switch Tab Example", p1.getSampleString());

	}
	
	@Test(groups= {"Sanity"})
	public void validatePracticePath() {
			
		Assert.assertTrue(p1.getPracticeXpath());

	}

	@AfterClass(alwaysRun=true)
	public void method3b() {
		driver.close();
	}

}
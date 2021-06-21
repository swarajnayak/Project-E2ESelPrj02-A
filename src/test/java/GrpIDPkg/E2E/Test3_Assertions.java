package GrpIDPkg.E2E;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Test3_Assertions extends Init {
	
	WebDriver driver;
	
	@Test
	public void method3() throws IOException {
		
		driver = initializeDriver();

		FileInputStream fis1 = new FileInputStream(xpathFile1);
		// FileInputStream fis2 = new FileInputStream(xpathFile2);
		prop.load(fis1);

		driver.navigate().to("https://www.rahulshettyacademy.com/AutomationPractice/");
		// String sample = driver.findElement(By.xpath("//legend[contains(text(),'Switch
		// Tab Example')]")).getText();
		String sample = driver.findElement(By.xpath(prop.getProperty("SwitchTabExampleXpath"))).getText();
		Assert.assertEquals("Switch Tab Example", sample);
		// Assert.assertTrue(driver.findElement(By.xpath("//button[contains(text(),'Practice')]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath(prop.getProperty("PracticeXpath"))).isDisplayed());

	}

	@AfterClass
	public void method3b() {
		driver.close();
	}

}
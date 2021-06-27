package GrpIDPkg.E2E;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Page1 {
	
	public WebDriver driver;
	
	public Page1(WebDriver driver) {
		this.driver = driver;
	}
	
	By SwitchTabExampleXpath = By.xpath("//legend[contains(text(),'Switch Tab Example')]");
	
	By PracticeXpath = By.xpath("//button[contains(text(),'Practice')]");

	public String getSampleString() {
		
		return driver.findElement(SwitchTabExampleXpath).getText();
		
	}
	
	public boolean getPracticeXpath() {
		
		return driver.findElement(SwitchTabExampleXpath).isDisplayed();
		
	}
}

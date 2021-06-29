package GrpIDPkg.E2E;

import java.util.List;

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
	By AllThefooterLinks = By.xpath("//li[@class='gf-li']/a");

	
	public String getSampleString() {		
		return driver.findElement(SwitchTabExampleXpath).getText();		
	}
	
	public boolean getPracticeXpath() {		
		return driver.findElement(SwitchTabExampleXpath).isDisplayed();	
	}
	
	public List<WebElement> getFooterLinks() {		
		return driver.findElements(AllThefooterLinks);	
	}
}
 
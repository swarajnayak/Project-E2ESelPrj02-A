package GrpIDPkg.E2E;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Test1_Google extends Init {
	public WebDriver driver;

	@Test
	public void basicVeryBasic() {
		
		driver = initializeDriver();

		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

		driver.navigate().to("http://google.com");

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@title='Search']"))));

		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//input[@title='Search']"))).sendKeys("dummy").sendKeys(Keys.ENTER)
				.build().perform();

		driver.close();
	}
}

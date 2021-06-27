package GrpIDPkg.E2E;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test2_DataProvAnnotations extends Init {
	
	public WebDriver driver;

	@Test(dataProvider = "getData")
	public void basicVeryBasic2(String user, String pwd, String text) throws IOException {
		driver = initializeDriver();

		driver.navigate().to("http://www.qaclickacademy.com/");

		driver.findElement(By.xpath("//span[contains(text(),'Login')]")).click();
		driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys(user);
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys(pwd);
		System.out.println(text);
		driver.quit();

	}

	@DataProvider
	public Object[][] getData() {

		Object[][] data = new Object[2][3]; // 2=number of rows/sets of data to be passed(0,1 will be the index where it
											// is stored) || 3=values per set

		data[0][0] = "user1";
		data[0][1] = "pwd1";
		data[0][2] = "text1";

		data[1][0] = "user2";
		data[1][1] = "pwd2";
		data[1][2] = "text2";

		return data;
	}
}

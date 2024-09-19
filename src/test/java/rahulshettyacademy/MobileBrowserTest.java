package rahulshettyacademy;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileBrowserTest extends BrowserBaseTest {

	@Test
	public void browserTest() throws InterruptedException {
//		driver.get("https://www.google.com/");
//		System.out.println(driver.getTitle());
//		driver.findElement(By.name("q")).sendKeys("rahul shetty academy");
//		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
//		Thread.sleep(3000);
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("button[class='navbar-toggler']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a[routerlink*='products']")).click();
		
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1000)", "");
		
		String text = driver.findElement(By.cssSelector("a[href*='products/3']")).getText();
		
		Assert.assertEquals(text, "Devops");
		
		Thread.sleep(3000);
	}
}

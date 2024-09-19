package rahulshettyacademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class IOSScrollTest extends IOSBaseTest {

	@Test
	public void IOSScrollTesting() throws InterruptedException {

		WebElement webviewEle = driver.findElement(AppiumBy.accessibilityId("Web View"));

		scrollGesture(webviewEle);
		webviewEle.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//XCUIElementTypeButton[@name='UIKitCatalog']")).click();
		
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == 'Picker View'`]")).click();
		
		driver.findElement(AppiumBy.iOSNsPredicateString("label == 'Red color component value'")).sendKeys("80");
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypePickerWheel[`name == 'Green color component value'`]")).sendKeys("220");
		driver.findElement(AppiumBy.iOSNsPredicateString("name == 'Blue color component value'")).sendKeys("105");
		
		String number = driver.findElement(AppiumBy.iOSNsPredicateString("name == 'Blue color component value'")).getText();
		Thread.sleep(2000);
		Assert.assertEquals(number, "105");
	}
}

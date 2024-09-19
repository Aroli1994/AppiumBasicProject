package rahulshettyacademy;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class AppiumBasics extends BaseTest {

	@Test
	public void WifiSettingsName() {

		// locators: xpath, id, classname, accessibilityId, androidUIAutomator
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();

		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();

		driver.findElement(By.id("android:id/checkbox")).click();

		driver.findElement(
				By.xpath("//android.widget.TextView[@resource-id='android:id/title' and @text='WiFi settings']"))
				.click();

		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		
		Assert.assertEquals(alertTitle, "WiFi settings");

		driver.findElement(By.id("android:id/edit")).sendKeys("VinayWifi");

		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		
		//set wifiname

	}
}

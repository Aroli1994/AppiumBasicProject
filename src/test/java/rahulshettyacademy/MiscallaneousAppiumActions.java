package rahulshettyacademy;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class MiscallaneousAppiumActions extends BaseTest {

	@Test
	public void Miscallenous() {

		//adb shell dumpsys window | grep -E 'mCurrentFocus'    => Mac
		//adb shell dumpsys window | find 'mCurrentFocus'       => Windows
		
		//App Package and App activity
		
		//Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
		//driver.startActivity(activity);  //deprecated in appium 2.0.0
		
		((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of(
			    "intent", "io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"
			));
		
		// locators: xpath, id, classname, accessibilityId, androidUIAutomator
//		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
//
//		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();

		driver.findElement(By.id("android:id/checkbox")).click();
		
		//Landscape mode
		DeviceRotation landScape = new DeviceRotation(0, 0, 90);
		driver.rotate(landScape);

		driver.findElement(
				By.xpath("//android.widget.TextView[@resource-id='android:id/title' and @text='WiFi settings']"))
				.click();

		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		
		Assert.assertEquals(alertTitle, "WiFi settings");
		
		//copy paste
		//copy to clipboard - paste it clipboard
		driver.setClipboardText("VinayWifi");
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));

	}
}

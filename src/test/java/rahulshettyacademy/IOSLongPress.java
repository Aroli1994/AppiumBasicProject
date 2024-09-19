package rahulshettyacademy;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class IOSLongPress extends IOSBaseTest {

	@Test
	public void IOSLongPressTest() {
		
		driver.findElement(AppiumBy.accessibilityId("Steppers")).click();
		WebElement incrementEle = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == 'Increment'`][3]"));
		
		longPressGesture(incrementEle);
	}
}

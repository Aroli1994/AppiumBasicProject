package rahulshettyacademy;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class ScrollDemo extends BaseTest {

	@Test
	public void ScrollGestureTest() throws InterruptedException {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		//when having prior idea to which element to scroll then use below scroll technique
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));

		//when 'no' prior idea to which element to scroll then use below scroll technique
		scrollToEndAction();

	}

}

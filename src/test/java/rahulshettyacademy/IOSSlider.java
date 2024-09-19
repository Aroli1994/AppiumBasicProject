package rahulshettyacademy;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class IOSSlider extends IOSBaseTest {

	@Test
	public void IOSSliderTest() throws InterruptedException {
		WebElement sliderEle = driver
				.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeSlider[`name == 'AppElem\'`]"));
		Thread.sleep(3000);
		sliderEle.sendKeys("0%");   //0 means 0%
		System.out.println(sliderEle.getAttribute("value"));
		Assert.assertEquals(sliderEle.getAttribute("value"), "0%");

		Thread.sleep(3000);

		sliderEle.sendKeys("1%");  //1 means 100%
		System.out.println(sliderEle.getAttribute("value"));
		Assert.assertEquals(sliderEle.getAttribute("value"), "100%");
	}
}

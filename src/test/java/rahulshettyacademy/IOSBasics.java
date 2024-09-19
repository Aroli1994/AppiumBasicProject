package rahulshettyacademy;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class IOSBasics extends IOSBaseTest {
	
	@Test
	public void IOSBasicsTest() {
		//Locators ->id, accessibilityId, Xpath, classname, IOS, iOSClassChain, iOSPredicateString
		
		driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
		
		//Xpath - Xml language
		//iOSClassChain, iOSPredicateString - faster than xpath usage 
		
		//driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Text Entry']")).click();
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == 'Text Entry'`]")).click();
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeCell")).sendKeys("Hello World");
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`label == 'OK'`]")).click();
		
		driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value == 'Confirm / Cancel'")).click();
//		driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'Confirm'"));
//		driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value ENDSWITH[c] 'Cancel'"));
		
		String message = driver.findElement(AppiumBy.iOSNsPredicateString("name BEGINSWITH[c] 'a message'")).getText();
		System.out.println(message);
		driver.findElement(AppiumBy.iOSNsPredicateString("label == 'Confirm'")).click();
		
		Assert.assertEquals(message, "A message should be a short, complete sentence.");
		
	}

}

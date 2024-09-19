package rahulshettyacademy;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	public AndroidDriver driver;
	public AppiumDriverLocalService service;

	@BeforeClass
	public void configureAppium() throws MalformedURLException, URISyntaxException {

		service = new AppiumServiceBuilder()
				.withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();

		service.start();

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Vinay_Pixel8");   //emulator
		options.setDeviceName("Android Device"); //real device which is generic name
		options.setChromedriverExecutable("//Users//krishnabros//Documents//chromedriver//chromedriver91");
		options.setApp("//Users//krishnabros//Desktop//Projects//Appium//eclipse-workspace//Appium_Project2//src//test//java//resources//ApiDemos-debug.apk");
		//options.setApp("//Users//krishnabros//Desktop//Projects//Appium//eclipse-workspace//Appium_Project2//src//test//java//resources//General-Store.apk");

		URL url_appium = new URI("http://127.0.0.1:4723").toURL();
		driver = new AndroidDriver(url_appium, options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void longPressAction(WebElement elem) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) elem).getId(), "duration", 2000));
	}

	public void scrollToEndAction() {
		boolean canScrollMore;

		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap
					.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 0.75));
		} while (canScrollMore);

	}
	
	public void swipeAction(WebElement elem, String direction) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement)elem).getId(),
				"direction", direction,
				"percent", 0.75
		));
	}
	
	public Double getFormattedAmount(String amount) {
		Double price = Double.parseDouble(amount.substring(1));
		return price;
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}

}

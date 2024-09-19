package rahulshettyacademy;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class IOSBaseTest {
	public IOSDriver driver;
	public AppiumDriverLocalService service;

	@BeforeClass
	public void configureAppium() throws MalformedURLException, URISyntaxException {

		service = new AppiumServiceBuilder()
				.withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();

		service.start();

		XCUITestOptions options = new XCUITestOptions();
		options.setDeviceName("iPhone 15 Pro Max");
//		options.setApp("/Users/krishnabros/Library/Developer/Xcode/DerivedData/UIKitCatalog-bjtytzoitisvauerejdwyprtaolr/Build/Products/Debug-iphonesimulator/UIKitCatalog.app");
//		options.setApp("//Users//krishnabros//Desktop//Projects//Appium//eclipse-workspace//Appium_Project2//src//test//java//resources//UIKitCatalog.app");

		//options.setApp("//Users//krishnabros//Desktop//Projects//Appium//eclipse-workspace//Appium_Project2//src//test//java//resources//UIKitCatalog.app");
		//options.setApp("//Users//krishnabros//Desktop//Projects//Appium//eclipse-workspace//Appium_Project2//src//test//java//resources//TestApp 3.app");

		options.setPlatformVersion("17.5");
		// Appium -> Webdriver Agent ->IOS apps
		options.setWdaLaunchTimeout(Duration.ofSeconds(20));

		URL url_appium = new URI("http://127.0.0.1:4723").toURL();
		driver = new IOSDriver(url_appium, options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void longPressGesture(WebElement ele) {
		Map<String, Object> params = new HashMap<>();
		params.put("element", ((RemoteWebElement) ele).getId());
		params.put("duration", 5);

		driver.executeScript("mobile: touchAndHold", params);
	}

	public void scrollGesture(WebElement ele) {
		Map<String, Object> params = new HashMap<>();
		params.put("element", ((RemoteWebElement) ele).getId());
		params.put("direction", "down");

		driver.executeScript("mobile: scroll", params);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}

}

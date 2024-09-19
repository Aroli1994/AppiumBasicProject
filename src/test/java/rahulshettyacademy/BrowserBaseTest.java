package rahulshettyacademy;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BrowserBaseTest {
	public AndroidDriver driver;
	public AppiumDriverLocalService service;

	@BeforeClass
	public void configureAppium() throws MalformedURLException, URISyntaxException {
		AppiumServiceBuilder builder = new AppiumServiceBuilder();
		builder.withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"));
		builder.withIPAddress("127.0.0.1");
		builder.usingPort(4723);
		builder.build();
		service = AppiumDriverLocalService.buildService(builder);

		service.start();

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Vinay_Pixel8");
		options.setChromedriverExecutable("//Users//krishnabros//Documents//chromedriver//chromedriver91");
		options.setCapability("browserName", "Chrome");
		URL url_appium = new URI("http://127.0.0.1:4723").toURL();
		driver = new AndroidDriver(url_appium, options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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

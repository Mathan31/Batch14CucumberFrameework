package hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.PicoTestContext;

public class PreAndPostCondition {
	private WebDriver driver;
	
	public PreAndPostCondition(PicoTestContext picoTestContext) {
		driver = picoTestContext.getBrowserBase().launchChromeBrowser();
	}
	
	@After
	public void closeBrowser() {
		driver.quit();
	}
	
	@AfterStep
	public void getSnapAndAttachToReport(Scenario scenario) {
		if(scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "ScreenFailure");
		}
	}

}

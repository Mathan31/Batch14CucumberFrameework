package runner;


import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features = "./src/test/resources/features/",
		glue = {"steps","hooks"},
		dryRun = false,
		monochrome = true,
		tags = "@Smoke",
		plugin = {"pretty","json:target/reports/search.json","html:target/reports/search.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		publish = true
)
public class TestNGRunner extends AbstractTestNGCucumberTests{

	@DataProvider(parallel = true)
    public Object[][] scenarios() {
       return super.scenarios();
    }

}

package Runner;

//TestNG runner for parallel execution of scenarios

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/features/LoginPageDDT.feature"},
		glue = {"Stepdeff", "AppHooks"},
		tags = "@Sanity",
		publish=true,
		dryRun = false,
		monochrome = true,
		plugin={"pretty","html:target/reports/cucumberReport.html"})


public class TestNgRunner extends AbstractTestNGCucumberTests{
	
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
	
}

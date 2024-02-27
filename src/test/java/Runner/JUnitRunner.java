package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/features/Index.feature"},
		glue = {"Stepdeff", "AppHooks"},
//		tags = "@Sanity",
		plugin={"pretty",
				"html:target/cucumber/report.html", 
				"json:target/cucumber/report.json", 
				"json:target/cucumber/report.xml",
				"timeline:target/cucumber" ,
				"me.jvt.cucumber.report.PrettyReports:target/cucumber",
				"rerun:target/failedSecnarios.txt"
				
				}
		
		)

public class JUnitRunner {

}

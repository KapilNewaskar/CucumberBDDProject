package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\newas\\eclipse-workspace\\CucumberFramework\\Features\\Customers.feature",
		// features =
		// "C:\\Users\\newas\\eclipse-workspace\\CucumberFramework\\Features", // if we
		// want to run all feature file
		// features =
		// {"C:\\Users\\newas\\eclipse-workspace\\CucumberFramework\\Features\\Customers.feature","C:\\Users\\newas\\eclipse-workspace\\CucumberFramework\\Features\\LoginFeature.feature"}
		//to run more than one feature file
		tags = "@Sanity",//"@sanity or @regression"//"@sanity and @regression"//"@sanity and not @regression"
		glue = "StepDefination",
		dryRun = false,
		monochrome = true,
		plugin = { "pretty",
				"html:target/cucumber-reports/reports_html.html", "json:target/cucumber-reports/reports_json.json",
				"junit:target/cucumber-reports/reports_xml.xml" })

public class Run2 {
//do not add here
}

package testRunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features=".//Features/",
		glue = "stepDefinitions",
		dryRun = false,
		monochrome=true,
		plugin= {"pretty", "html:test-output"}
		//tags = {"@sanity"}
		//tags = {"@sanity, @regression"}
		
		//"pretty": This plugin generates human-readable output during the execution of Cucumber tests.
	    //"html:test-output": This plugin generates HTML-formatted reports for your Cucumber tests.
		)
public class TestRun {

}

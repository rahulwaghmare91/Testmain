package TestRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions
(
		features="E:\\practiceproject\\Feature\\Login2.feature",
		glue="stepdefination",
		dryRun=true
		)
public class TestRun {

}

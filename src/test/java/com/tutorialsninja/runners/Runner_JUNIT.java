package com.tutorialsninja.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(dryRun = false, monochrome = true, features = "src\\test\\resources\\com\\tutorialsninja\\featureFiles", // Adjusted
																															// path
		glue = {"com.tutorialsninja.stepdefinitions", "com.tutorialsninja.hooks"}, // Package name for step definitions
		tags = "@TutorialNinjaLogin or @TutorialNinjaRegister or @TutorialsNinjaSearchProduct or @TutorialsNinjaAddtoCart or @TutorialNinjaLogout", 
		plugin = {
				"pretty", "html:target/site/cucumber-html", "json:target/cucumber1.json", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" , "com.tutorialsninja.Utilities.MyCucumberListener"}

)
public class Runner_JUNIT {

}
package com.tutorialsninja.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(dryRun = false, monochrome = true, features = {
		"src\\test\\resources\\com\\tutorialsninja\\featureFiles" }, glue = { "step_definitions",
				"com.tutorialsninja.stepdefinitions", "com.tutorialsninja.hooks" }, 
				tags = "@TutorialNinjaLogin or @TutorialNinjaRegister or @TutorialsNinjaSearchProduct or @TutorialsNinjaAddtoCart or @TutorialNinjaLogout", plugin = {
						"pretty", "html:target/site/cucumber-html", "json:target/cucumber1.json",
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "com.tutorialsninja.Utilities.MyCucumberListener" }

)

public class Test_Runner_TestNG extends AbstractTestNGCucumberTests {

}
//@TutorialNinjaLogin or @TutorialNinjaRegister or @TutorialsNinjaSearchProduct or @TutorialsNinjaAddtoCart or @TutorialNinjaLogout"
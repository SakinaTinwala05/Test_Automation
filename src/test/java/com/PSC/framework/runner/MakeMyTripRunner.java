package com.PSC.framework.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "classpath:BackOffice/MakeMytrip.feature" }, glue = {
		"classpath:com.PSC.framework.stepDefinition",
		"classpath:com.PSC.framework.helper" }, plugin = { "pretty", "json:target/Post.json" })

public class MakeMyTripRunner extends AbstractTestNGCucumberTests{

}

package com.GoogleDropBox;


import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class) 
@CucumberOptions(
		//features = "C:\\WorkSpace\\Java\\GoogleDropBox\\src\\test\\java\\com\\GoogleDropBox\\GoogleDrive.feature",
		glue = "classpath:com.GoogleDropBox",
		tags= "@smoke",
		plugin = "html:target/selenium-reports"
		)

public class Runner 
{
 public Runner()
 {
	
 }
}

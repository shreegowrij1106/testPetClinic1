import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) 

@CucumberOptions(
        features = "src/test/resources/features/",
        glue = {"stepdefs"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty.html",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "junit:target/cucumber-reports/cucumber.xml",
                "rerun:target/cucumber-reports/rerun.txt"
        },
      tags= "@SmokeTest or @RegressionTest")


//Specifying pretty as a format option ensure that HTML report will be generated. 
//When we specify html:target/Destination - It will generate the HTML report 

//inside the Destination folder, in the target folder of the maven project. 

public class runTest { }
package TESTBACK;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
@RunWith(Cucumber.class)
@CucumberOptions(features = "user_case",
	plugin= {"html:target/cucumber/wikipedia.html"},
	monochrome=true,
	snippets = SnippetType.CAMELCASE,
	glue = {"TESTBACK"},
	strict=true
	)
public class AcceptencTest {
	
}


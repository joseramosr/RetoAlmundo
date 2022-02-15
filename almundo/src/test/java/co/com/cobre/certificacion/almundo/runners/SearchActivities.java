package co.com.cobre.certificacion.almundo.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/search_activities.feature",
        glue = "co.com.cobre.certificacion.almundo.stepdefinitions",
        snippets = SnippetType.CAMELCASE)
public class SearchActivities {
}

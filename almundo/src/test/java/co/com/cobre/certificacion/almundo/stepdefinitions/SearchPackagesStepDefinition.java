package co.com.cobre.certificacion.almundo.stepdefinitions;

import co.com.cobre.certificacion.almundo.exceptions.CityNotFound;
import co.com.cobre.certificacion.almundo.exceptions.PackageNotFound;
import co.com.cobre.certificacion.almundo.questions.InTheScreenOfFoundPackages;
import co.com.cobre.certificacion.almundo.questions.TheVisibilityOfTheViewDetailsLink;
import co.com.cobre.certificacion.almundo.tasks.SearchPackages;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static co.com.cobre.certificacion.almundo.exceptions.PackageNotFound.PACKAGE_NOT_FOUND_ERROR;
import static co.com.cobre.certificacion.almundo.exceptions.CityNotFound.CITY_NOT_FOUND_ERROR;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class SearchPackagesStepDefinition {

    @When("^he looks for packages from (.*) to (.*) a week after the current day$")
    public void heLooksForPackagesFromDepartureCityToArrivalCityAWeekAfterTheCurrentDay(String origin, String destination) {
        theActorInTheSpotlight().attemptsTo(SearchPackages.forCities(origin, destination));
    }


    @Then("^he validates that the package search is successful$")
    public void heValidatesThatThePackageSearchIsSuccessful() {
        String arrivalCity = theActorInTheSpotlight().recall("arrivalCity");
        theActorInTheSpotlight().should(
                seeThat(InTheScreenOfFoundPackages.thePackageNameIs(), equalTo("Paquetes a " + arrivalCity))
                        .orComplainWith(CityNotFound.class, CITY_NOT_FOUND_ERROR),
                seeThat(TheVisibilityOfTheViewDetailsLink.onTheFoundPackageIs(), equalTo(true))
                        .orComplainWith(PackageNotFound.class, PACKAGE_NOT_FOUND_ERROR)
        );

    }

}




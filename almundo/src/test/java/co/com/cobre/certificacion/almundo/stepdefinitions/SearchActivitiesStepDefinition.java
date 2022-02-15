package co.com.cobre.certificacion.almundo.stepdefinitions;

import co.com.cobre.certificacion.almundo.exceptions.CityNotFound;

import static co.com.cobre.certificacion.almundo.exceptions.CityNotFound.*;

import co.com.cobre.certificacion.almundo.exceptions.FilterNotFound;

import static co.com.cobre.certificacion.almundo.exceptions.FilterNotFound.*;

import co.com.cobre.certificacion.almundo.interactions.CloseAlertOf;
import co.com.cobre.certificacion.almundo.questions.*;
import co.com.cobre.certificacion.almundo.tasks.*;

import static co.com.cobre.certificacion.almundo.userinterfaces.ActivitiesPageComponents.*;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.util.List;

import static org.hamcrest.Matchers.*;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class SearchActivitiesStepDefinition {

    @Before
    public void init() {
        setTheStage(new OnlineCast());
    }


    @Given("^that the (.*) is on the home page of almundo$")
    public void thatTheAnalystIsOnTheHomePageOfAlmundo(String actorName) {
        theActorCalled(actorName).wasAbleTo(NavigateTo.theAlmundoPage());
    }

    @When("^he looks for activities in the city of (.*)$")
    public void heLooksForActivitiesInTheCityOf(String destination) {
        theActorInTheSpotlight().attemptsTo(
                SearchActivities.inTheCityOf(destination)
        );
    }

    @Then("^he validates that the activities shown correspond to (.*)$")
    public void heValidatesThatTheActivitiesShownCorrespondTo(String city) {
        theActorInTheSpotlight().should(seeThat(
                InTheScreenOfFoundActivities.theVisibilityOfTheCityNameIs(city), equalTo(true))
                .orComplainWith(CityNotFound.class, CITY_NOT_FOUND_ERROR));
    }

    @And("^he should see the items of the activities found$")
    public void heShouldSeeTheItemsOfTheActivitiesFound() {
        List<WebElementFacade> activitiesItems = ITEMS_ACTIVITIES.resolveAllFor(theActorInTheSpotlight());
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(activitiesItems).allMatch("View activity button is displayed",
                        it -> it.isDisplayed() == true)
        );
    }

    @And("^he should also see the filter and sort buttons$")
    public void heShouldAlsoSeeTheFilterAndSortButtons() {
        theActorInTheSpotlight().should(
                seeThat(TheVisibilityOfTheCancellationFilter.is(), equalTo(true))
                        .orComplainWith(FilterNotFound.class, BTN_FLEXIBLE_CANCELLATION_NOT_FOUND_ERROR),
                seeThat(TheVisibilityOfThePriceFilter.is(), equalTo(true))
                        .orComplainWith(FilterNotFound.class, BTN_PRICE_NOT_FOUND_ERROR),
                seeThat(TheVisibilityOfTheActivityTypeFilter.is(), equalTo(true))
                        .orComplainWith(FilterNotFound.class, BTN_ACTIVITY_TYPE_NOT_FOUND_ERROR),
                seeThat(TheVisibilityOfTheActivityNameFilter.is(), equalTo(true))
                        .orComplainWith(FilterNotFound.class, BTN_ACTIVITY_NAME_NOT_FOUND_ERROR),
                seeThat(TheVisibilityOfTheSortButton.is(), equalTo(true))
                        .orComplainWith(FilterNotFound.class, BTN_ORDER_NOT_FOUND_ERROR)
        );
    }


}




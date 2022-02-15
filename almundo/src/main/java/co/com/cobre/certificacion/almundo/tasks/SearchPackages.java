package co.com.cobre.certificacion.almundo.tasks;

import static co.com.cobre.certificacion.almundo.userinterfaces.PackagesPageComponents.*;

import static co.com.cobre.certificacion.almundo.userinterfaces.ActivitiesPageComponents.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import co.com.cobre.certificacion.almundo.interactions.SelectDates;
import co.com.cobre.certificacion.almundo.interactions.SelectNumberOfRooms;
import co.com.cobre.certificacion.almundo.interactions.SelectTheNumberOfPeople;
import co.com.cobre.certificacion.almundo.utils.AddDaysTo;
import co.com.cobre.certificacion.almundo.utils.GenerateDate;
import co.com.cobre.certificacion.almundo.utils.GetTheCityNameWithoutTheCountryName;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class SearchPackages implements Task {

    private final String origin;
    private final String destination;

    public SearchPackages(String origin, String destination) {
        this.origin = origin;
        this.destination = destination;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String departureCityName = GetTheCityNameWithoutTheCountryName.ofTheText(origin);
        String arrivalCityName = GetTheCityNameWithoutTheCountryName.ofTheText(destination);
        actor.remember("arrivalCity", arrivalCityName);
        String startDay = GenerateDate.withAdditionalDaysToTheCurrentDate(AddDaysTo.START_DAY).getDay();
        String endDay = GenerateDate.withAdditionalDaysToTheCurrentDate(AddDaysTo.END_DAY).getDay();
        actor.attemptsTo(
                WaitUntil.the(BTN_PACKAGES, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BTN_PACKAGES),
                Click.on(BTN_ASSEMBLE_PACKAGE),
                Enter.theValue(origin).into(TEXT_BOX_DEPARTURE_CITY),
                WaitUntil.the(LIST_CITY_OPTION.of(departureCityName), isClickable()).forNoMoreThan(10).seconds(),
                Click.on(LIST_CITY_OPTION.of(departureCityName)),
                Enter.theValue(destination).into(TEXT_BOX_ARRIVAL_CITY),
                WaitUntil.the(LIST_CITY_OPTION.of(arrivalCityName), isClickable()).forNoMoreThan(10).seconds(),
                Click.on(LIST_CITY_OPTION.of(arrivalCityName)),
                Click.on(TEXT_BOX_START_DATE),
                WaitUntil.the(BTN_SELECT_DAY_OF_THE_CURRENT_MONTH.of(startDay), isVisible()).forNoMoreThan(10).seconds(),
                SelectDates.inTheCalendar(startDay, endDay),
                Click.on(TEXT_BOX_PERSONS_ROOMS),
                SelectNumberOfRooms.toReserve(),
                SelectTheNumberOfPeople.whoAreGoingToReserve(),
                WaitUntil.the(BTN_READY, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(BTN_READY),
                Click.on(BTN_SEARCH_PACKAGES),
                WaitUntil.the(PROGRESS_BAR_ON_PACKAGES, isNotVisible()).forNoMoreThan(60).seconds()
        );
    }

    public static SearchPackages forCities(String origin, String destination) {
        return Tasks.instrumented(SearchPackages.class, origin, destination);
    }
}

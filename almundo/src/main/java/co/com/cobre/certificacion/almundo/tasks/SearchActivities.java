package co.com.cobre.certificacion.almundo.tasks;

import static co.com.cobre.certificacion.almundo.userinterfaces.ActivitiesPageComponents.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

import co.com.cobre.certificacion.almundo.interactions.CloseAlertOf;
import co.com.cobre.certificacion.almundo.utils.GetTheCityNameWithoutTheCountryName;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class SearchActivities implements Task {

    private final String destination;

    public SearchActivities(String destination) {
        this.destination = destination;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String cityName = GetTheCityNameWithoutTheCountryName.ofTheText(destination);
        actor.attemptsTo(
                WaitUntil.the(BTN_ACTIVITIES, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BTN_ACTIVITIES),
                Enter.theValue(destination).into(TEXT_BOX_CITY),
                WaitUntil.the(LIST_CITY_OPTION.of(cityName), isClickable()).forNoMoreThan(10).seconds(),
                Click.on(LIST_CITY_OPTION.of(cityName)),
                Click.on(BTN_SEARCH_ACTIVITIES),
                WaitUntil.the(PROGRESS_BAR_ON_ACTIVITIES, isNotVisible()).forNoMoreThan(60).seconds(),
                CloseAlertOf.flexibleBooking()
        );
    }

    public static SearchActivities inTheCityOf(String destination) {
        return Tasks.instrumented(SearchActivities.class, destination);
    }

}

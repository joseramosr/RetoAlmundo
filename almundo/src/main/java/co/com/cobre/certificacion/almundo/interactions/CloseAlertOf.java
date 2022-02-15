package co.com.cobre.certificacion.almundo.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.cobre.certificacion.almundo.userinterfaces.ActivitiesPageComponents.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;

public class CloseAlertOf implements Interaction {

    public CloseAlertOf() {
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(ALERT_FLEXIBLE_BOOKING, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(ALERT_FLEXIBLE_BOOKING),
                WaitUntil.the(ALERT_FLEXIBLE_BOOKING, isNotVisible()).forNoMoreThan(10).seconds()
        );
    }

    public static CloseAlertOf flexibleBooking() {
        return Tasks.instrumented(CloseAlertOf.class);
    }

}

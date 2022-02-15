package co.com.cobre.certificacion.almundo.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.cobre.certificacion.almundo.userinterfaces.PackagesPageComponents.BTN_SELECT_DAY_OF_THE_CURRENT_MONTH;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class SelectDatesInTheCurrentMonth implements Interaction {

    private final String startDay;
    private final String endDay;

    public SelectDatesInTheCurrentMonth(String startDay, String endDay) {
        this.startDay = startDay;
        this.endDay = endDay;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BTN_SELECT_DAY_OF_THE_CURRENT_MONTH.of(startDay), isClickable()).forNoMoreThan(10).seconds(),
                Click.on(BTN_SELECT_DAY_OF_THE_CURRENT_MONTH.of(startDay)),
                WaitUntil.the(BTN_SELECT_DAY_OF_THE_CURRENT_MONTH.of(endDay), isClickable()).forNoMoreThan(10).seconds(),
                Click.on(BTN_SELECT_DAY_OF_THE_CURRENT_MONTH.of(endDay))
        );
    }

    public static SelectDatesInTheCurrentMonth ofTheCalendar(String starDay, String endDay) {
        return Tasks.instrumented(SelectDatesInTheCurrentMonth.class, starDay, endDay);
    }
}

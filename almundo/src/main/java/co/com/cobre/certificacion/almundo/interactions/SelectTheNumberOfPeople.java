package co.com.cobre.certificacion.almundo.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.cobre.certificacion.almundo.userinterfaces.PackagesPageComponents.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class SelectTheNumberOfPeople implements Interaction {

    public SelectTheNumberOfPeople() {
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        int numberPersons = Integer.parseInt(TEXT_NUMBER_OLD_PEOPLE.resolveFor(actor).getText());

        if (numberPersons < 1) {
            actor.attemptsTo(
                    WaitUntil.the(BTN_ADD_OLD_PEOPLE, isClickable()).forNoMoreThan(10).seconds(),
                    Click.on(BTN_ADD_OLD_PEOPLE)
            );
        }

    }

    public static SelectTheNumberOfPeople whoAreGoingToReserve() {
        return Tasks.instrumented(SelectTheNumberOfPeople.class);
    }
}

package co.com.cobre.certificacion.almundo.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;


import static co.com.cobre.certificacion.almundo.userinterfaces.PackagesPageComponents.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SelectNumberOfRooms implements Interaction {


    public SelectNumberOfRooms() {

    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(TEXT_NUMBER_OF_ROOMS, isVisible()).forNoMoreThan(10).seconds());
        int numberRooms = Integer.parseInt(TEXT_NUMBER_OF_ROOMS.resolveFor(actor).getText());
        if (numberRooms < 1) {
            actor.attemptsTo(
                    WaitUntil.the(BTN_ADD_ROOM, isClickable()).forNoMoreThan(10).seconds(),
                    Click.on(BTN_ADD_ROOM)
            );
        }
    }

    public static SelectNumberOfRooms toReserve() {
        return Tasks.instrumented(SelectNumberOfRooms.class);
    }
}

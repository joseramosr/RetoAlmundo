package co.com.cobre.certificacion.almundo.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

import static co.com.cobre.certificacion.almundo.userinterfaces.ActivitiesPageComponents.BTN_ORDER;

public class TheVisibilityOfTheSortButton implements Question<Boolean> {

    public TheVisibilityOfTheSortButton() {
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return Visibility.of(BTN_ORDER).viewedBy(actor).asBoolean();
    }

    public static TheVisibilityOfTheSortButton is() {
        return new TheVisibilityOfTheSortButton();
    }
}
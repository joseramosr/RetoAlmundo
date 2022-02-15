package co.com.cobre.certificacion.almundo.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

import static co.com.cobre.certificacion.almundo.userinterfaces.ActivitiesPageComponents.BTN_ACTIVITY_NAME;

public class TheVisibilityOfTheActivityNameFilter implements Question<Boolean> {

    public TheVisibilityOfTheActivityNameFilter() {
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return Visibility.of(BTN_ACTIVITY_NAME).viewedBy(actor).asBoolean();
    }

    public static TheVisibilityOfTheActivityNameFilter is() {
        return new TheVisibilityOfTheActivityNameFilter();
    }
}
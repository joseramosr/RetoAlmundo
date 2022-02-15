package co.com.cobre.certificacion.almundo.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

import static co.com.cobre.certificacion.almundo.userinterfaces.ActivitiesPageComponents.BTN_ACTIVITY_TYPE;

public class TheVisibilityOfTheActivityTypeFilter implements Question<Boolean> {

    public TheVisibilityOfTheActivityTypeFilter() {
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return Visibility.of(BTN_ACTIVITY_TYPE).viewedBy(actor).asBoolean();
    }

    public static TheVisibilityOfTheActivityTypeFilter is() {
        return new TheVisibilityOfTheActivityTypeFilter();
    }
}
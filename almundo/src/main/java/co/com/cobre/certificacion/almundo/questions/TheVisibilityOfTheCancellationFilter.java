package co.com.cobre.certificacion.almundo.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

import static co.com.cobre.certificacion.almundo.userinterfaces.ActivitiesPageComponents.BTN_FLEXIBLE_CANCELLATION;

public class TheVisibilityOfTheCancellationFilter implements Question<Boolean> {

    public TheVisibilityOfTheCancellationFilter() {
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return Visibility.of(BTN_FLEXIBLE_CANCELLATION).viewedBy(actor).asBoolean();
    }

    public static TheVisibilityOfTheCancellationFilter is() {
        return new TheVisibilityOfTheCancellationFilter();
    }
}
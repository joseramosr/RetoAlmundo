package co.com.cobre.certificacion.almundo.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

import static co.com.cobre.certificacion.almundo.userinterfaces.ActivitiesPageComponents.BTN_PRICE;

public class TheVisibilityOfThePriceFilter implements Question<Boolean> {

    public TheVisibilityOfThePriceFilter() {
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return Visibility.of(BTN_PRICE).viewedBy(actor).asBoolean();
    }

    public static TheVisibilityOfThePriceFilter is() {
        return new TheVisibilityOfThePriceFilter();
    }
}
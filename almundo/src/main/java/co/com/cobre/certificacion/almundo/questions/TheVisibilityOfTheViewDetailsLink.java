package co.com.cobre.certificacion.almundo.questions;

import static co.com.cobre.certificacion.almundo.userinterfaces.PackagesPageComponents.*;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;


public class TheVisibilityOfTheViewDetailsLink implements Question<Boolean> {

    public TheVisibilityOfTheViewDetailsLink() {
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return Visibility.of(LINK_SEE_DETAIL).viewedBy(actor).asBoolean();
    }

    public static TheVisibilityOfTheViewDetailsLink onTheFoundPackageIs() {
        return new TheVisibilityOfTheViewDetailsLink();
    }
}
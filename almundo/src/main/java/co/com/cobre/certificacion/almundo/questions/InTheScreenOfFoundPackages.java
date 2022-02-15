package co.com.cobre.certificacion.almundo.questions;

import static co.com.cobre.certificacion.almundo.userinterfaces.PackagesPageComponents.*;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class InTheScreenOfFoundPackages implements Question<String> {

    public InTheScreenOfFoundPackages() {
    }

    @Override
    public String answeredBy(Actor actor) {
        actor.attemptsTo(WaitUntil.the(TITLE_PACKAGES_BY_CITY, isVisible()).forNoMoreThan(20).seconds());
        return Text.of(TITLE_PACKAGES_BY_CITY).viewedBy(actor).asString();
    }

    public static InTheScreenOfFoundPackages thePackageNameIs() {
        return new InTheScreenOfFoundPackages();
    }
}
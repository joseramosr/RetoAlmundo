package co.com.cobre.certificacion.almundo.questions;

import static co.com.cobre.certificacion.almundo.userinterfaces.ActivitiesPageComponents.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class InTheScreenOfFoundActivities implements Question<Boolean> {

    private String city;

    public InTheScreenOfFoundActivities(String city) {
        this.city = city;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(WaitUntil.the(TITLE_ACTIVITIES_BY_CITY.of(city), isVisible()).forNoMoreThan(20).seconds());
        return Visibility.of(TITLE_ACTIVITIES_BY_CITY.of(city)).viewedBy(actor).asBoolean();
    }

    public static InTheScreenOfFoundActivities theVisibilityOfTheCityNameIs(String city) {
        return new InTheScreenOfFoundActivities(city);
    }
}
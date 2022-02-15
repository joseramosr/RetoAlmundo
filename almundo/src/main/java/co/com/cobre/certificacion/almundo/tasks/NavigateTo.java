package co.com.cobre.certificacion.almundo.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {

    private NavigateTo() {
    }

    public static Performable theAlmundoPage() {
        return Task.where("{0} opens the almundo page",
                Open.browserOn().thePageNamed("almundo")
        );
    }
}
package co.com.cobre.certificacion.almundo.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ActivitiesPageComponents {

    public static final Target BTN_ACTIVITIES = Target.the("Activities button").
            locatedBy("//span[contains(text(),'Actividades')]");

    public static final Target TEXT_BOX_CITY = Target.the("Field to enter city").
            locatedBy("//input[@id='origin']");

    public static final Target LIST_CITY_OPTION = Target.the("city list option").
            locatedBy("//mark[contains(text(),'{0}')]");

    public static final Target BTN_SEARCH_ACTIVITIES = Target.the("Button search activities").
            locatedBy("//button//span[contains(text(),'Buscar')]");

    public static final Target PROGRESS_BAR_ON_ACTIVITIES = Target.the("Progress bar on the activities screen to wait for the next items to load").
            locatedBy("//div[@class='progress-bar']/mb-progress-bar");

    public static final Target TITLE_ACTIVITIES_BY_CITY = Target.the("Text indicating the activities by chosen city").
            locatedBy("//div[@id='activities-results']//h1[contains(text(),'{0}')]");

    public static final Target ALERT_FLEXIBLE_BOOKING = Target.the("Flexible booking alert").
            locatedBy("//span[contains(@class,'close')]");

    public static final Target ITEMS_ACTIVITIES = Target.the("Activity items").
            locatedBy("//mb-card/footer//button/span/span[contains(text(),'ver actividad')]");

    public static final Target BTN_ORDER = Target.the("Order button").
            locatedBy("//label[contains(text(),'Ordenar por')]");

    public static final Target BTN_FLEXIBLE_CANCELLATION = Target.the("Filter button for flexible cancellation").
            locatedBy("//h3[text()='Cancelación']");

    public static final Target BTN_PRICE = Target.the("Filter button for price").
            locatedBy("//h3[text()='Precio']");

    public static final Target BTN_ACTIVITY_TYPE = Target.the("Filter button for activity type").
            locatedBy("//h3[text()='Tipo de actividad']");

    public static final Target BTN_ACTIVITY_NAME = Target.the("Filter button for activity name").
            locatedBy("//h3[text()='Nombre de la actividad']");

    private ActivitiesPageComponents() {
    }
}

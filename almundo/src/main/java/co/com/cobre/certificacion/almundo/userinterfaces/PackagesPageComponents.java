package co.com.cobre.certificacion.almundo.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class PackagesPageComponents {

    public static final Target BTN_PACKAGES = Target.the("Packages button").
            locatedBy("//span[contains(text(),'Paquetes')]");

    public static final Target BTN_ASSEMBLE_PACKAGE = Target.the("Radio button assemble your package").
            locatedBy("//span[text()='Armá tu paquete']/ancestor::span/preceding-sibling::span");

    public static final Target TEXT_BOX_DEPARTURE_CITY = Target.the("Field to enter departure city").
            locatedBy("//input[@id='flight-from']");

    public static final Target TEXT_BOX_ARRIVAL_CITY = Target.the("Field to enter arrival city").
            locatedBy("//input[@id='flight-to']");

    public static final Target TEXT_BOX_START_DATE = Target.the("Field to enter start date").
            locatedBy("//input[@id='startDate']");

    public static final Target BTN_SELECT_DAY_OF_THE_CURRENT_MONTH = Target.the("Button select day of the current month").
            locatedBy("(//button/span[text()='{0}'])[1]");

    public static final Target BTN_SELECT_DAY_OF_THE_NEXT_MONTH = Target.the("Button select day of the next month").
            locatedBy("(//button/span[text()='{0}'])[2]");

    public static final Target BTN_NEXT_MONTH = Target.the("Button next month").
            locatedBy("//*[@id='arrow-right']//ancestor::button");

    public static final Target TEXT_BOX_PERSONS_ROOMS = Target.the("Field to enter persons and rooms").
            locatedBy("(//input[@id='persons-rooms'])[1]");

    public static final Target TEXT_NUMBER_OF_ROOMS = Target.the("Text number of rooms").
            locatedBy("//span[text()='Habitaciones']/parent::div/following-sibling::div//div");

    public static final Target TEXT_NUMBER_OLD_PEOPLE = Target.the("Text number of old people").
            locatedBy("//span[text()='Mayores']/parent::div/following-sibling::div//div");

    public static final Target BTN_ADD_ROOM = Target.the("Button add room").
            locatedBy("//span[text()='Habitaciones']/parent::div/following-sibling::div//mb-icon[@id='add']");

    public static final Target BTN_ADD_OLD_PEOPLE = Target.the("Button add old people").
            locatedBy("//span[text()='Mayores']/parent::div/following-sibling::div//mb-icon[@id='add']");

    public static final Target BTN_READY = Target.the("Button ready").
            locatedBy("//button//span[contains(text(),'Listo')]");

    public static final Target PROGRESS_BAR_ON_PACKAGES = Target.the("Progress bar on the packages screen to wait for the next items to load").
            locatedBy("//div[@class='pkg-progress-bar']");

    public static final Target BTN_SEARCH_PACKAGES = Target.the("Button search packages").
            locatedBy("(//button//span[contains(text(),'Buscar')])[1]");

    public static final Target TITLE_PACKAGES_BY_CITY = Target.the("Text indicating the packages by chosen city").
            locatedBy("//a[text()='Paquetes']/following-sibling::a");

    public static final Target LINK_SEE_DETAIL = Target.the("Link see detail").
            locatedBy("//span[text()='Ver detalle']");

    private PackagesPageComponents() {
    }
}

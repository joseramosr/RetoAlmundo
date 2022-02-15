package co.com.cobre.certificacion.almundo.interactions;

import co.com.cobre.certificacion.almundo.utils.AddDaysTo;
import co.com.cobre.certificacion.almundo.utils.GenerateDate;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.cobre.certificacion.almundo.userinterfaces.PackagesPageComponents.BTN_NEXT_MONTH;
import static co.com.cobre.certificacion.almundo.utils.AddDaysTo.TWO_ADDITIONAL_DAYS;
import static co.com.cobre.certificacion.almundo.utils.AddDaysTo.ZERO_ADDITIONAL_DAYS;

public class SelectDates implements Interaction {

    private final String startDay;
    private final String endDay;

    public SelectDates(String startDay, String endDay) {
        this.startDay = startDay;
        this.endDay = endDay;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        int firstDayEnabledInCalendar = Integer.parseInt(GenerateDate.withAdditionalDaysToTheCurrentDate(TWO_ADDITIONAL_DAYS).getDay());
        int startDayInt = Integer.parseInt(startDay);
        int lastDayOfTheMonth = GenerateDate.withAdditionalDaysToTheCurrentDate(ZERO_ADDITIONAL_DAYS).getLastDayOfTheMonth();

        if (startDayInt < firstDayEnabledInCalendar) {
            actor.attemptsTo(
                    Click.on(BTN_NEXT_MONTH),
                    SelectDatesInTheCurrentMonth.ofTheCalendar(startDay, endDay)
            );
        } else {
            if (startDayInt == lastDayOfTheMonth || startDayInt == lastDayOfTheMonth - 1) {
                actor.attemptsTo(
                        SelectDatesInTheCurrentMonth.ofTheCalendar(startDay, endDay)
                );
            } else {
                int currentMonth = GenerateDate.withAdditionalDaysToTheCurrentDate(ZERO_ADDITIONAL_DAYS).getMonth();
                int monthWithAddedDays = GenerateDate.withAdditionalDaysToTheCurrentDate(AddDaysTo.END_DAY).getMonth();

                if (currentMonth != monthWithAddedDays) {
                    actor.attemptsTo(
                            SelectDatesInCurrentMonthAndNextMonth.ofTheCalendar(startDay, endDay)
                    );

                } else {
                    actor.attemptsTo(
                            SelectDatesInTheCurrentMonth.ofTheCalendar(startDay, endDay)
                    );
                }
            }

        }
    }

    public static SelectDates inTheCalendar(String starDay, String endDay) {
        return Tasks.instrumented(SelectDates.class, starDay, endDay);
    }
}

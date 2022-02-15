package co.com.cobre.certificacion.almundo.utils;

import java.util.Calendar;
import java.util.TimeZone;

public class GenerateDate {

    private final String day;
    private final int lastDayOfTheMonth;
    private final int month;

    public GenerateDate(int extraDay) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("America/Bogota"));
        this.lastDayOfTheMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        calendar.add(Calendar.DAY_OF_MONTH, extraDay);
        this.month = calendar.get(Calendar.MONTH) + 1;
        this.day = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
    }

    public static GenerateDate withAdditionalDaysToTheCurrentDate(int extraDay) {
        return new GenerateDate(extraDay);
    }

    public String getDay() {
        return day;
    }

    public int getLastDayOfTheMonth() {
        return lastDayOfTheMonth;
    }

    public int getMonth() {
        return month;
    }
}

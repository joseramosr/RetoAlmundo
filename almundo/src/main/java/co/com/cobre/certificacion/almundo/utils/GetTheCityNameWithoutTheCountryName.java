package co.com.cobre.certificacion.almundo.utils;

public class GetTheCityNameWithoutTheCountryName {

    private GetTheCityNameWithoutTheCountryName() {
    }

    public static String ofTheText(String cityAndCountry) {
        String[] arrayCityAndCountry = cityAndCountry.split(",");
        return arrayCityAndCountry[0];
    }
}

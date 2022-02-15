package co.com.cobre.certificacion.almundo.exceptions;

public class CityNotFound extends AssertionError {

    public static final String CITY_NOT_FOUND_ERROR = "ERROR, THE SEARCHED CITY WAS NOT FOUND";

    public CityNotFound(String message, Throwable testErrorException) {
        super(message, testErrorException);
    }
}

package co.com.cobre.certificacion.almundo.exceptions;

public class FilterNotFound extends AssertionError {

    public static final String BTN_FLEXIBLE_CANCELLATION_NOT_FOUND_ERROR = "ERROR, THE FILTER FOR ACTIVITIES WITH FLEXIBLE CANCELLATION WAS NOT FOUND";
    public static final String BTN_PRICE_NOT_FOUND_ERROR = "ERROR, THE FILTER FOR THE PRICE RANGE OF THE ACTIVITY WAS NOT FOUND";
    public static final String BTN_ACTIVITY_TYPE_NOT_FOUND_ERROR = "ERROR, THE FILTER FOR THE TYPE OF ACTIVITY TO SEARCH WAS NOT FOUND";
    public static final String BTN_ACTIVITY_NAME_NOT_FOUND_ERROR = "ERROR, THE FILTER TO SEARCH THE NAME OF THE ACTIVITY WAS NOT FOUND";
    public static final String BTN_ORDER_NOT_FOUND_ERROR = "ERROR, THE SORT FILTER WAS NOT FOUND";

    public FilterNotFound(String message, Throwable testErrorException) {
        super(message, testErrorException);
    }
}

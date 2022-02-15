package co.com.cobre.certificacion.almundo.exceptions;

public class PackageNotFound extends AssertionError {

    public static final String PACKAGE_NOT_FOUND_ERROR = "ERROR, THE PACKAGE SEARCH WAS NOT SUCCESSFUL OR THERE ARE NO PACKAGES FOR THE SEARCHED CITY";

    public PackageNotFound(String message, Throwable testErrorException) {
        super(message, testErrorException);
    }
}

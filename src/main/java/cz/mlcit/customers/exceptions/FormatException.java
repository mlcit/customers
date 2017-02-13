package cz.mlcit.customers.exceptions;

/**
 * Created by Mlcit on 12.02.2017.
 * FormatException is used when bad format is processed.
 */
public class FormatException extends Exception {

    public FormatException() {
        super();
    }

    public FormatException(String message) {
        super(message);
    }

    public FormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public FormatException(Throwable cause) {
        super(cause);
    }

}

package cz.mlcit.customers.exceptions;

/**
 * Created by Mlcit on 12.02.2017.
 * ValidationException is used when some entity has illegal values.
 */
public class ValidationException extends Exception {

    public ValidationException() {
        super();
    }

    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidationException(Throwable cause) {
        super(cause);
    }

}

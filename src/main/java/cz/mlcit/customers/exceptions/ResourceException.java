package cz.mlcit.customers.exceptions;

/**
 * Created by Mlcit on 12.02.2017.
 * ResourceException is used when resource is unavailable or not exist.
 */
public class ResourceException extends Exception {

    public ResourceException() {
        super();
    }

    public ResourceException(String message) {
        super(message);
    }

    public ResourceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceException(Throwable cause) {
        super(cause);
    }
}

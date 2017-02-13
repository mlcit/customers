package cz.mlcit.customers.exceptions;

/**
 * Created by Mlcit on 12.02.2017.
 * Error class is used for creating error messages for api response.
 */
public class Error {
    private String type;
    private String message;

    public Error(String type, String message) {
        this.type = type;
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

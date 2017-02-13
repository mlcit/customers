package cz.mlcit.customers.api;

import cz.mlcit.customers.exceptions.Error;

/**
 * Created by Mlcit on 12.02.2017.
 * Data class is used for building api response and it is prepared for other additional information.
 */
public class Data {

    private Object data;
    private Error error;

    public Data() {
        this.data = "OK";
    }

    public Data(Object data) {
        this.data = data;
    }

    public Data(Error error) {
        this.error = error;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
}

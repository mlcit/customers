package cz.mlcit.customers.utils;

import cz.mlcit.customers.exceptions.FormatException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Mlcit on 10.02.2017.
 * DateParam parse string in constructor to a Calendar.
 */
public class DateParam {

    private final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    private Calendar calendar = null;

    public DateParam(String string) throws Exception {
        if (string != null) {
            calendar = new GregorianCalendar();
            try {
                calendar.setTime(df.parse(string));
            } catch (ParseException e) {
                throw new FormatException("Date must be in format [" + df.toPattern() + "].");
            }
        }
    }

    public Calendar toCalendar() {
        return calendar;
    }

    @Override
    public String toString() {
        if (calendar != null) {
            return df.format(calendar);
        } else {
            return "";
        }
    }
}

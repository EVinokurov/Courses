package ru.itis.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {

    public static String formatDateToSimpleType(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
        return dateFormat.format(date);
    }
}

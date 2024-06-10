package com.alican.hotelbookingsystem.utils;

import com.alican.hotelbookingsystem.exception.DateConvertException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {

    public static Date convert(String date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date formattedDate = format.parse(date);
            return formattedDate;
        } catch (Exception e) {
            throw new DateConvertException("Date format is not valid");
        }
    }
}

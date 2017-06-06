package com.baf.musafir.bafphonebook.util;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import android.annotation.SuppressLint;
import android.util.Log;

public class DateUtility {

    /***********************************************************************************************
     * Parse string date to formatted date object
     * @param dateString
     * @param dateFormat
     * @return parseDate - Date object or null
     ***********************************************************************************************/
    public static Date parseDate(String dateString, String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        try {
            Date parsedDate = sdf.parse(dateString);
            return parsedDate;
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /***********************************************************************************************
     * Format simple date formatted object to string
     * @param date
     * @param dateFormat
     * @return formatDate - Formatted date string
     ***********************************************************************************************/
    public static String formatSDF(Date date, String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        String formatDate = sdf.format(date).trim();
        return formatDate;
    }

    /***********************************************************************************************
     * Format date object to string
     * @param date
     * @param dateFormat
     * @return formatDate - formatted date string
     ***********************************************************************************************/
    public static String formatDate(Date date, String dateFormat) {
        Format formatter = new SimpleDateFormat(dateFormat);
        String formatDate = formatter.format(date).trim();
        return formatDate;
    }

    /***********************************************************************************************
     * Convert Date to millisecond
     * @param fromDateString
     * @return
     ***********************************************************************************************/
    public static long dateToMillisecond(String fromDateString) {
        SimpleDateFormat sdf;
        Date date = null;
        sdf = new SimpleDateFormat(Tools.YYYY_MM_DD_HH_MM_SS);
        try {
            date = sdf.parse(fromDateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long currentMillisec = date.getTime();
        return currentMillisec;

    }

    /***********************************************************************************************
     * Calculate Difference between two Date
     * @param currentDate
     * @param oneday
     * @return
     ***********************************************************************************************/
    public static String dateFromDayDifference(String currentDate, long oneday) {
        SimpleDateFormat sdf;
        Date date = null;
        String finalDateString;
        sdf = new SimpleDateFormat(Tools.YYYY_MM_DD_HH_MM_SS);
        try {
            date = sdf.parse(currentDate);
            long currentMillisec = date.getTime();
            Date resultExpectDate = new Date((currentMillisec + oneday));
            String finalDate = sdf.format(resultExpectDate).toString().trim();
            date = sdf.parse(finalDate);
            finalDateString = formatDate(date, Tools.YYYY_MM_DD_HH_MM_SS);
            return finalDateString;
        } catch (Exception e) {
            return "NULL";
        }

    }

    /***********************************************************************************************
     * Convert any types of date format
     * @param fromFormate
     * @param toFormate
     * @param dateinString
     * @return
     ***********************************************************************************************/
    @SuppressLint("SimpleDateFormat")
    public static String dateConvertion(String fromFormate, String toFormate, String dateinString) {
        SimpleDateFormat sdf = new SimpleDateFormat(fromFormate);
        final Format formatter = new SimpleDateFormat(toFormate);
        String result = "";
        try {
            Date date = sdf.parse(dateinString);
            System.out.println(date);
            System.out.println(formatter.format(date));
            result = formatter.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            result = null;
        }
        return result;

    }
}

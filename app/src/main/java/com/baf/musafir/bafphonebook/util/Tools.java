/**
 *
 */
package com.baf.musafir.bafphonebook.util;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import android.annotation.SuppressLint;
import android.util.Log;

/**
 * @author Vaiuu
 */
@SuppressLint("SimpleDateFormat")
public class Tools {

    // Static final String
    public static final String EMPTY_SPACE = "";
    public static final String SINGLE_SPACE = " ";

    public static final String UNDERSCORE = "_";
    public static final String COMA = ",";
    public static final String SEMICOLON = ";";
    public static final String COLON = ":";
    public static final String SINGLE_QUOTE = "'";
    public static final String DOT = ".";

    public static final String LEFT_PARENTHESIS = "(";
    public static final String RIGHT_PARENTHESIS = ")";

    public static final String BACK_SLASH = "/";
    public static final String RIGHT_SLASH = "\\";

    // Static Date Pattern
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String EEEE_DD_MMMM = "EEEE, dd MMMM";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    // Static Final Numeric
    public static final long ONE_DAY = 24 * 60 * 60 * 1000;
    // static Final SystemDate
    public static final long TIME_MILLISECOND = System.currentTimeMillis();
    // Static File Extensions
    public static final String PNG = ".png";
    public static final String PDF = ".pdf";
    public static final String MP3 = ".mp3";
    public static final String MP4 = ".mp4";
    public static final String DOC = ".doc";
    public static final String JPEG = ".jpeg";
    public static final String VIDEO = ".avi";
    public static final String XLS = ".xls";
    public static final String TXT = ".txt";
    public static final String DOCX = ".docx";
    public static final String MPG = ".mpg";
    public static final String XLSX = ".xlsx";
    public static final String JPG = ".jpg";
    // Static mime type
    public static final String PDF_MIME_TYPE = "application/pdf";
    public static final String MP3_MIME_TYPE = "audio/mp3";
    public static final String MP4_MIME_TYPE = "video/mp4";

    public static final String DOC_MIME_TYPE = "application/msword";
    public static final String JPEG_MIME_TYPE = "image/jpeg";
    public static final String VIDEO_MIME_TYPE = "video/*";
    public static final String XLS_MIME_TYPE = "application/vnd.ms-powerpoint";
    public static final String TXT_MIME_TYPE = "text/plain";


    public static String buildCommaSeparatedValue(List<String> lstString) {
        String commaSeparatedString = EMPTY_SPACE;
        for (int i = 0; i < lstString.size(); i++) {
            if ((i + 1) == lstString.size()) {
                commaSeparatedString = commaSeparatedString + SINGLE_QUOTE
                        + lstString.get(i) + SINGLE_QUOTE;
            } else {
                commaSeparatedString = commaSeparatedString + SINGLE_QUOTE
                        + lstString.get(i) + SINGLE_QUOTE + COMA;
            }
        }
        Log.w("commaSeparatedString ", commaSeparatedString);
        return commaSeparatedString;
    }

    @SuppressLint("SimpleDateFormat")
    public static String dateConvertion(String fromFormate, String toFormate,
                                        String dateinString) {

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

    public static String toUpperCaseFirstLetter(String string) {
        String sourceString=string;
        sourceString = sourceString.substring(0,1).toUpperCase() + sourceString.substring(1).toLowerCase();;
        return sourceString;
    }

}

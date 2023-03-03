package utils;


import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {


    public static String getCurrentDate(){
        return new Date().toString();
    }


    /**
     * This method is used for Extent Report
     * @return
     */
    public static String getCurrentDateAndTimeForReport(){
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
        return df.format(date);
    }


    public static String getCurrentTimeInMilis(){
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return String.valueOf(c.getTimeInMillis());
    }

    public static String getCurrentDateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:SS");
        LocalDateTime localDateTime = LocalDateTime.now();
        String curr = dtf.format(localDateTime);
        return curr;
    }

    public static String getCurrentDateTimeExcel() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yy-HH-mm-SS");
        LocalDateTime localDateTime = LocalDateTime.now();
        String curr = dtf.format(localDateTime);
        return curr;
    }
    public static void main(String[] args) {
        System.out.println();
    }

}

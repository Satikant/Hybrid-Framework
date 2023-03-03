package common;


import java.text.SimpleDateFormat;
import java.util.Date;

public class DataFactory {

    public static String getTimeStamp() {
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    }
}

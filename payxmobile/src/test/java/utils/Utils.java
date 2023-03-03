package utils;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import framework.mobiquityPayX.qnb.fetchOtp.FetchOtp;
import globalConstants.FilePaths;
import initializers.AppPageInit;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.lept;
import org.bytedeco.javacpp.tesseract;
import org.openqa.selenium.*;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.testng.Assert;
import propertyManagement.MobileProperties;
import propertyManagement.TestCases;
import reportManagement.ExtentManager;
import reportManagement.Screenshot;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static org.bytedeco.javacpp.lept.pixDestroy;
import static org.bytedeco.javacpp.lept.pixRead;



/**
 * Created by ayush.singh on 21-11-2019.
 */
public class Utils extends AppPageInit{

    protected static LogEntries clientLog;
    protected static LogEntries logcatLog;



/*    public static void scrollDown(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }*/


//    MobileElement element = (MobileElement) driver.findElementByClassName("android.widget.ListView");
//    JavascriptExecutor js = (JavascriptExecutor)driver;
//    HashMap<String, String> scrollObject = new HashMap<String, String>();
//    scrollObject.put("direction", "down");
//    scrollObject.put("element", ((RemoteWebElement) element).getId());
//    scrollObject.put("text", "AUDI");
//    js.executeScript("mobile: scrollTo", scrollObject);




/*    public void scrollUp(WebElement element){
        js.executeScript("arguments[0].scrollIntoView();", element);
    }*/


    public static void putThreadSleep(int miliSecond) {
        try {
            Thread.sleep(miliSecond);
        } catch (InterruptedException e) {
            System.err.println("Interrupted Exception occurred :" + e);
        } catch (Exception e) {
            System.err.println("Exception occurred :" + e);
        }
    }

    public static void attachFileAsExtentLog(String filename,ExtentTest node){
        node.log(Status.INFO, "<b> <h6><font color='TEAL'>Link to Log File :</b><a href='" + filename + "'><b><h6><font color='blue'> " + filename + "</font></h6></b></a>");
    }

    public static void scrollToRightOfActivityPage()  {
        System.out.println("Right Swipe ");
        Dimension dim =driver.manage().window().getSize();
        int height = dim.getHeight();
        int width=dim.getWidth();
        int starty = height/2;
        int startx = (int)(width * 0.90);
        int endx = (int)(width * 0.05);
       PointOption.point(startx,starty).build();
       PointOption.point(endx,starty).build();
    }

    public static void rightLeftSwipe(int timeduration) {
         Dimension size = driver.manage().window().getSize();
        System.out.println(size);
        int startx = (int) (size.width * 0.70);
        int endx = (int) (size.width * 0.30);
        int starty =(int) size.height / 2;
        System.out.println("Start swipe operation");
       PointOption.point(startx, starty).build();
       PointOption.point(endx, starty).build();
    }


    public static void slideSeekBar(String elemenId , int timeduration)
    {
        WebElement seek_bar=driver.findElement(By.id(elemenId));
        int start=seek_bar.getLocation().getX();
        int end=seek_bar.getSize().getWidth();
        int y=seek_bar.getLocation().getY();
        PointOption.point(start, y);
        PointOption.point(end, y);

    }

/*
* set the event
* Move finger to starting position
*    a) Determine Scroll area dimension
*    b) Determine X and Y on Screen
* Finger comes in contact with the screen
* Wait for a bit
* Finger moves to position
*   a) Determine X and Y on Screen
*   b) speed
* Finger moves up from the screen
* */

    public static void scrollDown(){
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollToEnd(10)"));
    }


    public static void scrollUp(){


    }
    public static void zoomOut(){

    }
    public static void zoomIn(){

    }
    public static void swipeRight(){

    }
    public static void swipeLeft(){

    }

    public static String getToastMessage()  {
        String str = "",path,tokenpath="";
        try{
            path=Screenshot.captureScreenMobile();
            BytePointer outText;
            tesseract.TessBaseAPI api = new tesseract.TessBaseAPI();
            if (api.Init(System.getProperty("user.home") +"\\AppData\\Local\\Programs\\Tesseract-OCR\\tessdata", MobileProperties.getProperty("tessdata.lang")) != 0) {
                System.err.println("Could not initialize tesseract.");
                System.exit(1);
            }
            System.out.println(path);
            String[] tokens = path.split(".+?/(?=[^/]+$)");
            for (String token : tokens) {
                tokenpath=token;
            }
            System.out.println(tokenpath);
            pageInfo.info("Message :- "+ MediaEntityBuilder.createScreenCaptureFromPath("../reports/captures/"+tokenpath).build());
            lept.PIX image = pixRead(FilePaths.toastmessage + tokenpath);
            api.SetImage(image);
            outText = api.GetUTF8Text();
            str = outText.getString();
            Assert.assertTrue(!str.isEmpty());
            api.End();
            outText.deallocate();
            pixDestroy(image);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return str;
    }
    private static final Scanner scanner = new Scanner(System.in);


    public static String  fetchDecimalNumber(String msg){
        Pattern pattern = Pattern.compile("(\\d+)(\\.)?(\\d+)?");
        Matcher matcher = pattern.matcher(msg);
        String val = "";
        if (matcher.find()) {
            return    val = matcher.group(0);
        }
        else {
            return "";
        }
    }

    public static void captureClientLog() {
        try {
            clientLog =  driver.manage().logs().get("client");
            createTxtFile(FilePaths.CLIENT_LOGS);
            PrintWriter log_file_writer = new PrintWriter(FilePaths.CLIENT_LOGS);
            for (LogEntry entry : clientLog) {
                log_file_writer.println(entry.getMessage());
                log_file_writer.flush();
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void captureLogcatLog() {
        try {
            logcatLog =  MobileProperties.getProperty("device.platform").equalsIgnoreCase("android")
                    ?driver.manage().logs().get("logcat")
            :driver.manage().logs().get("syslog");
            new PrintWriter(FilePaths.LOGCAT_LOGS).close();
            PrintWriter log_file_writer = new PrintWriter(FilePaths.LOGCAT_LOGS);
            for (LogEntry entry : logcatLog) {
                if (entry.getMessage().contains("org.json.JSONException")) {
                log_file_writer.println(entry.getMessage());
                log_file_writer.flush();
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String  fetchServiceRequestId(String serviceFlow){
        captureLogcatLog();
        String serviceRequestId = null;
        String line;
        try{
            FileReader fr = new FileReader(FilePaths.LOGCAT_LOGS);
            BufferedReader br = new BufferedReader(fr);
            while((line =  br.readLine()) != null){
                if (line.contains("serviceRequestId") && line.contains(serviceFlow))
                {
                    serviceRequestId = serviceFlow == "P2P"?line.split(":")[6] : line.split(":")[5];
                    break;
                }
            }
            serviceRequestId = serviceRequestId.split(",")[0];
            serviceRequestId =   serviceRequestId.replaceAll("\"","");
            return serviceRequestId;
        }
        catch (Exception e){
            pageInfo.fail("Unable to Find Service Request ID :- ");
            pageInfo.log(Status.INFO,"StackTrace Result: " + ExceptionUtils.getStackTrace(e));
            return   "";
        }
    }


    public static void createTxtFile(String pathFileName) {
        try {
            File file = new File(pathFileName);
            if(file.exists()){
              //  System.out.println("File already exists.");
            }
            else{
                file.createNewFile();
                System.out.println("File Created : "+ pathFileName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

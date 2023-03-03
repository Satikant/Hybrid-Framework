package utils;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import reportManagement.ExtentManager;
import reportManagement.Screenshot;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;


public class CommonUtils {

    public static void pauseExecution(int seconds){
        try{
            System.out.println("Wait For  : "+ seconds +"sec");
            Thread.sleep(seconds*1000);
        }catch (InterruptedException e){
            System.err.println("Error occured");
        }
    }

    public static void createMethodLabel(String methodName){
        Markup m = MarkupHelper.createLabel("Inside Method: "+methodName, ExtentColor.TEAL);
        ExtentManager.getTest().info(m);
    }
    public static void captureScreenMobile(ExtentTest node, String details){
        try{
            node.info(details,MediaEntityBuilder.createScreenCaptureFromPath(Screenshot.captureScreenMobile()).build());
        }catch (Exception e){
            System.out.println("Exception Occurred while capturing Screen");
            System.out.println(e);
        }
    }

    public static String takeScreenShotOfCurrentView() {
        System.out.println("\n Taking Screenshot");
        String capturePath = "reports/captures/";
        String fileName = "scr" + DateUtil.getCurrentDateAndTimeForReport() + ".png";
        String filePath = capturePath + fileName;
        try {
                        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            Rectangle screenRectangle = new Rectangle(screenSize);
            Robot robot = new Robot();
            BufferedImage image = robot.createScreenCapture(screenRectangle);
            ImageIO.write(image, "png", new File(filePath));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "../captures/"+fileName;
    }

}

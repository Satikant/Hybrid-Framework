package reportManagement;

import common.DriverFactory;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.DateUtil;

import java.io.File;
import java.io.IOException;
public class Screenshot {

    private static WebDriver webdriver;
    private static AppiumDriver mobileDriver;

    static {
    //    webdriver = DriverFactory.getDriver();
        mobileDriver = DriverFactory.getMobileAppDriver();
    }
    public static String captureScreenMobile() {
        System.out.println("\n Taking Screenshot");
        String capturePath = "reports/captures/";
        String fileName = "scr" + DateUtil.getCurrentDateAndTimeForReport() + ".png";
        String filePath = capturePath + fileName;
        try {
            File src = ((TakesScreenshot) mobileDriver).getScreenshotAs(OutputType.FILE);
            File dest = new File(filePath);
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "../captures/"+fileName;
    }
}

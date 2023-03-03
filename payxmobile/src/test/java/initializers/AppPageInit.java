package initializers;

import com.aventstack.extentreports.ExtentTest;
import common.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.Setting;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import propertyManagement.MobileProperties;
import reportManagement.ExtentManager;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Set;


public class AppPageInit {

    protected static AppiumDriver driver;
    protected static ExtentTest pageInfo;
    protected static Actions action ;
    protected  WebElement element;
    protected  String locatorId;


    public AppPageInit() {
        driver = DriverFactory.getMobileAppDriver();
        System.out.println("Mobile DRIVER : " + driver);
       // driver.switchTo().alert().accept();
        driver.setSetting(Setting.WAIT_FOR_IDLE_TIMEOUT, 100);
        driver.setSetting(Setting.IGNORE_UNIMPORTANT_VIEWS,true);
       /*Set plog = driver.manage().logs().getAvailableLogTypes();
        for(Object gh : plog){
            System.out.println(gh.toString());
        }*/
        //CommonUtils.pauseExecution(5);
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public boolean isElementNotPresent(WebElement element ) {
        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60), Duration.ofMillis(500));
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementNotPresent(WebElement element,long timeOutInSeconds ) {
        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds), Duration.ofMillis(500));
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean waitUntilElementDisappear(String androidLocatorId , String iOSLocatorId) {
        try {
            locatorId  = MobileProperties.getProperty("device.platform").equalsIgnoreCase("android")?
                    androidLocatorId:iOSLocatorId;
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60), Duration.ofMillis(500));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(locatorId)));
            return false;
        } catch (NoSuchElementException e) {
            return true;
        }
    }

    public boolean waitUntilElementDisappear(String locatorId) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60), Duration.ofMillis(500));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(locatorId)));
            return false;
        } catch (NoSuchElementException e) {
            return true;
        }
    }

    public boolean isElementClickable(WebElement element){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60), Duration.ofMillis(500));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    protected void setText(WebElement element, String text, String elementName) {
        pageInfo = ExtentManager.getTest();
        element.sendKeys(text);
        pageInfo.info("Entered text: '" + text + "' into field " + elementName);
    }

    protected void setTextByAction(String text, String elementName) {
        pageInfo = ExtentManager.getTest();
        action = new Actions(driver);
        action.sendKeys(text).perform();
        pageInfo.info("Entered text: '" + text + "' into field " + elementName);
    }

    protected void clickOnElement(WebElement element, String elementName) {
        pageInfo = ExtentManager.getTest();
        element.click();
        pageInfo.info("Clicked on : '" + elementName + "'");
    }


    protected void clear(WebElement element, String elementName) {
        pageInfo = ExtentManager.getTest();
        element.clear();
        pageInfo.info("Value Clear on : '" + elementName + "'");
    }

    protected void info(String information) {
        pageInfo = ExtentManager.getTest();
        pageInfo.info(information);
    }

    protected String getAttribute(WebElement element, String attributeName,String elementName){
        pageInfo = ExtentManager.getTest();
        pageInfo.info("Getting Attribute '"+attributeName+"' of : '" + elementName + "'");
        return element.getAttribute(attributeName);
    }

    protected String getText(WebElement element,String elementName){
        pageInfo = ExtentManager.getTest();
        pageInfo.info("Getting Text of : '" + elementName + "'");
        return element.getText();
    }

}

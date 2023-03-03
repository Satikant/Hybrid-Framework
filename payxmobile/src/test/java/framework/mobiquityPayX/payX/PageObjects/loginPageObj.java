package framework.mobiquityPayX.payX.PageObjects;

import com.aventstack.extentreports.Status;
import initializers.AppPageInit;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import propertyManagement.MobileProperties;
import utils.Utils;

public class loginPageObj extends AppPageInit {


    public loginPageObj() {
        super();
    }

    @FindBy(xpath = "//XCUIElementTypeButton[@name='Allow']")
    private WebElement iOSnotificationAllow;
    @FindBy(xpath = "//XCUIElementTypeButton[@name='OK']")
    private WebElement iOSnotificationOk;
    @AndroidFindBy(xpath = "//*[@text='Login']")
    private WebElement loginPage;

    @AndroidFindBy(xpath = "//*[@text='Mobile number']")
    private WebElement mobileNum;
    @FindBy(xpath = "//XCUIElementTypeTextField[@value='Mobile number']")
    private WebElement iOSmobileNum;

    @AndroidFindBy(xpath = "//*[@text='Enter PIN']")
    private WebElement Pin;
    @FindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Enter PIN']")
    private WebElement iOSPin;

    @AndroidFindBy(xpath = "//*[@text='Next']")
    private WebElement loginbtn;
    @FindBy(xpath = "(//XCUIElementTypeStaticText[@name='Login'])[2]")
    private WebElement iOSLoginbtn;

    @FindBy(xpath = "//XCUIElementTypeButton[@name='Done]")
    private WebElement iOSDoneinkeyboard;

    @AndroidFindBy(xpath = "//*[@text='user not found or not active in the system']")
    private WebElement errorMSG;

    @AndroidFindBy(xpath = "//*[@text='Error']")
    private WebElement errorBox;

    @AndroidFindBy(xpath = "//*[@text='OK']")
    private WebElement acceptError;

    @AndroidFindBy(id = "otp_edit_text")
    private WebElement pinField;

    @AndroidFindBy(xpath = "//*[@text='Login']")
    private WebElement login;
    Boolean devicePlatform = MobileProperties.getProperty("device.platform").equalsIgnoreCase("android");


    public loginPageObj setMobileNum(String msisdn) {
        element = devicePlatform ? mobileNum : iOSmobileNum;
        isElementNotPresent(element);
        setText(element, msisdn, "Entering the mobile number");
        return this;
    }

    public loginPageObj setPin(String pin) {
        element = devicePlatform ? Pin : iOSPin;
        isElementNotPresent(element);
        setText(element, pin, "Entering the Pin");
        return this;
    }

    public loginPageObj setPin2(String pin) {
        Utils.putThreadSleep(5000);
        setText(pinField, pin, "Entering the Pin");
        return this;
    }

    public loginPageObj clickonLogin2() {
        clickOnElement(login, "clicking on Login button");
        return this;
    }

    public loginPageObj clickonLogin() {
        clickOnElement(loginbtn, "clicking on Login button");
        return this;
    }

    public loginPageObj clearMobileNumber() {
        clear(mobileNum, "mobile number field");
        return this;
    }

    public boolean ifErrorDilogBoxPresent() {
        isElementNotPresent(errorBox);
        return driver.findElements(By.xpath("//*[@text='Error']")).size() > 0;
    }

    public boolean isErrorDilogboxPresent() {
        Utils.putThreadSleep(5000);
        return driver.findElements(By.xpath("//*[@text='Error']")).size() > 0;
    }
    public boolean isFirstNotificationiOSPresent(){
        Utils.putThreadSleep(5000);
        return driver.findElements(By.xpath("//XCUIElementTypeButton[@name='Allow']")).size()>0;
    }
    public boolean isSecondNotificationiOSPresent(){
        Utils.putThreadSleep(5000);
        return driver.findElements(By.xpath("//XCUIElementTypeButton[@name='OK']")).size()>0;
    }

    public boolean isAleartBoxPresent() {
        isElementNotPresent(acceptError);
        return driver.findElements(By.xpath("//*[@text='OK']")).size() > 0;
    }

    public loginPageObj clickOnAcceptErr() {
        clickOnElement(acceptError, "Clicking on OK button of error message box");
        return this;
    }
    public loginPageObj clickOnAllowNotification() {
        clickOnElement(iOSnotificationAllow, "Clicking on Allow button in notification pop up");
        return this;
    }
    public loginPageObj clickOnOkNotification() {
        clickOnElement(iOSnotificationOk, "Clicking on OK button in notification pop up");
        return this;
    }


    public String getErrorText() {
        try {
            waitUntilElementDisappear("pb_loading");
            info("Fetching Text : " + errorBox.getText());
            return errorBox.getText();
        } catch (Exception e) {
            e.printStackTrace();
            pageInfo.fail("Test Case Failed");
            pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        return "";
    }

}

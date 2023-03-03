package framework.mobiquityPayX.qnb.pageObjects;

import com.aventstack.extentreports.Status;
import initializers.AppPageInit;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.TapOptions;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.*;

import org.openqa.selenium.support.FindBy;
import propertyManagement.MobileProperties;
import utils.CommonUtils;
import utils.Utils;

import java.util.HashMap;
import java.util.List;

public class QNBLoginPageObjects extends AppPageInit {
    public QNBLoginPageObjects(){
        super();
    }

    @AndroidFindBy(xpath = "//*[@content-desc='loginMobileNumber']")
    private WebElement loginMobileNumber;

    @FindBy(name = "Form_InputField_0")
    private List<WebElement> msisdnPin;

    @FindBy(id = "Done")
    private WebElement hideKeyboard;

    @FindBy(id = "Previous")
    private WebElement prevKeyboard;

    @AndroidFindBy(id = "homeAvailableLabel")
    private WebElement homeAvailableLabel;

    @AndroidFindBy(xpath = "//*[@content-desc='loginpin']")
    private WebElement loginpin;

    @AndroidFindBy(id = "loginButton")
    private WebElement loginButton;

    @FindBy(xpath = "//XCUIElementTypeButton[@index = '6']")
    private WebElement login;

    @FindBy(name = "Form_InputField_0")
    private WebElement log;

   @AndroidFindBy(id = "pb_loading")
    private WebElement loader;

   @AndroidFindBy(id = "toolbarTextViewCenter")
    private WebElement toolbarTextViewCenter;

    @AndroidFindBy(id = "custom_dialog_message_textView")
    private WebElement validationMessage;

    @AndroidFindBy(id = "custom_dialog_ok_buttonView")
    private WebElement ok;

    @AndroidFindBy(id = "errortext")
    private List<WebElement> errorText;

    @AndroidFindBy(id = "button_enter")
    private WebElement enterButton;

    Boolean devicePlatform = MobileProperties.getProperty("device.platform").equalsIgnoreCase("android");
    WebElement element;

    public QNBLoginPageObjects setMobileNumber(String msisdn){
            element = devicePlatform ?loginMobileNumber :log;
            isElementNotPresent(element);
            element = devicePlatform ? loginMobileNumber : msisdnPin.get(0);
            setText(element,msisdn,"Mobile Number");
            return this;
    }

    public QNBLoginPageObjects setPin(String pin){
        if(devicePlatform) {
            isElementNotPresent(loginpin);
            setText(loginpin,pin,"Login PIN");
            return this;
        }
        else{
            clickOnElement(hideKeyboard,"Done");
            isElementNotPresent(msisdnPin.get(1));
            setText(msisdnPin.get(1),pin,"Login PIN");
            clickOnElement(prevKeyboard,"Previous");
            CommonUtils.pauseExecution(3);
            clickOnElement(hideKeyboard,"Done");
            return this;
        }

    }


    public QNBLoginPageObjects getFocus(){
        if(devicePlatform) {
            clickOnElement(loginMobileNumber, "Login Mobile Number");
            clickOnElement(loginpin, "Login PIN");
            clickOnElement(enterButton, "Enter button");
            driver.navigate().back();
        }
        else{

        }
        return this;
    }



    public QNBLoginPageObjects clickOnLoginButton(){
            element = devicePlatform?loginButton:login;
            clickOnElement(element, "Login Button");
            waitUntilElementDisappear("pb_loading","In progress");
        return this;
    }



    public Boolean isHomePageDisplayed(){
        waitUntilElementDisappear("pb_loading");
        isElementNotPresent(homeAvailableLabel);
        System.out.println("Waiting for Home Page to be Displayed...");
        info("Waiting for Home Page to be Displayed...");
        return driver.findElements(By.id("toolbarTextViewCenter")).size() > 0 ;
    }

    public String getWelcomeText(){
        try{
            waitUntilElementDisappear("pb_loading");
            info("Fetching Text : "+toolbarTextViewCenter.getText());
            return toolbarTextViewCenter.getText();
        }
        catch (Exception e){
            e.printStackTrace();
            pageInfo.fail("Test Case Failed");
            pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        return "";
    }

    public String getValidationMessageFromDialog(){
        try{
            waitUntilElementDisappear("pb_loading");
            info("Fetching Text : "+validationMessage.getText());
            return validationMessage.getText();
        }
        catch (Exception e){
            e.printStackTrace();
            pageInfo.fail("Test Case Failed");
            pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
            return "";
        }
    }

    public String getValidationMessageFromLabel(){
        try{
            info("Fetching Text : "+errorText.get(0).getText());
            return errorText.get(0).getText();
        }
        catch (Exception e){
            e.printStackTrace();
            pageInfo.fail("Test Case Failed");
            pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
            return "";
        }
    }

    public QNBLoginPageObjects clickOnOkButton(){
        clickOnElement(ok,"OK Button");
        return this;
    }

    public Boolean isValidationDialogBoxDisplayed(){
        return driver.findElements(By.id("custom_dialog_ok_buttonView")).size() > 0 ;
    }
}

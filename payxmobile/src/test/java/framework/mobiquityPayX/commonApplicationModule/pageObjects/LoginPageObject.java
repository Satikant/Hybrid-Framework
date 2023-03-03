package framework.mobiquityPayX.commonApplicationModule.pageObjects;

import com.aventstack.extentreports.Status;
import initializers.AppPageInit;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import propertyManagement.MobileProperties;

import java.util.List;

public class LoginPageObject extends AppPageInit {

    public LoginPageObject(){
        super();
    }

    @AndroidFindBy(xpath = "//*[@content-desc='loginMobileNumber']")
    private WebElement loginMobileNumber;

    @AndroidFindBy(xpath = "//*[@content-desc='loginpin']")
    private WebElement loginpin;

    @AndroidFindBy(id = "loginButton")
    private WebElement loginButton;

    @AndroidFindBy(id = "homeAvailableLabel")
    private WebElement homeAvailableLabel;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@index='1']")
    private WebElement homeAvailableLabelIOS;

    @AndroidFindBy(id = "pb_loading")
    private WebElement loader;

    @AndroidFindBy(id = "toolbarTextViewCenter")
    private WebElement toolbarTextViewCenter;

    @AndroidFindBy(id = "custom_dialog_message_textView")
    private WebElement validationMessage;

    @FindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeStaticText[@index='2']")
    private WebElement getValidationMessageIOS;

    @AndroidFindBy(id = "custom_dialog_ok_buttonView")
    private WebElement ok;

    @FindBy( name = "PopUpActionButtonIdentifier")
    private WebElement okIOS;

    @AndroidFindBy(id = "errortext")
    private List<WebElement> errorText;

    @AndroidFindBy(id = "button_enter")
    private WebElement enterButton;

    @FindBy(name = "Form_InputField_0")
    private List<WebElement> msisdnPin;

    @FindBy(id = "Done")
    private WebElement hideKeyboard;

    @FindBy(id = "Previous")
    private WebElement prevKeyboard;

    @FindBy(xpath = "//XCUIElementTypeButton[@name='Login']")
    private WebElement login;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@index='1']")
    private WebElement errorTextIOS;

    @FindBy(name = "Form_InputField_0")
    private WebElement log;

    @FindBy(xpath = "//XCUIElementTypeCell[1]")
    private WebElement pin;

    @FindBy(xpath = "//XCUIElementTypeButton[@index='7']")
    private WebElement rrbAccountButton;

    Boolean devicePlatform = MobileProperties.getProperty("device.platform").equalsIgnoreCase("android");
    WebElement element;

    public LoginPageObject setMobileNumber(String msisdn){
        element = devicePlatform ?loginMobileNumber :log;
        isElementNotPresent(element);
        element = devicePlatform ? loginMobileNumber : msisdnPin.get(0);
        element.clear();
        setText(element,msisdn,"Mobile Number");
        if(!devicePlatform){
            isElementNotPresent(hideKeyboard,5);
            clickOnElement(hideKeyboard,"Done");
        }
        return this;
    }

    public LoginPageObject setPin(String pin){
        if(devicePlatform) {
            isElementNotPresent(loginpin);
            setText(loginpin,pin,"Login PIN");
            return this;
        }
        else{
            isElementNotPresent(msisdnPin.get(1));
            msisdnPin.get(1).clear();
            setText(msisdnPin.get(1),pin,"Login PIN");
          //  clickOnElement(prevKeyboard,"Previous");
            isElementNotPresent(hideKeyboard,5);
            clickOnElement(hideKeyboard,"Done");
            return this;
        }
    }

    public LoginPageObject setPinForLoggedInUser(String loggedInUserPin){
        setText(pin,loggedInUserPin,"Logged In User's PIN");
        clickOnElement(hideKeyboard,"Done");
        return this;
    }

        public LoginPageObject  getFocus(){
            if(devicePlatform) {
                clickOnElement(loginMobileNumber, "Login Mobile Number");
                clickOnElement(loginpin, "Login PIN");
               // clickOnElement(enterButton, "Enter button");
                driver.navigate().back();
            }
            else{

            }
           return this;
        }

        public LoginPageObject clickOnLoginButton(){
            element = devicePlatform?loginButton:login;
            clickOnElement(element, "Login Button");
            waitUntilElementDisappear("pb_loading","In progress");
            return this;
        }



        public Boolean isHomePageDisplayed(){
           element = devicePlatform?homeAvailableLabel:homeAvailableLabelIOS;
            waitUntilElementDisappear("pb_loading","In progress");
            isElementNotPresent(element);
            System.out.println("Waiting for Home Page to be Displayed...");
            info("Waiting for Home Page to be Displayed...");
            return  element.isDisplayed();
        }

        public String getWelcomeText(){
            try{
                waitUntilElementDisappear("pb_loading","In progress");
                element = devicePlatform?toolbarTextViewCenter:homeAvailableLabelIOS;
                info("Fetching Text : "+element.getText());
                return element.getText();
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
                waitUntilElementDisappear("pb_loading","In progress");
                element = devicePlatform ? validationMessage : getValidationMessageIOS;
                info("Fetching Text : "+element.getText());
                return element.getText();
            }
            catch (Exception e){
                e.printStackTrace();
                pageInfo.fail("Test Case Failed");
                pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
                return "";
            }
        }

        public Boolean isErrorLabelPresent(){
        return driver.findElements(By.id("errortext")).size() > 0;
        }

        public String getValidationMessageFromLabel(){
        element = devicePlatform?errorText.get(0):errorTextIOS;
            try{
                info("Fetching Text : "+element.getText());
                return element.getText();
            }
            catch (Exception e){
                e.printStackTrace();
                pageInfo.fail("Test Case Failed");
                pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
                return "";
            }
        }

        public LoginPageObject clickOnOkButton(){
            element = devicePlatform ? ok : okIOS;
            clickOnElement(element,"OK Button");
            return this;
        }

        public Boolean isValidationDialogBoxDisplayed(){
            return     devicePlatform?
                driver.findElements(By.id("custom_dialog_ok_buttonView")).size() > 0 :
            driver.findElements(By.name("PopUpActionButtonIdentifier")).size() > 0;

        }

    public Boolean isRRBAcoountDisplayed(){
        return     devicePlatform?
                driver.findElements(By.id("custom_dialog_ok_buttonView")).size() > 0 :
                driver.findElements(By.name("Open new RBB account")).size() > 0;

    }
    public Boolean isMsisdnFieldPresent(){
        return     devicePlatform?
                driver.findElements(By.id("custom_dialog_ok_buttonView")).size() > 0 :
                driver.findElements(By.name("Form_InputField_0")).size() > 0;

    }


}

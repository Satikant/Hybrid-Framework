package framework.mobiquityPayX.DBXP.pageObjects;

import com.aventstack.extentreports.Status;
import framework.mobiquityPayX.commonApplicationModule.pageObjects.LoginPageObject;
import initializers.AppPageInit;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import propertyManagement.MobileProperties;

public class DBXPLoginPageObjects extends AppPageInit {

    public DBXPLoginPageObjects(){
        super();
    }

    @AndroidFindBy (id = "com.comviva.dbxp.app:id/user_id")
    private WebElement loginMobileNumber ;

    @AndroidFindBy (id = "com.comviva.dbxp.app:id/password")
    private WebElement loginpin ;

    @AndroidFindBy (id = "com.comviva.dbxp.app:id/login")
    private WebElement loginButton ;

    @AndroidFindBy(id = "com.comviva.dbxp.app:id/forgot")
    private WebElement forgotPin;

    @AndroidFindBy(id = "com.comviva.dbxp.app:id/syncAccountsLabel")
    private WebElement homepageTitle;

    @AndroidFindBy(id = "com.comviva.dbxp.app:id/languageArrow")
    private WebElement changeLanguage;

    @AndroidFindBy(id = "com.comviva.dbxp.app:id/custom_dialog_ok_buttonView")
    private WebElement SessionError;

    @AndroidFindBy(id = "com.comviva.dbxp.app:id/needHelp")
    private WebElement needHelp;

    @FindBy(id = "Done")
    private WebElement hideKeyboard;

    @AndroidFindBy(id = "custom_dialog_ok_buttonView")
    private WebElement ok;

    @FindBy( name = "PopUpActionButtonIdentifier")
    private WebElement okIOS;

    Boolean devicePlatform = MobileProperties.getProperty("device.platform").equalsIgnoreCase("android");
    WebElement element;

    public Boolean isHomePageDisplayed() {
        //waitUntilElementDisappear("");
        isElementNotPresent(homepageTitle);
        System.out.println("Waiting for Home Page to be Displayed...");
        info("Waiting for Home Page to be Displayed...");
        return homepageTitle.isDisplayed();
    }

    public Boolean isMsisdnFieldPresent(){

        return     devicePlatform?
                driver.findElements(By.id("com.comviva.dbxp.app:id/user_id")).size() > 0 :
                driver.findElements(By.name("Form_InputField_0")).size() > 0;

    }

    public DBXPLoginPageObjects setPinForLoggedInUser(String loggedInUserPin){
        setText(loginpin,loggedInUserPin,"Logged In User's PIN");
        clickOnElement(hideKeyboard,"Done");
        return this;
    }

    public DBXPLoginPageObjects clickOnLoginButton(){
        //element = devicePlatform?loginButton:login;
        clickOnElement(loginButton, "Login Button");
        waitUntilElementDisappear("pb_loading","In progress");
        return this;
    }

    public DBXPLoginPageObjects setMobileNumber(String msisdn){
       // element = devicePlatform ?loginMobileNumber :log;
        isElementNotPresent(loginMobileNumber);
        //element = devicePlatform ? loginMobileNumber : msisdnPin.get(0);
        loginMobileNumber.clear();
        setText(loginMobileNumber,msisdn,"Mobile Number");
        if(!devicePlatform){
            isElementNotPresent(hideKeyboard,5);
            clickOnElement(hideKeyboard,"Done");
        }
        return this;
    }

    public DBXPLoginPageObjects setPin(String pin){
            isElementNotPresent(loginpin);
            setText(loginpin,pin,"Login PIN is being entered");
            return this;
        }

    public String getWelcomeText(){
        try{
           // waitUntilElementDisappear("pb_loading","In progress");
           // element = devicePlatform?toolbarTextViewCenter:homeAvailableLabelIOS;
            info("Fetching Text : "+ homepageTitle.getText());
            return homepageTitle.getText();
        }
        catch (Exception e){
            e.printStackTrace();
            pageInfo.fail("Test Case Failed");
            pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        return "";
    }

    public Boolean isValidationDialogBoxDisplayed(){
        return     devicePlatform?
                driver.findElements(By.id("custom_dialog_ok_buttonView")).size() > 0 :
                driver.findElements(By.name("PopUpActionButtonIdentifier")).size() > 0;

    }

    public DBXPLoginPageObjects clickOnOkButton(){
        element = devicePlatform ? ok : okIOS;
        clickOnElement(element,"OK Button");
        return this;
    }

    public String getValidationMessageFromDialog(){
        try{
            //waitUntilElementDisappear("pb_loading","In progress");
            //element = devicePlatform ? validationMessage : getValidationMessageIOS;
            info("Fetching Text : "+ element.getText());
            return element.getText();
        }
        catch (Exception e){
            e.printStackTrace();
            pageInfo.fail("Test Case Failed");
            pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
            return "";
        }
    }
    //
}


package framework.wallet.omantel.pageObjects;

import initializers.AppPageInit;


import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import propertyManagement.MobileProperties;
import utils.CommonUtils;
import utils.LogReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class LoginPage extends AppPageInit {
    LogReader logReader= new LogReader();
    public LoginPage() {
        super();
    }

    @AndroidFindBy(id = "com.omantel.efloos.subscriber:id/LoginID")
    private WebElement LoginID ;

    @AndroidFindBy(id = "com.omantel.efloos.subscriber:id/password")
    private WebElement password;

    @AndroidFindBy(id = "com.omantel.efloos.subscriber:id/btn_login")
    private WebElement btn_login;

    @AndroidFindBy(id = "com.omantel.efloos.subscriber:id/btn_skip")
    private WebElement btn_skip;

    @AndroidFindBy(id = "android:id/button2")
    private WebElement button2;

    @AndroidFindBy(id = "com.omantel.efloos.subscriber:id/textinput_error")
    private static WebElement textinput_error;

    @AndroidFindBy(id = "com.omantel.efloos.subscriber:id/snackbar_text")
    private static WebElement snackbar_text;

    @AndroidFindBy(id = "com.omantel.efloos.subscriber:id/snackbar_action")
    private WebElement snackbar_action;

    @AndroidFindBy(id = "com.omantel.efloos.subscriber:id/msg")
    private static WebElement msg;

    @AndroidFindBy(id = "com.omantel.efloos.subscriber:id/try_button")
    private WebElement try_button;

    @AndroidFindBy(id = "android:id/message")
    private static WebElement message;

    @AndroidFindBy(id = "com.omantel.efloos.subscribe:id/register_button")
    private WebElement register_button;

    @AndroidFindBy(id = "com.omantel.efloos.subscriber:id/img_profile")
    private WebElement img_profile;

    @AndroidFindBy(xpath = "//*[@content-desc='More options']")
    public WebElement language_oman;

    @AndroidFindBy(className = "android.widget.ImageView")
    public List<WebElement> language;

    @AndroidFindBy(id = "com.omantel.efloos.subscriber:id/title")
    private WebElement title;

    @AndroidFindBy(id = "android:id/text1")
    public List<WebElement> element;

    @AndroidFindBy(xpath = "//*[@text='English']")
    private WebElement english;

    @AndroidFindBy(xpath = "//*[@text='Arabic']")
    private WebElement arabic;

    @AndroidFindBy(xpath = "//*[@text='Hindi']")
    private WebElement hindi;

    @AndroidFindBy(xpath = "//*[@text='Urdu']")
    private WebElement urdu;

    @AndroidFindBy(id = "com.omantel.efloos.subscriber:id/balanceText")
    private WebElement balanceText;


    public LoginPage clickOnLanguage()  {
        isElementNotPresent(language_oman);
        clickOnElement(language_oman,"Clicking on Language Button");
        clickOnElement(title,"Clicking on Language");
        return this;
    }

    public LoginPage clickOnEngLanguage()  {
            clickOnElement(english, "Clicking on English");
            return this;
    }

    public LoginPage clickOnArLanguage()  {
        clickOnElement(arabic,"Clicking on Arabic");
        return this;
    }

    public LoginPage clickOnHindiLanguage()  {
        clickOnElement(hindi,"Clicking on Hindi");
        return this;
    }

    public LoginPage clickOnUrduLanguage() {
        clickOnElement(urdu,"Clicking on Urdu");
        return this;
    }

    public LoginPage changeLanguageToAr() {
        clickOnLanguage();
        clickOnArLanguage();
        return this;
    }

    public LoginPage selectLanguage()  {
        if(MobileProperties.getProperty("language.code").equalsIgnoreCase("en"))
        {
            changeLanguageToEng();
        }
       else if(MobileProperties.getProperty("language.code").equalsIgnoreCase("ar"))
        {
            changeLanguageToAr();
        }
        else if(MobileProperties.getProperty("language.code").equalsIgnoreCase("hi"))
        {
            changeLanguageToHindi();
        }
        else{
            changeLanguageToUrdu();
        }
        return this;
    }

    public LoginPage changeLanguageToHindi()  {
        clickOnLanguage();
        clickOnHindiLanguage();
        return this;
    }

    public LoginPage changeLanguageToUrdu()  {
        clickOnLanguage();
        clickOnUrduLanguage();
        return this;
    }

    public LoginPage changeLanguageToEng() {
        clickOnLanguage();
        clickOnEngLanguage();
        return this;
    }

    public LoginPage setMsisdn(String msisdn){
        setText(LoginID, msisdn, "Customer Mobile Number");
        return  this;
    }

    public LoginPage clickOnSkipButton()  {
        clickOnElement(btn_skip, "Skip Button");
        return  this;
    }

    public LoginPage setPassword(String pin) {
        setText(password, pin, "Pin");
        return this;
    }

    public LoginPage clickOnLogin()  {
        driver.navigate().back();
        clickOnElement(btn_login, "Login Button");
        return this;
    }

    public LoginPage clickNoOnFingerSensor()  {
        isElementNotPresent(button2);
        clickOnElement(button2, "Opting Out Finger Print");
        return this;
    }

    public LoginPage clickOnsnackbarButton()  {
        clickOnElement(snackbar_action, "OK");
        return this;
    }

    public boolean isClickOnOkisDisplayed(){
        return driver.findElements(By.id("snackbar_action")).size()>0;
    }

    public boolean isSnackbarDisplayed() {
            return driver.findElements(By.id("snackbar_text")).size() > 0;
    }


    public static String getMsgFromDevice() throws InterruptedException, UnsupportedEncodingException {
        driver.navigate().back();
        return textinput_error.getText();

    }

    public  String getErrMsgFromDevice() throws InterruptedException, UnsupportedEncodingException {
            isElementNotPresent(snackbar_text);
            return snackbar_text.getText();
    }

    public static String getErrMsgFromDialogBox() throws InterruptedException, UnsupportedEncodingException {
        Thread.sleep(2000);
        System.out.print(msg.getText());
        return msg.getText();
    }

    public LoginPage clickOnTryButton()  {
        clickOnElement(try_button, "TRY AGAIN");
        return this;
    }

    public boolean isClickOnTryDisplayed() {
            return driver.findElements(By.id("try_button")).size() > 0;
    }

    public boolean isClickOnImg_profile() {
        return driver.findElements(By.id("img_profile")).size() > 0;
    }

    public boolean isShowBalanceDisplayed() {
        isElementNotPresent(balanceText);
        return driver.findElements(By.id("balanceText")).size() > 0;

    }


    public  String getMsgFromDialogBox() throws InterruptedException {
        return message.getText();
    }

    public LoginPage clearFields(){
        LoginID.clear();
        driver.navigate().back();
        password.clear();
        return this;
    }

    public LoginPage isFingerSensorChoiceDisplayed(){
        isElementNotPresent(button2);
        return this;
    }

    public boolean isLoginIdDisplayed(){
        CommonUtils.pauseExecution(3);
        return driver.findElements(By.id("LoginID")).size()>0;
    }


}

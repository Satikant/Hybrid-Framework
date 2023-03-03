package framework.wallet.omanArabBank.pageObjects;


import initializers.AppPageInit;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.CommonUtils;

import javax.swing.*;
import java.io.UnsupportedEncodingException;


public class LoginPage extends AppPageInit {
    public LoginPage() {
        super();
    }

    @AndroidFindBy(id = "com.oman.arabbank.opay.qa:id/engButton")
    private WebElement engButton ;

    @AndroidFindBy(id = "com.oman.arabbank.opay.qa:id/arabicButton")
    private WebElement arabicButton ;

    @AndroidFindBy(id = "com.oman.arabbank.opay.qa:id/btn_skip")
    private WebElement btn_skip3 ;

    @AndroidFindBy(id = "com.oman.arabbank.opay.qa:id/btn_next")
    private WebElement btn_next ;

    @AndroidFindBy(id = "com.oman.arabbank.opay.qa:id/mobile_text")
    private WebElement mobile_text ;

    /*@AndroidFindBy(xpath = "/*//*[@resource-id='mobile_text']")
    private WebElement mobile_text ;*/

    @AndroidFindBy(id = "com.oman.arabbank.opay.qa:id/pin_1")
    private WebElement pin_1 ;

    @AndroidFindBy(id = "com.oman.arabbank.opay.qa:id/pin_2")
    private WebElement pin_2 ;

    @AndroidFindBy(id = "com.oman.arabbank.opay.qa:id/pin_3")
    private WebElement pin_3 ;

    @AndroidFindBy(id = "com.oman.arabbank.opay.qa:id/pin_4")
    private WebElement pin_4 ;

    @AndroidFindBy(id = "com.oman.arabbank.opay.qa:id/login_button")
    private WebElement login_button ;

    @AndroidFindBy(id = "com.oman.arabbank.opay.qa:id/forgotPinText")
    private WebElement forgotPinText ;

    @AndroidFindBy(id = "com.oman.arabbank.opay.qa:id/register_button")
    private WebElement register_button2 ;

    @AndroidFindBy(id = "com.oman.arabbank.opay.qa:id/sub_text")
    private  WebElement sub_text ;

    @AndroidFindBy(id = "com.oman.arabbank.opay.qa:id/ok_button")
    private WebElement ok_button ;

    @AndroidFindBy(id = "com.oman.arabbank.opay.qa:id/btnLoginWithPin")
    private WebElement btnLoginWithPin ;




    public LoginPage clickOnEnglishLang()  {
        clickOnElement(engButton, "Selecting English Language Button");
        return this;
    }

    public LoginPage clickOnArabicLang()  {
        clickOnElement(arabicButton, "Selecting Arabic Language Button");
        return this;
    }

    public LoginPage clickOnLanguageConfirmButton()  {
        clickOnElement(btn_skip3, "Skip Button");
        return this;
    }

    public LoginPage setMobileNo(String mobNo) {
        isElementNotPresent(mobile_text);
        setText(mobile_text, mobNo, "Mobile Number");
        return this;
    }


    public LoginPage setPin1(String pin1) {
        setText(pin_1, pin1, "Pin 1");
        return this;
    }

    public LoginPage setPin2(String pin2) {
        setText(pin_2, pin2, "Pin 2");
        return this;
    }

    public LoginPage setPin3(String pin3) {
        setText(pin_3, pin3, "Pin 3");
        return this;
    }

    public LoginPage setPin4(String pin4) {
        setText(pin_4, pin4, "Pin 4");
        return this;
    }

    public LoginPage setPin5(String pin5) {
        System.out.println("NA");
        return this;
    }

    public LoginPage setPin(String pin) {
        setPin1(pin.substring(0));
        setPin1(pin.substring(1));
        setPin1(pin.substring(2));
        setPin1(pin.substring(3));
        setPin1(pin.substring(4));
        return this;
    }

    public LoginPage clickOnLoginButton() {
        clickOnElement(login_button, "Login Button");
        return this;
    }

    public LoginPage clickOnOk()  {
        clickOnElement(ok_button, "Ok Button");
        return this;
    }

    public boolean isclickOnOkDisplayed() {
        return driver.findElements(By.id("ok_button")).size() > 0;
    }

    public boolean isLoginWithPinDisplayed() {
        isElementNotPresent(btnLoginWithPin);
        return driver.findElements(By.id("btnLoginWithPin")).size() > 0;
    }

    public LoginPage clickOnLoginWithPin(){
        isElementNotPresent(btnLoginWithPin);
        clickOnElement(btnLoginWithPin,"Login With Pin");
        return this;
    }

    public  String getMessageFromDevice() throws InterruptedException, UnsupportedEncodingException {
        isElementNotPresent(sub_text);
        return sub_text.getText();
    }

    public boolean isclickOnButtonNoDisplayed() {
        return driver.findElements(By.id("btnno")).size() > 0;
    }

    public LoginPage clearField(){
            mobile_text.clear();
            pin_1.clear();
            pin_2.clear();
            pin_3.clear();
            pin_4.clear();
           PointOption.point(1, 500);
            driver.navigate().back();
        return this;
    }

    public boolean isClickOnOkisDisplayed(){
        return driver.findElements(By.id("snackbar_action")).size()>0;
    }

    public boolean isSnackbarDisplayed() {
            return driver.findElements(By.id("snackbar_text")).size() > 0;
    }

    public boolean isClickOnTryDisplayed() {
            return driver.findElements(By.id("try_button")).size() > 0;
    }

    public boolean isClickOnImg_profile() {
        return driver.findElements(By.id("img_profile")).size() > 0;
    }

    public boolean isLoginIdDisplayed(){
        CommonUtils.pauseExecution(3);
        return driver.findElements(By.id("LoginID")).size()>0;
    }


}

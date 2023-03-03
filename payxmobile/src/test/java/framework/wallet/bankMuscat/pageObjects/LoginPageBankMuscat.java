package framework.wallet.bankMuscat.pageObjects;


import framework.wallet.omantel.pageObjects.HomePage;
import initializers.AppPageInit;


import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class LoginPageBankMuscat extends AppPageInit {
    public LoginPageBankMuscat() {
        super();
    }

    @AndroidFindBy(id = "app.banking.bankmuscat:id/btnok")
    private WebElement btnok;

    @AndroidFindBy(id = "app.banking.bankmuscat:id/mobedtMobileNumber")
    private WebElement mobedtMobileNumber;

    @AndroidFindBy(id = "app.banking.bankmuscat:id/edtpin1")
    private WebElement edtpin1;

    @AndroidFindBy(id = "app.banking.bankmuscat:id/edtpin2")
    private WebElement edtpin2;

    @AndroidFindBy(id = "app.banking.bankmuscat:id/edtpin3")
    private WebElement edtpin3;

    @AndroidFindBy(id = "app.banking.bankmuscat:id/edtpin4")
    private WebElement edtpin4;

    @AndroidFindBy(id = "app.banking.bankmuscat:id/edtpin5")
    private WebElement edtpin5;

    @AndroidFindBy(id = "app.banking.bankmuscat:id/mob_buttonlogin")
    private WebElement mob_buttonlogin;

    @AndroidFindBy(id = "app.banking.bankmuscat:id/mob_buttonregister")
    private WebElement mob_buttonregister;

    @AndroidFindBy(id = "app.banking.bankmuscat:id/edtenglish")
    private WebElement edtenglish;

    @AndroidFindBy(id = "app.banking.bankmuscat:id/edtarabic")
    private WebElement edtarabic;

    @AndroidFindBy(id = "app.banking.bankmuscat:id/mob_buttonconfirm")
    private WebElement mob_buttonconfirm;

    @AndroidFindBy(xpath = "//*[@text='Logout']")
    private WebElement logoutButton;

    @AndroidFindBy(id = "app.banking.bankmuscat:id/btnyes")
    private WebElement btnyes;

    @AndroidFindBy(id = "app.banking.bankmuscat:id/btnno")
    private WebElement btnno;

    @AndroidFindBy(id = "app.banking.bankmuscat:id/txtmessage")
    private static WebElement txtmessage;

    @AndroidFindBy(id = "app.banking.bankmuscat:id/img_profilepic")
    private WebElement profilePic;



    public LoginPageBankMuscat clickOnEnglishLang()  {
        String loginsource=driver.getPageSource();
        info(loginsource);
        clickOnElement(edtenglish, "Selecting English Language Button");
        return this;
    }

    public LoginPageBankMuscat clickOnArabicLang()  {
        clickOnElement(edtarabic, "Selecting Arabic Language Button");
        return this;
    }

    public LoginPageBankMuscat clickOnLanguageConfirmButton()  {
        clickOnElement(mob_buttonconfirm, "Confirm Button");
        return this;
    }

    public LoginPageBankMuscat setMobileNo(String mobNo) {
        setText(mobedtMobileNumber, mobNo, "Mobile Number");
        return this;
    }


    public LoginPageBankMuscat setPin1(String pin1) {
        setText(edtpin1, pin1, "Pin 1");
        return this;
    }

    public LoginPageBankMuscat setPin2(String pin2) {
        setText(edtpin2, pin2, "Pin 2");
        return this;
    }

    public LoginPageBankMuscat setPin3(String pin3) {
        setText(edtpin3, pin3, "Pin 3");
        return this;
    }

    public LoginPageBankMuscat setPin4(String pin4) {
        setText(edtpin4, pin4, "Pin 4");
        return this;
    }

    public LoginPageBankMuscat setPin5(String pin5) {
        setText(edtpin5, pin5, "Pin 5");
        return this;
    }

    public LoginPageBankMuscat setPin(String pin) {
        setPin1(pin.substring(0));
        setPin2(pin.substring(1));
        setPin3(pin.substring(2));
        setPin4(pin.substring(3));
        setPin5(pin.substring(4));
        return this;
    }

    public LoginPageBankMuscat clickOnLoginButton() {
        clickOnElement(mob_buttonlogin, "Login Button");
        return this;
    }

    public LoginPageBankMuscat clickOnOk()  {
        clickOnElement(btnok, "Ok Button");
        return this;
    }

    public boolean isclickOnOkDisplayed() {
            return driver.findElements(By.id("btnok")).size() > 0;
    }

    public  String getMessageFromDevice() {
            return txtmessage.getText();
    }

    public boolean isclickOnButtonNoDisplayed() {
        return driver.findElements(By.id("btnno")).size() > 0;
    }

    public LoginPageBankMuscat clickOnButtonNo() {
        clickOnElement(btnno, "Clicking on NO Button");
        return this;
    }

    public LoginPageBankMuscat clickOnButtonYes() {
        clickOnElement(btnyes, "Yes Button of Logout");
        return this;
    }

    public LoginPageBankMuscat performLogout()  {
        new HomePage().clickOnKebabMenuButton();
        clickOnElement(logoutButton, "Logout Button");
        clickOnButtonYes();
        return this;
    }

    public LoginPageBankMuscat clearField(){
            mobedtMobileNumber.clear();
            edtpin1.clear();
            edtpin2.clear();
            edtpin3.clear();
            edtpin4.clear();
            edtpin5.clear();
        return this;
    }

    public boolean isProfilePicDisplayed(){
        return profilePic.isDisplayed();
    }


}

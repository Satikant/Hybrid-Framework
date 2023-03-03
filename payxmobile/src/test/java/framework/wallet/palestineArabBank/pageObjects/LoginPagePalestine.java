package framework.wallet.palestineArabBank.pageObjects;


import globalConstants.Config;
import initializers.AppPageInit;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import propertyManagement.MobileProperties;
import utils.CommonUtils;
import java.util.List;

public class LoginPagePalestine extends AppPageInit {

    public LoginPagePalestine(){
        super();
    }

    @AndroidFindBy(id = "com.abp.sub:id/LoginID")
    public WebElement LoginID ;

    @AndroidFindBy(id = "com.abp.sub:id/password")
    private WebElement password ;

    @AndroidFindBy(id="com.abp.sub:id/pin_first_edittext")
    public WebElement pin1;

    @AndroidFindBy(id="com.abp.sub:id/pin_second_edittext")
    public WebElement pin2;

    @AndroidFindBy(id="com.abp.sub:id/pin_third_edittext")
    public WebElement pin3;

    @AndroidFindBy(id="com.abp.sub:id/pin_forth_edittext")
    public WebElement pin4;

    @AndroidFindBy(id = "com.abp.sub:id/btn_login")
    public WebElement loginBtn;

    @AndroidFindBy(id = "com.abp.sub:id/account_holder")
    private WebElement welcomeText;

    @AndroidFindBy(id = "android:id/button2")
    private WebElement button2;

    @AndroidFindBy(id = "com.abp.sub:id/textinput_error")
    private static WebElement textinput_error2;

    @AndroidFindBy(id = "com.abp.sub:id/snackbar_text")
    private static WebElement snackbar_text2;

    @AndroidFindBy(id = "com.abp.sub:id/snackbar_action")
    private  WebElement snackbar_action2;

    @AndroidFindBy(id = "com.abp.sub:id/msg")
    private static WebElement msg2;

    @AndroidFindBy(id = "com.abp.sub:id/try_button")
    private  WebElement try_button2;

    @AndroidFindBy(id = "android:id/message")
    private static WebElement message;

    @AndroidFindBy(className = "android.widget.ImageView")
    public List<WebElement> language;

    @AndroidFindBy(id = "com.abp.sub:id/title")
    private WebElement title2;

    @AndroidFindBy(id = "android:id/text1")
    public List<WebElement> element;

    @AndroidFindBy(xpath = "//*[@text='English']")
    private WebElement english;

    @AndroidFindBy(xpath = "//*[@text='Arabic']")
    private WebElement arabic;

    @AndroidFindBy(id = "com.abp.sub:id/showBalance")
    private WebElement showBalance;

    @AndroidFindBy(id ="com.abp.sub:id/otp_input")
    private WebElement OTP ;

    @AndroidFindBy(id ="com.abp.sub:id/sq_tv")
    private WebElement SecQues ;

    @AndroidFindBy(id ="com.abp.sub:id/sa_et")
    private WebElement SecAns ;

    @AndroidFindBy(id ="com.abp.sub:id/next_button")
    private WebElement nextbtn ;

    @AndroidFindBy(id ="com.abp.sub:id/verify_button")
    private WebElement verifyOtp ;

    @AndroidFindBy(id ="com.abp.sub:id/textView18")
    private WebElement DevChangetxt ;

    @AndroidFindBy(xpath ="//*[@class='android.widget.ImageButton']")
    private WebElement backbutton ;


    public LoginPagePalestine clickonback(){
        clickOnElement(backbutton,"Going a step backward");
        return this;
    }

    public boolean devChng() {
//        isElementNotPresent(DevChangetxt);
        return driver.findElements(By.id("com.abp.sub:id/textView18")).size()>0;
    }

    public LoginPagePalestine VerifyOtp (){
        clickOnElement(verifyOtp,"Verify OTP");
        return this;
    }

    public LoginPagePalestine DevNextbtn(){
        clickOnElement(nextbtn,"Logging in after Device Change");
        return this;
    }

    public LoginPagePalestine SetSecAns(String Answer){
        setText(SecAns,Answer,"Entering the Security Answer");
        return this;
    }

    public boolean isSecurityQuesDisplayed(){
        isElementNotPresent(SecQues);
        return driver.findElements(By.id("com.abp.sub:id/sq_tv")).size()>0;
    }


    public LoginPagePalestine enterOtp (String otp){
        setText(OTP , otp ,"Entering OTP");
        return this;
    }


    public LoginPagePalestine clickOnLanguage()  {
        isElementNotPresent(language.get(1));
        clickOnElement(language.get(1),"Clicking on Language Button");
        isElementNotPresent(title2);
        clickOnElement(title2,"Clicking on Language");
        return this;
    }

    public LoginPagePalestine clickOnEngLanguage()  {
        clickOnElement(element.get(0), "Clicking on English");
        return this;
    }

    public LoginPagePalestine clickOnArLanguage()  {
        clickOnElement(element.get(1), "Clicking on Arabic");
        return this;
    }


    public LoginPagePalestine changeLanguageToAr() {
        clickOnLanguage();
        clickOnArLanguage();
        return this;
    }

    public LoginPagePalestine selectLanguage()  {
        if(MobileProperties.getProperty("language.code").equalsIgnoreCase("en"))
        {
            changeLanguageToEng();
        }
        else if(MobileProperties.getProperty("language.code").equalsIgnoreCase("ar"))
        {
            changeLanguageToAr();
        }

        return this;
    }


    public LoginPagePalestine changeLanguageToEng() {
        clickOnLanguage();
        clickOnEngLanguage();
        return this;
    }

    public LoginPagePalestine setMsisdn(String msisdn){
        isElementNotPresent(LoginID);
        driver.navigate().back();
        setText(LoginID, msisdn, "Customer Mobile Number");

        return  this;
    }
    public boolean isWelcomeTextPresent()  {
        isElementNotPresent(welcomeText);
        return driver.findElements(By.id("com.abp.sub:id/account_holder")).size() > 0;
        //Assertion.verifyContains(welcomeText.getText(),"Hi,");
    }

    public boolean isShowBalanceDisplayed() {
        isElementNotPresent(showBalance);
        return driver.findElements(By.id("showBalance")).size() > 0;
    }

    public LoginPagePalestine setPin1(String pin) {
        setText(pin1, pin, "Pin1");
        return this;
    }

    public LoginPagePalestine setPin2(String pin) {
        setText(pin2, pin, "Pin2");
        return this;
    }

    public LoginPagePalestine setPin3(String pin) {
        setText(pin3, pin, "Pin3");
        return this;
    }

    public LoginPagePalestine setPin4(String pin) {
        setText(pin4, pin, "Pin4");
        return this;
    }

    public LoginPagePalestine clearPinField() {
        pin1.clear();
        pin2.clear();
        pin3.clear();
        pin4.clear();
        return this;
    }

    public LoginPagePalestine setPin(String pin) {

        if (Config.isClearFieldTrue) {clearPinField(); return this;}
        else {
            setPin1(pin.substring(0));
            setPin2(pin.substring(1));
            setPin3(pin.substring(2));
            setPin4(pin.substring(3));
            return this;
        }
        }

    public LoginPagePalestine clickOnLogin()  {
       // driver.navigate().back();
        clickOnElement(loginBtn, "Login Button");
        info("Extra Information : "+ driver.getSettings());
        return this;
    }

    public LoginPagePalestine clickNoOnFingerSensor()  {
        isElementNotPresent(button2);
        clickOnElement(button2, "Opting Out Finger Print");
        return this;
    }

    public boolean isSnackbarActionButtonDiplayed(){
        return isElementNotPresent(snackbar_action2);
    }

    public LoginPagePalestine clickOnsnackbarButton()  {
        clickOnElement(snackbar_action2, "OK");
        return this;
    }

    public boolean isClickOnOkisDisplayed(){
        return driver.findElements(By.id("snackbar_action")).size()>0;
    }

    public boolean isSnackbarDisplayed() {
        return driver.findElements(By.id("snackbar_text")).size() > 0;
    }


    public static String getMsgFromDevice()  {
        return textinput_error2.getText();
    }

    public  String getErrMsgFromDevice()  {
        isElementNotPresent(snackbar_text2);
        return snackbar_text2.getText();
    }

    public  String getErrorMsg()  {
        isElementNotPresent(textinput_error2);
        return textinput_error2.getText();
    }

    public static String getErrMsgFromDialogBox() {
        try {
            Thread.sleep(2000);
            System.out.print(msg2.getText());
            return msg2.getText();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public LoginPagePalestine clickOnTryButton()  {
        isElementNotPresent(try_button2);
        clickOnElement(try_button2, "TRY AGAIN");
        return this;
    }

    public boolean isClickOnTryDisplayed() {
        return driver.findElements(By.id("try_button")).size() > 0;
    }

    public boolean isClickOnImg_profile() {
        return driver.findElements(By.id("img_profile")).size() > 0;
    }




    public  String getMsgFromDialogBox() {
        return message.getText();
    }

    public LoginPagePalestine clearFields(){
        isElementNotPresent(LoginID);
        LoginID.clear();
        driver.navigate().back();
        password.clear();
        return this;
    }

    public boolean isFingerSensorChoiceDisplayed(){
        isElementNotPresent(button2);
        return driver.findElements(By.id("android:id/button2")).size()>0;
    }


    public boolean isLoginIdDisplayed(){
        CommonUtils.pauseExecution(3);
        return driver.findElements(By.id("LoginID")).size()>0;
    }
}

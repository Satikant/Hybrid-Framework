package framework.wallet.bharain.pageObjects;

import initializers.AppPageInit;


import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import propertyManagement.MobileProperties;
import utils.CommonUtils;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class LoginPageBharain extends AppPageInit {
    public LoginPageBharain() {
        super();
    }

    @AndroidFindBy(id = "com.batelco.sub:id/LoginID")
    private WebElement LoginID2 ;

    @AndroidFindBy(id = "com.batelco.sub:id/password")
    private WebElement password2;

    @AndroidFindBy(id = "com.batelco.sub:id/btn_login")
    private WebElement btn_login2;

    @AndroidFindBy(id = "com.batelco.sub:id/btn_skip")
    private WebElement btn_skip2;

    @AndroidFindBy(id = "android:id/button2")
    private WebElement button2;

    @AndroidFindBy(id = "com.batelco.sub:id/textinput_error")
    private static WebElement textinput_error2;

    @AndroidFindBy(id = "com.batelco.sub:id/snackbar_text")
    private static WebElement snackbar_text2;

    @AndroidFindBy(id = "com.batelco.sub:id/snackbar_action")
    private  WebElement snackbar_action2;

    @AndroidFindBy(id = "com.batelco.sub:id/msg")
    private static WebElement msg2;

    @AndroidFindBy(id = "com.batelco.sub:id/try_button")
    private  WebElement try_button2;

    @AndroidFindBy(id = "android:id/message")
    private static WebElement message;

    @AndroidFindBy(id = "com.batelco.sub:id/img_profile")
    private WebElement img_profile2;

    @AndroidFindBy(className = "android.widget.ImageView")
    public List<WebElement> language;

    @AndroidFindBy(id = "com.batelco.sub:id/title")
    private WebElement title2;

    @AndroidFindBy(id = "android:id/text1")
    public List<WebElement> element;

    @AndroidFindBy(xpath = "//*[@text='English']")
    private WebElement english;

    @AndroidFindBy(xpath = "//*[@text='Arabic']")
    private WebElement arabic;

    @AndroidFindBy(id = "com.batelco.sub:id/showBalance")
    private WebElement showBalance;

    @AndroidFindBy(id ="com.batelco.sub:id/otp_input")
    private WebElement OTP ;

    @AndroidFindBy(id ="com.batelco.sub:id/sq_tv")
    private WebElement SecQues ;

    @AndroidFindBy(id ="com.batelco.sub:id/sa_et")
    private WebElement SecAns ;

    @AndroidFindBy(id ="com.batelco.sub:id/next_button")
    private WebElement nextbtn ;

    @AndroidFindBy(id ="com.batelco.sub:id/verify_button")
    private WebElement verifyOtp ;

    @AndroidFindBy(id ="com.batelco.sub:id/textView18")
    private WebElement DevChangetxt ;

    @AndroidFindBy(xpath ="//*[@class='android.widget.ImageButton']")
    private WebElement backbutton ;


    public LoginPageBharain clickonback(){
        clickOnElement(backbutton,"Going a step backward");
        return this;
    }

    public boolean devChng() {
        return driver.findElements(By.id("com.batelco.sub:id/otp_input")).size()>0;
    }

    public LoginPageBharain VerifyOtp (){
        clickOnElement(verifyOtp,"Verify OTP");
        return this;
    }

    public LoginPageBharain DevNextbtn(){
        clickOnElement(nextbtn,"Logging in after Device Change");
        return this;
    }

    public LoginPageBharain SetSecAns(String Answer){
        setText(SecAns,Answer,"Entering the Security Answer");
        return this;
    }

    public boolean isSecurityQuesDisplayed(){
        isElementNotPresent(SecQues);
        return driver.findElements(By.id("com.batelco.sub:id/sq_tv")).size()>0;
    }


    public LoginPageBharain enterOtp (String otp){
        setText(OTP , otp ,"Entering OTP");
        return this;
    }


    public LoginPageBharain clickOnLanguage()  {
            isElementNotPresent(language.get(1));
            clickOnElement(language.get(1),"Clicking on Language Button");
            isElementNotPresent(title2);
            clickOnElement(title2,"Clicking on Language");
        return this;
    }

    public LoginPageBharain clickOnEngLanguage()  {
        clickOnElement(element.get(0), "Clicking on English");
        return this;
    }

    public LoginPageBharain clickOnArLanguage()  {
        clickOnElement(element.get(1), "Clicking on Arabic");
        return this;
    }


    public LoginPageBharain changeLanguageToAr() {
        clickOnLanguage();
        clickOnArLanguage();
        return this;
    }

    public LoginPageBharain selectLanguage()  {
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


    public LoginPageBharain changeLanguageToEng() {
        clickOnLanguage();
        clickOnEngLanguage();
        return this;
    }

    public LoginPageBharain setMsisdn(String msisdn){
        isElementNotPresent(LoginID2);
        setText(LoginID2, msisdn, "Customer Mobile Number");

        return  this;
    }
    public LoginPageBharain clickOnSkipButton()  {
        clickOnElement(btn_skip2, "Skip Button");
        return  this;
    }

    public LoginPageBharain setPassword(String pin) {
        setText(password2, pin, "Pin");
        return this;
    }

    public LoginPageBharain clickOnLogin()  {
        driver.navigate().back();
        clickOnElement(btn_login2, "Login Button");
        return this;
    }

    public LoginPageBharain clickNoOnFingerSensor()  {
        isElementNotPresent(button2);
        clickOnElement(button2, "Opting Out Finger Print");
        return this;
    }

    public boolean isSnackbarActionButtonDiplayed(){
        return isElementNotPresent(snackbar_action2);
    }

    public LoginPageBharain clickOnsnackbarButton()  {
        clickOnElement(snackbar_action2, "OK");
        return this;
    }

    public boolean isClickOnOkisDisplayed(){
        return driver.findElements(By.id("snackbar_action")).size()>0;
    }

    public boolean isSnackbarDisplayed() {
            return driver.findElements(By.id("snackbar_text")).size() > 0;
    }


    public static String getMsgFromDevice() {
        return textinput_error2.getText();
    }

    public  String getErrMsgFromDevice()  {
        try{
            isElementNotPresent(snackbar_text2);
            return snackbar_text2.getText();
        }
        catch(Exception e){
            return null;
        }
    }

    public static String getErrMsgFromDialogBox() throws InterruptedException {
        Thread.sleep(2000);
        System.out.print(msg2.getText());
        return msg2.getText();
    }

    public LoginPageBharain clickOnTryButton()  {
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

    public boolean isShowBalanceDisplayed() {
        isElementNotPresent(showBalance);
        return driver.findElements(By.id("showBalance")).size() > 0;
    }


    public  String getMsgFromDialogBox() throws InterruptedException {
        return message.getText();
    }

    public LoginPageBharain clearFields(){
        isElementNotPresent(LoginID2);
        LoginID2.clear();
        driver.navigate().back();
        password2.clear();
        return this;
    }

    public LoginPageBharain isFingerSensorChoiceDisplayed(){
        isElementNotPresent(button2);
        return this;
    }

    public boolean isLoginIdDisplayed(){
        CommonUtils.pauseExecution(3);
        return driver.findElements(By.id("LoginID")).size()>0;
    }


}

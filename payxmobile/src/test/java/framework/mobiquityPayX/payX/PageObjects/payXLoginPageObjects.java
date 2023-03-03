package framework.mobiquityPayX.payX.PageObjects;

import com.aventstack.extentreports.Status;
import initializers.AppPageInit;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class payXLoginPageObjects extends AppPageInit {


    public payXLoginPageObjects(){
        super();
    }


    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"loginMobileNumber\"]")
    public WebElement mobileNum ;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"loginpin\"]")
    public WebElement  Pin;

    @AndroidFindBy(id = "loginButton")
    public WebElement loginbtn ;

    @AndroidFindBy(id = "com.comviva.mobiquity.consumer.debug:id/selectLanguageLayout")
    public WebElement language ;

    @AndroidFindBy(id = "com.comviva.mobiquity.consumer.debug:id/loginfma_forgotpin_label")
    public WebElement forgotpin ;

    @AndroidFindBy(id = "com.comviva.mobiquity.consumer.debug:id/loginfma_registration_text")
    public WebElement register ;

    @AndroidFindBy(id = "com.comviva.mobiquity.consumer.debug:id/toolbarTextViewCenter")
    public WebElement toolbartextview ;

    @AndroidFindBy(id = " com.comviva.mobiquity.consumer.debug:id/custom_dialog_title_imageView")
    public WebElement errorI;

    @AndroidFindBy(id = " com.comviva.mobiquity.consumer.debug:id/custom_dialog_ok_buttonView")
    public WebElement acceptError;

    public payXLoginPageObjects setMobileNum(String msisdn){
        //isElementNotPresent(mobileNum);
        isElementNotPresent(mobileNum,300);
        setText(mobileNum,msisdn,"Entering the mobile number");
        return this;
    }

    public payXLoginPageObjects setpin(String pin){
//        isElementNotPresent(Pin);
        isElementNotPresent(Pin,300);
        setText(Pin,pin,"Entering the Pin");
        return this;
    }

    public payXLoginPageObjects clickonLogin(){
        clickOnElement(loginbtn,"clicking on Login button");
        return this;
    }
    public payXLoginPageObjects clickonRegister(){
        isElementNotPresent(register,20);
        clickOnElement(register,"clicking on Register button");
        return this;
    }

    public boolean ishomePagePresent(){
        isElementNotPresent(toolbartextview);
        return driver.findElements(By.id("com.comviva.mobiquity.consumer.debug:id/toolbarTextViewCenter")).size() > 0;
    }

    public boolean isValidationDialogBoxPresent(){
        isElementNotPresent(errorI);
        return driver.findElements(By.id("com.comviva.mobiquity.consumer.debug:id/custom_dialog_title_imageView")).size() > 0;
    }

    public payXLoginPageObjects clickOnAcceptErr(){
        clickOnElement(acceptError,"Clicking on OK button of error message box");
        return this;
    }

    public String getWelcomeText(){
        try{
            waitUntilElementDisappear("pb_loading");
            info("Fetching Text : "+ toolbartextview.getText());
            return toolbartextview.getText();
        }
        catch (Exception e){
            e.printStackTrace();
            pageInfo.fail("Test Case Failed");
            pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        return "";
    }

}

package framework.mobiquityPayX.asiaHawala.pageObjects;

import com.aventstack.extentreports.Status;
import initializers.AppPageInit;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class AHLoginPageObject extends AppPageInit {

    public AHLoginPageObject(){
        super();
    }

    @AndroidFindBy(xpath = "//*[@content-desc='loginMobileNumber']")
    private WebElement loginMobileNumber;

    @AndroidFindBy(xpath = "//*[@content-desc='loginpin']")
    private WebElement loginpin;

    @AndroidFindBy(id = "com.asiahawala.consumer.dev:id/loginButton")
    private WebElement loginButton;

    @AndroidFindBy(id = "com.asiahawala.consumer.dev:id/pb_loading")
    private WebElement loader;

    @AndroidFindBy(id = "com.asiahawala.consumer.dev:id/toolbarTextViewCenter")
    private WebElement toolbarTextViewCenter;

    @AndroidFindBy(id = "com.asiahawala.consumer.dev:id/custom_dialog_message_textView")
    private WebElement validationMessage;

    @AndroidFindBy(id = "com.asiahawala.consumer.dev:id/custom_dialog_ok_buttonView")
    private WebElement ok;

    @AndroidFindBy(id = "com.asiahawala.consumer.dev:id/errortext")
    private List<WebElement> errorText;

    @AndroidFindBy(id = "com.asiahawala.consumer.dev:id/button_enter")
    private WebElement enterButton;


    public AHLoginPageObject setMobileNumber(String msisdn){
        setText(loginMobileNumber,msisdn,"Mobile Number");
        return this;
    }

    public AHLoginPageObject setPin(String pin){
        setText(loginpin,pin,"Login PIN");
        return this;
    }

    public AHLoginPageObject getFocus(){
        clickOnElement(loginMobileNumber,"Login Mobile Number");
        clickOnElement(loginpin,"Login PIN");
        clickOnElement(enterButton,"Enter button");
        return this;
    }



    public AHLoginPageObject clickOnLoginButton(){
        clickOnElement(loginButton,"Login Button");
        waitUntilElementDisappear("pb_loading");
        waitUntilElementDisappear("pb_loading");
        return this;
    }

    public Boolean isHomePageDisplayed(){
        isElementNotPresent(loader);
        waitUntilElementDisappear("pb_loading");
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

    public AHLoginPageObject clickOnOkButton(){
        clickOnElement(ok,"OK Button");
        return this;
    }

    public Boolean isValidationDialogBoxDisplayed(){
        return driver.findElements(By.id("custom_dialog_ok_buttonView")).size() > 0 ;
    }

}

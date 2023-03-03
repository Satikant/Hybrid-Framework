package framework.mobiquityPayX.payX.PageObjects;

import com.aventstack.extentreports.Status;
import initializers.AppPageInit;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.WebElement;
import utils.Utils;

import javax.rmi.CORBA.Util;

public class pinAuthenticationPageObj extends AppPageInit {

    public pinAuthenticationPageObj(){
        super();
    }

    @AndroidFindBy(xpath = "//*[@text='Please enter PIN to verify']")
    private WebElement enterPinTitle;

    @AndroidFindBy(id = "toolbar_icon")
    private WebElement backButton;

    @AndroidFindBy(id = "otp_edit_text")
    private WebElement pinField;

    @AndroidFindBy(xpath = "//*[@text='Verify']")
    private WebElement verifyButton;



    public pinAuthenticationPageObj clickOnEnterPinField() {
        isElementNotPresent(enterPinTitle);
        clickOnElement(pinField, "Clicking on pin field.");
        return this;
    }


    public pinAuthenticationPageObj setPin(String pin){
        isElementNotPresent(pinField);
        Utils.putThreadSleep(4000);
        setText(pinField, pin,"Enter PIN for payment authentication..");
        return this;
    }

    public pinAuthenticationPageObj clickVerify() {
        isElementNotPresent(verifyButton);
        clickOnElement(verifyButton, "Clicking on Verify button to validate the authentication page.");
        Utils.putThreadSleep(5000);
        return this;
    }


    public String getMaskPinVerify() {
        try {
            waitUntilElementDisappear("//*[@text='Verify']");
            info("Fetching Text : " + verifyButton.getText());
            return verifyButton.getText();
        } catch (Exception e) {
            e.printStackTrace();
            pageInfo.fail("Test Case Failed");
            pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        return "";
    }



}

package framework.mobiquityPayX.commonApplicationModule.pageObjects;

import com.aventstack.extentreports.Status;
import framework.mobiquityPayX.qnb.fetchOtp.FetchOtp;
import initializers.AppPageInit;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import propertyManagement.MobileProperties;
import utils.Utils;

public class CommonFeaturesPageObject extends AppPageInit {
    @AndroidFindBy(id = "otp_edit_text")
    private WebElement otpField;

    @FindBy(xpath = "//XCUIElementTypeCollectionView/XCUIElementTypeCell[@index = '0']")
    private WebElement otpBox;

    @FindBy(id = "Done")
    private WebElement hideKeyboard;

    @FindBy(id = "Previous")
    private WebElement prevKeyboard;

    @AndroidFindBy(id = "verifyotp_button")
    private WebElement verifyOtp;

    @FindBy(xpath = "//XCUIElementTypeButton[@name='Verify']")
    private WebElement iVerifyOtp;

    Boolean devicePlatform = MobileProperties.getProperty("device.platform").equalsIgnoreCase("android");
    WebElement element;

    public CommonFeaturesPageObject setOtp(String otp, String msisdn ){
         element = devicePlatform?otpField:otpBox;
            isElementNotPresent(element);
            otp=otp.equalsIgnoreCase("")?getOtp(msisdn):otp;
            setText(element,otp,"OTP");
            return this;
        }

        public CommonFeaturesPageObject hideKeyboard(){
            clickOnElement(hideKeyboard,"Hide Keypad");
            return this;
        }

    public CommonFeaturesPageObject clickOnVerifyOtp(){
            element = devicePlatform ? verifyOtp:iVerifyOtp;
            clickOnElement(element,"Verify OTP Button");
            waitUntilElementDisappear("pb_loading","In progress");
        waitUntilElementDisappear("pb_loading","In progress");
        waitUntilElementDisappear("pb_loading","In progress");
        return this;
    }

    /*public String getOtp(String serviceFlow){
        String otp="";
        try{
            otp = FetchOtp.fetchOTP(Utils.fetchServiceRequestId(serviceFlow));
            if (!otp.matches("\\b[a-zA-z]*[0-9]+[a-zA-z0-9]*\\b")) {
                pageInfo.fail("HttpResponseException occurred " + otp);
                throw new Exception("HttpResponseException " + otp);
            } else if (otp == "") {
                pageInfo.fail("OTP is NULL " + otp);
                throw new NullPointerException(" OTP is NULL ");
            }
            else{
                return otp;
            }
        }
        catch (Exception e) {
            pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
            e.printStackTrace();
            return "";
        }
    }*/

    public  String getOtp(String msisdn){
        String otp="";
        try{
            otp = FetchOtp.fetchOTP(msisdn);
            if (!otp.matches("\\b[a-zA-z]*[0-9]+[a-zA-z0-9]*\\b")) {
                pageInfo.fail("HttpResponseException occurred " + otp);
                throw new Exception("HttpResponseException " + otp);
            } else if (otp == "") {
               // pageInfo.fail("OTP is NULL " + otp);
                throw new NullPointerException(" OTP is NULL ");
            }
            else{
                return otp;
            }
        }
        catch (Exception e) {
            pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
            e.printStackTrace();
            return "";
        }
    }

    public static void main(String[] args) {
        CommonFeaturesPageObject commonFeaturesPageObject = new CommonFeaturesPageObject();
        System.out.println("OTP IS :  "+commonFeaturesPageObject.getOtp("778688686"));
    }



}

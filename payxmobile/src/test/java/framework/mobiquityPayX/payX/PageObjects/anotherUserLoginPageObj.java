package framework.mobiquityPayX.payX.PageObjects;

import com.aventstack.extentreports.Status;
import initializers.AppPageInit;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class anotherUserLoginPageObj extends AppPageInit {

        public anotherUserLoginPageObj() { super();}

        @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"loginMobileNumber\"]")
        public WebElement mobileNum ;

        @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"loginpin\"]")
        public WebElement  Pin;

        @AndroidFindBy(id = "com.comviva.mobiquity.consumer.debug:id/loginButton")
        public WebElement loginbtn ;

        @AndroidFindBy(id = "com.comviva.mobiquity.consumer.debug:id/selectLanguageLayout")
        public WebElement language ;

        @AndroidFindBy(id = "com.comviva.mobiquity.consumer.debug:id/loginfma_forgotpin_label")
        public WebElement forgotpin ;

        @AndroidFindBy(id = "com.comviva.mobiquity.consumer.debug:id/loginfma_registration_text")
        public WebElement register ;

        @AndroidFindBy(id = "com.comviva.mobiquity.consumer.debug:id/toolbarTextViewCenter")
        public WebElement toolbartextview ;

        /* @AndroidFindBy(id = " com.comviva.mobiquity.consumer.debug:id/custom_dialog_ok_buttonView")
         public WebElement errorI;
     */
        @AndroidFindBy(id = "com.comviva.mobiquity.consumer.debug:id/custom_dialog_ok_buttonView")
        public WebElement acceptError;

        @AndroidFindBy(id = "com.comviva.mobiquity.consumer.debug:id/custom_dialog_cancel_buttonView")
        public WebElement ignoresecuritybox ;

        @AndroidFindBy(id = "com.comviva.mobiquity.consumer.debug:id/toolbar_icon")
        public WebElement hambergmenu ;

        @AndroidFindBy(xpath = "//android.widget.TextView[@text='Logout']")
        public WebElement logout ;

        @AndroidFindBy(id = "com.comviva.mobiquity.consumer.debug:id/confirmation_action_button")
        public WebElement logoutbox ;

        @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"More options\"]")
        public WebElement threedots ;

        @AndroidFindBy(xpath = "//android.widget.TextView[@text='Login with another account']")
        public WebElement loginanother ;


        public anotherUserLoginPageObj setMobileNum(String msisdn) {
            if (isElementNotPresent(mobileNum)) {
                setText(mobileNum, msisdn, "Entering the mobile number");
                return this;
            } else {
                return this;
            }
        }

        public anotherUserLoginPageObj setpin(String pin){

            if (isElementNotPresent(Pin)) {
                setText(Pin,pin,"Entering the Pin");
                return this;
            } else {
                return this;
            }

        }

        public anotherUserLoginPageObj clickonLogin(){
            clickOnElement(loginbtn,"clicking on Login button");
            return this;
        }

        public boolean ishomePagePresent(){
            isElementNotPresent(toolbartextview);
            return driver.findElements(By.id("com.comviva.mobiquity.consumer.debug:id/toolbarTextViewCenter")).size() > 0;
        }

    /*public boolean isValidationDialogBoxPresent(){
        //isElementNotPresent(acceptError);
        return driver.findElements(By.id("com.comviva.mobiquity.consumer.debug:id/custom_dialog_ok_buttonView")).size() > 0;
    }*/

        public anotherUserLoginPageObj clickOnAcceptErr() {
            if (isElementNotPresent(acceptError)) {
                return this;
            } else {
                clickOnElement(acceptError, "Clicking on OK button of error message box");
                return this;
            }
        }

        public anotherUserLoginPageObj clickOnIgnore(){
            if(isElementNotPresent(ignoresecuritybox)){
                clickOnElement(ignoresecuritybox,"Clicking on ignore button");
                return this;
            }else{

                return this;
            }}

        public anotherUserLoginPageObj clickOnhambergmenu(){
            clickOnElement(hambergmenu,"Clicking on hambergemenu");
            return this;
        }

        public anotherUserLoginPageObj clickOnlogout(){
            clickOnElement(logout,"Clicking on logout");
            return this;
        }

        public anotherUserLoginPageObj clickOnlogoutbox() throws InterruptedException {
            clickOnElement(logoutbox,"Clicking on logoutoption");
            Thread.sleep(5000);
            return this;
        }

        public anotherUserLoginPageObj clickOnthreedots()  {
            isElementNotPresent(threedots);
            clickOnElement(threedots,"Clicking on threedots");
            return this;
        }

        public anotherUserLoginPageObj clickOnloginanother(){
            isElementNotPresent(loginanother);
            clickOnElement(loginanother,"Clicking on loginwithanother");
            return this;
        }

        public String getWelcomeText(){
            try{
                waitUntilElementDisappear("//*[@text='Welcome Subscriber']");
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



package framework.mobiquityPayX.payX.feature;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import common.Assertion;
import framework.mobiquityPayX.payX.PageObjects.payXLoginPageObjects;
import framework.mobiquityPayX.payX.PageObjects.payXLoginPageObjects;
import org.apache.commons.lang3.exception.ExceptionUtils;
import reportManagement.ExtentManager;

public class payXLoginFeature extends payXLoginPageObjects {

    payXLoginPageObjects loginpage = new payXLoginPageObjects();

    public void login(String Msisdn , String Pin){
        ExtentTest node = ExtentManager.getTest();

        try{
            //The service flow of Login automation
            loginpage.setMobileNum(Msisdn).setpin(Pin).clickonLogin();
            //loginpage.clickOnAcceptErr();
            //enter mobile number . enter pin , and click on login button
            if(loginpage.ishomePagePresent()){
                Assertion.verifyContains(loginpage.getWelcomeText(),"Welcome Subscriber");
            }
            // Assertion that login has been successful

        }catch (Exception e){
            e.printStackTrace();
            pageInfo.fail("Test Case Failed");
            pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
    }
         //Accepting the dialog box if it appears
        public void AcceptDialogBox(){
            if(isValidationDialogBoxPresent()){
            loginpage.clickOnAcceptErr();
            }
        }
        public void DialogBox(){
            try{
                loginpage.clickOnAcceptErr();
            }catch (Exception e){
//                e.printStackTrace();
                pageInfo.pass("Dialogbox is not present");
//                pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
            }
        }

        public void register(){
            try{
//                loginpage.clickonRegister();
            }catch (Exception e){
                e.printStackTrace();
                pageInfo.fail("Test Case Failed");
                pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
            }
        }
}

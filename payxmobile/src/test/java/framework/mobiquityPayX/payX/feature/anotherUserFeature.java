package framework.mobiquityPayX.payX.feature;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import common.Assertion;
import framework.mobiquityPayX.payX.PageObjects.anotherUserLoginPageObj;
import framework.mobiquityPayX.payX.PageObjects.dashboardPageObj;
import org.apache.commons.lang3.exception.ExceptionUtils;
import reportManagement.ExtentManager;

public class anotherUserFeature extends anotherUserLoginPageObj {

    anotherUserLoginPageObj anotherUser = new anotherUserLoginPageObj();
    dashboardPageObj db = new dashboardPageObj();


    public void loginWithAnotherUser(String Msisdn , String Pin){
        ExtentTest node = ExtentManager.getTest();

        try{
            //The service flow of Login automation

            //enter mobile number . enter pin , and click on login button

//            anotherUser.clickOnIgnore();
            if(anotherUser.ishomePagePresent()){
                clickOnhambergmenu().clickOnlogout().clickOnlogoutbox()
                        .clickOnthreedots().clickOnloginanother();


                anotherUser.setMobileNum(Msisdn).setpin(Pin).clickonLogin();
                //enter mobile number . enter pin , and click on login button

                if (db.isIgnoreBoxPresent()){
                    db.clickOnIgnore();
                }
                else
                {
                    Assertion.verifyContains(anotherUser.getWelcomeText(),"Welcome Subscriber");
                }

/*                if(anotherUser.ishomePagePresent()){
                }*/


                // Assertion.verifyContains(loginpage.getWelcomeText(),"welcome");
            }
            // Assertion that login has been successful

        }catch (Exception e) {
            e.printStackTrace();
            pageInfo.fail("Test Case Failed");
            pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        // loginanother.clickOnhambergmenu().clickOnlogout().clickOnlogoutbox().clickOnthreedots().clickOnloginanother();


    }
    // Accepting the dialog box if it appears
    /*public void AcceptDialogBox(){
        if(loginanother.isValidationDialogBoxPresent()){
            loginanother.clickOnAcceptErr();
        }
        else{
        }
    }*/
  /*  public void clickonloginanother(String mobile , String pin){
        ExtentTest node = ExtentManager.getTest();

        try{
//            loginanother.clickOnthreedots().clickOnloginanother();

//The service flow of Login automation

            anotherUser.setMobileNum(mobile).setpin(pin).clickonLogin();
            //enter mobile number . enter pin , and click on login button

            if(anotherUser.ishomePagePresent()){
                Assertion.verifyContains(anotherUser.getWelcomeText(),"Welcome Subscriber");
            }
            // Assertion that login has been successful

        }catch (Exception e) {
            e.printStackTrace();
            pageInfo.fail("Test Case Failed");
            pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }


    }
*/

}

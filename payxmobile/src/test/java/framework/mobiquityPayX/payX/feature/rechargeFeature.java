package framework.mobiquityPayX.payX.feature;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import common.Assertion;
import framework.mobiquityPayX.payX.PageObjects.*;
import org.apache.commons.lang3.exception.ExceptionUtils;
import reportManagement.ExtentManager;
import utils.Utils;

public class rechargeFeature extends rechargePrepaidPageObj {

    loginPageObj slpo = new loginPageObj();
    dashboardPageObj dpo = new dashboardPageObj();
    rechargePrepaidPageObj rppo = new rechargePrepaidPageObj();
    chooseOperatorPageObj copo = new chooseOperatorPageObj();
    rechargePrepaidSecPageObj rpspo = new rechargePrepaidSecPageObj();
    rechargePrepaidAmountDetailsPageObj rpadpo = new rechargePrepaidAmountDetailsPageObj();
    pinAuthenticationPageObj papo = new pinAuthenticationPageObj();
    rechargePrepaidSuccessPageObj rpsp = new rechargePrepaidSuccessPageObj();

    public void recharge(String mobile, String amount, String pin){
        ExtentTest node = ExtentManager.getTest();

        try{

//            slpo.setMobileNum(msisdn).setPin(pin).clickonLogin();
            toRechargeNumber();
            rppo.setMobileNumber(mobile).clickOnMobileOper();
            copo.clickOnAirtel();
            rppo.clickOnNext();
            rpspo.clearAmount().setAmount(amount).clickOnNext();
            rpadpo.clickOnPay();
            papo.clickOnEnterPinField().setPin(pin).clickVerify();

            if(rpsp.isServiceTypePresent()){
                Assertion.verifyContains(rpsp.getRechargeStatus(),"Service Type");
                Utils.scrollDown();
                rpsp.clickOnGoHome();
//                    node.pass("Test case PASS");
            }

        }catch (Exception e){
            e.printStackTrace();
            pageInfo.fail("Test Case FAILED");
            pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }



    }

    public void toRechargeNumber(){
        dpo.clickOnRecharge();

        if(rppo.isSwapIconPresent())
        {
            rppo.clickOnSwapIcon();
        }
        else
        {
            rppo.clickOnMobileField();
        }
    }

}

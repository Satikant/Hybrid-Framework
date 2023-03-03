package framework.mobiquityPayX.payX.feature;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import common.Assertion;
import framework.mobiquityPayX.payX.PageObjects.*;
import org.apache.commons.lang3.exception.ExceptionUtils;
import reportManagement.ExtentManager;
import utils.Utils;

public class depositeCashUn_registerFeature extends depositeCashPageObj{

    dashboardPageObj dpo = new dashboardPageObj();
    depositeCashPageObj dcpo = new depositeCashPageObj();
    depositeCashDetailsPageObj dcdpo = new depositeCashDetailsPageObj();
    pinAuthenticationPageObj papo = new pinAuthenticationPageObj();
    depositeCashSuccessPageObj dcspo = new depositeCashSuccessPageObj();


    public void depositeCashUnRegister(String depositemob , String withdrawermob, String amount, String pin){
        ExtentTest node = ExtentManager.getTest();

        try {
            forDepositeCash();
            dcpo.setDepositeMobNo(depositemob).setwithdrawerMobNo(withdrawermob).setAmount(amount).clickOnNext();
            dcdpo.clickOnTransferNow();
            papo.clickOnEnterPinField().setPin(pin).clickVerify();
//            dcspo.isTransctionSuccess();

            if(dcspo.isTransctionSuccess()){
                Assertion.verifyContains(dcspo.getDepositeCashSuccessful(),"Service Type");
                dcspo.clickOnGoHome();
//                    node.pass("Test case PASS");
            }


        }
        catch (Exception e){
            e.printStackTrace();
            pageInfo.fail("Test Case Failed");
            pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }

    }

    public void forDepositeCash(){
        Utils.putThreadSleep(10000);
        dpo.isWelcomeTitlePresent();
        dpo.clickOnDipositeCash();
        dcpo.clickOnUnregisterUser();
    }

    public void depositeCash(String depositemob , String withdrawermob, String amount){
        ExtentTest node = ExtentManager.getTest();

        try {
            forDepositeCash();
            dcpo.setDepositeMobNo(depositemob).setwithdrawerMobNo(withdrawermob).setAmount(amount).clickOnNext();


        }
        catch (Exception e){
            e.printStackTrace();
            pageInfo.fail("Test Case Failed");
            pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }

    }

    public void depositeCashSuccess(String pin){

        dcdpo.clickOnTransferNow();
        papo.clickOnEnterPinField().setPin(pin).clickVerify();
        dcspo.isTransctionSuccess();

    }


}

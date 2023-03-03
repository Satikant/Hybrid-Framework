package framework.mobiquityPayX.payX.feature;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import common.Assertion;
import framework.mobiquityPayX.payX.PageObjects.*;
import org.apache.commons.lang3.exception.ExceptionUtils;
import reportManagement.ExtentManager;
import utils.Utils;
import utils.W3CActions;


public class billPayFeature extends billPayPageObj {
    dashboardPageObj dbpage = new dashboardPageObj();
    billPayPageObj bp = new billPayPageObj();
    electricityBoardPageObj electricBoard = new electricityBoardPageObj();
    electricityDetailsPageObj edpo = new electricityDetailsPageObj();
    electricityBillDetailsPageObj ebdpo = new electricityBillDetailsPageObj();
    electricityBillAmountDetailsPageObj ebadpo = new electricityBillAmountDetailsPageObj();
    pinAuthenticationPageObj papo = new pinAuthenticationPageObj();
    electricityBillPaymentSuccessPageObj ebpsp = new electricityBillPaymentSuccessPageObj();


    public void electricityBillPay(String amount, String customerID, String pin) {
        ExtentTest node = ExtentManager.getTest();

        try {
            toElectricityBillpay();
            edpo.setConsumerID(customerID);

            if (edpo.isCustomerIdPresent()) {
                Assertion.verifyContains(edpo.getCustomerId(), "Next");
            }

            edpo.clickOnNext();
            ebdpo.clearAmountField().setAmount(amount).clickOnNext();
            ebadpo.clickOnPay();
            papo.clickOnEnterPinField().setPin(pin).clickVerify();


                if (ebpsp.isServiceTypePresent()){
                    ebpsp.clickOnGoHome();
                }


        } catch (Exception e) {
            e.printStackTrace();
            pageInfo.fail("Test Case Failed");
            pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
    }



    public void toElectricityBillpay(){
        if(dbpage.isWelcomeTitlePresent())
        {
            dbpage.clickOnBillPay();
        }

        else if (bp.isElectricityPresent())
        {
            bp.clickOnElectricity();
        }

        else
        {
            dbpage.clickOnIgnore().clickOnBillPay();
        }

        if (bp.isElectricityPresent()){
            bp.clickOnElectricity();
        }
//        bp.isElectricityPresent();
//        bp.clickOnElectricity();
        if (electricBoard.isElectricityBoardPresent()){
            electricBoard.chooseElecticityBoard();
        }
    }



}




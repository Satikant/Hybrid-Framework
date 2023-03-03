package framework.mobiquityPayX.payXUAT.feature;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import common.Assertion;
import framework.mobiquityPayX.payX.PageObjects.*;
import framework.mobiquityPayX.payXUAT.PageObjects.mobilePostPaidPageObj;
import framework.mobiquityPayX.payXUAT.PageObjects.mobilePostpaidDetails2PageObj;
import framework.mobiquityPayX.payXUAT.PageObjects.mobilePostpaidDetailsPageObj;
import org.apache.commons.lang3.exception.ExceptionUtils;
import reportManagement.ExtentManager;


public class billPayFeature extends billPayPageObj {
    dashboardPageObj dbpage = new dashboardPageObj();
    billPayPageObj bp = new billPayPageObj();
    electricityBoardPageObj electricBoard = new electricityBoardPageObj();
    electricityDetailsPageObj edpo = new electricityDetailsPageObj();
    mobilePostpaidDetailsPageObj mppdObj = new mobilePostpaidDetailsPageObj();
    mobilePostPaidPageObj mppObj = new mobilePostPaidPageObj();
    electricityBillDetailsPageObj ebdpo = new electricityBillDetailsPageObj();
    electricityBillAmountDetailsPageObj ebadpo = new electricityBillAmountDetailsPageObj();
    mobilePostpaidDetails2PageObj mppd2Obj = new mobilePostpaidDetails2PageObj();
    pinAuthenticationPageObj papo = new pinAuthenticationPageObj();
    electricityBillPaymentSuccessPageObj ebpsp = new electricityBillPaymentSuccessPageObj();


    public void electricityBillPay(String amount, String customerID) {
        ExtentTest node = ExtentManager.getTest();

        try {
            toElectricityBillpay();
            edpo.setConsumerID(customerID).clickOnNext();
            ebdpo.clearAmountField().setAmount(amount).clickOnNext();
            if (ebadpo.isCheckBoxPresent()){
                ebadpo.clickCheckBox().clickOnPay();
            }
            else{
                ebadpo.clickOnPay();
            }



        } catch (Exception e) {
            e.printStackTrace();
            pageInfo.fail("Test Case Failed");
            pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
    }


    public void toElectricityBillpay() {
        if (dbpage.isWelcomeTitlePresent()) {
            dbpage.clickOnBillPay();
        }

/*        else if (bp.isElectricityPresent())
        {
            bp.clickOnElectricity();
        }

        else
        {
            dbpage.clickOnBillPay();
        }*/

        if (bp.isElectricityPresent()){
            bp.clickOnElectricity();
        }
//        bp.isElectricityPresent();
//        bp.clickOnElectricity();
        if (electricBoard.isElectricityBoardPresent()){
            electricBoard.chooseElecticityBoard();
        }

        if (edpo.isBoardPresent()){
            edpo.clickOnBoard();
            electricBoard.chooseElecticityBoard();
        }
    }


    public void makeAnotherPayment() {
        if (ebpsp.isAnotherPaymentPresent()) {
            ebpsp.makeAnotherPayment();
        }


    }

    public void backToDashboard() {
        try {
            if(bp.isBackPresent() || electricBoard.isBackPresent())
                clickOnBack();
        }
        catch (Exception e){
            ExtentTest node = ExtentManager.getTest();
            e.printStackTrace();
            node.fail("Test Case Failed");
            node.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }

    }


    public void postPaidBillPay(String mobileNo, String amount, String Pin) {
        ExtentTest node = ExtentManager.getTest();

        try {
            if (bp.isPostpaidPresent()){
                bp.clickOnPostpaid();
            }
            mppObj.setMobileNumber(mobileNo).clickOnOperator().chooseOperator().clickOnNext();
            mppdObj.setAmount(amount).clickOnNext();
            mppd2Obj.clickOnPay();
            papo.clickOnEnterPinField().setPin(Pin).clickVerify();

        } catch (Exception e) {
            e.printStackTrace();
            pageInfo.fail("Test Case Failed");
            pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
    }



}




package framework.wallet.ahliBank.features;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import framework.wallet.ahliBank.pageObjects.LoginPageAhliBank;
import framework.wallet.ahliBank.pageObjects.TransferToBankPageAB;
import globalConstants.Config;
import org.apache.commons.lang3.exception.ExceptionUtils;
import reportManagement.ExtentManager;
import utils.CommonUtils;
import utils.DataDriven;

import java.io.IOException;

import static initializers.TestInit.startPositveTest;

public class TransferToBankFeatureAB {

    TransferToBankPageAB page = new TransferToBankPageAB();
    LoginPageAhliBank page2 = new LoginPageAhliBank();
    CustomerLoginAhliBank login = new CustomerLoginAhliBank();

    public TransferToBankFeatureAB TransferToBank(String amt , String Otp) throws InterruptedException , IOException {

        ExtentTest featureNode = ExtentManager.getTest();
        try {
            startPositveTest();
            if(Config.isFirstTimeLogin) {
                login.login(DataDriven.getUserByStatus("Y"), DataDriven.getUserPinByStatus("Y"));
                Config.setFirstTimeLoginFalse();
            }

            page.clickonTransferIcon().enterAmount(amt).clickonNext();

            if (page.isAlertMessageAvailable()) {
                featureNode.info("Negative Test case flow");
            }

            else if (page.isConfirmBtnPresent()) {
                page.clickOnConfirm1();
                page.setotp(Otp);
                CommonUtils.pauseExecution(1);

                if (page.isAlertMessageAvailable()) {
                    featureNode.info("Negative Test case Flow");
                }
                CommonUtils.pauseExecution(1);
                if(page.isCancelButtonPresent()){
                    page.clickonConfirm2();
                }
                else if (page.istitlePresent()){
                    String transactiondetails[] = page.getDetails();
                    featureNode.info("Transaction Status : " + transactiondetails[0]);
                    featureNode.info("Transaction ID : " + transactiondetails[1]);
                    featureNode.info("Transaction Date and Time : " + transactiondetails[2]);
                    featureNode.info("Account : " + transactiondetails[3]);
                    featureNode.info("Transfer Details : " + transactiondetails[4]);
                }
            }

        }   catch (Exception e) {
            e.printStackTrace();
            featureNode.fail("Test Case Failed");
            featureNode.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
    return this ;
    }

    public TransferToBankFeatureAB OtpReturn(String amt) throws InterruptedException {
        ExtentTest featureNode = ExtentManager.getTest();
        try {
               /* startPositveTest();
                if (Config.isFirstTimeLogin) {
                    login.login(DataDriven.getUserByStatus("Y"), DataDriven.getUserPinByStatus("Y"));
                    Config.setFirstTimeLoginFalse();
                }*/
            featureNode.info("Negative Test case Flow");
            page.clickonTransferIcon().enterAmount(amt).clickonNext();
            page.clickOnConfirm1();
            page.clickOnOtpCancel();

        } catch (Exception e) {
            e.printStackTrace();
            featureNode.fail("Test Case Failed");
            featureNode.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        return this;
    }

}

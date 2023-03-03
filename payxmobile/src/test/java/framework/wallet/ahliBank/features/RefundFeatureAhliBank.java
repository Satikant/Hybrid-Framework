package framework.wallet.ahliBank.features;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import framework.wallet.ahliBank.pageObjects.MerchantLoginPageAB;
import framework.wallet.ahliBank.pageObjects.RefundPageAhlibank;
import globalConstants.Config;
import org.apache.commons.lang3.exception.ExceptionUtils;
import reportManagement.ExtentManager;
import utils.CommonUtils;
import utils.DataDriven;

import java.io.IOException;

import static initializers.TestInit.startPositveTest;

public class RefundFeatureAhliBank {


    RefundPageAhlibank page = new RefundPageAhlibank();
    MerchantLoginPageAB page2 = new MerchantLoginPageAB();
    MerchantLoginFeatureAB login = new MerchantLoginFeatureAB();

    public RefundFeatureAhliBank Refund(String TransactionId , String Otp) throws InterruptedException, IOException {
        ExtentTest featureNode = ExtentManager.getTest();
        try {
            startPositveTest();
            if (Config.isFirstTimeLogin) {
                login.login(DataDriven.getUserByStatus("MY"), DataDriven.getUserPinByStatus("MY"));
                Config.setFirstTimeLoginFalse();
            }
            page.clickonRefund().editTxnid(TransactionId).clickonconfirm();

            if (page.isConfirmBtnPresent()){
                page.setOTP(Otp);
                CommonUtils.pauseExecution(1);

                if (page.isAlertMessageAvailable()) {
                    featureNode.info("Negative Test case Flow");
                }
                if(page.isCancelButtonPresent()){
                    page.clickonConfirm2();
                }
                else if (page.istitlePresent()){
                    String transactiondetails[] = page.getDetails();
                    featureNode.info("Transaction Status : " + transactiondetails[0]);
                    featureNode.info("Transaction ID : " + transactiondetails[1]);
                    featureNode.info("Transaction Date and Time : " + transactiondetails[2]);
                    featureNode.info("Transaction Amount : " + transactiondetails[3]);
                    featureNode.info("Refund To Details : " + transactiondetails[4]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            featureNode.fail("Test Case Failed");
            featureNode.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        return this;
        }

    public RefundFeatureAhliBank OtpReturn(String TransactionId) throws InterruptedException {
        ExtentTest featureNode = ExtentManager.getTest();
        try {
               /* startPositveTest();
                if (Config.isFirstTimeLogin) {
                    login.login(DataDriven.getUserByStatus("Y"), DataDriven.getUserPinByStatus("Y"));
                    Config.setFirstTimeLoginFalse();
                }*/
            featureNode.info("Negative Test case Flow");

            page.clickonRefund().editTxnid(TransactionId).clickonconfirm();
            page.clickOnOtpCancel();

        } catch (Exception e) {
            e.printStackTrace();
            featureNode.fail("Test Case Failed");
            featureNode.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        return this;
    }

}

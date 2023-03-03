package framework.wallet.bharain.features;

import com.aventstack.extentreports.ExtentTest;
import common.Assertion;
import framework.wallet.bharain.pageObjects.DonationPage;
import framework.wallet.bharain.pageObjects.LoginPageBharain;
import framework.wallet.bharain.pageObjects.SplitBillPage;
import globalConstants.Config;
import globalConstants.VariableConstant;
import initializers.TestInit;
import reportManagement.ExtentManager;
import utils.CommonUtils;
import utils.DataDriven;
import utils.MessageReader;

import java.io.IOException;

import static initializers.TestInit.startPositveTest;


public class DonationFeature {

    CustomerLoginBharain customerLogin = new CustomerLoginBharain();
    LoginPageBharain lPage = new LoginPageBharain();
    DonationPage page = new DonationPage();
    SplitBillPage spltBillPg = new SplitBillPage();

    public DonationFeature Donation(String amt, Boolean value) throws IOException, InterruptedException {
        ExtentTest node = ExtentManager.getTest();
            startPositveTest();
        if (Config.isFirstTimeLogin) {
            customerLogin.Login(DataDriven.getUserByStatus("Y"), DataDriven.getUserPinByStatus("Y"));
            Config.setFirstTimeLoginFalse();
            CommonUtils.pauseExecution(5);
        }
        page.clickOnDonationFromHomeScreen();
        page.enterAmount(amt);
        page.clickOnPayNow();
        CommonUtils.pauseExecution(2);
        if (!page.isTransactionDetailPresent()) {
            page.clickOnPayNow();
            CommonUtils.pauseExecution(5);
            if(page.isTxnStatusDisplayed()){
            CommonUtils.pauseExecution(2);
            String txnDetails[] = page.fetchDetails();
            VariableConstant.TRANSACTION_AMOUNT = amt;
                VariableConstant.TRANSACTION_DATE_TIME= txnDetails[2];
                VariableConstant.TRANSACTION_ID= txnDetails[0];
                VariableConstant.TRANSACTION_STATUS= txnDetails[1];
             /*   node.info("\nTransaction Id -"+VariableConstant.TRANSACTION_ID);
                node.info("\nTransaction Status -"+VariableConstant.TRANSACTION_STATUS);
                node.info("\n Transaction Date -"+VariableConstant.TRANSACTION_DATE_TIME);
                node.info("\n Transaction Amount -"+ VariableConstant.TRANSACTION_AMOUNT);*/
            Assertion.verifyEqual(page.fetchTxnStatus(), MessageReader.getMessage("ERRMSG_0060"));
            CommonUtils.pauseExecution(2);
            if (value == Boolean.TRUE) {
                page.isTransactionPresentInTxnHistory(VariableConstant.TRANSACTION_ID);
            }
            }

        }return this;

    }

    public void acceptAlert() throws InterruptedException {
        if (lPage.isSnackbarDisplayed()) {
            lPage.clickOnsnackbarButton();
        }
        Thread.sleep(1000);
        if (page.isHomeBtnDisplayed()) {
            page.clickOnHome();
        } else if (page.isBackBtnPresent()) {
            spltBillPg.clickBack();
        }
    }


}

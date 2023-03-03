package framework.wallet.ahliBank.features;

import com.aventstack.extentreports.ExtentTest;
import common.Assertion;
import framework.wallet.ahliBank.pageObjects.BillPayPageAhliBank;
import framework.wallet.ahliBank.pageObjects.LoginPageAhliBank;
import framework.wallet.ahliBank.pageObjects.SendMoneyPageAhliBank;
import globalConstants.Config;
import globalConstants.VariableConstant;
import initializers.TestInit;
import reportManagement.ExtentManager;
import utils.CommonUtils;
import utils.DataDriven;
import utils.MessageReader;

import java.io.IOException;

public class SendMoneyFeatureAhliBank {

    SendMoneyPageAhliBank sendMoneyPg= new SendMoneyPageAhliBank();
    CustomerLoginAhliBank login = new CustomerLoginAhliBank();
    LoginPageAhliBank loginPage = new LoginPageAhliBank();
    BillPayPageAhliBank billPay = new BillPayPageAhliBank();

    public  SendMoneyFeatureAhliBank performSendMoney(String recMobile,String recBeneficiaryName, String recAmt,String OTPvalue) throws InterruptedException, IOException {
        ExtentTest node = ExtentManager.getTest();
        TestInit.startPositveTest();
        if(Config.isFirstTimeLogin){
            loginPage.clickOnUATServer();
            CommonUtils.pauseExecution(5);
            Config.setFirstTimeLoginFalse();
            if(loginPage.isLoginBtnPresent()){
                loginPage.clickOnLoginButton();
                login.login(DataDriven.getUserByStatus("Y"),DataDriven.getUserPinByStatus("Y"));
            }
        }
        if (sendMoneyPg.isSendMoneyIconAvailable()) {
            sendMoneyPg.clickOnSendMoneyIcon();
        }
        if (sendMoneyPg.isMsisdnFieldDisplayed()) {
            if (Config.isSelectContactFromList == true) {
                sendMoneyPg.clickOnContact().selectName();
                Config.isSelectContactFromList = false;
            } else {
                sendMoneyPg.setMobileNumber(recMobile);
            }
            sendMoneyPg.setBeneficiaryName(recBeneficiaryName);
            sendMoneyPg.setTransferAmt(recAmt);

            if (Config.isTermsAndCondNonClickable == true) {
                sendMoneyPg.clickOnTermsLink();
//            Thread.sleep(5000);
//        sendMoneyPg.scrollToEndOfthePage();
//        sendMoneyPg.clickOnConfirmBtn();
            }
            sendMoneyPg.clickOnNext();
            if (sendMoneyPg.isAlertMessageAvailable()) {
                return this;
            }
            sendMoneyPg.clickOnConfirmBtn();
            if (sendMoneyPg.isAlertMessageAvailable()) {
                return this;
            }
        }
        if(sendMoneyPg.isAlertDialogBoxPresent())
        {sendMoneyPg.clickOnAlertOK();}
        else {
        if(sendMoneyPg.isOTPFeildPresent()){sendMoneyPg.enterOTP(OTPvalue);}
        sendMoneyPg.clickOnOTPConfirmBtn();
        if(sendMoneyPg.isAlertMessageAvailable()){
            return this;}
        if(sendMoneyPg.isTxnSuccessMessagePresent()){
            String transactiondetails[] = billPay.getDetails();
            VariableConstant.TRANSACTION_STATUS=transactiondetails[0];
            VariableConstant.TRANSACTION_ID=transactiondetails[1];
            VariableConstant.TRANSACTION_DATE_TIME=transactiondetails[2];
            VariableConstant.TRANSACTION_AMOUNT=transactiondetails[3];
            VariableConstant.PROVIDER=transactiondetails[4];
            node.info("Transaction Status : " + VariableConstant.TRANSACTION_STATUS);
            node.info("Transaction ID : " + VariableConstant.TRANSACTION_ID);
            node.info("Transaction Date and Time : " + VariableConstant.TRANSACTION_DATE_TIME);
            node.info("Transaction Amount : " + VariableConstant.TRANSACTION_AMOUNT);
            node.info("Money Transfered To : " + VariableConstant.PROVIDER);
            if(VariableConstant.TRANSACTION_STATUS.equalsIgnoreCase(MessageReader.getMessage("Error_AH_SendMoney_004"))){
                node.pass("Transaction Pass");
              }
            return this;}}
        return this;
    }

    public String getAlertMessage() throws InterruptedException {
        Thread.sleep(1000);
        if(sendMoneyPg.isTxnSuccessMessagePresent()){

            return sendMoneyPg.getSucessMessage();
        }
        return sendMoneyPg.getAlertMessage();
    }



//    public SendMoneyFeatureAhliBank clickOnAlertOK(){
//        sendMoneyPg.clickOnAlertOK();
//        return this;
//    }


    public SendMoneyFeatureAhliBank resetForTesting() throws InterruptedException {
        if(sendMoneyPg.isAlertOkPresent()){sendMoneyPg.clickOnAlertOK();}
        if(sendMoneyPg.isCancelButtonPresent()){sendMoneyPg.clickOnCancelBtn();}
        return this;
    }
}

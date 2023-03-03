package framework.wallet.bharain.features;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import entities.Transaction;
import framework.wallet.bharain.pageObjects.LoginPageBharain;
import framework.wallet.bharain.pageObjects.RequestMoneyPage;
import framework.wallet.bharain.pageObjects.SendMoneyPage1;
import globalConstants.Config;
import initializers.TestInit;
import org.apache.commons.lang3.exception.ExceptionUtils;
import reportManagement.ExtentManager;
import utils.CommonUtils;
import utils.DataDriven;
import utils.MessageReader;

import java.io.IOException;

public class RequestMoneyFeature {

    CustomerLoginBharain customerLogin = new CustomerLoginBharain();
    SendMoneyPage1 page1 = new SendMoneyPage1();
    LoginPageBharain page = new LoginPageBharain();
    RequestMoneyPage requestMoneyPage=new RequestMoneyPage();

    public RequestMoneyFeature requestMoney(Transaction txn, String countrycode, String msisdn, String amt) throws InterruptedException, IOException {
        ExtentTest featureNode = ExtentManager.getTest();
        TestInit.startPositveTest();
        if(Config.isFirstTimeLogin){
            customerLogin.Login(DataDriven.getUserByStatus("Y"), DataDriven.getUserPinByStatus("Y"));
            Config.setFirstTimeLoginFalse();
        }
        requestMoneyPage.clickOnRequestMoneyIcon();
        page1
               //.selectCountryCode(countrycode)
                .setMsisdn(msisdn).setAmt(amt).clickOnSubmitButton();

        if(Config.toastCheck){
            Config.setToastCheckFalse();
            page1.getToast();
            page1.clickOnBackButton();
        }
        else {
            if (page.isClickOnOkisDisplayed()) {
                CommonUtils.captureScreenMobile(featureNode, "REQUEST MONEY ERROR MESSAGE");
            }
            page1.clickOnSubmitButton();
            CommonUtils.pauseExecution(2);
            if (page.isClickOnOkisDisplayed()) {
                CommonUtils.captureScreenMobile(featureNode, "REQUEST MONEY ERROR MESSAGE");
            } else {
                if (page1.isClickOnSubmitButtonDisplayed()) {
                    page1.clickOnSubmitButton();
                    page1.getUnknownError();
                    do {
                        page1.clickOnBackButton();
                        System.out.println(page1.isClickOnSubmitButtonDisplayed() + "  Toast");
                    } while (page1.isClickOnSubmitButtonDisplayed());
                } else if (page1.isHomeButtonDisplayed()) {
                    String transactiondetails[] = page1.getDetails();
                    if (transactiondetails[0].equalsIgnoreCase(MessageReader.getMessage("COMVALMSG_002"))) {
                        featureNode.pass("Transaction Successful and Transaction ID  :" + transactiondetails[1]);
                    } else {
                        featureNode.fail("Transaction is not Successful and Transaction Status : " + transactiondetails[0] + " and Transaction ID : " + transactiondetails[1]);
                    }
                    CommonUtils.captureScreenMobile(featureNode, "Request Money Screenshot");
                    page1.clickOnHomeButton();
                }
            }
        }
        return this;
    }


    public void acceptAlert()  {
        try{
            if(page.isClickOnOkisDisplayed()) {
                page.clickOnsnackbarButton();
                do{
                    CommonUtils.pauseExecution(2);
                    page1.clickOnBackButton();
                    System.out.println(page1.isClickOnSubmitButtonDisplayed()+"UP");
                }while(page1.isClickOnSubmitButtonDisplayed());
            }
        }

        catch (Exception e) {
            ExtentTest node = ExtentManager.getTest();
            e.printStackTrace();
            node.fail("Test Case Failed");
            node.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
    }


}

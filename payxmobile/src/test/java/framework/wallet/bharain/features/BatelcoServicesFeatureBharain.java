package framework.wallet.bharain.features;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import framework.wallet.bharain.pageObjects.BatelcoServicesPage;
import framework.wallet.bharain.pageObjects.LoginPageBharain;
import framework.wallet.bharain.pageObjects.SendMoneyPage1;
import globalConstants.Config;
import org.apache.commons.lang3.exception.ExceptionUtils;
import reportManagement.ExtentManager;
import utils.CommonUtils;
import utils.DataDriven;
import utils.MessageReader;
import java.io.IOException;

import static initializers.TestInit.startPositveTest;

public class BatelcoServicesFeatureBharain {
    BatelcoServicesPage batelcoServicesPage=new BatelcoServicesPage();
    CustomerLoginBharain customerLogin=new CustomerLoginBharain();
    LoginPageBharain page=new LoginPageBharain();
    SendMoneyPage1 page1=new SendMoneyPage1();

    public BatelcoServicesFeatureBharain doBillPay(String msisdn, String cpr, String amt, String billpaymethod)  {
        ExtentTest featureNode = ExtentManager.getTest();
        startPositveTest();
        try{
            if(Config.isFirstTimeLogin){
                customerLogin.Login(DataDriven.getUserByStatus("Y"), DataDriven.getUserPinByStatus("Y"));
                Config.setFirstTimeLoginFalse();
                batelcoServicesPage.clickOnBatelcoServicesIcon().clickOnBillPayMode(billpaymethod);
            }

            if(batelcoServicesPage.isBatelcoServicesIconDisplayed()){
                batelcoServicesPage.clickOnBatelcoServicesIcon().clickOnBillPayMode(billpaymethod);
            }
            batelcoServicesPage.setPostpaidNumber(msisdn).setPostpaidCprNumber(cpr);
            if(Config.isBillEnquiryReuired){
                batelcoServicesPage.clickOnGetBill();
                Config.setBillEnquiryFalse();
                amt=batelcoServicesPage.getAmount();
            }

            batelcoServicesPage.setAmount(amt).clickOnProceedButton();
            if (Config.toastCheck) {
                batelcoServicesPage.getToast();
                Config.setToastCheckFalse();
            }
            if (batelcoServicesPage.isConfirmButtonDisplayed()) {
                batelcoServicesPage.clickOnConfirmButton();
                if(Config.checkSufficientBalance){
                    Config.setCheckSufficientBalance();
                }
                else {
                    if (page1.isHomeButtonDisplayed()) {
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
        }
        catch (Exception e) {
            e.printStackTrace();
            featureNode.fail("Test Case Failed");
            featureNode.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }

        return this;
    }

    public BatelcoServicesFeatureBharain doPrepaid(String msisdn) {
        ExtentTest featureNode = ExtentManager.getTest();
        try{
            startPositveTest();
            if(Config.isFirstTimeLogin){
                customerLogin.Login(DataDriven.getUserByStatus("Y"), DataDriven.getUserPinByStatus("Y"));
                Config.setFirstTimeLoginFalse();
                batelcoServicesPage.clickOnBatelcoServicesIcon();
                batelcoServicesPage.clickOnPrepaid().setPrepaidNumber(msisdn).clickOnQuickPay().selectAmount()
                        .clickOnProceedButton().clickOnConfirmButton();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            featureNode.fail("Test Case Failed");
            featureNode.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        return this;
    }



    public void acceptAlertBatelcoServices()  {
        try{
            if (page.isSnackbarDisplayed()) {
                page.clickOnsnackbarButton();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

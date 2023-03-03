package framework.wallet.bankMuscat.features;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import entities.Transaction;
import framework.wallet.bankMuscat.pageObjects.LoginPageBankMuscat;
import framework.wallet.bankMuscat.pageObjects.SendMoneyPageBankMuscat;
import globalConstants.Config;
import org.apache.commons.lang3.exception.ExceptionUtils;
import propertyManagement.MobileProperties;
import reportManagement.ExtentManager;
import utils.CommonUtils;
import java.io.IOException;


public class SendMoneyFeatureBankMuscat {
    CustomerLoginBankMuscat customerLogin = new CustomerLoginBankMuscat();
    SendMoneyPageBankMuscat sendMoneyPageBankMuscat=new SendMoneyPageBankMuscat();
    LoginPageBankMuscat page = new LoginPageBankMuscat();
    ProfileDetailsFeature profileDetailsFeature=new ProfileDetailsFeature();

    public SendMoneyFeatureBankMuscat performSendMoneyToMobileNo(Transaction txn, String pin, String msisdn, String amt, String desp) throws IOException, InterruptedException {
        ExtentTest featureNode = ExtentManager.getTest();
        Config.setIsSendMoneySuccessTrue();
        try{
            if(Config.isFirstTimeLogin){
                customerLogin.doLogin("77123478","14709");
                if(MobileProperties.getProperty("language").equals("ENGLISH")) {
                  //  profileDetailsFeature.changeLanguageToEnglish();
                }
                else{
                  //  profileDetailsFeature.changeLanguageToArabic();
                }
                sendMoneyPageBankMuscat.
                        clickOnSendMoney();
                Config.setFirstTimeLoginFalse();
            }
            sendMoneyPageBankMuscat.
                    setBeneficiaryMobileNo(msisdn).
                    setAmount(amt).
                    setDescription(desp).
                    clickOnNext();
            if(sendMoneyPageBankMuscat.isErrorMessageDisplayed()){
                CommonUtils.captureScreenMobile(featureNode, "SEND MONEY ERROR MESSAGE");
                Config.setIsSendMoneySuccessFalse();
            }
            else {

                sendMoneyPageBankMuscat.
                        clickOnNext();
                page.
                        setPin1(pin.substring(0, 1)).
                        setPin2(pin.substring(1, 2)).
                        setPin3(pin.substring(2, 3)).
                        setPin4(pin.substring(3, 4)).
                        setPin5(pin.substring(4, 5));
                sendMoneyPageBankMuscat.clickOnNext();
                if(Config.isSendMoneySuccess) {
                    if (sendMoneyPageBankMuscat.isTitleDisplayed()) {
                        featureNode.pass("Successfully money sent");
                        CommonUtils.captureScreenMobile(featureNode, "SEND MONEY SUCCESS MESSAGE");
                    } else {
                        System.out.println("Send Money Failed");
                        featureNode.fail("Send Money Failed");
                        CommonUtils.captureScreenMobile(featureNode, "SEND MONEY FAILED MESSAGE");
                    }
                    sendMoneyPageBankMuscat.clickButtonOk();
                    sendMoneyPageBankMuscat.clickOnSendMoney();
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
            featureNode.fail("Test Case Failed");
            featureNode.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        return this;
    }

    public SendMoneyFeatureBankMuscat performSendMoneyToAlias(Transaction txn)  {
        try{
            sendMoneyPageBankMuscat.
                    clickOnAliasTab().
                    selectBankNameForAlias("Oman Arab Bank SAO");
        }
         catch(Exception e){
            ExtentTest featureNode = ExtentManager.getTest();
            e.printStackTrace();
            featureNode.fail("Test Case Failed");
            featureNode.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        return this;
    }
}

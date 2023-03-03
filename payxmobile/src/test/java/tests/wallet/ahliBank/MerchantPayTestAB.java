package tests.wallet.ahliBank;


import common.Assertion;
import framework.wallet.ahliBank.features.MerchantPayFeatureAB;
import framework.wallet.ahliBank.pageObjects.MerchantPaymentPageAhliBank;
import globalConstants.Config;
import globalConstants.Constants;
import initializers.TestInit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import propertyManagement.TestCases;
import reportManagement.ExtentManager;
import utils.MessageReader;
import static utils.GenerateRandomValue.*;


public class MerchantPayTestAB extends TestInit {
    
    MerchantPaymentPageAhliBank merchantPaymentPage = new MerchantPaymentPageAhliBank();
    MerchantPayFeatureAB merchantPayFeature = new MerchantPayFeatureAB();

    @AfterMethod(alwaysRun = true)
    public void acceptTheAlert()
    {
        merchantPayFeature.acceptAlert();
    }

    @Test
    public void TC_MP_AB_001(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MP_AB_001"));
        merchantPayFeature.PaytoMerchant("",
                getRandomAlphabeticValue(8),
                getRandomAlphabeticValue(5),
                getRandomIntValue(1) ,  "");
        Assertion.verifyEqual(merchantPaymentPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_MPay_001"));
    }

    @Test
    public void TC_MP_AB_002()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MP_AB_002"));
        merchantPayFeature.PaytoMerchant(getRandomIntValue(16),
                getRandomAlphabeticValue(8),
                getRandomAlphabeticValue(5),
                getRandomIntValue(1), "");
        Assertion.verifyEqual(merchantPaymentPage.getMessageFromAlertBox(),MessageReader.getMessage("Error_AH_MPay_001"));
    }

    @Test
    public void TC_MP_AB_003()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MP_AB_003"));
        merchantPayFeature.PaytoMerchant(getRandomIntValue(10),
                getRandomAlphabeticValue(8),
                getRandomAlphabeticValue(5),
                getRandomIntValue(1), "");
        Assertion.verifyEqual(merchantPaymentPage.getMessageFromAlertBox(),MessageReader.getMessage("Error_AH_MPay_001"));
    }

    @Test
    public void TC_MP_AB_004()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MP_AB_004"));
        merchantPayFeature.PaytoMerchant(getRandomIntValue(10),
                getRandomAlphabeticValue(8),
                getRandomAlphabeticValue(5),
                getRandomIntValue(1), "");
        Assertion.verifyEqual(merchantPaymentPage.getMessageFromAlertBox(),MessageReader.getMessage("Error_AH_MPay_001"));
    }

    @Test
    public void TC_MP_AB_005()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MP_AB_005"));
        merchantPayFeature.PaytoMerchant(getRandomIntValue(16),
                "", /* Description */getRandomAlphabeticValue(5),
                 getRandomIntValue(1), "");
        Assertion.verifyEqual(merchantPaymentPage.getMessageFromAlertBox(),MessageReader.getMessage("Error_AH_Mpay_005"));
    }


    @Test
    public void TC_MP_AB_006()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MP_AB_006"));
        merchantPayFeature.PaytoMerchant(getRandomIntValue(16),
                 getRandomAlphabeticValue(8),
                "", getRandomIntValue(1),  "");
        Assertion.verifyEqual(merchantPaymentPage.getMessageFromAlertBox(),MessageReader.getMessage("Error_AH_Mpay_006"));
    }

    @Test
    public void TC_MP_AB_007()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MP_AB_007"));
        merchantPayFeature.PaytoMerchant(getRandomIntValue(16),
                getRandomAlphabeticValue(8),
                getRandomAlphabeticValue(5),
                 "", "");
        Assertion.verifyEqual(merchantPaymentPage.getMessageFromAlertBox(),MessageReader.getMessage("Error_AH_MPay_003"));
    }

    @Test
    public void TC_MP_AB_008()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MP_AB_008"));
        merchantPayFeature.PaytoMerchant(getRandomIntValue(16),
                getRandomAlphabeticValue(8),
                getRandomAlphabeticValue(5),
                "0", "");
        Assertion.verifyEqual(merchantPaymentPage.getMessageFromAlertBox(),MessageReader.getMessage("Error_AH_MPay_003"));
    }

    @Test
    public void TC_MP_AB_009()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MP_AB_009"));
        merchantPayFeature.PaytoMerchant(getRandomIntValue(16),
                 getRandomAlphabeticValue(8),
                 getRandomAlphabeticValue(5),
                "9999999", "");
        Assertion.verifyEqual(merchantPaymentPage.getMessageFromAlertBox(),MessageReader.getMessage("Error_AH_SendMoney_005"));
    }

    @Test
    public void TC_MP_AB_010()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MP_AB_010"));
        merchantPayFeature.PaytoMerchant(getRandomIntValue(16),
                 getRandomAlphabeticValue(8),
                getRandomAlphabeticValue(5),
                "0.00", "");
        Assertion.verifyEqual(merchantPaymentPage.getMessageFromAlertBox(),MessageReader.getMessage("Error_AH_MPay_003"));
    }

    @Test
    public void TC_MP_AB_011()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MP_AB_011"));
        Config.setTermsAndCondNonClickable();
        merchantPayFeature.PaytoMerchant(getRandomIntValue(16),
                 getRandomAlphabeticValue(8),
                getRandomAlphabeticValue(5),
                "1","");
        Config.setTermsAndCondClickable();
        Assertion.verifyEqual(merchantPaymentPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_Mpay_007"));
    }

    @Test
    public void TC_MP_AB_012()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MP_AB_012"));
        merchantPayFeature.PaytoMerchant(Constants.MERCHANTCODE, getRandomAlphabeticValue(7),
                getRandomAlphabeticValue(5),
                getRandomIntValue(1), "");
        Assertion.verifyEqual(merchantPaymentPage.getMessageFromAlertBox(),MessageReader.getMessage("Error_AH_Mpay_004"));
    }

    @Test
    public void TC_MP_AB_013()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MP_AB_013"));
        merchantPayFeature.PaytoMerchant(Constants.MERCHANTCODE,
                getRandomAlphabeticValue(7),
                getRandomAlphabeticValue(5),
                getRandomIntValue(2),
                getRandomIntValue(7));
        Assertion.verifyEqual(merchantPaymentPage.getMessageFromAlertBox(),MessageReader.getMessage("Error_AH_MPay_002"));
    }

    @Test
    public void TC_MP_AB_014()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MP_AB_014"));
        merchantPayFeature.PaytoMerchant(Constants.MERCHANTCODE,
                getRandomAlphabeticValue(6),
                getRandomAlphabeticValue(5),
                getRandomIntValue(2),
                getRandomIntValue(4));
        Assertion.verifyEqual(merchantPaymentPage.getMessageFromAlertBox(),MessageReader.getMessage("Error_AH_Mpay_004"));
    }

    @Test
    public void TC_MP_AB_015()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MP_AB_015"));
        Config.setOTPcancel();
        merchantPayFeature.PaytoMerchant(Constants.MERCHANTCODE,
                getRandomAlphabeticValue(5),
                getRandomAlphabeticValue(5),
                getRandomIntValue(2),"");
        Assertion.verifyEqual(merchantPaymentPage.getOTPcancelFlowMsg(),MessageReader.getMessage("Error_AH_Mpay_008"));
        merchantPaymentPage.cancelOtpTxn();
    }

    @Test
    public void TC_MP_AB_016()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MP_AB_016"));
        merchantPayFeature.PaytoMerchant(Constants.MERCHANTCODE,
                getRandomAlphabeticValue(5),
                getRandomAlphabeticValue(5),
                getRandomIntValue(2),"");
        merchantPaymentPage.cancelOtpTxn();
        Assertion.verifyContains(merchantPaymentPage.getWelcomeMessage(),MessageReader.getMessage("Error_AH_Mpay_009"));
    }

    @Test
    public void TC_MP_AB_017()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MP_AB_017"));
        merchantPayFeature.PaytoMerchant(Constants.MERCHANTCODE,
                getRandomAlphabeticValue(5),
                getRandomAlphabeticValue(5),
                getRandomIntValue(2),"");
        merchantPaymentPage.retryOtpTxn();
        Assertion.verifyEqual(merchantPaymentPage.getMessageFromOTPtitle(),MessageReader.getMessage("Error_AH_Mpay_010"));
    }

    @Test
    public void TC_MP_AB_018()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MP_AB_018"));
        merchantPayFeature.PaytoMerchant(Constants.MERCHANTCODE,
                getRandomAlphabeticValue(5),
                getRandomAlphabeticValue(5),
                getRandomIntValue(2),"");
        merchantPaymentPage.retryOtpTxn().resendotp(); Config.setOTPnotcancel();
       // Assertion.verifyContains(page1.getToast(),MessageReader.getDynamicMessage("Msg_AH_Mpay_001"));
    }

    @Test
    public void TC_MP_AB_019()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MP_AB_019"));
        merchantPayFeature.PaytoMerchant(Constants.MERCHANTCODE,
                getRandomAlphabeticValue(5),
                getRandomAlphabeticValue(5),
                /*Amount*/  "1",Constants.AhlibankOTP );
    }

}

package tests.wallet.ahliBank;

import common.Assertion;
import framework.wallet.ahliBank.features.BillPayFeatureAhliBank;
import framework.wallet.ahliBank.features.NotificationFeatureAhliBank;
import framework.wallet.ahliBank.pageObjects.BillPayPageAhliBank;
import globalConstants.Config;
import initializers.TestInit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import propertyManagement.TestCases;
import reportManagement.ExtentManager;
import utils.MessageReader;
import static globalConstants.Constants.*;
import static utils.GenerateRandomValue.*;

/**
 * Created by ayush.singh on 23-09-2020.
 */
public class BillPayTestAhliBank extends TestInit {
    BillPayFeatureAhliBank billPayFeature=new BillPayFeatureAhliBank();
    BillPayPageAhliBank billPayPage=new BillPayPageAhliBank();
    NotificationFeatureAhliBank notificationFeature=new NotificationFeatureAhliBank();
    

    @AfterMethod(alwaysRun = true)
    public BillPayTestAhliBank acceptTheAlert(){
        try{
            billPayFeature.acceptAlert("BILLPAY");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    @Test(priority=51)
    public void TC0001(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_001"));
        billPayFeature.billPay("","1134232","","","","", KAHRAMAA , "BILLPAY");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_008"));
    }

    @Test(priority=52)
    public void TC0002(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_002"));
        billPayFeature.billPay("93361259865","","","","","", KAHRAMAA , "BILLPAY");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_009"));
    }

    @Test(priority=53)
    public void TC0003(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_003"));
        billPayFeature.billPay(getRandomIntValue(3),"1134232","","","","", KAHRAMAA , "BILLPAY");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_010"));
    }

    @Test(priority=54)
    public void TC0004(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_004"));
        billPayFeature.billPay("93361259865",getRandomIntValue(3),"","","","", KAHRAMAA , "BILLPAY");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_011"));
    }

    @Test(priority=55)
    public void TC0005(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_005"));
        billPayFeature.billPay(getRandomIntValue(11),"1134232","","","","", KAHRAMAA , "BILLPAY");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_012"));
    }

    @Test(priority=56)
    public void TC0006(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_006"));
        billPayFeature.billPay("93361259865",getRandomIntValue(7),"","","","", KAHRAMAA , "BILLPAY");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_012"));
    }

    @Test(priority=57)
    public void TC0007(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_007"));
        billPayFeature.billPay("93361259865","1134232","",DEFAULT_AMOUNT,DEFAULT_OTP,"", KAHRAMAA , "BILLPAY");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_013"));
    }

    @Test(priority=58)
    public void TC0008(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_008"));
        billPayFeature.billPay("93361259865","1134232",getRandomAlphabeticValue(5),"",DEFAULT_OTP,"", KAHRAMAA , "BILLPAY");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_014"));
    }

    @Test(priority=59)
    public void TC0009(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_009"));
        billPayFeature.billPay("93361259865","1134232",getRandomAlphabeticValue(5),"0",DEFAULT_OTP,"", KAHRAMAA , "BILLPAY");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_014"));
    }

    @Test(priority=60)
    public void TC0010(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_010"));
        billPayFeature.billPay("93361259865","1134232",getRandomAlphabeticValue(5),"5555",DEFAULT_OTP,"", KAHRAMAA , "BILLPAY");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_017"));
    }

    @Test(priority=61)
    public void TC0011(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_011"));
        Config.isTermsAndCondNonClickable=true;
        billPayFeature.billPay("93361259865","1134232",getRandomAlphabeticValue(5),DEFAULT_AMOUNT,DEFAULT_OTP,"", KAHRAMAA , "BILLPAY");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_021"));
    }

    @Test(priority=62)
    public void TC0012(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_012"));
        billPayFeature.billPay("93361259865","1134232",getRandomAlphabeticValue(5),DEFAULT_AMOUNT,"","", KAHRAMAA , "BILLPAY");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_015"));
    }

    @Test(priority=63)
    public void TC0013(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_013"));
        billPayFeature.billPay("93361259865","1134232",getRandomAlphabeticValue(5),DEFAULT_AMOUNT,getRandomIntValue(7),"", KAHRAMAA , "BILLPAY");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_016"));
    }

    @Test(priority=64)
    public void TC0014(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_014"));
        Config.isMultipleOtpValidationCheck=true;
        billPayFeature.billPay("93361259865","1134232",getRandomAlphabeticValue(5),DEFAULT_AMOUNT,getRandomIntValue(7),"", KAHRAMAA , "BILLPAY");
    }

    @Test(priority=65)
    public void TC0015(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_015"));
        billPayFeature.billPay("93361259865","1134232",getRandomAlphabeticValue(5),DEFAULT_AMOUNT,"1234","", KAHRAMAA , "BILLPAY");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_015"));
    }

    @Test(priority=65)
    public void TC0016(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_016"));
        Config.isOtpPositiveAction=false;
        billPayFeature.billPay("93361259865","1134232",getRandomAlphabeticValue(5),DEFAULT_AMOUNT,"","", KAHRAMAA , "BILLPAY");
    }

    @Test(priority=67)
    public void TC0017(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_017"));
        Config.isOtpPositiveAction=false;
        billPayFeature.billPay("93361259865","1134232",getRandomAlphabeticValue(5),DEFAULT_AMOUNT,"","", KAHRAMAA , "BILLPAY");
    }

    @Test(priority=68)
    public void TC0018(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_018"));
        Config.isOtpPositiveAction=false;
        Config.isOtpRetry=true;
        billPayFeature.billPay("93361259865","1134232",getRandomAlphabeticValue(5),DEFAULT_AMOUNT,"","", KAHRAMAA , "BILLPAY");
    }

    @Test(priority=69)
    public void TC0019(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_019"));
        Config.isOtpPositiveAction=false;
        Config.toastCheck=true;
        billPayFeature.billPay("93361259865","1134232",getRandomAlphabeticValue(5),DEFAULT_AMOUNT,DEFAULT_OTP,"", KAHRAMAA , "BILLPAY");
    }

    @Test(priority=70)
    public void TC0020(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_020"));
        billPayFeature.billPay("93361259865","1134232",getRandomAlphabeticValue(5),DEFAULT_AMOUNT,DEFAULT_OTP,"", KAHRAMAA , "BILLPAY");
    }

    //@Test(priority=71)
    public void TC0021(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_021"));
        billPayFeature.billPay("93361259865","1134232",getRandomAlphabeticValue(5),"",DEFAULT_OTP,"", KAHRAMAA , "BILLPAY");
    }

    @Test(priority=72)
    public void TC0022(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_022"));
        Config.isFavouriteTransactionCheck=true;
        billPayFeature.billPay("93361259865","1134232",getRandomAlphabeticValue(5),DEFAULT_AMOUNT,DEFAULT_OTP,"", KAHRAMAA , "BILLPAY");
    }

    @Test(priority=73)
    public void TC0023(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_023"));
        Config.isFavouriteTransactionCheck=true;
        billPayFeature.billPay("93361259865","1134232",getRandomAlphabeticValue(5),DEFAULT_AMOUNT,DEFAULT_OTP,getRandomAlphabeticValue(5), KAHRAMAA , "BILLPAY");
    }

    @Test(priority=74)
    public void TC0024() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_024"));
        billPayFeature.billPay("93361259865","1134232",getRandomAlphabeticValue(5),DEFAULT_AMOUNT,DEFAULT_OTP,"", KAHRAMAA , "BILLPAY");
        notificationFeature.validateNotification("Bill Pay");
    }

    @Test(priority=75)
    public void TC0025() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_025"));
        billPayFeature.billPay("93361259865","1134232",getRandomAlphabeticValue(5),DEFAULT_AMOUNT,DEFAULT_OTP,"", KAHRAMAA , "BILLPAY");
        notificationFeature.validateTransactionHistory("Bill Pay - KAHRAMAA");
    }

    @Test(priority=76)
    public void TC0026(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_026"));
        billPayFeature.billPay("","50994466","","","","", OOREDOO , "BILLPAY");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_008"));
    }

    @Test(priority=77)
    public void TC0027(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_027"));
        billPayFeature.billPay("27758603607","","","","","", OOREDOO , "BILLPAY");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_009"));
    }

    @Test(priority=78)
    public void TC0028(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_028"));
        billPayFeature.billPay(getRandomIntValue(3),"50994466","","","","", OOREDOO , "BILLPAY");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_010"));
    }

    @Test(priority=79)
    public void TC0029(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_029"));
        billPayFeature.billPay("27758603607",getRandomIntValue(3),"","","","", OOREDOO , "BILLPAY");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_011"));
    }

    @Test(priority=80)
    public void TC0030(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_030"));
        billPayFeature.billPay(getRandomIntValue(11),"50994466","","","","", OOREDOO , "BILLPAY");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_012"));
    }

    @Test(priority=81)
    public void TC0031(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_031"));
        billPayFeature.billPay("27758603607",getRandomIntValue(7),"","","","", OOREDOO , "BILLPAY");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_012"));
    }

    @Test(priority=82)
    public void TC0032(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_032"));
        billPayFeature.billPay("27758603607","50994466","",DEFAULT_AMOUNT,DEFAULT_OTP,"", OOREDOO , "BILLPAY");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_013"));
    }

    @Test(priority=83)
    public void TC0033(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_033"));
        billPayFeature.billPay("27758603607","50994466",getRandomAlphabeticValue(5),"",DEFAULT_OTP,"", OOREDOO , "BILLPAY");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_014"));
    }

    @Test(priority=84)
    public void TC0034(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_034"));
        billPayFeature.billPay("27758603607","50994466",getRandomAlphabeticValue(5),"0",DEFAULT_OTP,"", OOREDOO , "BILLPAY");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_014"));
    }

    @Test(priority=85)
    public void TC0035(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_035"));
        billPayFeature.billPay("27758603607","50994466",getRandomAlphabeticValue(5),"5555",DEFAULT_OTP,"", OOREDOO , "BILLPAY");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_017"));
    }

    @Test(priority=86)
    public void TC0036(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_036"));
        Config.isTermsAndCondNonClickable=true;
        billPayFeature.billPay("27758603607","50994466",getRandomAlphabeticValue(5),DEFAULT_AMOUNT,DEFAULT_OTP,"", OOREDOO , "BILLPAY");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_021"));
    }

    @Test(priority=87)
    public void TC0037(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_037"));
        billPayFeature.billPay("27758603607","50994466",getRandomAlphabeticValue(5),DEFAULT_AMOUNT,"","", OOREDOO , "BILLPAY");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_015"));
    }

    @Test(priority=88)
    public void TC0038(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_038"));
        billPayFeature.billPay("27758603607","50994466",getRandomAlphabeticValue(5),DEFAULT_AMOUNT,getRandomIntValue(7),"", OOREDOO , "BILLPAY");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_016"));
    }

    @Test(priority=89)
    public void TC0039(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_039"));
        Config.isMultipleOtpValidationCheck=true;
        billPayFeature.billPay("27758603607","50994466",getRandomAlphabeticValue(5),DEFAULT_AMOUNT,getRandomIntValue(7),"", OOREDOO , "BILLPAY");
    }

    @Test(priority=90)
    public void TC0040(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_040"));
        billPayFeature.billPay("27758603607","50994466",getRandomAlphabeticValue(5),DEFAULT_AMOUNT,"1234","", OOREDOO , "BILLPAY");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_015"));
    }

    @Test(priority=91)
    public void TC0041(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_041"));
        Config.isOtpPositiveAction=false;
        billPayFeature.billPay("27758603607","50994466",getRandomAlphabeticValue(5),DEFAULT_AMOUNT,"","", OOREDOO , "BILLPAY");
    }

    @Test(priority=92)
    public void TC0042(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_042"));
        Config.isOtpPositiveAction=false;
        billPayFeature.billPay("27758603607","50994466",getRandomAlphabeticValue(5),DEFAULT_AMOUNT,"","", OOREDOO , "BILLPAY");
    }

    @Test(priority=93)
    public void TC0043(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_043"));
        Config.isOtpPositiveAction=false;
        Config.isOtpRetry=true;
        billPayFeature.billPay("27758603607","50994466",getRandomAlphabeticValue(5),DEFAULT_AMOUNT,"","", OOREDOO , "BILLPAY");
    }

    @Test(priority=94)
    public void TC0044(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_044"));
        Config.isOtpPositiveAction=false;
        Config.toastCheck=true;
        billPayFeature.billPay("27758603607","50994466",getRandomAlphabeticValue(5),DEFAULT_AMOUNT,DEFAULT_OTP,"", OOREDOO , "BILLPAY");
    }

    @Test(priority=95)
    public void TC0045(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_045"));
        billPayFeature.billPay("27758603607","50994466",getRandomAlphabeticValue(5),DEFAULT_AMOUNT,DEFAULT_OTP,"", OOREDOO , "BILLPAY");
    }

    //@Test(priority=96)
    public void TC0046(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_046"));
        billPayFeature.billPay("27758603607","50994466",getRandomAlphabeticValue(5),"",DEFAULT_OTP,"", OOREDOO , "BILLPAY");
    }

    @Test(priority=97)
    public void TC0047(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_047"));
        Config.isFavouriteTransactionCheck=true;
        billPayFeature.billPay("27758603607","50994466",getRandomAlphabeticValue(5),DEFAULT_AMOUNT,DEFAULT_OTP,"", OOREDOO , "BILLPAY");
    }

    @Test(priority=98)
    public void TC0048(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_048"));
        Config.isFavouriteTransactionCheck=true;
        billPayFeature.billPay("27758603607","50994466",getRandomAlphabeticValue(5),DEFAULT_AMOUNT,DEFAULT_OTP,getRandomAlphabeticValue(5), OOREDOO , "BILLPAY");
    }

    @Test(priority=99)
    public void TC0049() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_049"));
        billPayFeature.billPay("27758603607","50994466",getRandomAlphabeticValue(5),DEFAULT_AMOUNT,DEFAULT_OTP,"", OOREDOO , "BILLPAY");
        notificationFeature.validateNotification("Bill Pay");
    }

    @Test(priority=100)
    public void TC0050() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_050"));
        billPayFeature.billPay("27758603607","50994466",getRandomAlphabeticValue(5),DEFAULT_AMOUNT,DEFAULT_OTP,"", OOREDOO , "BILLPAY");
        notificationFeature.validateTransactionHistory("Bill Pay - OOREDOO");
    }


    @Test(priority=101)
    public void TC0051(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_051"));
        billPayFeature.billPay("",VODAFONE_SERVICE_NUMBER,"","","","", VODAFONE , "BILLPAY");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_008"));
    }

    @Test(priority=102)
    public void TC0052(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_052"));
        billPayFeature.billPay(VODAFONE_QID,"","","","","", VODAFONE , "BILLPAY");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_009"));
    }

    @Test(priority=103)
    public void TC0053(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_053"));
        billPayFeature.billPay(getRandomIntValue(3),VODAFONE_SERVICE_NUMBER,"","","","", VODAFONE , "BILLPAY");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_010"));
    }

    @Test(priority=104)
    public void TC0054(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_054"));
        billPayFeature.billPay(VODAFONE_QID,getRandomIntValue(3),"","","","", VODAFONE , "BILLPAY");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_011"));
    }

    @Test(priority=105)
    public void TC0055(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_055"));
        billPayFeature.billPay(getRandomIntValue(11),VODAFONE_SERVICE_NUMBER,"","","","", VODAFONE , "BILLPAY");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_012"));
    }

    @Test(priority=106)
    public void TC0056(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_056"));
        billPayFeature.billPay(VODAFONE_QID,getRandomIntValue(7),"","","","", VODAFONE , "BILLPAY");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_012"));
    }

    @Test(priority=107)
    public void TC0057(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_057"));
        billPayFeature.billPay(VODAFONE_QID,VODAFONE_SERVICE_NUMBER,"",DEFAULT_AMOUNT,DEFAULT_OTP,"", VODAFONE , "BILLPAY");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_013"));
    }

    @Test(priority=108)
    public void TC0058(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_058"));
        billPayFeature.billPay(VODAFONE_QID,VODAFONE_SERVICE_NUMBER,getRandomAlphabeticValue(5),"",DEFAULT_OTP,"", VODAFONE , "BILLPAY");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_014"));
    }

    @Test(priority=109)
    public void TC0059(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_059"));
        billPayFeature.billPay(VODAFONE_QID,VODAFONE_SERVICE_NUMBER,getRandomAlphabeticValue(5),"0",DEFAULT_OTP,"", VODAFONE , "BILLPAY");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_014"));
    }

    @Test(priority=110)
    public void TC0060(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_060"));
        billPayFeature.billPay(VODAFONE_QID,VODAFONE_SERVICE_NUMBER,getRandomAlphabeticValue(5),"5555",DEFAULT_OTP,"", VODAFONE , "BILLPAY");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_017"));
    }

    @Test(priority=111)
    public void TC0061(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_061"));
        Config.isTermsAndCondNonClickable=true;
        billPayFeature.billPay(VODAFONE_QID,VODAFONE_SERVICE_NUMBER,getRandomAlphabeticValue(5),DEFAULT_AMOUNT,DEFAULT_OTP,"", VODAFONE , "BILLPAY");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_021"));
    }

    @Test(priority=112)
    public void TC0062(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_062"));
        billPayFeature.billPay(VODAFONE_QID,VODAFONE_SERVICE_NUMBER,getRandomAlphabeticValue(5),DEFAULT_AMOUNT,"","", VODAFONE , "BILLPAY");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_015"));
    }

    @Test(priority=113)
    public void TC0063(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_063"));
        billPayFeature.billPay(VODAFONE_QID,VODAFONE_SERVICE_NUMBER,getRandomAlphabeticValue(5),DEFAULT_AMOUNT, getRandomIntValue(7),"", VODAFONE , "BILLPAY");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_016"));
    }

    @Test(priority=114)
    public void TC0064(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_064"));
        Config.isMultipleOtpValidationCheck=true;
        Config.isAssertionRequiredCheck=true;
        billPayFeature.billPay(VODAFONE_QID,VODAFONE_SERVICE_NUMBER,getRandomAlphabeticValue(5),DEFAULT_AMOUNT,getRandomIntValue(7),"", VODAFONE , "BILLPAY");
    }

    @Test(priority=115)
    public void TC0065(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_065"));
        billPayFeature.billPay(VODAFONE_QID,VODAFONE_SERVICE_NUMBER,getRandomAlphabeticValue(5),DEFAULT_AMOUNT,"1234","", VODAFONE , "BILLPAY");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_015"));
    }

    @Test(priority=116)
    public void TC0066(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_066"));
        Config.isOtpPositiveAction=false;
        Config.isAssertionRequiredCheck=true;
        billPayFeature.billPay(VODAFONE_QID,VODAFONE_SERVICE_NUMBER,getRandomAlphabeticValue(5),DEFAULT_AMOUNT,"","", VODAFONE , "BILLPAY");
    }

    @Test(priority=117)
    public void TC0067(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_067"));
        Config.isOtpPositiveAction=false;
        Config.isAssertionRequiredCheck=true;
        billPayFeature.billPay(VODAFONE_QID,VODAFONE_SERVICE_NUMBER,getRandomAlphabeticValue(5),DEFAULT_AMOUNT,"","", VODAFONE , "BILLPAY");
    }

    @Test(priority=118)
    public void TC0068(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_068"));
        Config.isOtpPositiveAction=false;
        Config.isOtpRetry=true;
        Config.isAssertionRequiredCheck=true;
        billPayFeature.billPay(VODAFONE_QID,VODAFONE_SERVICE_NUMBER,getRandomAlphabeticValue(5),DEFAULT_AMOUNT,"","", VODAFONE , "BILLPAY");
    }

    @Test(priority=119)
    public void TC0069(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_069"));
        Config.isOtpPositiveAction=false;
        Config.toastCheck=true;
        Config.isAssertionRequiredCheck=true;
        billPayFeature.billPay(VODAFONE_QID,VODAFONE_SERVICE_NUMBER,getRandomAlphabeticValue(5),DEFAULT_AMOUNT,DEFAULT_OTP,"", VODAFONE , "BILLPAY");
    }

    @Test(priority=120)
    public void TC0070(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_070"));
        Config.isAssertionRequiredCheck=true;
        billPayFeature.billPay(VODAFONE_QID,VODAFONE_SERVICE_NUMBER,getRandomAlphabeticValue(5),DEFAULT_AMOUNT,DEFAULT_OTP,"", VODAFONE , "BILLPAY");
    }

    //@Test(priority=121)
    public void TC0071(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_071"));
        Config.isAssertionRequiredCheck=true;
        billPayFeature.billPay(VODAFONE_QID,VODAFONE_SERVICE_NUMBER,getRandomAlphabeticValue(5),"",DEFAULT_OTP,"", VODAFONE , "BILLPAY");
    }

    @Test(priority=122)
    public void TC0072(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_072"));
        Config.isFavouriteTransactionCheck=true;
        Config.isAssertionRequiredCheck=true;
        billPayFeature.billPay(VODAFONE_QID,VODAFONE_SERVICE_NUMBER,getRandomAlphabeticValue(5),DEFAULT_AMOUNT,DEFAULT_OTP,"", VODAFONE , "BILLPAY");
    }

    @Test(priority=123)
    public void TC0073(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_073"));
        Config.isFavouriteTransactionCheck=true;
        Config.isAssertionRequiredCheck=true;
        billPayFeature.billPay(VODAFONE_QID,VODAFONE_SERVICE_NUMBER,getRandomAlphabeticValue(5),DEFAULT_AMOUNT,DEFAULT_OTP,getRandomAlphabeticValue(5), VODAFONE , "BILLPAY");
    }

    @Test(priority=124)
    public void TC0074() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_074"));
        billPayFeature.billPay(VODAFONE_QID,VODAFONE_SERVICE_NUMBER,getRandomAlphabeticValue(5),DEFAULT_AMOUNT,DEFAULT_OTP,"", VODAFONE , "BILLPAY");
        notificationFeature.validateNotification("Bill Pay");
    }

    @Test(priority=125)
    public void TC0075() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_BillPay_075"));
        billPayFeature.billPay(VODAFONE_QID,VODAFONE_SERVICE_NUMBER,getRandomAlphabeticValue(5),DEFAULT_AMOUNT,DEFAULT_OTP,"", VODAFONE , "BILLPAY");
        notificationFeature.validateTransactionHistory("Bill Pay - VODAFONE");
    }

}

package tests.wallet.ahliBank;


import common.Assertion;
import framework.wallet.ahliBank.features.NotificationFeatureAhliBank;
import framework.wallet.ahliBank.features.TopUpAndDataFeatureAhliBank;
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

public class TopUpAndDataTestAhliBank extends TestInit {

    TopUpAndDataFeatureAhliBank topUpAndDataFeature = new TopUpAndDataFeatureAhliBank();
    BillPayPageAhliBank billPayPage=new BillPayPageAhliBank();
    NotificationFeatureAhliBank notificationFeature=new NotificationFeatureAhliBank();

    @AfterMethod(alwaysRun = true)
    public TopUpAndDataTestAhliBank acceptTheAlert(){
        try{
            topUpAndDataFeature.acceptAlert("DATAANDTOPUP");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    /*@Test(priority=76)
    public void TC0026(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_001"));
        topUpAndDataFeature.topUpAndData("",OOREDOO_SERVICE_NUMBER,"","","","", OOREDOO , "DATAANDTOPUP");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_008"));
    }

    @Test(priority=77)
    public void TC0027(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_002"));
        topUpAndDataFeature.topUpAndData(OOREDOO_QID,"","","","","", OOREDOO , "DATAANDTOPUP");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_009"));
    }

    @Test(priority=78)
    public void TC0028(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_003"));
        topUpAndDataFeature.topUpAndData(getRandomIntValue(3),OOREDOO_SERVICE_NUMBER,"","","","", OOREDOO , "DATAANDTOPUP");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_010"));
    }

    @Test(priority=79)
    public void TC0029(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_004"));
        topUpAndDataFeature.topUpAndData(OOREDOO_QID,getRandomIntValue(3),"","","","", OOREDOO , "DATAANDTOPUP");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_011"));
    }

    @Test(priority=80)
    public void TC0030(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_005"));
        topUpAndDataFeature.topUpAndData(getRandomIntValue(11),OOREDOO_SERVICE_NUMBER,"","","","", OOREDOO , "DATAANDTOPUP");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_012"));
    }

    @Test(priority=81)
    public void TC0031(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_006"));
        topUpAndDataFeature.topUpAndData(OOREDOO_QID,getRandomIntValue(7),"","","","", OOREDOO , "DATAANDTOPUP");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_012"));
    }

    @Test(priority=82)
    public void TC0032(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_007"));
        topUpAndDataFeature.topUpAndData(OOREDOO_QID,OOREDOO_SERVICE_NUMBER,"",DEFAULT_AMOUNT,DEFAULT_OTP,"", OOREDOO , "DATAANDTOPUP");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_013"));
    }

    @Test(priority=83)
    public void TC0033(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_008"));
        topUpAndDataFeature.topUpAndData(OOREDOO_QID,OOREDOO_SERVICE_NUMBER,getRandomAlphabeticValue(5),"",DEFAULT_OTP,"", OOREDOO , "DATAANDTOPUP");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_014"));
    }

    @Test(priority=84)
    public void TC0034(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_009"));
        topUpAndDataFeature.topUpAndData(OOREDOO_QID,OOREDOO_SERVICE_NUMBER,getRandomAlphabeticValue(5),"0",DEFAULT_OTP,"", OOREDOO , "DATAANDTOPUP");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_014"));
    }

    @Test(priority=85)
    public void TC0035(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_010"));
        topUpAndDataFeature.topUpAndData(OOREDOO_QID,OOREDOO_SERVICE_NUMBER,getRandomAlphabeticValue(5),"5555",DEFAULT_OTP,"", OOREDOO , "DATAANDTOPUP");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_017"));
    }

    @Test(priority=86)
    public void TC0036(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_011"));
        Config.isTermsAndCondNonClickable=true;
        topUpAndDataFeature.topUpAndData(OOREDOO_QID,OOREDOO_SERVICE_NUMBER,getRandomAlphabeticValue(5),DEFAULT_AMOUNT,DEFAULT_OTP,"", OOREDOO , "DATAANDTOPUP");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_021"));
    }

    @Test(priority=87)
    public void TC0037(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_012"));
        topUpAndDataFeature.topUpAndData(OOREDOO_QID,OOREDOO_SERVICE_NUMBER,getRandomAlphabeticValue(5),DEFAULT_AMOUNT,"","", OOREDOO , "DATAANDTOPUP");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_015"));
    }

    @Test(priority=88)
    public void TC0038(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_013"));
        topUpAndDataFeature.topUpAndData(OOREDOO_QID,OOREDOO_SERVICE_NUMBER,getRandomAlphabeticValue(5),DEFAULT_AMOUNT,getRandomIntValue(7),"", OOREDOO , "DATAANDTOPUP");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_016"));
    }

    @Test(priority=89)
    public void TC0039(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_014"));
        Config.isMultipleOtpValidationCheck=true;
        topUpAndDataFeature.topUpAndData(OOREDOO_QID,OOREDOO_SERVICE_NUMBER,getRandomAlphabeticValue(5),DEFAULT_AMOUNT,getRandomIntValue(7),"", OOREDOO , "DATAANDTOPUP");
    }

    @Test(priority=90)
    public void TC0040(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_015"));
        topUpAndDataFeature.topUpAndData(OOREDOO_QID,OOREDOO_SERVICE_NUMBER,getRandomAlphabeticValue(5),DEFAULT_AMOUNT,"1234","", OOREDOO , "DATAANDTOPUP");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_015"));
    }

    @Test(priority=91)
    public void TC0041(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_016"));
        Config.isOtpPositiveAction=false;
        topUpAndDataFeature.topUpAndData(OOREDOO_QID,OOREDOO_SERVICE_NUMBER,getRandomAlphabeticValue(5),DEFAULT_AMOUNT,"","", OOREDOO , "DATAANDTOPUP");
    }

    @Test(priority=92)
    public void TC0042(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_017"));
        Config.isOtpPositiveAction=false;
        topUpAndDataFeature.topUpAndData(OOREDOO_QID,OOREDOO_SERVICE_NUMBER,getRandomAlphabeticValue(5),DEFAULT_AMOUNT,"","", OOREDOO , "DATAANDTOPUP");
    }

    @Test(priority=93)
    public void TC0043(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_018"));
        Config.isOtpPositiveAction=false;
        Config.isOtpRetry=true;
        topUpAndDataFeature.topUpAndData(OOREDOO_QID,OOREDOO_SERVICE_NUMBER,getRandomAlphabeticValue(5),DEFAULT_AMOUNT,"","", OOREDOO , "DATAANDTOPUP");
    }

    @Test(priority=94)
    public void TC0044(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_019"));
        Config.isOtpPositiveAction=false;
        Config.toastCheck=true;
        topUpAndDataFeature.topUpAndData(OOREDOO_QID,OOREDOO_SERVICE_NUMBER,getRandomAlphabeticValue(5),DEFAULT_AMOUNT,DEFAULT_OTP,"", OOREDOO , "DATAANDTOPUP");
    }

    @Test(priority=95)
    public void TC0045(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_020"));
        topUpAndDataFeature.topUpAndData(OOREDOO_QID,OOREDOO_SERVICE_NUMBER,getRandomAlphabeticValue(5),DEFAULT_AMOUNT,DEFAULT_OTP,"", OOREDOO , "DATAANDTOPUP");
    }

    //@Test(priority=96)
    public void TC0046(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_021"));
        topUpAndDataFeature.topUpAndData(OOREDOO_QID,OOREDOO_SERVICE_NUMBER,getRandomAlphabeticValue(5),"",DEFAULT_OTP,"", OOREDOO , "DATAANDTOPUP");
    }

    @Test(priority=97)
    public void TC0047(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_022"));
        Config.isFavouriteTransactionCheck=true;
        topUpAndDataFeature.topUpAndData(OOREDOO_QID,OOREDOO_SERVICE_NUMBER,getRandomAlphabeticValue(5),DEFAULT_AMOUNT,DEFAULT_OTP,"", OOREDOO , "DATAANDTOPUP");
    }

    @Test(priority=98)
    public void TC0048(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_023"));
        Config.isFavouriteTransactionCheck=true;
        topUpAndDataFeature.topUpAndData(OOREDOO_QID,OOREDOO_SERVICE_NUMBER,getRandomAlphabeticValue(5),DEFAULT_AMOUNT,DEFAULT_OTP,getRandomAlphabeticValue(5), OOREDOO , "DATAANDTOPUP");
    }

    @Test(priority=99)
    public void TC0049() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_024"));
        topUpAndDataFeature.topUpAndData(OOREDOO_QID,OOREDOO_SERVICE_NUMBER,getRandomAlphabeticValue(5),DEFAULT_AMOUNT,DEFAULT_OTP,"", OOREDOO , "DATAANDTOPUP");
        notificationFeature.validateNotification("Bill Pay");
    }

    @Test(priority=100)
    public void TC0050() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_025"));
        topUpAndDataFeature.topUpAndData(OOREDOO_QID,OOREDOO_SERVICE_NUMBER,getRandomAlphabeticValue(5),DEFAULT_AMOUNT,DEFAULT_OTP,"", OOREDOO , "DATAANDTOPUP");
        notificationFeature.validateTransactionHistory("Bill Pay - OOREDOO");
    }


    @Test(priority=101)
    public void TC0051(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_026"));
        topUpAndDataFeature.topUpAndData("",VODAFONE_SERVICE_NUMBER,"","","","", VODAFONE , "DATAANDTOPUP");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_008"));
    }

    @Test(priority=102)
    public void TC0052(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_027"));
        topUpAndDataFeature.topUpAndData(VODAFONE_QID,"","","","","", VODAFONE , "DATAANDTOPUP");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_009"));
    }

    @Test(priority=103)
    public void TC0053(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_028"));
        topUpAndDataFeature.topUpAndData(getRandomIntValue(3),VODAFONE_SERVICE_NUMBER,"","","","", VODAFONE , "DATAANDTOPUP");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_010"));
    }

    @Test(priority=104)
    public void TC0054(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_029"));
        topUpAndDataFeature.topUpAndData(VODAFONE_QID,getRandomIntValue(3),"","","","", VODAFONE , "DATAANDTOPUP");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_011"));
    }

    @Test(priority=105)
    public void TC0055(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_030"));
        topUpAndDataFeature.topUpAndData(getRandomIntValue(11),VODAFONE_SERVICE_NUMBER,"","","","", VODAFONE , "DATAANDTOPUP");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_012"));
    }

    @Test(priority=106)
    public void TC0056(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_031"));
        topUpAndDataFeature.topUpAndData(VODAFONE_QID,getRandomIntValue(7),"","","","", VODAFONE , "DATAANDTOPUP");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_012"));
    }

    @Test(priority=107)
    public void TC0057(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_032"));
        topUpAndDataFeature.topUpAndData(VODAFONE_QID,VODAFONE_SERVICE_NUMBER,"",DEFAULT_AMOUNT,DEFAULT_OTP,"", VODAFONE , "DATAANDTOPUP");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_013"));
    }

    @Test(priority=108)
    public void TC0058(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_033"));
        topUpAndDataFeature.topUpAndData(VODAFONE_QID,VODAFONE_SERVICE_NUMBER,getRandomAlphabeticValue(5),"",DEFAULT_OTP,"", VODAFONE , "DATAANDTOPUP");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_014"));
    }

    @Test(priority=109)
    public void TC0059(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_034"));
        topUpAndDataFeature.topUpAndData(VODAFONE_QID,VODAFONE_SERVICE_NUMBER,getRandomAlphabeticValue(5),"0",DEFAULT_OTP,"", VODAFONE , "DATAANDTOPUP");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_014"));
    }

    @Test(priority=110)
    public void TC0060(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_035"));
        topUpAndDataFeature.topUpAndData(VODAFONE_QID,VODAFONE_SERVICE_NUMBER,getRandomAlphabeticValue(5),"5555",DEFAULT_OTP,"", VODAFONE , "DATAANDTOPUP");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_017"));
    }

    @Test(priority=111)
    public void TC0061(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_036"));
        Config.isTermsAndCondNonClickable=true;
        topUpAndDataFeature.topUpAndData(VODAFONE_QID,VODAFONE_SERVICE_NUMBER,getRandomAlphabeticValue(5),DEFAULT_AMOUNT,DEFAULT_OTP,"", VODAFONE , "DATAANDTOPUP");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_021"));
    }

    @Test(priority=112)
    public void TC0062(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_037"));
        topUpAndDataFeature.topUpAndData(VODAFONE_QID,VODAFONE_SERVICE_NUMBER,getRandomAlphabeticValue(5),DEFAULT_AMOUNT,"","", VODAFONE , "DATAANDTOPUP");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_015"));
    }

    @Test(priority=113)
    public void TC0063(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_038"));
        topUpAndDataFeature.topUpAndData(VODAFONE_QID,VODAFONE_SERVICE_NUMBER,getRandomAlphabeticValue(5),DEFAULT_AMOUNT, getRandomIntValue(7),"", VODAFONE , "DATAANDTOPUP");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_016"));
    }

    @Test(priority=114)
    public void TC0064(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_039"));
        Config.isMultipleOtpValidationCheck=true;
        Config.isAssertionRequiredCheck=true;
        topUpAndDataFeature.topUpAndData(VODAFONE_QID,VODAFONE_SERVICE_NUMBER,getRandomAlphabeticValue(5),DEFAULT_AMOUNT,getRandomIntValue(7),"", VODAFONE , "DATAANDTOPUP");
    }

    @Test(priority=115)
    public void TC0065(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_040"));
        topUpAndDataFeature.topUpAndData(VODAFONE_QID,VODAFONE_SERVICE_NUMBER,getRandomAlphabeticValue(5),DEFAULT_AMOUNT,"1234","", VODAFONE , "DATAANDTOPUP");
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_015"));
    }

    @Test(priority=116)
    public void TC0066(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_041"));
        Config.isOtpPositiveAction=false;
        Config.isAssertionRequiredCheck=true;
        topUpAndDataFeature.topUpAndData(VODAFONE_QID,VODAFONE_SERVICE_NUMBER,getRandomAlphabeticValue(5),DEFAULT_AMOUNT,"","", VODAFONE , "DATAANDTOPUP");
    }

    @Test(priority=117)
    public void TC0067(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_042"));
        Config.isOtpPositiveAction=false;
        Config.isAssertionRequiredCheck=true;
        topUpAndDataFeature.topUpAndData(VODAFONE_QID,VODAFONE_SERVICE_NUMBER,getRandomAlphabeticValue(5),DEFAULT_AMOUNT,"","", VODAFONE , "DATAANDTOPUP");
    }

    @Test(priority=118)
    public void TC0068(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_043"));
        Config.isOtpPositiveAction=false;
        Config.isOtpRetry=true;
        Config.isAssertionRequiredCheck=true;
        topUpAndDataFeature.topUpAndData(VODAFONE_QID,VODAFONE_SERVICE_NUMBER,getRandomAlphabeticValue(5),DEFAULT_AMOUNT,"","", VODAFONE , "DATAANDTOPUP");
    }

    @Test(priority=119)
    public void TC0069(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_044"));
        Config.isOtpPositiveAction=false;
        Config.toastCheck=true;
        Config.isAssertionRequiredCheck=true;
        topUpAndDataFeature.topUpAndData(VODAFONE_QID,VODAFONE_SERVICE_NUMBER,getRandomAlphabeticValue(5),DEFAULT_AMOUNT,DEFAULT_OTP,"", VODAFONE , "DATAANDTOPUP");
    }

    @Test(priority=120)
    public void TC0070(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_045"));
        Config.isAssertionRequiredCheck=true;
        topUpAndDataFeature.topUpAndData(VODAFONE_QID,VODAFONE_SERVICE_NUMBER,getRandomAlphabeticValue(5),DEFAULT_AMOUNT,DEFAULT_OTP,"", VODAFONE , "DATAANDTOPUP");
    }

    //@Test(priority=121)
    public void TC0071(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_046"));
        Config.isAssertionRequiredCheck=true;
        topUpAndDataFeature.topUpAndData(VODAFONE_QID,VODAFONE_SERVICE_NUMBER,getRandomAlphabeticValue(5),"",DEFAULT_OTP,"", VODAFONE , "DATAANDTOPUP");
    }

    @Test(priority=122)
    public void TC0072(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_047"));
        Config.isFavouriteTransactionCheck=true;
        Config.isAssertionRequiredCheck=true;
        topUpAndDataFeature.topUpAndData(VODAFONE_QID,VODAFONE_SERVICE_NUMBER,getRandomAlphabeticValue(5),DEFAULT_AMOUNT,DEFAULT_OTP,"", VODAFONE , "DATAANDTOPUP");
    }

    @Test(priority=123)
    public void TC0073(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_048"));
        Config.isFavouriteTransactionCheck=true;
        Config.isAssertionRequiredCheck=true;
        topUpAndDataFeature.topUpAndData(VODAFONE_QID,VODAFONE_SERVICE_NUMBER,getRandomAlphabeticValue(5),DEFAULT_AMOUNT,DEFAULT_OTP,getRandomAlphabeticValue(5), VODAFONE , "DATAANDTOPUP");
    }

    @Test(priority=124)
    public void TC0074() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_049"));
        topUpAndDataFeature.topUpAndData(VODAFONE_QID,VODAFONE_SERVICE_NUMBER,getRandomAlphabeticValue(5),DEFAULT_AMOUNT,DEFAULT_OTP,"", VODAFONE , "DATAANDTOPUP");
        notificationFeature.validateNotification("Bill Pay");
    }

    @Test(priority=125)
    public void TC0075() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_050"));
        topUpAndDataFeature.topUpAndData(VODAFONE_QID,VODAFONE_SERVICE_NUMBER,getRandomAlphabeticValue(5),DEFAULT_AMOUNT,DEFAULT_OTP,"", VODAFONE , "DATAANDTOPUP");
        notificationFeature.validateTransactionHistory("Bill Pay - VODAFONE");
    }*/

    @Test
    public void TC0076(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_001"));
        topUpAndDataFeature.topUpService("",
                0,
                "",
                OOREDOO
        );
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_008"));
    }

    @Test
    public void TC0077(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_001"));
        topUpAndDataFeature.topUpService("3399",
                0,
                "",
                OOREDOO
        );
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_008"));
    }

    @Test
    public void TC0078(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_001"));
        topUpAndDataFeature.topUpService("00000000",
                0,
                "",
                OOREDOO
        );
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_008"));
    }

    @Test
    public void TC0079(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_001"));
        topUpAndDataFeature.topUpService("33991891",
                0,
                "",
                OOREDOO
        );
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_008"));
    }

    @Test
    public void TC0080(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_001"));
        Config.isTermsAndCondNonClickable=true;
        topUpAndDataFeature.topUpService("33991891",
                0,
                "djhkhf",
                OOREDOO
        );
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_008"));
    }

    //@Test Insufficient balance
    public void TC0081(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_001"));
        Config.isTermsAndCondNonClickable=true;
        topUpAndDataFeature.topUpService("33991891",
                7,
                "djhkhf",
                OOREDOO
        );
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_008"));
    }




    @Test
    public void TC0100(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_001"));
        topUpAndDataFeature.topUpService("",
                0,
                "",
                VODAFONE
        );
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_008"));
    }

    @Test
    public void TC0101(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_001"));
        topUpAndDataFeature.topUpService("3399",
                0,
                "",
                VODAFONE
        );
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_008"));
    }

    @Test
    public void TC0102(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_001"));
        topUpAndDataFeature.topUpService("00000000",
                0,
                "",
                VODAFONE
        );
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_008"));
    }

    @Test
    public void TC0103(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_001"));
        topUpAndDataFeature.topUpService("33991891",
                0,
                "",
                VODAFONE
        );
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_008"));
    }

    @Test
    public void TC0104(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_001"));
        Config.isTermsAndCondNonClickable=true;
        topUpAndDataFeature.topUpService("33991891",
                0,
                "djhkhf",
                VODAFONE
        );
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_008"));
    }

    //@Test Insufficient balance
    public void TC0105(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_001"));
        Config.isTermsAndCondNonClickable=true;
        topUpAndDataFeature.topUpService("33991891",
                7,
                "djhkhf",
                VODAFONE
        );
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_008"));
    }


    /// DATA RECHARGE



    @Test
    public void TC0121(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_001"));
        topUpAndDataFeature.dataRechargeService("",
                0,
                "",
                OOREDOO
        );
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_008"));
    }

    @Test
    public void TC0122(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_001"));
        topUpAndDataFeature.dataRechargeService("3399",
                0,
                "",
                OOREDOO
        );
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_008"));
    }

    @Test
    public void TC0123(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_001"));
        topUpAndDataFeature.dataRechargeService("00000000",
                0,
                "",
                OOREDOO
        );
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_008"));
    }

    @Test
    public void TC0124(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_001"));
        topUpAndDataFeature.dataRechargeService("33991891",
                0,
                "",
                OOREDOO
        );
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_008"));
    }

    @Test
    public void TC0125(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_001"));
        Config.isTermsAndCondNonClickable=true;
        topUpAndDataFeature.dataRechargeService("33991891",
                0,
                "djhkhf",
                OOREDOO
        );
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_008"));
    }

    //@Test Insufficient balance
    public void TC0126(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_001"));
        Config.isTermsAndCondNonClickable=true;
        topUpAndDataFeature.dataRechargeService("33991891",
                7,
                "djhkhf",
                OOREDOO
        );
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_008"));
    }




    @Test
    public void TC0151(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_001"));
        topUpAndDataFeature.dataRechargeService("",
                0,
                "",
                VODAFONE
        );
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_008"));
    }

    @Test
    public void TC0152(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_001"));
        topUpAndDataFeature.dataRechargeService("3399",
                0,
                "",
                VODAFONE
        );
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_008"));
    }

    @Test
    public void TC0153(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_001"));
        topUpAndDataFeature.dataRechargeService("00000000",
                0,
                "",
                VODAFONE
        );
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_008"));
    }

    @Test
    public void TC0154(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_001"));
        topUpAndDataFeature.dataRechargeService("33991891",
                0,
                "",
                VODAFONE
        );
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_008"));
    }

    @Test
    public void TC0155(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_001"));
        Config.isTermsAndCondNonClickable=true;
        topUpAndDataFeature.dataRechargeService("33991891",
                0,
                "djhkhf",
                VODAFONE
        );
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_008"));
    }

    //@Test Insufficient balance
    public void TC0156(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_TopUpAndData_001"));
        Config.isTermsAndCondNonClickable=true;
        topUpAndDataFeature.dataRechargeService("33991891",
                7,
                "djhkhf",
                VODAFONE
        );
        Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_008"));
    }


}

package tests.wallet.palestineArabBank;

import common.Assertion;
import framework.wallet.palestineArabBank.features.AtmCashoutFeaturePalestine;
import framework.wallet.palestineArabBank.pageObjects.AtmCashoutPagePalestine;
import initializers.TestInit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import propertyManagement.TestCases;
import reportManagement.ExtentManager;
import utils.MessageReader;
import static utils.GenerateRandomValue.*;

public class AtmCashoutTestPalestine extends TestInit {

    @AfterMethod
    public void accpetAlert() {
        feature.acceptAlert();
    }

    AtmCashoutFeaturePalestine feature = new AtmCashoutFeaturePalestine();
    AtmCashoutPagePalestine atmCashoutPagePalestine = new AtmCashoutPagePalestine();
   

    @Test
    public void TC_ATM_001()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ATM_001"));
        feature.atmCashOutMoney("");
        Assertion.verifyEqual(atmCashoutPagePalestine.getErrMsg(), MessageReader.getMessage("ERRMSG_0069"));
    }

    @Test
    public void TC_ATM_002()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ATM_002"));
        feature.atmCashOutMoney("0");
        Assertion.verifyEqual(atmCashoutPagePalestine.getErrMsg(), MessageReader.getMessage("ERRMSG_0070"));
    }

    @Test
    public void TC_ATM_003()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ATM_003"));
        feature.atmCashOutMoney(getRandomIntValue(1));
        Assertion.verifyEqual(atmCashoutPagePalestine.getErrMsg(), MessageReader.getMessage("ERRMSG_0077"));
    }

    @Test
    public void TC_ATM_004()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ATM_004"));
        feature.atmCashOutMoney(getRandomIntValue(3));
        Assertion.verifyEqual(atmCashoutPagePalestine.getErrMsg(), MessageReader.getMessage("ERRMSG_0073"));
    }

    @Test
    public void TC_ATM_005()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ATM_005"));
        feature.atmCashOutMoney("1000");
        Assertion.verifyEqual(atmCashoutPagePalestine.getErrMsg(), MessageReader.getMessage("ERRMSG_0051"));
    }

    @Test
    public void TC_ATM_006()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ATM_006"));
        feature.atmCashOutMoney("1620");
        Assertion.verifyEqual(atmCashoutPagePalestine.getErrMsg(), MessageReader.getMessage("ERRMSG_0074"));
    }

    @Test
    public void TC_ATM_007()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ATM_007"));
        feature.atmCashOutMoney("20.00");
        atmCashoutPagePalestine.clickOnHomeButton();
    }

//   // @Test
//    public void TC_ATM_008()  {
//        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ATM_008"));
//       feature.atmCashOutMoney("20.00");
//    }

    @Test
    public void TC_ATM_009()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ATM_009"));
        feature.atmCashOutMoney("20.00");
        Assertion.verifyEqual(atmCashoutPagePalestine.getTxnStatus(), MessageReader.getMessage("ERRMSG_0075"));
        atmCashoutPagePalestine.clickOnHomeButton();
    }

    @Test
    public void TC_ATM_010()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ATM_010"));
        feature.atmCashOutMoney("20.00");
        Assertion.verifyEqual(atmCashoutPagePalestine.getOtpStatus(), MessageReader.getMessage("ERRMSG_0076"));
        atmCashoutPagePalestine.clickOnHomeButton();
    }

    @Test
    public void TC_ATM_011()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ATM_011"));
        feature.atmCashOutMoney("100ILS");
        Assertion.verifyEqual(atmCashoutPagePalestine.getTxnStatus2(), "100.00");
        atmCashoutPagePalestine.clickOnHomeButton();
    }
//
//
//    @Test
//    public void TC_ATM_012()  {
//        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ATM_012"));
//        feature.atmCashOutMoney("200ILS");
//        Assertion.verifyEqual(atmCashoutPagePalestine.getTxnStatus2(), "200.00");
//        atmCashoutPagePalestine.clickOnHomeButton();
//    }
//
//    @Test
//    public void TC_ATM_013()  {
//        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ATM_013"));
//        feature.atmCashOutMoney("400ILS");
//        Assertion.verifyEqual(atmCashoutPagePalestine.getTxnStatus2(), "400.00");
//        atmCashoutPagePalestine.clickOnHomeButton();
//    }
//
//    @Test
//    public void TC_ATM_014()  {
//        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ATM_014"));
//        feature.atmCashOutMoney("600ILS");
//        Assertion.verifyEqual(atmCashoutPagePalestine.getTxnStatus2(), "600.00");
//        atmCashoutPagePalestine.clickOnHomeButton();
//    }
}

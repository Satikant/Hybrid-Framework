package tests.wallet.bharain;

import common.Assertion;

import framework.wallet.bharain.features.InternationalTopUpFeature;
import framework.wallet.bharain.features.ProfileDetailsFeature;
import framework.wallet.bharain.pageObjects.InternationalTopUpPage;
import framework.wallet.bharain.pageObjects.LoginPageBharain;
import globalConstants.Config;
import initializers.TestInit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import propertyManagement.TestCases;
import reportManagement.ExtentManager;
import utils.GenerateRandomValue;
import utils.MessageReader;


import java.io.IOException;

public class InternationalTopUpTest extends TestInit {
    InternationalTopUpFeature internationalTopUpFeature = new InternationalTopUpFeature();
    LoginPageBharain loginPage = new LoginPageBharain();
    InternationalTopUpPage internationalTopUpPage = new InternationalTopUpPage();


    @AfterMethod(alwaysRun = true)
    public void acceptTheAlert()  {
        internationalTopUpFeature.acceptAlert();
    }

    @AfterClass(alwaysRun = true)
    /*public void logOut(){
        ProfileDetailsFeature.logOut();
    }*/



    @Test(priority=261)
    public void TC_ITP_001()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ITP_001"));
            internationalTopUpFeature.InternationalTopup("", GenerateRandomValue.getRandomIntValue(8));
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0076"));
    }

    @Test(priority=262)
    public void TC_ITP_002()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ITP_002"));
        internationalTopUpFeature.InternationalTopup(GenerateRandomValue.getRandomAlphabeticValue(5),GenerateRandomValue.getRandomIntValue(8));
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0075"));
    }

      @Test(priority=263)
    public void TC_ITP_003()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ITP_003"));
            Config.toastCheck=true;                                                                                    // for toast messsage
            internationalTopUpFeature.InternationalTopup("India","");
//          Assertion.verifyContains(Utils.getToastMessage(), MessageReader.getDynamicMessage("ERRMSG_0077"));
//            Assertion.verifyEqual(internationalTopUpPage.getToast(), MessageReader.getMessage("ERRMSG_0077"));
    }

    @Test(priority=264)
    public void TC_ITP_004()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ITP_004"));
            internationalTopUpFeature.InternationalTopup("India",GenerateRandomValue.getRandomIntValue(6));
//            Assertion.verifyContains(Utils.getToastMessage(), MessageReader.getDynamicMessage
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0075"));
    }

    @Test(priority=265)
    public void TC_ITP_005()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ITP_005"));
            internationalTopUpFeature.InternationalTopup("India",GenerateRandomValue.getRandomIntValueWithPrefix(4,"00000"));
            Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0075"));
    }

    @Test(priority=266)
    public void TC_ITP_006()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ITP_006"));
            internationalTopUpFeature.InternationalTopup("India",GenerateRandomValue.getRandomIntValueWithPrefix(10,"91"));
            Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0075"));
    }

    @Test(priority=267)
    public void TC_ITP_007()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ITP_007"));
            internationalTopUpFeature.InternationalTopup("India",GenerateRandomValue.getRandomIntValueWithPrefix(10,"91"));
            Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0075"));
    }

    @Test(priority=268)
    public void TC_ITP_008()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ITP_008"));
            internationalTopUpFeature.InternationalTopup("India",GenerateRandomValue.getRandomIntValueWithPrefix(10,"91"));
            Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0075"));
    }
}

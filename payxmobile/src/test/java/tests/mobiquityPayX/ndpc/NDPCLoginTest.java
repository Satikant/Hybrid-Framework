package tests.mobiquityPayX.ndpc;

import common.Assertion;
import framework.mobiquityPayX.commonApplicationModule.features.LoginFeature;
import framework.mobiquityPayX.commonApplicationModule.pageObjects.LoginPageObject;
import initializers.TestInit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import propertyManagement.TestCases;
import reportManagement.ExtentManager;
import utils.DataDriven;
import utils.GenerateRandomValue;
import utils.MessageReader;

public class NDPCLoginTest extends TestInit {

    LoginPageObject loginPage = new LoginPageObject();
    LoginFeature loginFeature = new LoginFeature();

    @AfterMethod
    public void AcceptDialogBox(){
        loginFeature.AcceptDialogBox();
    }

    @Test(priority = 1)
    public void Login001(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("LOGIN01"));
        loginFeature.login(GenerateRandomValue.getRandomIntValueWithPrefix(8,"00"),
                GenerateRandomValue.getRandomIntValue(4),
                "");
        Assertion.verifyEqual(loginPage.getValidationMessageFromDialog(), MessageReader.getMessage("ERROR_LOGIN_002"));

    }

    @Test(priority = 2)
    public void Login002(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("LOGIN02"));
        loginFeature.login(GenerateRandomValue.getRandomIntValueWithPrefix(8,"77"),
                GenerateRandomValue.getRandomIntValue(4),
                "");
        Assertion.verifyEqual(loginPage.getValidationMessageFromDialog(),MessageReader.getMessage("ERROR_LOGIN_002"));
    }

    @Test(priority = 3)
    public void Login003(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("LOGIN03"));
        loginFeature.login(GenerateRandomValue.getRandomIntValue(4),GenerateRandomValue.getRandomIntValue(4),
                "");
        Assertion.verifyEqual(loginPage.getValidationMessageFromDialog(),MessageReader.getMessage("ERROR_LOGIN_001"));
    }

    @Test(priority = 4)
    public void Login004(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("LOGIN04"));
        loginFeature.login(DataDriven.getUserByStatus("Y"),GenerateRandomValue.getRandomIntValue(2),
                "");
        Assertion.verifyEqual(loginPage.getValidationMessageFromLabel(),MessageReader.getMessage("ERROR_LOGIN_003"));
    }

    @Test(priority =5)
    public void Login005(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("LOGIN05"));
        loginFeature.login(DataDriven.getUserByStatus("Y"),GenerateRandomValue.getRandomIntValue(4),
                "");
        Assertion.verifyEqual(loginPage.getValidationMessageFromDialog(),MessageReader.getMessage("ERROR_LOGIN_004"));
    }

     @Test(priority = 6 )
    public void Login006(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("LOGIN06"));
        loginFeature.login(DataDriven.getUserByStatus("Y"),GenerateRandomValue.getRandomIntValue(4),
                "");
        Assertion.verifyEqual(loginPage.getValidationMessageFromDialog(),MessageReader.getMessage("ERROR_LOGIN_005"));
    }

 /*   @Test(priority =7)
    public void Login007(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("LOGIN07"));
        loginFeature.login(DataDriven.getUserByStatus("Y"),GenerateRandomValue.getRandomIntValue(4),
                "");
        Assertion.verifyEqual(loginPage.getValidationMessageFromDialog(),MessageReader.getMessage("ERROR_LOGIN_006"));
    }

   //  @Test(priority = 8)
    public void Login008(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("LOGIN08"));
        loginFeature.login(DataDriven.getUserByStatus("Y"),GenerateRandomValue.getRandomIntValue(4),
                "");
        Assertion.verifyEqual(loginPage.getValidationMessageFromDialog(),MessageReader.getMessage("ERROR_LOGIN_007"));
    }

    //@Test(priority = 9)
    public void Login009(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("LOGIN09"));
        loginFeature.login(DataDriven.getUserByStatus("BL"),DataDriven.getUserPinByStatus("BL"),
                "");
        Assertion.verifyEqual(loginPage.getValidationMessageFromDialog(),MessageReader.getMessage(""));
    }

  */


     @Test(priority = 10 )
    public void Login010(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("LOGIN10"));
        loginFeature.login(DataDriven.getUserByStatus("S"),DataDriven.getUserPinByStatus("S"),
                "");
        Assertion.verifyEqual(loginPage.getValidationMessageFromDialog(),MessageReader.getMessage("ERROR_LOGIN_008"));
    }

    //@Test(priority = 11)
    public void Login0011(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("LOGIN11"));
        loginFeature.login(DataDriven.getUserByStatus("BD"),DataDriven.getUserPinByStatus("BD"),
                "");
        Assertion.verifyEqual(loginPage.getValidationMessageFromDialog(),MessageReader.getMessage(""));
    }
    @Test(priority = 12 )
    public void Login0012(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("LOGIN16"));
        startPositveTest();
        loginFeature.login(DataDriven.getUserByStatus("Y"),DataDriven.getUserPinByStatus("Y"), "");
    }
}

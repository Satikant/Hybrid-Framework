package tests.mobiquityPayX.asiaHawala;

import common.Assertion;
import framework.mobiquityPayX.asiaHawala.features.AHLoginFeature;
import framework.mobiquityPayX.asiaHawala.pageObjects.AHLoginPageObject;
import initializers.TestInit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import propertyManagement.TestCases;
import reportManagement.ExtentManager;
import utils.DataDriven;
import utils.GenerateRandomValue;


public class AHLoginTest extends TestInit {
    AHLoginFeature loginFeature = new AHLoginFeature();
    AHLoginPageObject loginPage = new AHLoginPageObject();

    @AfterMethod
    public void AcceptDialogBox(){
        loginFeature.AcceptDialogBox();
    }

    @Test(priority = 1)
    public void Login001(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("AH0001"));
        loginFeature.login(GenerateRandomValue.getRandomIntValue(10),"1357");
        Assertion.verifyEqual(loginPage.getValidationMessageFromLabel(),"Please enter a valid mobile number");
    }

    @Test(priority = 2)
    public void Login002(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("AH0002"));
        loginFeature.login(GenerateRandomValue.getRandomIntValueWithPrefix(8,"77"),"13557");
        Assertion.verifyEqual(loginPage.getValidationMessageFromDialog(),"user not found or not active in the system");
    }

    @Test(priority = 3)
    public void Login003(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("AH0003"));
        loginFeature.login(GenerateRandomValue.getRandomIntValue(4),"1357");
        Assertion.verifyEqual(loginPage.getValidationMessageFromLabel(),"Please enter a valid mobile number");
    }

    @Test(priority = 4)
    public void Login004(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("AH0004"));
        loginFeature.login("7712345678",GenerateRandomValue.getRandomIntValue(2));
        Assertion.verifyEqual(loginPage.getValidationMessageFromLabel(),"Please enter a valid PIN");
    }

    @Test(priority =5)
    public void Login005(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("AH0005"));
        loginFeature.login("7713587339",GenerateRandomValue.getRandomIntValue(4));
        Assertion.verifyEqual(loginPage.getValidationMessageFromDialog(),"Provided Password Authentication is invalid. Remaining attempts: 3");
    }

   // @Test(priority = 6 )
    public void Login006(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0001"));
        loginFeature.login("7713587339",GenerateRandomValue.getRandomIntValue(4));
        Assertion.verifyEqual(loginPage.getValidationMessageFromDialog(),"");
    }

    //@Test(priority =7)
    public void Login007(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0001"));
        loginFeature.login("7713587339",GenerateRandomValue.getRandomIntValue(4));
        Assertion.verifyEqual(loginPage.getValidationMessageFromDialog(),"");
    }

   // @Test(priority = 8)
    public void Login008(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0001"));
        loginFeature.login("7713587339",GenerateRandomValue.getRandomIntValue(4));
        Assertion.verifyEqual(loginPage.getValidationMessageFromDialog(),"");
    }

   //@Test(priority = 9)
    public void Login009(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0001"));
        loginFeature.login("Blacklisted","2468");
        Assertion.verifyEqual(loginPage.getValidationMessageFromDialog(),"");
    }

   // @Test(priority = 10 )
    public void Login010(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0001"));
        loginFeature.login("Suspended","1357");
        Assertion.verifyEqual(loginPage.getValidationMessageFromDialog(),"");
    }

    //@Test(priority = 11)
    public void Login0011(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0001"));
        loginFeature.login("Blacklisted Device","2468");
        Assertion.verifyEqual(loginPage.getValidationMessageFromDialog(),"");
    }

    @Test(priority = 12 )
    public void Login0012(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("AH0016"));
        startPositveTest();
        loginFeature.login(DataDriven.getUserByStatus("RETAILER"), DataDriven.getUserPinByStatus("Y"));
    }

    @Test(priority = 13 )
    public void Login0013(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("AH0016"));
        startPositveTest();
        loginFeature.login(DataDriven.getUserByStatus("CONSUMER"),DataDriven.getUserPinByStatus("Y"));
    }

    @Test(priority = 14 )
    public void Login0014(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("AH0016"));
        startPositveTest();
        loginFeature.login(DataDriven.getUserByStatus("MERCHANT"),DataDriven.getUserPinByStatus("Y"));
    }
}

package tests.mobiquityPayX.ndpc;

import common.Assertion;
import framework.mobiquityPayX.commonApplicationModule.features.FinancialTransactionFlowFeature;
import framework.mobiquityPayX.commonApplicationModule.pageObjects.FinancialTransactionFlowPageObject;
import framework.mobiquityPayX.ndpc.features.NDPCSendMoneyFeature;
import globalConstants.Config;
import initializers.TestInit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import propertyManagement.TestCases;
import reportManagement.ExtentManager;
import utils.DataDriven;

public class NDPCSendMoneyTest extends TestInit {

   NDPCSendMoneyFeature sendMoneyFeature = new NDPCSendMoneyFeature();
    FinancialTransactionFlowFeature financialTransactionFlow = new FinancialTransactionFlowFeature();
    FinancialTransactionFlowPageObject financialTransactionPage = new FinancialTransactionFlowPageObject();


    @AfterMethod(alwaysRun = true)
    public void afterMethod(){
        financialTransactionFlow.afterTestHandler();
    }

    @Test(priority = 51)
    public void SM001(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("SM001"));
        sendMoneyFeature.sendMoney("dd","2","1357","SM");
        Assertion.verifyEqual(financialTransactionPage.getValidationMessageFromLabel(),"Please enter a valid mobile number / other payment id");
    }

    @Test(priority = 52)
    public void SM002(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("SM002"));
        sendMoneyFeature.sendMoney(" ","2","1357","SM");
        Assertion.verifyEqual(financialTransactionPage.getValidationMessageFromLabel(),"Please enter a valid mobile number / other payment id");
    }

    @Test (priority = 53)
    public void SM003(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("SM003"));
        sendMoneyFeature.sendMoney("986","2","1357","SM");
        Assertion.verifyEqual(financialTransactionPage.getValidationMessageFromLabel(),"Please enter a valid mobile number / other payment id");
    }

    @Test (priority = 54)
    public void SM004(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("SM004"));
        sendMoneyFeature.sendMoney("0009864400","2","1357","SM");
        Assertion.verifyEqual(financialTransactionPage.getValidationMessageFromDialog(),"The amount will be credited only once the user is registered");
    }

    @Test (priority = 55)
    public void SM005(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("SM005"));
        sendMoneyFeature.sendMoney("9863366999","0","1357","SM");
        Assertion.verifyEqual(financialTransactionPage.getValidationMessageFromDialog(),"There seems to be some problem with the charge configuration, as the specified transaction amount does not match against any of the slab ranges");
    }

    @Test (priority = 56)
    public void SM006(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("SM006"));
        sendMoneyFeature.sendMoney("9863366999","","1357","SM");
        Assertion.verifyEqual(financialTransactionPage.getValidationMessageFromLabel(),"Please enter amount");
    }

    @Test (priority = 57)
    public void SM007(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("SM007"));
        Config.isValidationRequired = true;
        sendMoneyFeature.sendMoney("9863366999","0.1","1357","SM");
        Assertion.verifyEqual(financialTransactionPage.getTransactionFailureText(),"Transfer amount less than minimum allowed transfer amount.");
    }

    @Test (priority = 58)
    public void SM008(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("SM008"));
        sendMoneyFeature.sendMoney("9863366999","999999","1357","SM");
        Assertion.verifyEqual(financialTransactionPage.getValidationMessageFromDialog(),"Please add money into your wallet to make a transaction");
    }

    @Test (priority = 59)
    public void SM009(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("SM009"));
        sendMoneyFeature.sendMoney("9863366999","100","","SM");
        Assertion.verifyEqual(financialTransactionPage.getValidationMessageFromLabel(),"Please enter PIN");
    }
    @Test (priority = 60)
    public void SM010(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("SM010"));
        sendMoneyFeature.sendMoney("9863366999","100","1","SM");
        Assertion.verifyEqual(financialTransactionPage.getValidationMessageFromLabel(),"Please enter a valid PIN");
    }


    @Test (priority = 61)
    public void SM011(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("SM011"));
        Config.isValidationRequired = true;
        sendMoneyFeature.sendMoney("9863366999","100","1117","SM");
        Assertion.verifyEqual(financialTransactionPage.getTransactionFailureText(),"Provided Pin Authentication is missing or invalid.Remainig attempt:3");
    }

    @Test (priority = 62)
    public void SM012(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("SM012"));
        Config.isValidationRequired = true;
        sendMoneyFeature.sendMoney("9863366999","100","1117","SM");
        Assertion.verifyEqual(financialTransactionPage.getTransactionFailureText(),"Provided Pin Authentication is missing or invalid.Remainig attempt:2");
    }

    @Test (priority = 63)
    public void SM013(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("SM013"));
        Config.isValidationRequired = true;
        sendMoneyFeature.sendMoney("9863366999","100","1117","SM");
        Assertion.verifyEqual(financialTransactionPage.getTransactionFailureText(),"Provided Pin Authentication is missing or invalid.Remainig attempt:1");
    }

    //@Test (priority = 64)
    public void SM014(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("SM014"));
        Config.isValidationRequired = true;
        sendMoneyFeature.sendMoney("9863366999","100","1117","SM");
        Assertion.verifyEqual(financialTransactionPage.getTransactionFailureText(),"User has blocked due to invalid pin");
    }

    //@Test (priority = 65)
    public void SM0015(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("SM015"));
        Config.isValidationRequired = true;
        sendMoneyFeature.sendMoney("9863366999","2","1357","SM");
        Assertion.verifyEqual(financialTransactionPage.getTransactionFailureText(),"User has blocked due to invalid pin");
    }

    @Test (priority = 66)
    public void SM0016(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("SM016"));
        sendMoneyFeature.sendMoney("9751111654","2","1357","SM");
        Assertion.verifyEqual(financialTransactionPage.getValidationMessageFromDialog(),"Payee Barred as Receiver");
    }

    @Test (priority = 67)
    public void SM0017(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("SM017"));
        Config.isLoginWithDifferentMsisdnRequired = true;
        Config.userStatus = "BRS";
        sendMoneyFeature.sendMoney("9863366999","2","1357","SM");
        Assertion.verifyEqual(financialTransactionPage.getValidationMessageFromDialog(),"Initiator has been barred as sender");
    }

    @Test (priority = 68)
    public void SM0018(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("SM018"));
        Config.isLoginWithDifferentMsisdnRequired = true;
        Config.userStatus = "BRSB";
        sendMoneyFeature.sendMoney("9863366999","2","1357","SM");
        Assertion.verifyEqual(financialTransactionPage.getValidationMessageFromDialog(),"Initiator has been barred as both");
    }

    @Test (priority = 69)
    public void SM0019(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("SM019"));
        Config.isLoginWithDifferentMsisdnRequired = true;
        Config.userStatus = "Y";
        sendMoneyFeature.sendMoney("9753333123","2","1357","SM");
        Assertion.verifyEqual(financialTransactionPage.getValidationMessageFromDialog(),"Receiver Barred as both");
    }

    @Test (priority = 70)
    public void SM0020(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("SM020"));
        sendMoneyFeature.sendMoney(DataDriven.getUserByStatus("Y"),"2","1357","SM");
        Assertion.verifyEqual(financialTransactionPage.getValidationMessageFromDialog(),"You can not send money to your own account");
    }

    @Test (priority = 71)
    public void SM0021(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("SM021"));
        Config.isValidationRequired = true;
        Config.isRetryOptionRequired = true;
        sendMoneyFeature.sendMoney("9863366999","2","0000","SM");
    }

    @Test (priority = 72)
    public void SM0022(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("SM022"));
        sendMoneyFeature.sendMoney("9863366999","2","1357","SM");
    }

    @Test (priority = 73)
    public void SM0023(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("SM023"));
        sendMoneyFeature.sendMoney("9863366999","2","1357","SM");
    }

   // @Test (priority = 67)
    public void SM0027(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("SM017"));
        sendMoneyFeature.sendMoney("9863366999","2","1357","SM");
    }

}

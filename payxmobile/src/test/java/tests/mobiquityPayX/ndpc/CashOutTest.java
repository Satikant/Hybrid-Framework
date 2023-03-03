package tests.mobiquityPayX.ndpc;

import common.Assertion;
import framework.mobiquityPayX.commonApplicationModule.features.FinancialTransactionFlowFeature;
import framework.mobiquityPayX.commonApplicationModule.pageObjects.FinancialTransactionFlowPageObject;
import framework.mobiquityPayX.ndpc.features.NDPCCashOutFeatureFlow;
import globalConstants.Config;
import initializers.TestInit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import propertyManagement.TestCases;
import reportManagement.ExtentManager;

public class CashOutTest extends TestInit {

    NDPCCashOutFeatureFlow cashOutFlow = new NDPCCashOutFeatureFlow();
    FinancialTransactionFlowFeature financialTransactionFlow = new FinancialTransactionFlowFeature();
    FinancialTransactionFlowPageObject financialTransactionPage = new FinancialTransactionFlowPageObject();

    @AfterMethod(alwaysRun = true)
    public void afterMethod(){
        financialTransactionFlow.afterTestHandler();
    }


    @Test(priority = 31)
    public void CASHOUT001(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("CASHOUT001"));
        cashOutFlow.cashOut("dd","2","1357","CASHOUT");
        Assertion.verifyEqual(financialTransactionPage.getValidationMessageFromLabel(),"Please enter a valid mobile number / agent code");
        // cashOutFlow.cashOut("9862233669","2","1357","CASHOUT");
    }

    @Test(priority = 32)
    public void CASHOUT002(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("CASHOUT002"));
        cashOutFlow.cashOut(" ","2","1357","CASHOUT");
        Assertion.verifyEqual(financialTransactionPage.getValidationMessageFromLabel(),"Please enter a valid mobile number / agent code");
        // cashOutFlow.cashOut("9862233669","2","1357","CASHOUT");
    }

    @Test (priority = 33)
    public void CASHOUT003(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("CASHOUT003"));
        cashOutFlow.cashOut("986","2","1357","CASHOUT");
        Assertion.verifyEqual(financialTransactionPage.getValidationMessageFromLabel(),"Please enter a valid mobile number / agent code");
        // cashOutFlow.cashOut("9862233669","2","1357","CASHOUT");
    }

    @Test (priority = 34)
    public void CASHOUT004(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("CASHOUT004"));
        cashOutFlow.cashOut("0009864400","2","1357","CASHOUT");
        Assertion.verifyEqual(financialTransactionPage.getValidationMessageFromDialog(),"No Data Found");
        // cashOutFlow.cashOut("9862233669","2","1357","CASHOUT");
    }

    @Test (priority = 35)
    public void CASHOUT005(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("CASHOUT005"));
        cashOutFlow.cashOut("9864400440","0","1357","CASHOUT");
        Assertion.verifyEqual(financialTransactionPage.getValidationMessageFromDialog(),"There seems to be some problem with the charge configuration, as the specified transaction amount does not match against any of the slab ranges");
    }

    @Test (priority = 36)
    public void CASHOUT006(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("CASHOUT006"));
        cashOutFlow.cashOut("9864400440","","1357","CASHOUT");
        Assertion.verifyEqual(financialTransactionPage.getValidationMessageFromLabel(),"Please enter amount");
    }

    @Test (priority = 37)
    public void CASHOUT007(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("CASHOUT007"));
        Config.isValidationRequired = true;
        cashOutFlow.cashOut("9864400440","1","1357","CASHOUT");
        Assertion.verifyEqual(financialTransactionPage.getValidationMessageFromDialog(),"");
    }

    @Test (priority = 38)
    public void CASHOUT008(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("CASHOUT008"));
        cashOutFlow.cashOut("9864400440","999999","1357","CASHOUT");
        Assertion.verifyEqual(financialTransactionPage.getValidationMessageFromDialog(),"Please add money into your wallet to make a transaction");
    }

    @Test (priority = 39)
    public void CASHOUT009(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("CASHOUT009"));
        cashOutFlow.cashOut("9864400440","100","","CASHOUT");
        Assertion.verifyEqual(financialTransactionPage.getValidationMessageFromLabel(),"Please enter PIN");
    }
    @Test (priority = 40)
    public void CASHOUT010(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("CASHOUT010"));
        cashOutFlow.cashOut("9864400440","100","1","CASHOUT");
        Assertion.verifyEqual(financialTransactionPage.getValidationMessageFromLabel(),"Please enter a valid PIN");
    }


    @Test (priority = 41)
    public void CASHOUT011(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("CASHOUT011"));
        Config.isValidationRequired = true;
        cashOutFlow.cashOut("9864400440","100","1117","CASHOUT");
        Assertion.verifyEqual(financialTransactionPage.getTransactionFailureText(),"Provided Pin Authentication is missing or invalid.Remainig attempt:3");
    }

    @Test (priority = 42)
    public void CASHOUT012(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("CASHOUT012"));
        Config.isValidationRequired = true;
        cashOutFlow.cashOut("9864400440","100","1117","CASHOUT");
        Assertion.verifyEqual(financialTransactionPage.getTransactionFailureText(),"Provided Pin Authentication is missing or invalid.Remainig attempt:2");
    }

    @Test (priority = 43)
    public void CASHOUT013(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("CASHOUT013"));
        Config.isValidationRequired = true;
        cashOutFlow.cashOut("9864400440","100","1117","CASHOUT");
        Assertion.verifyEqual(financialTransactionPage.getTransactionFailureText(),"Provided Pin Authentication is missing or invalid.Remainig attempt:1");
    }

   // @Test (priority = 44)
    public void CASHOUT014(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("CASHOUT014"));
        Config.isValidationRequired = true;
        cashOutFlow.cashOut("9864400440","100","1117","CASHOUT");
        Assertion.verifyEqual(financialTransactionPage.getTransactionFailureText(),"User has blocked due to invalid pin");
    }

   // @Test (priority = 45)
    public void CASHOUT015(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("CASHOUT015"));
        Config.isValidationRequired = true;
        cashOutFlow.cashOut("9864400440","2","1357","CASHOUT");
        Assertion.verifyEqual(financialTransactionPage.getTransactionFailureText(),"User has blocked due to invalid pin");
    }

     @Test (priority = 46)
    public void CASHOUT016(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("CASHOUT016"));
        Config.isValidationRequired = true;
        cashOutFlow.cashOut("9864400440","2","1357","CASHOUT");
    }

    @Test (priority = 47)
    public void CASHOUT017(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("CASHOUT017"));
        cashOutFlow.cashOut("9864400440","2","1357","CASHOUT");
    }


}

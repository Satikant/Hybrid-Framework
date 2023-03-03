package tests.mobiquityPayX.qnb;

import framework.mobiquityPayX.commonApplicationModule.features.FinancialTransactionFlowFeature;
import framework.mobiquityPayX.commonApplicationModule.pageObjects.FinancialTransactionFlowPageObject;
import framework.mobiquityPayX.qnb.features.QNBSendMoneyFeature;
import initializers.TestInit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import propertyManagement.TestCases;
import reportManagement.ExtentManager;

public class QNBSendMoneyTest extends TestInit {

    QNBSendMoneyFeature sendMoneyFeature = new QNBSendMoneyFeature();
    FinancialTransactionFlowFeature financialTransactionFlow = new FinancialTransactionFlowFeature();
    FinancialTransactionFlowPageObject financialTransactionPage = new FinancialTransactionFlowPageObject();

    @AfterMethod(alwaysRun = true)
    public void afterMethod(){
        financialTransactionFlow.afterTestHandler();
    }
    
    @Test
    public void SM001(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("SM0001"));
        sendMoneyFeature.SendMoney("RECENT","2.00","","SEND_MONEY");
    }

    @Test
    public void SM002(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("SM0002"));
        sendMoneyFeature.SendMoney("FAVOURITE","2.00","","SEND_MONEY");
    }

    @Test
    public void SM003(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("SM0003"));
        sendMoneyFeature.SendMoney("77779919","2.00","","SEND_MONEY");
    }
}

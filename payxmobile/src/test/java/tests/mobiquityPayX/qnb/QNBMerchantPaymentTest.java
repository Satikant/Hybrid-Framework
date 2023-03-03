package tests.mobiquityPayX.qnb;

import framework.mobiquityPayX.qnb.features.QNBSendMoneyFeature;
import initializers.TestInit;
import org.testng.annotations.Test;
import propertyManagement.TestCases;
import reportManagement.ExtentManager;

public class QNBMerchantPaymentTest extends TestInit {
    QNBSendMoneyFeature sendMoneyFeature = new QNBSendMoneyFeature();

    @Test
    public void MP001(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("MP0001"));
        sendMoneyFeature.mPay("RECENT","1.00","","MERCHANT_PAYMENT");
    }

    @Test
    public void MP002(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("MP0002"));
        sendMoneyFeature.mPay("FAVOURITE","2.00","","MERCHANT_PAYMENT");
    }

    @Test
    public void MP003(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("MP0003"));
        sendMoneyFeature.mPay("56565656","3.00","","MERCHANT_PAYMENT");
    }
}

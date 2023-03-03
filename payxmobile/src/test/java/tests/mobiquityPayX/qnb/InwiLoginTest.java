package tests.mobiquityPayX.qnb;

import initializers.TestInit;
import org.testng.annotations.Test;
import propertyManagement.TestCases;
import reportManagement.ExtentManager;


public class InwiLoginTest extends TestInit {

   // InwiLoginPageObjects inwi = new InwiLoginPageObjects();

    @Test(priority = 12 )
    public void Login0012(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("LOGIN16"));
        // startPositveTest();
        // loginFeature.login(DataDriven.getUserByStatus("Y"),DataDriven.getUserPinByStatus("Y"), "");
    }
    }

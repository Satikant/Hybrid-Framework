package framework.mobiquityPayX.payX.feature;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import common.Assertion;
import framework.mobiquityPayX.payX.PageObjects.*;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTRotY;
import reportManagement.ExtentManager;

public class pinChangedSuccessFeature extends pinChangeSuccessPageObj {

    dashboardPageObj dpo = new dashboardPageObj();
    humbergerPageObj hpo = new humbergerPageObj();
    settingsPageObj spo = new settingsPageObj();
    securityPageObj spo2 = new securityPageObj();
   changePinPageObj cppo = new changePinPageObj();
   pinChangeSuccessPageObj pcspo = new pinChangeSuccessPageObj();


   public void doPinChange (String pin , String newpin, String confirmpin){
       ExtentTest node = ExtentManager.getTest();

       try {
           toPinChange();
           cppo.setCurrentPin(pin).setNewPin(newpin).setConfirmPin(confirmpin).clickChangePIN();


           if(pcspo.isPinChangeSuccess()){
               Assertion.verifyContains(pcspo.getPinChangeSuccessful(),"PIN changed successfully");
                pcspo.clickOnLogin();
//                    node.pass("Test case PASS");
           }


       }
       catch (Exception e){
           e.printStackTrace();
           pageInfo.fail("Test Case Failed");
           pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
       }
   }

       public void toPinChange(){
       dpo.clickOnHumberger();
       hpo.clickOnSettings();
       spo.clickOnSecurity();
       spo2.clickOnChangePIN();

       }


    public void PinChange (String pin , String newpin, String confirmpin){
        ExtentTest node = ExtentManager.getTest();

        try {
            toPinChange();
            cppo.setCurrentPin(pin).setNewPin(newpin).setConfirmPin(confirmpin).clickChangePIN();


        }
        catch (Exception e){
            e.printStackTrace();
            pageInfo.fail("Test Case Failed");
            pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
    }



}



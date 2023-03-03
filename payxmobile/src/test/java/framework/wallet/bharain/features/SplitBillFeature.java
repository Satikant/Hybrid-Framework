package framework.wallet.bharain.features;

import com.aventstack.extentreports.ExtentTest;
import common.Assertion;
import framework.wallet.bharain.pageObjects.DonationPage;
import framework.wallet.bharain.pageObjects.LoginPageBharain;
import framework.wallet.bharain.pageObjects.SplitBillPage;
import globalConstants.Config;
import globalConstants.Constants;
import initializers.TestInit;
import reportManagement.ExtentManager;
import utils.CommonUtils;
import utils.DataDriven;
import utils.MessageReader;

import java.io.IOException;
import java.util.ArrayList;


public class SplitBillFeature {
    SplitBillPage spltBillPg = new SplitBillPage();
    CustomerLoginBharain customerLogin = new CustomerLoginBharain();
    LoginPageBharain page = new LoginPageBharain();
    ExtentTest testCase = ExtentManager.getTest();
    DonationPage donationPage = new DonationPage();

    public SplitBillFeature splitBillFeature(String GrpName, ArrayList<String> msisdn, ArrayList<String> names, int total_people_Group_number, String AddOrEditOrDelete) throws IOException, InterruptedException {
        TestInit.startPositveTest();
        if(Config.isFirstTimeLogin){
            customerLogin.Login(DataDriven.getUserByStatus("Y"), DataDriven.getUserPinByStatus("Y"));
            Config.setFirstTimeLoginFalse();
        }
        if(spltBillPg.isShowBalanceDisplayed()) {
            spltBillPg.clickOnSplitBillMenu();
        }
            //Add Group
            switch (AddOrEditOrDelete) {
                case "Add": spltBillPg.clickonAddGroup().enterGroupName(GrpName);
            addMember(total_people_Group_number,msisdn,names,AddOrEditOrDelete);
            if(Config.toastCheck==true)
            { Config.toastCheck=false;
            }else{
                spltBillPg.clickOnCreate();
            }
            break;
                case "Modify":   //Modify
                    if(spltBillPg.isGroupPresent()==true){
            spltBillPg.selectGroup();
//            spltBillPg.selectGroup(2);
            spltBillPg.clickOnEdit();}
            if(Config.isDeleteMember==true){
                spltBillPg.clickOnDeleteContact();
            }else {
                addMember(total_people_Group_number, msisdn, names, AddOrEditOrDelete);
            }
            spltBillPg.clickOnSave();
            break;

            case "Delete"://Delete
                spltBillPg.selectGroup().clickOnEdit().clickOnDelete();
                break;
            }
        return this;
    }

    public SplitBillFeature initiateSplitBill(String amount, String AcceptReject) throws InterruptedException, IOException {
        TestInit.startPositveTest();
        if(Config.isFirstTimeLogin){
            customerLogin.Login(DataDriven.getUserByStatus("Y"), DataDriven.getUserPinByStatus("Y"));
            Config.setFirstTimeLoginFalse();
        }
        if(spltBillPg.isShowBalanceDisplayed()) {
            spltBillPg.clickOnSplitBillMenu();
        }
        CommonUtils.pauseExecution(2);
        spltBillPg.selectGroup();
      //  CommonUtils.pauseExecution(2);
        spltBillPg.clickOnCreate();
        spltBillPg.enterAmt(amount);
        double amt[] = spltBillPg.checkAmtIsEqual();
        if (amt[0] != Double.parseDouble(amount))
            testCase.info("Amount not distributed equally");
        spltBillPg.clickOnRequestMoney();
        if (Config.checkNotification == true) {
            spltBillPg.clickOnDone_Retry();
          //  profileDetailsFeature.logOut();
            CheckAndAcceptPendingReq(AcceptReject);
        }
        return this;
    }

    public void CheckAndAcceptPendingReq(String AcceptReject) throws IOException, InterruptedException {

        customerLogin.Login(DataDriven.getUserByStatus("Y"), DataDriven.getUserPinByStatus("Y"));
        Double previousBalnace = spltBillPg.checkBalance();
        spltBillPg.clickOnPendingRequest();

        CommonUtils.pauseExecution(5);
        String amnt = spltBillPg.clickOnRequest();

        if (AcceptReject == Constants.ACCEPT) {
            spltBillPg.clickOnApprove();
            if (page.isSnackbarDisplayed()){
                acceptAlert();
                spltBillPg.clickBack();
            }else
                Assertion.verifyEqual(spltBillPg.fetchTxnStatus(), MessageReader.getMessage("ERRMSG_0060"));

        } else if(AcceptReject==Constants.REJECT){
            spltBillPg.clickOnReject();
            Assertion.verifyEqual(spltBillPg.fetchTxnStatus(), MessageReader.getMessage("ERRMSG_0064"));
        }

        if(donationPage.isHomeBtnDisplayed()) {
            donationPage.clickOnHome();
            Double currentBalance = spltBillPg.checkBalance();
            if (previousBalnace == currentBalance) {
                testCase.info("Balance not deducted");
            }
            //   profileDetailsPage.clickOnMenuButton();
            spltBillPg.clickOnSplitBillMenu().fetchNotification(amnt, AcceptReject);//Notification
        }else if(!spltBillPg.isMenuButtonPresent())
            spltBillPg.clickBack();
    }


    public void acceptAlert() throws InterruptedException {
        if (spltBillPg.isClickOnOkisDisplayed()) {
            System.out.print(" method accept alert else condition");
            spltBillPg.clickOK();
        } else if (page.isSnackbarDisplayed()) {
            page.clickOnsnackbarButton();
        }
        Thread.sleep(1000);
        if (spltBillPg.isCreateButtonPresent()) {
            spltBillPg.clickBack();
        }
    }

    public void addMember(int total_people_Group_number, ArrayList<String> msisdn, ArrayList<String> names, String AddOrEditOrDelete) throws IOException, InterruptedException {
        int i = 0;
          while (i < total_people_Group_number) {
                spltBillPg.enterMsisdn(msisdn.get(i)).enterName(names.get(i)).clickAddMember();
                if(Config.toastCheck==true)
                {
                    spltBillPg.getToast();
                }
                i++;
            }
            ;
           // Config.setToastCheckFalse();
        }

}



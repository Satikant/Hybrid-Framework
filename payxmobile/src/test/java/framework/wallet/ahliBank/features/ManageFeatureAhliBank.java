package framework.wallet.ahliBank.features;

import framework.wallet.ahliBank.pageObjects.LoginPageAhliBank;
import framework.wallet.ahliBank.pageObjects.ManagePageAhliBank;
import globalConstants.Config;
import utils.CommonUtils;
import utils.DataDriven;
import utils.Utils;
import utils.W3CActions;

import java.io.IOException;

import static initializers.TestInit.startPositveTest;

public class ManageFeatureAhliBank {

    ManagePageAhliBank managePage = new ManagePageAhliBank();
    CustomerLoginAhliBank custLogin = new CustomerLoginAhliBank();

    public ManageFeatureAhliBank() throws InterruptedException {
    }

    public ManageFeatureAhliBank viewManageBeneficiary() throws InterruptedException, IOException {
        startPositveTest();
        if(Config.isFirstTimeLogin) {
            custLogin.login(DataDriven.getUserByStatus("Y"), DataDriven.getUserPinByStatus("Y"));
            Config.setFirstTimeLoginFalse();
            Utils.rightLeftSwipe(2000);
        }

        String name1="", transferOption1="";

        if (managePage.isManageBenIconAvailable()) {
            managePage.clickOnManageBenIcon();
            CommonUtils.pauseExecution(5);
        }
        if (managePage.isBeneficiaryPresent()) {
            managePage.clickOnBeneficiary();
            CommonUtils.pauseExecution(1);
    }

        managePage.clickOnView();
        CommonUtils.pauseExecution(3);
        W3CActions w3CActions = new W3CActions();
        w3CActions.scrollDown();
        managePage.clickOnCancel();

        return this;
    }

    public ManageFeatureAhliBank deleteManageBeneficiary() {

        if (managePage.isManageBenIconAvailable()) {
            managePage.clickOnManageBenIcon();
            CommonUtils.pauseExecution(2);
        }

        if (managePage.isBeneficiaryPresent()) {
            managePage.clickOnBeneficiary();
            CommonUtils.pauseExecution(2);
        }

        if (managePage.isDeleteButtonPresent()) {
            managePage.clickOnDelete();
            CommonUtils.pauseExecution(2);
            managePage.getDeleteMessage();
        }
        managePage.chickOnNoDelete();
        return this;
    }

    public ManageFeatureAhliBank delete1ManageBeneficiary() {

        if (managePage.isManageBenIconAvailable()) {
            managePage.clickOnManageBenIcon();
            CommonUtils.pauseExecution(1);
        }

        if (managePage.isBeneficiaryPresent()) {
            managePage.clickOnBeneficiary();
            CommonUtils.pauseExecution(1);
        }

        managePage.clickOnView();

        if (managePage.isDelete1ButtonPresent()) {
            managePage.clickOnDelete1();
            CommonUtils.pauseExecution(1);
        }
        managePage.chickOnNoDelete();
        managePage.clickOnBack();
        return this;
    }

    public ManageFeatureAhliBank delete2ManageBeneficiary() throws InterruptedException {

        if (managePage.isManageBenIconAvailable()) {
            managePage.clickOnManageBenIcon();
            CommonUtils.pauseExecution(1);
        }

        if (managePage.isBeneficiaryPresent()) {
            managePage.clickOnBeneficiary();
            CommonUtils.pauseExecution(1);
        }

        managePage.clickOnView();
        W3CActions w3CActions = new W3CActions();
        w3CActions.scrollDown();

        if (managePage.isDelete2ButtonPresent()) {
            managePage.clickOnDelete2();
            CommonUtils.pauseExecution(1);
        }
        managePage.chickOnNoDelete();
        managePage.clickOnCancel();
        return this;
    }

//    String beneficiaryDetails [] = managePage.getBeneficiaryDetails();


}

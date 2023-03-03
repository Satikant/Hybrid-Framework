package framework.walletAdmin.features;

import com.aventstack.extentreports.ExtentTest;
import com.jcraft.jsch.JSchException;
import common.AssertionWeb;
import framework.walletAdmin.pageObjects.WalletAdminHomePage;
import propertyManagement.MobileProperties;
import propertyManagement.ProjectProperties;
import utils.DataDriven;
import utils.ExcelUtil;

import javax.xml.crypto.Data;
import java.io.IOException;


/**
 * Created by ayush.singh on 22-01-2020.
 */
public class BlacklistManagement {
    /*
    ExtentTest node;
    String value = null;
    WalletAdminHomePage walletAdminHomePage = new WalletAdminHomePage();
    WalletAdminLogin walletAdminLogin = new WalletAdminLogin();

    public BlacklistManagement AddToBlacklist() throws JSchException, InterruptedException, IOException {
        value = DataDriven.getUserByStatus("YL");
        walletAdminHomePage.clickOnFraudManagement().
                clickOnBlacklistManagement().
                ClickOnAddBlacklist().
                clickOnMobilePhone().
                setValue(value).
                setRemark(value).
                ClickOnContinue().
                ClickOnConfirm();
        AssertionWeb.verifyEqual(walletAdminHomePage.getConfirmMsg(), "Blacklist added successfully");
        DataDriven.setCellValueByStatus("YL", "BL");
        return this;
    }
    */
}


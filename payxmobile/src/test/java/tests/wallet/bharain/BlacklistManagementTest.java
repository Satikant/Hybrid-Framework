package tests.wallet.bharain;

import com.jcraft.jsch.JSchException;
import common.Assertion;
import common.AssertionWeb;
import framework.walletAdmin.features.BlacklistManagement;
import framework.walletAdmin.features.WalletAdminLogin;
import framework.walletAdmin.pageObjects.WalletAdminHomePage;
import initializers.TestInit;
import org.testng.annotations.Test;
import propertyManagement.TestCases;
import reportManagement.ExtentManager;

import java.io.IOException;

/**
 * Created by ayush.singh on 22-01-2020.
 */
public class BlacklistManagementTest extends TestInit {
    /*
    WalletAdminLogin walletAdminLogin=new WalletAdminLogin();
    BlacklistManagement blacklistManagement=new BlacklistManagement();
    WalletAdminHomePage walletAdminHomePage=new WalletAdminHomePage();

    @Test
    public void blacklist_001() throws JSchException, InterruptedException, IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0001"));
        walletAdminLogin.adminLogin("superadmin","Com@2468");
        blacklistManagement.AddToBlacklist();
    }
    */
}

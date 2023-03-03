package framework.walletAdmin.pageObjects;

import com.jcraft.jsch.JSchException;
import framework.walletAdmin.features.WalletAdminLogin;
import initializers.PageInit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by ayush.singh on 22-01-2020.
 */
public class WalletAdminHomePage extends PageInit {
/*
    public  WalletAdminHomePage(){
        super();
    }

    @FindBy(xpath = "//*[@id=\"FRAUDMGMT\"]/div")
    private WebElement FRAUDMGMT;

    @FindBy(xpath = "//*[@id=\"BLACKLISTMGMT\"]/a")
    private WebElement BLACKLISTMGMT;

    @FindBy(xpath = "//*[@id=\"blacklistSearchForm\"]/div[2]/a")
    private WebElement blacklistSearchForm;

    @FindBy(id = "blacklistType")
    private WebElement blacklistType;

    @FindBy(id = "blacklistValue")
    private WebElement blacklistValue;

    @FindBy(id = "remarks")
    private WebElement remarks;

    @FindBy(id = "continue")
    private WebElement continu;

    @FindBy(xpath = "//*[@id=\"confirmBox\"]/div/div/div[2]/div[1]/button[2]")
    private WebElement confirmBox;

    @FindBy(xpath = "//*[@id=\"msg\"]/ul/li/span")
    private static WebElement confirmmsg;

    public WalletAdminHomePage clickOnFraudManagement() throws JSchException, InterruptedException {
        isElementNotPresent(FRAUDMGMT);
        Thread.sleep(3000);
        clickOnElement(FRAUDMGMT,"FRAUDMGMT");
        return this;
    }

    public WalletAdminHomePage clickOnBlacklistManagement() throws JSchException, InterruptedException {
        isElementNotPresent(BLACKLISTMGMT);
        Thread.sleep(3000);
        clickOnElement(BLACKLISTMGMT," BLACKLISTMGMT");
        return this;
    }

    public WalletAdminHomePage ClickOnAddBlacklist() throws JSchException, InterruptedException {
        Thread.sleep(10000);
        clickOnElement(blacklistSearchForm,"blacklistSearchForm");
        return this;
    }

    public WalletAdminHomePage clickOnMobilePhone() throws JSchException, InterruptedException {
        isElementNotPresent(blacklistType);
        Thread.sleep(3000);
        Select dropdown = new Select(blacklistType);
        dropdown.selectByIndex(3);
        info("Clicked on Dropdown");
        return this;
    }

    public WalletAdminHomePage setValue(String value) throws JSchException {
        setText(blacklistValue,value,"Mobile Number");
        return this;
    }

    public WalletAdminHomePage setRemark(String remark) throws JSchException {
        setText(remarks,remark,"Mobile Number");
        return this;
    }

    public WalletAdminHomePage ClickOnContinue() throws JSchException {
        clickOnElement(continu,"Continue");
        return this;
    }

    public WalletAdminHomePage ClickOnConfirm() throws JSchException {
        isElementNotPresent(confirmBox);
        clickOnElement(confirmBox,"confirmBox");
        return this;
    }

    public  String getConfirmMsg(){
        isElementNotPresent(confirmmsg);
        return confirmmsg.getText();
    }
*/
}

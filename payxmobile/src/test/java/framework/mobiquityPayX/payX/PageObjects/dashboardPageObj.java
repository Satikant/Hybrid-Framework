package framework.mobiquityPayX.payX.PageObjects;

import com.aventstack.extentreports.Status;
import initializers.AppPageInit;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Utils;

import javax.rmi.CORBA.Util;

public class dashboardPageObj extends AppPageInit {

    public dashboardPageObj(){
        super();
    }


    @AndroidFindBy(xpath = "//*[@text='Ignore']")
    private WebElement ignoreButton;

    @AndroidFindBy(xpath = "//*[@text='Set now']")
    private WebElement setNowButton;

    @AndroidFindBy(id = "toolbarTextViewCenter")
    private WebElement welcomeTitle;

    @AndroidFindBy(id = "toolbar_icon")
    private WebElement humbergerMenu;

    @AndroidFindBy(xpath = "//*[@text='Please set security questions']")
    private WebElement setPINPopup;

    @AndroidFindBy(xpath = "//*[@text='Withdraw cash']")
    private WebElement withdrawCash;

    @AndroidFindBy(xpath = "//*[@text='Bill pay']")
    private WebElement billPay;

    @AndroidFindBy(xpath = "//*[@text='Transfer stock']")
    private WebElement transferStock;

    @AndroidFindBy(xpath = "//*[@text='Deposit cash']")
    private WebElement depositCash;

    @AndroidFindBy(xpath = "//*[@text='Add money']")
    private WebElement addMoney;

    @AndroidFindBy(xpath = "//*[@text='International Transfer']")
    private WebElement internationalTransfer;

    @AndroidFindBy(xpath = "//*[@text='Recharge']")
    private WebElement recharge;

    @AndroidFindBy(id = "com.comviva.mobiquity.channeluser.debug:id/landingHomeNavigation")
    private WebElement channelHome;

    @AndroidFindBy(id = "com.comviva.mobiquity.consumer.debug:id/homeNavigation")
    private WebElement subscriberHome;

    @AndroidFindBy(xpath = "//*[@text='My QR']")
    private WebElement myQR;

/*    (//*[@class='android.widget.FrameLayout'])[16]
@AndroidFindBy(xpath = "//*[@text='History']")
    private WebElement history;*/
//*[@contentDescription='History']

    @AndroidFindBy(id = "com.comviva.mobiquity.channeluser.debug:id/landingNavigationTransaction")
    private WebElement channelHistory;

    @AndroidFindBy(id = "com.comviva.mobiquity.consumer.debug:id/homeNavigationTransaction")
    private WebElement subscriberHistory;

    @AndroidFindBy(id = "com.comviva.mobiquity.consumer.debug:id/homeNavigationWallet")
    public WebElement subscriberWallet;

/*    @AndroidFindBy(id = "homeAvailableLabel")
    private WebElement homeDashboard;*/




    public boolean isIgnoreBoxPresent() {
        Utils.putThreadSleep(10000);
        return driver.findElements(By.xpath("//*[@text='Ignore']")).size() > 0;
    }



    public boolean isWelcomeTitlePresent() {
        Utils.putThreadSleep(5000);
        return driver.findElements(By.xpath("//*[@text='Bill pay']")).size() > 0;
    }

    public dashboardPageObj clickOnHumberger(){
        isElementNotPresent(humbergerMenu);
        clickOnElement(humbergerMenu,"Click on Humberger.");
        return this;
    }

    public dashboardPageObj clickOnDipositeCash(){
        isElementNotPresent(depositCash);
        clickOnElement(depositCash,"Click on Deposite Cash tab.");
        return this;
    }

    public dashboardPageObj clickOnBillPay() {

        if (isIgnoreBoxPresent())
        {
            clickOnIgnore();
            Utils.putThreadSleep(3000);
            clickOnElement(billPay, "click on billpay tab");
        }
        else
        {
            Utils.putThreadSleep(3000);
            clickOnElement(billPay, "click on billpay tab");
        }
        return this;
    }

    public dashboardPageObj clickOnRecharge() {
        Utils.putThreadSleep(10000);
        isElementNotPresent(recharge);
        clickOnElement(recharge, "click on recharge");
        return this;
    }

    public dashboardPageObj clickOnIgnore() {
        clickOnElement(ignoreButton, "click on Ignore button");
        return this;
    }

    public dashboardPageObj clickChannelHistory() {
        clickOnElement(channelHistory, "click on history tab.");
        return this;
    }

    public dashboardPageObj clickOnWallet() {
        clickOnElement(subscriberWallet, "click on wallet tab.");
        return this;
    }

    public dashboardPageObj clickSubscriberHistory() {
        clickOnElement(subscriberHistory, "click on history tab.");
        return this;
    }

    public dashboardPageObj clickSubscriberHome() {
        clickOnElement(subscriberHome, "click on home tab.");
        Utils.putThreadSleep(4000);
        return this;
    }

    public dashboardPageObj clickChannelHome() {
        clickOnElement(channelHome, "click on home tab.");
        return this;
    }


/*    public dashboardPageObj backToDashboard(){
        clickOnElement();
    }*/


    public String getDashboardWelcomePage() {
        try {
            Utils.putThreadSleep(5000);
            waitUntilElementDisappear("//*[@text='Bill pay']");
            info("Fetching Text : " + billPay.getText());
            return billPay.getText();
        } catch (Exception e) {
            e.printStackTrace();
            pageInfo.fail("Test Case Failed");
            pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        return "";
    }



/*    public String getAlertMsg() {
        try {
            waitUntilElementDisappear("//*[@text='OK']");
            info("Fetching Text : " + .getText());
            return home.getText();
        } catch (Exception e) {
            e.printStackTrace();
            pageInfo.fail("Test Case Failed");
            pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        return "";
    }*/


    public String setPINPopup() {
        try {
            waitUntilElementDisappear("//*[@text='Ignore']");
            info("Fetching Text : " + ignoreButton.getText());
            return ignoreButton.getText();
        } catch (Exception e) {
            e.printStackTrace();
            pageInfo.fail("Test Case Failed");
            pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        return "";
    }

}

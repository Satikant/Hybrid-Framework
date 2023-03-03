package framework.mobiquityPayX.payX.PageObjects;

import initializers.AppPageInit;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import utils.Utils;

public class HomescreenPageObjects extends AppPageInit {

    public HomescreenPageObjects() {
        super();
    }

    @AndroidFindBy(id = "com.comviva.mobiquity.consumer.debug:id/homeNavigation")
    public WebElement HomeMainmenu;
    @AndroidFindBy(id = "com.comviva.mobiquity.consumer.debug:id/homeNavigationWallet")
    public WebElement WalletMainmenu;
    @AndroidFindBy(id = "toolbar_icon")
    public WebElement hambergericon;
    //    @AndroidFindBy(id = "com.comviva.mobiquity.consumer.debug:id/homeAddmoneyLayout")
//    public WebElement AddMoneyoption;
    @AndroidFindBy(xpath = "//*[@text='Add money']")
    public WebElement AddMoneyoption;
    //    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[@resource-id='com.comviva.mobiquity.consumer.debug:id/homeAddmoneyLayout']/android.widget.ImageView")
//    public WebElement AddMoneyoption;
    @AndroidFindBy(id = "com.comviva.mobiquity.consumer.debug:id/custom_dialog_cancel_buttonView")
    public WebElement IgnoreError;

    @AndroidFindBy(xpath = "//*[@text = 'Withdraw cash']")
    public WebElement Witdrawcash;



    public HomescreenPageObjects clickonHambergerMenu() {
        waitUntilElementDisappear("hambergericon");
        Utils.putThreadSleep(5000);
        clickOnElement(hambergericon, "clicking on Hambergermenu in Homescreen");
        return this;
    }

    public HomescreenPageObjects clickonAddmoney() {
        isElementNotPresent(AddMoneyoption, 300);
        clickOnElement(AddMoneyoption, "clicking on Addmoney in Homescreen");
        return this;
    }

    public HomescreenPageObjects clickonHome() {
        clickOnElement(HomeMainmenu, "Clicking on Homemain menu");
        return this;
    }

    public HomescreenPageObjects clickonWallet() {
        isElementNotPresent(WalletMainmenu, 100);
        clickOnElement(WalletMainmenu, "Clicking on Homemain menu");
        return this;
    }

    public HomescreenPageObjects clickOnAcceptErr() {
        clickOnElement(IgnoreError, "Clicking on OK button of error message box");
        return this;
    }
    public HomescreenPageObjects clickonWithdrawcash() {
        isElementNotPresent(Witdrawcash, 100);
        clickOnElement(Witdrawcash, "Clicking on withdrawcash option");
//        implicitlywait();
        return this;
    }
}

package framework.mobiquityPayX.qnb.pageObjects;

import initializers.AppPageInit;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class QNBHomePageObjects extends AppPageInit {

    public QNBHomePageObjects() {
        super();
    }

    @AndroidFindBy(id = "homeAddmoneyMainLayout")
    private WebElement addMoney;

    @AndroidFindBy(id = "homeTransferToBankMainLayout")
    private WebElement transferToBank;

    @AndroidFindBy(id = "toolbar_icon")
    private WebElement toolBarIcon;

    @AndroidFindBy(id = "profileLayout")
    private WebElement profileOption;

    @AndroidFindBy(xpath = "//*[@text='Payment methods']/../..")
    private WebElement paymentsMethodOption;

    @AndroidFindBy(xpath = "//*[@text='Settings']/../..")
    private WebElement settingsOption;

    @AndroidFindBy(xpath = "//*[@text='Help & support']/../..")
    private WebElement helpAndSupportOption;

    @AndroidFindBy(xpath = "//*[@text='Logout']/../..")
    private WebElement logoutOption;

    @AndroidFindBy(xpath = "//*[@text='Security']/../..")
    private WebElement securityOption;

    @AndroidFindBy(xpath = "//*[@text='Language']/../..")
    private WebElement languageOption;

    @AndroidFindBy(xpath = "//*[@text='English']/../../..")
    private WebElement selectEnglish;

    @AndroidFindBy(xpath = "//*[@text='Arabic']/../../..")
    private WebElement selectArabic;

    @AndroidFindBy(id = "securityPinLayout")
    private WebElement changePinOption;



    @AndroidFindBy(id = "menuProfileVersionText")
    private WebElement appVersion;

    public QNBHomePageObjects clickOnAddMoney() {
        isElementNotPresent(addMoney);
        clickOnElement(addMoney, "Add Money");
        return this;
    }

    public QNBHomePageObjects clickOnTransferToBank() {
        isElementNotPresent(transferToBank);
        clickOnElement(transferToBank, "Transfer To Bank");
        return this;
    }

    public QNBHomePageObjects clickOnToolBarIcon() {
        isElementNotPresent(toolBarIcon);
        clickOnElement(toolBarIcon, "Transfer To Bank");
        return this;
    }

    public QNBHomePageObjects clickOnProfileOption() {
        isElementNotPresent(profileOption);
        clickOnElement(profileOption, "Profile Option");
        return this;
    }

    public QNBBankPageObjects clickOnPaymentsMethod() {
        isElementNotPresent(paymentsMethodOption);
        clickOnElement(paymentsMethodOption, "Payments Method");
        return new QNBBankPageObjects();
    }
    public QNBHomePageObjects clickOnSettings() {
        isElementNotPresent(settingsOption);
        clickOnElement(settingsOption, "Settings");
        return this;
    }
    public QNBHomePageObjects clickOnHelpAndSupport() {
        isElementNotPresent(helpAndSupportOption);
        clickOnElement(helpAndSupportOption, "Help And Support");
        return this;
    }
    public QNBHomePageObjects clickOnLogoutOption() {
        isElementNotPresent(logoutOption);
        clickOnElement(logoutOption, "Logout");
        return this;
    }

    public QNBHomePageObjects clickOnChangePin() {
        isElementNotPresent(changePinOption);
        clickOnElement(changePinOption, "Change Pin");
        return this;
    }

    public QNBHomePageObjects clickOnLanguage() {
        isElementNotPresent(languageOption);
        clickOnElement(languageOption, "Language");
        return this;
    }

    public QNBHomePageObjects selectEnglish() {
        isElementNotPresent(selectEnglish);
        clickOnElement(selectEnglish, "Select English");
        return this;
    }

    public QNBHomePageObjects selectArabic() {
        isElementNotPresent(selectArabic);
        clickOnElement(selectArabic, "Select Arabic");
        return this;
    }

    public String getAppVersionFromMenu() {
        return getAttribute(appVersion,"Text","App Version");
    }




}

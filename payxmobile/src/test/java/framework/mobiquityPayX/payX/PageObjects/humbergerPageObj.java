package framework.mobiquityPayX.payX.PageObjects;

import initializers.AppPageInit;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class humbergerPageObj extends AppPageInit {

    public humbergerPageObj()
    {
        super();
    }


    @AndroidFindBy(id = "toolbar_icon")
    private WebElement humbergerMenu;

    @AndroidFindBy(xpath = "//*[@text='Settings']")
    private WebElement settingsTab;

    @AndroidFindBy(xpath = "//*[@text='Logout']")
    private WebElement logoutButton;

    @AndroidFindBy(xpath = "//*[@text='Payment methods']")
    private WebElement paymentMethods;

    @AndroidFindBy(xpath = "//*[@text='Cancel']")
    private WebElement logoutCancel;




    public humbergerPageObj clickOnLogout(){
        isElementNotPresent(logoutButton);
        clickOnElement(logoutButton,"Click on logout button.");
        return this;
    }

    public humbergerPageObj clickOnSettings(){
        isElementNotPresent(settingsTab);
        clickOnElement(settingsTab,"Click on settings tab");
        return this;
    }



}


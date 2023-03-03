package framework.mobiquityPayX.payX.PageObjects;

import initializers.AppPageInit;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class settingsPageObj extends AppPageInit {

    public settingsPageObj(){
        super();
    }

    @AndroidFindBy(xpath = "//*[@text='Settings']")
    private WebElement settingsTitle;

    @AndroidFindBy(xpath = "//*[@text='Security']")
    private WebElement securityTab;

    @AndroidFindBy(id = "toolbar_icon")
    private WebElement backButton;

    @AndroidFindBy(xpath = "//*[@text='Language']")
    private WebElement languageTab;


    public settingsPageObj clickOnSecurity(){
        isElementNotPresent(securityTab);
        clickOnElement(securityTab,"Click on security tab");
        return this;
    }


}

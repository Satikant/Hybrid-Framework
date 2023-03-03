package framework.mobiquityPayX.payX.PageObjects;

import initializers.AppPageInit;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class securityPageObj extends AppPageInit {

    public securityPageObj(){
        super();
    }

    @AndroidFindBy(xpath = "//*[@text='Security']")
    private WebElement securityTitle;

    @AndroidFindBy(id = "toolbar_icon")
    private WebElement backButton;

    @AndroidFindBy(xpath = "//*[@text='change PIN']")
    private WebElement changePin;

    @AndroidFindBy(xpath = "//*[@text='Security questions']")
    private WebElement securityQuestions;


    public securityPageObj clickOnChangePIN(){
        isElementNotPresent(changePin);
        clickOnElement(changePin,"Click on change pin tab");
        return this;
    }

}

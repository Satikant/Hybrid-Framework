package framework.mobiquityPayX.payX.PageObjects;

import initializers.AppPageInit;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class rechargePrepaidAmountDetailsPageObj extends AppPageInit {

    public rechargePrepaidAmountDetailsPageObj(){
        super();
    }


    @AndroidFindBy(id = "toolbar_icon")
    private WebElement backBtn;

    @AndroidFindBy(xpath = "//*[@text='Recharge - Prepaid']")
    private WebElement pageTitle;

    @AndroidFindBy(xpath = "//*[@text='Pay']")
    private WebElement payBtn;


    public rechargePrepaidAmountDetailsPageObj clickOnPay(){
        isElementNotPresent(payBtn);
        clickOnElement(payBtn,"Click on pay");
        return this;
    }



}

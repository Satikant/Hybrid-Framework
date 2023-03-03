package framework.mobiquityPayX.payX.PageObjects;

import initializers.AppPageInit;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class rechargePrepaidSecPageObj extends AppPageInit {


    public rechargePrepaidSecPageObj(){
        super();
    }



    @AndroidFindBy(xpath = "//*[@text='Recharge - Prepaid']")
    private WebElement pageTitle;

    @AndroidFindBy(id = "toolbar_icon")
    private WebElement backBtn;

    @AndroidFindBy(id = "multiCurrencyAmountEdittext")
    private WebElement amountField;

    @AndroidFindBy(id = "multiCurrencyNameLabel")
    private WebElement currencyType;

    @AndroidFindBy(xpath = "//*[@text='Next']")
    private WebElement nextBtn;

    @AndroidFindBy(xpath = "//*[@text='IndianRupee']")
    private WebElement indianRupee;


    public rechargePrepaidSecPageObj clearAmount(){
        isElementNotPresent(amountField);
        clear(amountField,"Clear amount field");
        return this;
    }

    public rechargePrepaidSecPageObj setAmount( String amount){
        isElementNotPresent(amountField);
        setText(amountField, amount,"Enter amount");
        return this;
    }


    public rechargePrepaidSecPageObj clickOnNext(){
        isElementNotPresent(nextBtn);
        clickOnElement(nextBtn,"click on next button");
        return this;
    }


}

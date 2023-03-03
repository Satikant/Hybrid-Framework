package framework.mobiquityPayX.payX.PageObjects;

import initializers.AppPageInit;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Utils;

public class electricityBillAmountDetailsPageObj extends AppPageInit {

    public electricityBillAmountDetailsPageObj(){
        super();
    }

    @AndroidFindBy(xpath = "//*[@text='Electricity']")
    public WebElement electricityTitle;

    @AndroidFindBy(id = "toolbar_icon")
    public WebElement backButton;

    @AndroidFindBy(xpath = "//*[@text='Pay']")
    public WebElement payButton;

    @AndroidFindBy(id = "chkbox_autobillpay")
    public WebElement checkBox;


    public boolean isCheckBoxPresent(){
        Utils.putThreadSleep(4000);
        return driver.findElements(By.id("chkbox_autobillpay")).size()>0;
    }

    public electricityBillAmountDetailsPageObj clickOnPay() {
        isElementNotPresent(payButton);
        clickOnElement(payButton, "Clicking on pay button.");
        return this;
    }

    public electricityBillAmountDetailsPageObj clickCheckBox() {
        clickOnElement(checkBox, "Clicking on check box.");
        return this;
    }


}

package framework.mobiquityPayX.payXUAT.PageObjects;

import framework.mobiquityPayX.payX.PageObjects.dashboardPageObj;
import initializers.AppPageInit;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Utils;

public class mobilePostpaidDetailsPageObj extends AppPageInit {

    public mobilePostpaidDetailsPageObj(){
        super();
    }


    @AndroidFindBy(xpath = "//*[@text='Next']")
    private WebElement nextBtn;

    @AndroidFindBy(id = "multiCurrencyAmountEdittext")
    private WebElement amountField;

    @AndroidFindBy(id = "toolbar_icon")
    private WebElement backBtn;

    @AndroidFindBy(xpath = "//*[@text='Mobile Postpaid']")
    private WebElement mobilePostpaidTitle;



    public boolean isPostpaidPresent() {
        Utils.putThreadSleep(5000);
        return driver.findElements(By.xpath("//*[@text='Next']")).size() > 0;
    }

    public mobilePostpaidDetailsPageObj clickOnNext(){
        clickOnElement(nextBtn,"Click on Next button.");
        return this;
    }

    public mobilePostpaidDetailsPageObj setAmount(String amount){
        Utils.putThreadSleep(3000);
        amountField.clear();
        setText(amountField, amount,"Set amount for recharge.");
        return this;
    }


}

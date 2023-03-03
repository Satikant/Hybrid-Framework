package framework.mobiquityPayX.payXUAT.PageObjects;

import initializers.AppPageInit;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Utils;

public class mobilePostpaidDetails2PageObj extends AppPageInit {

    public mobilePostpaidDetails2PageObj(){
        super();
    }


    @AndroidFindBy(xpath = "//*[@text='Pay']")
    private WebElement payBtn;

    @AndroidFindBy(id = "toolbar_icon")
    private WebElement backBtn;

    @AndroidFindBy(xpath = "//*[@text='Mobile Postpaid']")
    private WebElement mobilePostpaidTitle;



    public boolean isPostpaidPresent() {
        Utils.putThreadSleep(5000);
        return driver.findElements(By.xpath("//*[@text='Next']")).size() > 0;
    }

    public mobilePostpaidDetails2PageObj clickOnPay(){
        Utils.putThreadSleep(5000);
        clickOnElement(payBtn,"Click on pay button.");
        return this;
    }


}

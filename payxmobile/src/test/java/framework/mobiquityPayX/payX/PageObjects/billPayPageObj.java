package framework.mobiquityPayX.payX.PageObjects;

import com.aventstack.extentreports.Status;
import initializers.AppPageInit;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Utils;

public class billPayPageObj extends AppPageInit {

    public billPayPageObj(){
        super();
    }


    @AndroidFindBy(xpath = "//*[@text='Billpay']")
    private WebElement billPayTitle;

    @AndroidFindBy(xpath = "//*[@text='Recents']")
    private WebElement recentsIcon;

    @AndroidFindBy(xpath = "//*[@text='Mobile Postpaid']")
    private WebElement mobilePostpaid;

    @AndroidFindBy(xpath = "//*[@text='Electricity']")
    private WebElement electricitytab;

    @AndroidFindBy(id = "id_1")
    private WebElement retryButton;

    @AndroidFindBy(id = "toolbar_icon")
    private WebElement backButton;



    public boolean isElectricityPresent() {
        Utils.putThreadSleep(5000);
        return driver.findElements(By.xpath("//*[@text='Electricity']")).size() > 0;
    }


    public billPayPageObj clickOnElectricity() {
        clickOnElement(electricitytab, "Clicking on the first elctricity board");
        return this;
    }


    public boolean isPostpaidPresent() {
        Utils.putThreadSleep(5000);
        return driver.findElements(By.xpath("//*[@text='Mobile Postpaid']")).size() > 0;
    }


    public billPayPageObj clickOnPostpaid() {
        clickOnElement(mobilePostpaid, "Clicking on the first elctricity board");
        return this;
    }


    public boolean isBackPresent() {
        Utils.putThreadSleep(5000);
        return driver.findElements(By.id("toolbar_icon")).size() > 0;
    }

    public billPayPageObj clickOnBack() {
        Utils.putThreadSleep(10000);
        clickOnElement(backButton, "Clicking on back button");
        return this;
    }


    public String getBillPayPageTitle() {
        try {
            Utils.putThreadSleep(3000);
            waitUntilElementDisappear("//*[@text='Billpay']");
            info("Fetching Text : " + billPayTitle.getText());
            return billPayTitle.getText();
        } catch (Exception e) {
            e.printStackTrace();
            pageInfo.fail("Test Case Failed");
            pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        return "";
    }




}

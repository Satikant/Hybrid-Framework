package framework.mobiquityPayX.payX.PageObjects;

import com.aventstack.extentreports.Status;
import initializers.AppPageInit;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Utils;

public class rechargePrepaidSuccessPageObj extends AppPageInit {

    public rechargePrepaidSuccessPageObj(){
        super();
    }

    @AndroidFindBy(xpath = "//*[@text='Service Type']")
    private WebElement serviceType;

    @AndroidFindBy(xpath = "//*[@text='Go home']")
    private WebElement goHomeBtn;



    public boolean isServiceTypePresent(){
        isElementNotPresent(serviceType);
        return driver.findElements(By.xpath("//*[@text='Service Type']")).size()>0;
    }


    public rechargePrepaidSuccessPageObj clickOnGoHome(){
        Utils.putThreadSleep(4000);
        clickOnElement(goHomeBtn,"Click on Go home button");
        return this;
    }


    public String getRechargeStatus() {
        try {
            waitUntilElementDisappear("//*[@text='Service Type']");
            info("Fetching Text : " + serviceType.getText());
            return serviceType.getText();
        } catch (Exception e) {
            e.printStackTrace();
            pageInfo.fail("Test Case Failed");
            pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        return "";
    }


}

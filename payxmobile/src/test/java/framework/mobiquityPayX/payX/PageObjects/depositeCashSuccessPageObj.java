package framework.mobiquityPayX.payX.PageObjects;

import com.aventstack.extentreports.Status;
import initializers.AppPageInit;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Utils;

public class depositeCashSuccessPageObj extends AppPageInit {

    public depositeCashSuccessPageObj(){
        super();
    }

    @AndroidFindBy(xpath = "//*[@text='Payment successful']")
    private WebElement paymentSuccess;

    @AndroidFindBy(xpath = "//*[@text='Service Type']")
    private WebElement serviceType;

    @AndroidFindBy(xpath = "//*[@text='Transaction ID']")
    private WebElement transctionID;

    @AndroidFindBy(xpath = "//*[@text='Go home']")
    private WebElement goHome;


    public boolean isTransctionSuccess(){
        isElementNotPresent(serviceType);
        return driver.findElements(By.xpath("//*[@text='Service Type']")).size()>0;
    }


    public depositeCashSuccessPageObj clickOnGoHome(){
        isElementNotPresent(goHome);
        Utils.putThreadSleep(10000);
        clickOnElement(goHome,"Click on Go Home tab.");
        return this;
    }


    public String getDepositeCashSuccessful() {
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

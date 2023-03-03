package framework.mobiquityPayX.payX.PageObjects;

import com.aventstack.extentreports.Status;
import initializers.AppPageInit;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Utils;

public class pinChangeSuccessPageObj extends AppPageInit {

    public pinChangeSuccessPageObj(){
        super();
    }

    @AndroidFindBy(xpath = "//*[@text='PIN changed successfully']")
    private WebElement pinChanged;

    @AndroidFindBy(xpath = "//*[@text='Login']")
    private WebElement loginButton;



    public boolean isPinChangeSuccess(){
        isElementNotPresent(pinChanged);
        return driver.findElements(By.xpath("//*[@text='PIN changed successfully']")).size()>0;
    }


    public pinChangeSuccessPageObj clickOnLogin(){
        isElementNotPresent(loginButton);
        Utils.putThreadSleep(5000);
        clickOnElement(loginButton,"Click on login button.");
        return this;
    }


    public String getPinChangeSuccessful() {
        try {
            waitUntilElementDisappear("//*[@text='Login']");
            info("Fetching Text : " + loginButton.getText());
            return loginButton.getText();
        } catch (Exception e) {
            e.printStackTrace();
            pageInfo.fail("Test Case Failed");
            pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        return "";
    }


}

package framework.mobiquityPayX.payX.PageObjects;

import com.aventstack.extentreports.Status;
import initializers.AppPageInit;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.WebElement;
import utils.Utils;

public class depositeCashDetailsPageObj extends AppPageInit {

    public depositeCashDetailsPageObj(){
        super();
    }

    @AndroidFindBy(xpath = "//*[@text='Deposit cash']")
    private WebElement depositeCashTitle;

    @AndroidFindBy(id = "toolbar_icon")
    private WebElement backButton;

    @AndroidFindBy(xpath = "//*[@text='Transfer now']")
    private WebElement transferNowButton;


    public depositeCashDetailsPageObj clickOnTransferNow(){
        isElementNotPresent(transferNowButton);
        clickOnElement(transferNowButton,"Click on transfer now button");
        return this;
    }

    public String getTransforNow() {
        try {
            Utils.putThreadSleep(5000);
            waitUntilElementDisappear("//*[@text='Transfer now']");
            info("Fetching Text : " + transferNowButton.getText());
            return transferNowButton.getText();
        } catch (Exception e) {
            e.printStackTrace();
            pageInfo.fail("Test Case Failed");
            pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        return "";
    }


}

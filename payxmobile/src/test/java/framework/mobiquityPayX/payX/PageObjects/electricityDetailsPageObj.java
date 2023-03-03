package framework.mobiquityPayX.payX.PageObjects;

import com.aventstack.extentreports.Status;
import initializers.AppPageInit;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Utils;

public class electricityDetailsPageObj extends AppPageInit {

    public electricityDetailsPageObj(){
        super();
    }

    @AndroidFindBy(xpath = "//*[@text='Electricity']")
    private WebElement electricityTitle;

    @AndroidFindBy(id = "toolbar_icon")
    private WebElement backButton;

    @AndroidFindBy(xpath = "(//*[@class='android.widget.LinearLayout'])[10]")
    private WebElement boardDetails;

    @AndroidFindBy(xpath = "//*[@text='Board']")
    private WebElement board;

    @AndroidFindBy(xpath = "//*[@text='Customer ID']")
    private WebElement customerID;

    @AndroidFindBy(xpath = "//*[@text='Next']")
    private WebElement nextButton;



    public electricityDetailsPageObj setConsumerID(String customerid){
        isElementNotPresent(customerID);
        setText(customerID, customerid, "Enter customer id");
        return this;
    }

    public boolean isCustomerIdPresent(){
        Utils.putThreadSleep(3000);
        return driver.findElements(By.xpath("//*[@text='Next']")).size()>0;
    }

    public boolean isBoardPresent(){
        Utils.putThreadSleep(3000);
        return driver.findElements(By.xpath("//*[@text='Board']")).size()>0;
    }


    public electricityDetailsPageObj clickOnNext() {
        isElementNotPresent(nextButton);
        clickOnElement(nextButton, "Clicking on next button.");
        return this;
    }

    public electricityDetailsPageObj clickOnBoard() {
        clickOnElement(board, "Clicking on board field.");
        return this;
    }


    public String getElectricityPageVerify() {
        try {
            waitUntilElementDisappear("//*[@text='Electricity']");
            info("Fetching Text : " + electricityTitle.getText());
            return electricityTitle.getText();
        } catch (Exception e) {
            e.printStackTrace();
            pageInfo.fail("Test Case Failed");
            pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        return "";
    }

    public String getCustomerId() {
        try {
            waitUntilElementDisappear("//*[@text='Next']");
            info("Fetching Text : " + nextButton.getText());
            return nextButton.getText();
        } catch (Exception e) {
            e.printStackTrace();
            pageInfo.fail("Test Case Failed");
            pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        return "";
    }



}

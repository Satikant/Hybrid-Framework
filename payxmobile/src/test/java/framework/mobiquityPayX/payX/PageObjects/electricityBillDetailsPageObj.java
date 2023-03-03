package framework.mobiquityPayX.payX.PageObjects;

import com.aventstack.extentreports.Status;
import initializers.AppPageInit;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class electricityBillDetailsPageObj extends AppPageInit {

    public electricityBillDetailsPageObj(){
        super();
    }



    @AndroidFindBy(xpath = "//*[@text='Electricity']")
    private WebElement electricityTitle;

    @AndroidFindBy(id = "toolbar_icon")
    private WebElement backButton;

    @AndroidFindBy(xpath = "((//*[@class='android.widget.TextView'])[4]")
    private WebElement billDetails;

    @AndroidFindBy(id = "multiCurrencyAmountEdittext")
    private WebElement amountField;

    @AndroidFindBy(xpath = "//*[@text='Next']")
    private WebElement nextButton;




    public electricityBillDetailsPageObj clearAmountField() throws InterruptedException {
        isElementNotPresent(amountField);
        clear(amountField, "Clear the amount field.");
        return this;
    }


    public electricityBillDetailsPageObj clickOnElectricity() {
        isElementNotPresent(nextButton);
        clickOnElement(nextButton, "Clicking on next button.");
        return this;
    }

    public electricityBillDetailsPageObj setAmount(String amount){
        isElementNotPresent(amountField);
        setText(amountField, amount, "Enter bill amount.");
        return this;
    }

    public electricityBillDetailsPageObj clickOnNext() {
        isElementNotPresent(nextButton);
        clickOnElement(nextButton, "Clicking on next button.");
        return this;
    }

    public boolean isElectricityBillPagePresent(){
        isElementNotPresent(electricityTitle);
        return driver.findElements(By.xpath("//*[@text='Electricity']")).size()>0;
    }

    public String getElectricityPageTitle() {
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



}

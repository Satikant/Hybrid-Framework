package framework.mobiquityPayX.payXUAT.PageObjects;

import initializers.AppPageInit;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import utils.Utils;

public class mobilePostPaidPageObj extends AppPageInit {

    public mobilePostPaidPageObj(){
        super();
    }


    @AndroidFindBy(xpath = "//*[@text='Mobile Postpaid']")
    private WebElement mobilePostPaidTitle;

    @AndroidFindBy(id = "toolbar_icon")
    private WebElement backButton;

    @AndroidFindBy(xpath = "(//*[@class='android.widget.EditText'])[1]")
    private WebElement mobileNo;

    @AndroidFindBy(xpath = "(//*[@class='android.widget.EditText'])[2]")
    private WebElement operator;

    @AndroidFindBy(xpath = "//*[@text='Airtel']")
    private WebElement airtel;

    @AndroidFindBy(xpath = "//*[@text='Next']")
    private WebElement nextButton;



    public mobilePostPaidPageObj setMobileNumber(String mobile) {
        Utils.putThreadSleep(5000);
        setText(mobileNo,mobile,"Enter the mobile number.");
        return this;
    }

    public mobilePostPaidPageObj clickOnOperator() {
        clickOnElement(operator, "Clicking on Operator.");
        return this;
    }

    public mobilePostPaidPageObj chooseOperator() {
        Utils.putThreadSleep(5000);
        clickOnElement(airtel, "Choose a Operator.");
        return this;
    }

    public mobilePostPaidPageObj clickOnNext() {
        Utils.putThreadSleep(3000);
        clickOnElement(nextButton, "Clicking on next button.");
        return this;
    }




}

package framework.mobiquityPayX.payX.PageObjects;

import initializers.AppPageInit;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class chooseOperatorPageObj extends AppPageInit {



    @AndroidFindBy(xpath = "//*[@text='Airtel']")
    private WebElement airtel;

    @AndroidFindBy(xpath = "//*[@text='Search']")
    private WebElement search;

    @AndroidFindBy(id = "operatorBackArrowImageview")
    private WebElement backBtn;

    @AndroidFindBy(xpath = "//*[@text='Bill pay']")
    private WebElement billPay;



    public chooseOperatorPageObj clickOnAirtel(){
        isElementNotPresent(airtel);
        clickOnElement(airtel,"Click on airtel operator");
        return this;
    }




}

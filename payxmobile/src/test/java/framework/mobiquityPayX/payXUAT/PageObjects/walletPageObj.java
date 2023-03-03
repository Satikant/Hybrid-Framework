package framework.mobiquityPayX.payXUAT.PageObjects;

import initializers.AppPageInit;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class walletPageObj extends AppPageInit {

    public walletPageObj(){
        super();
    }


    @AndroidFindBy(xpath = "//*[@text='Order details']")
    private WebElement orderDetails;





}

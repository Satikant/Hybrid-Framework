package framework.mobiquityPayX.payX.PageObjects;

import initializers.AppPageInit;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class rechargePageObj extends AppPageInit {

    public rechargePageObj(){
        super();
    }


    @AndroidFindBy(xpath = "//*[@text='Add another email account']")
    private WebElement addEmailAcc;

    @AndroidFindBy(xpath = "//*[@text='Apps & notifications']")
    private WebElement appsAndNotifications;

    @AndroidFindBy(xpath = "//*[@text='Connected devices']")
    private WebElement connectedDevices;


}

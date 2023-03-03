package framework.mobiquityPayX.payX.PageObjects;

import initializers.AppPageInit;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import utils.Utils;

public class HamburgerMenuPageObjects extends AppPageInit {
    public HamburgerMenuPageObjects(){ super();}

    @AndroidFindBy(xpath = "//*[@text='Logout']")
    public WebElement hm_Logout;

    @AndroidFindBy(xpath = "//*[@text='Payment methods']")
    public WebElement hm_Payment;

    @AndroidFindBy(id = "com.comviva.mobiquity.consumer.debug:id/confirmation_action_button")
    public WebElement logoutbtnInConfirmation;


    public HamburgerMenuPageObjects clickonmenus(){
        Utils.putThreadSleep(4000);
        clickOnElement(hm_Logout,"clicking on logout option from hamberger");
        clickOnElement(logoutbtnInConfirmation,"clicking on confirmation in logout option");
        return this;
    }
}

package framework.wallet.bharain.pageObjects;

import initializers.AppPageInit;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import propertyManagement.MobileProperties;
import utils.Utils;

import java.util.List;

/**
 * Created by ayush.singh on 18-02-2020.
 */
public class RequestMoneyPage extends AppPageInit {
    @AndroidFindBy(id = "com.batelco.sub:id/desc_image")
    private List<WebElement> desc_image;

    public RequestMoneyPage clickOnRequestMoneyIcon() throws InterruptedException {
        Utils.scrollToRightOfActivityPage();
        clickOnElement(desc_image.get(0), "Clicking on Request money");
        return this;
    }


}

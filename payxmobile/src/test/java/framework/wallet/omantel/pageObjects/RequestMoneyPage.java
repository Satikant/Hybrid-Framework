package framework.wallet.omantel.pageObjects;

import initializers.AppPageInit;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import propertyManagement.MobileProperties;
import utils.Utils;

import java.util.List;

public class RequestMoneyPage extends AppPageInit {
    @AndroidFindBy(id = "com.omantel.efloos.subscriber:id/add_services")
    private List<WebElement> desc_image;

    public RequestMoneyPage clickOnRequestMoneyIcon() throws InterruptedException {
        clickOnElement(desc_image.get(3), "Clicking on Request money");
        return this;
    }
}

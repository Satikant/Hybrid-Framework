package framework.wallet.omantel.pageObjects;

import initializers.AppPageInit;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProfileDetailsPage extends AppPageInit {

    @AndroidFindBy(xpath = "//android.widget.TextView")
    public List<WebElement> element;

    @AndroidFindBy(id = "com.omantel.efloos.subscriber:id/menu_button")
    private WebElement menu_button;

    public ProfileDetailsPage clickOnMenuButton()  {
        isElementNotPresent(menu_button);
        clickOnElement(menu_button, "Clicking On Menu button");
        return this;
    }

    public ProfileDetailsPage clickOnLogOut()  {
        clickOnElement(element.get(8), "Clicking On Log Out");
        return this;
    }

}

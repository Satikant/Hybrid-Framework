package framework.wallet.bharain.pageObjects;

import initializers.AppPageInit;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProfileDetailsPage extends AppPageInit {


    @AndroidFindBy(id = "com.batelco.sub:id/parent_name")
    public List<WebElement> element1;

    @AndroidFindBy(xpath = "//*[@class='android.widget.EditText']")
    public List<WebElement> element2;

    @AndroidFindBy(id = "com.batelco.sub:id/submit_button")
    private WebElement submit_button;


    @AndroidFindBy(id = "com.batelco.sub:id/menu_button")
    private WebElement menu_button1;


    @AndroidFindBy(id = "com.batelco.sub:id/lblListHeader")
    public List<WebElement> element3;

    @AndroidFindBy(className = "android.widget.ImageView")
    public List<WebElement> language;

    public ProfileDetailsPage clickOnMenuButton()  {
        isElementNotPresent(menu_button1);
        clickOnElement(menu_button1, "Clicking On Menu button");
        return this;
    }


    public ProfileDetailsPage clickOnLogOut()  {
        clickOnElement(element3.get(8),"Clicking On Log Out");
        return this;
    }


}

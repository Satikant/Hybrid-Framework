package framework.mobiquityPayX.ndpc.pageObjects;

import initializers.AppPageInit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NDPCSendMoneyPageObject extends AppPageInit {
    public NDPCSendMoneyPageObject(){
        super();
    }

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='Send money']")
    private WebElement sendMoneyIOS;

    public WebElement NDPCSendMoneyPageObject(){
        return  sendMoneyIOS;
    }
}

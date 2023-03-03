package framework.mobiquityPayX.ndpc.pageObjects;

import initializers.AppPageInit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NDPCCashOutPageObject extends AppPageInit {

    public NDPCCashOutPageObject(){
        super();
    }

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='Send money']")
    private  WebElement sendMoneyIOS;
    @FindBy(xpath="//XCUIElementTypeImage[@name='home_withdrawCashIcon']")
    private WebElement cashOutIcon;

    public WebElement clickOnCashOutIcon(){
       return  cashOutIcon;
    }
}

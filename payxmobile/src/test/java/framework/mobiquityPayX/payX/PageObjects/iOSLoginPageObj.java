package framework.mobiquityPayX.payX.PageObjects;

import initializers.AppPageInit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class iOSLoginPageObj extends AppPageInit {
    public iOSLoginPageObj() {super();}
    @FindBy(xpath = "//XCUIElementTypeTextField[@name='Form_InputField_0']")
    public WebElement MobileNumber;
    @FindBy(xpath = "//XCUIElementTypeSecureTextField[@name='Form_InputField_0']")
    public WebElement Pin;
    @FindBy(xpath = "//XCUIElementTypeButton[@name='Login']")
    public WebElement LoginBtn;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='Recharge']")
    public WebElement Recharge;

    public iOSLoginPageObj setMobileNumber(String msisdn)
    {
        isElementNotPresent(MobileNumber);
        setText(MobileNumber,msisdn,"Entering Mobile Number");
        return this;
    }
    public iOSLoginPageObj setpin(String pin) {
        isElementNotPresent(Pin);
        setText(Pin, pin, "Entering Pin");
        return this;
    }
    public iOSLoginPageObj clickLogin(){
        clickOnElement(LoginBtn,"Clicking Login Button");
        return this;
    }
    public iOSLoginPageObj clickRecharge(){
        isElementNotPresent(Recharge,20);
        clickOnElement(Recharge,"Click On Recharge");
        return this;
    }
}

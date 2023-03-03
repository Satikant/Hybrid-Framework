package framework.mobiquityPayX.payX.PageObjects;

import initializers.AppPageInit;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import utils.Utils;

public class changePinPageObj extends AppPageInit {

    public changePinPageObj(){
        super();
    }

    @AndroidFindBy(xpath = "//*[@text='Change PIN']")
    private WebElement changePinTitle;

    @AndroidFindBy(id = "toolbar_icon")
    private WebElement backButton;

    @AndroidFindBy(xpath = "(//*[@class='android.widget.EditText'])[1]")
    private WebElement currentPin;

    @AndroidFindBy(xpath = "(//*[@class='android.widget.EditText'])[2]")
    private WebElement newPin;

    @AndroidFindBy(xpath = "(//*[@class='android.widget.EditText'])[3]")
    private WebElement confirmNewPin;

    @AndroidFindBy(id = "changepin_button")
    private WebElement changePinButton;


    public changePinPageObj setCurrentPin(String pin){
        isElementNotPresent(currentPin);
        setText(currentPin, pin,"Enter current PIN..");
        return this;
    }

    public changePinPageObj setNewPin(String newpin){
        isElementNotPresent(newPin);
        setText(newPin, newpin,"Enter new PIN..");
        return this;
    }

    public changePinPageObj setConfirmPin(String confirmpin){
        isElementNotPresent(confirmNewPin);
        setText(confirmNewPin, confirmpin,"Enter confirm PIN..");
        return this;
    }

    public changePinPageObj clickChangePIN() {
        isElementNotPresent(changePinButton);
        clickOnElement(changePinButton, "Clicking on change pin..");
        return this;
    }


}

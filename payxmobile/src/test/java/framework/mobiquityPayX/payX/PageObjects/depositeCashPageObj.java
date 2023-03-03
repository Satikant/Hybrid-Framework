package framework.mobiquityPayX.payX.PageObjects;

import initializers.AppPageInit;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class depositeCashPageObj extends AppPageInit {

    public depositeCashPageObj()
    {
        super();
    }

    @AndroidFindBy(xpath = "//*[@text='Deposit cash']")
    private WebElement depositeCashTitle;

    @AndroidFindBy(xpath = "//*[@text='Registered user']")
    private WebElement registeredUser;

    @AndroidFindBy(xpath = "//*[@text='Un-registered user']")
    private WebElement unregisteredUser;

    @AndroidFindBy(xpath = "(//*[@class='android.widget.EditText'])[1]")
    private WebElement dipositorMobileNo;

    @AndroidFindBy(xpath = "(//*[@class='android.widget.EditText'])[2]")
    private WebElement withdrawerMobileNo;

    @AndroidFindBy(xpath = "(//*[@class='android.widget.EditText'])[3]")
    private WebElement amountField;

    @AndroidFindBy(xpath = "//*[@text='Next']")
    private WebElement nextButton;


    public depositeCashPageObj clickOnUnregisterUser(){
        isElementNotPresent(unregisteredUser);
        clickOnElement(unregisteredUser,"Click on Un-registered user");
        return this;
    }

    public depositeCashPageObj setDepositeMobNo(String depositemob){
        isElementNotPresent(dipositorMobileNo);
        setText(dipositorMobileNo, depositemob,"Set value on diposite mobile number");
        return this;
    }

    public depositeCashPageObj setwithdrawerMobNo(String withdrawermob){
        isElementNotPresent(withdrawerMobileNo);
        setText(withdrawerMobileNo, withdrawermob,"Set value on withdrawer mobile number");
        return this;
    }

    public depositeCashPageObj setAmount(String amount){
        isElementNotPresent(amountField);
        setText(amountField, amount,"Set amount");
        return this;
    }

    public depositeCashPageObj clickOnNext(){
        isElementNotPresent(nextButton);
        clickOnElement(nextButton,"Click on Next button");
        return this;
    }


}

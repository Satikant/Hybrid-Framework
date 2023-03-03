package framework.wallet.palestineArabBank.pageObjects;

import initializers.AppPageInit;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonUtils;
import utils.Utils;

import java.util.List;

public class AtmCashoutPagePalestine extends AppPageInit {

    public AtmCashoutPagePalestine() {
        super();
    }

    @AndroidFindBy(id = "com.abp.sub:id/add_services")
    public List<WebElement> atmCashoutBtn;

    @AndroidFindBy(id = "com.abp.sub:id/add_services")
    public WebElement add_services;

    @AndroidFindBy(className = "android.widget.EditText")
    public List<WebElement> confirmAmount;

    @AndroidFindBy(className = "android.widget.EditText")
    public List<WebElement> amountILS;

    @AndroidFindBy(id = "com.abp.sub:id/submit_button")
    public WebElement submitButton;

    @AndroidFindBy(id = "com.abp.sub:id/textview1")
    public List<WebElement>  cashoutStatus;

    @AndroidFindBy(id = "com.abp.sub:id/textview2")
    public List<WebElement> otpStatus;

//    @AndroidFindBy(id="com.abp.sub:id/snackbar_text")
//    private WebElement snackBarText;

//    @AndroidFindBy(id="com.abp.sub:id/snackbar_action")
//    private WebElement snackBarOkBtn;

    @AndroidFindBy(xpath = "//*[@text='Confirm']")
    public WebElement confBtn;

    @AndroidFindBy(xpath = "//*[@class='android.widget.ImageButton']")
    public List<WebElement> backButton;

    @AndroidFindBy(id = "com.abp.sub:id/showBalance")
    public WebElement walletBalance;

    @AndroidFindBy(id = "com.abp.sub:id/home_button")
    public WebElement homeButton;

    @AndroidFindBy(xpath = "//*[@class='android.widget.Button']")
    public List<WebElement> amountButton;

    @AndroidFindBy(id = "com.abp.sub:id/snackbar_text")
    private static WebElement snackbar_text;

    public AtmCashoutPagePalestine setAmt(String amount) {
        setText(amountILS.get(0), amount, "Amount(ILS)");
        return this;
    }

    public String getAmount() {
        System.out.println("AMOUNT:  "+confirmAmount.get(1).getText());
        return confirmAmount.get(1).getText();
    }

    public String getTxnStatus() {
        System.out.println("Status:  "+cashoutStatus.get(2).getText());
        return cashoutStatus.get(2).getText();
    }

    public String getTxnStatus2() {
//        System.out.println("Status  "+cashoutStatus.get(2).getText());
        return cashoutStatus.get(1).getText();
    }

    public String getOtpStatus() {
        System.out.println("OTP text  " + otpStatus.get(0).getText());
        return otpStatus.get(0).getText();
    }


    public AtmCashoutPagePalestine clickOnSubmitBtn() {
        isElementNotPresent(submitButton);
        info("Clicking on Submit button");
        Utils.slideSeekBar("submit_button", 2000);
        return this;
    }

    public AtmCashoutPagePalestine clickOnAtmCashoutIcon() {
        isElementNotPresent(add_services);
        Utils.scrollToRightOfActivityPage();
        Utils.scrollToRightOfActivityPage();
        clickOnElement(atmCashoutBtn.get(3), "Clicking on ATM Cashout");
        return this;
    }

    public AtmCashoutPagePalestine clickOnBackButton() {
        clickOnElement(backButton.get(0), "Clicking On Back Button");
        return this;
    }

    public AtmCashoutPagePalestine clickOnConfBtn() {
        clickOnElement(confBtn, "Clicking On Confirm Button");
        return this;
    }

    public AtmCashoutPagePalestine clickOnHomeButton() {
        clickOnElement(homeButton, "Clicking On Home Button");
        return this;
    }

    public AtmCashoutPagePalestine clickOn100ILSBtn() {
        clickOnElement(amountButton.get(0), "Clicking on 100 ILS button");
        return this;
    }

    public AtmCashoutPagePalestine clickOn200ILSBtn() {
        clickOnElement(amountButton.get(1), "Clicking on 200 ILS button");
        return this;
    }

    public AtmCashoutPagePalestine clickOn400ILSBtn() {
        clickOnElement(amountButton.get(2), "Clicking on 400 ILS button");
        return this;
    }

    public AtmCashoutPagePalestine clickOn600ILSBtn() {
        clickOnElement(amountButton.get(3), "Clicking on 600 ILS button");
        return this;
    }

    public String selectAmount(String amt) {

        switch (amt) {

            case "100ILS":
                clickOnElement(amountButton.get(0), "Clicking on '" + amt + "' ILS button");
                break;

            case "200ILS":
                clickOnElement(amountButton.get(1), "Clicking on '" + amt + "' ILS button");
                break;

            case "400ILS":
                clickOnElement(amountButton.get(2), "Clicking on '" + amt + "' ILS button");
                break;

            case "600ILS":
                clickOnElement(amountButton.get(3), "Clicking on '" + amt + "' ILS button");
                break;

            default:
                setAmt(amt);

        }
        return amt.replaceAll("ILS", "");

    }

    public boolean isConfBtnPresent() {
        return driver.findElements(By.id("swip_btn_text")).size() > 0;
    }

    public boolean isClickOnSubmitButtonDisplayed() {
        return driver.findElements(By.id("submit_button")).size() > 0;
    }

    public boolean isAtmCashoutPresent() {
        return driver.findElements(By.id("add_services")).size() > 0;
    }

    public boolean isHomeBtnPresent() {
        return driver.findElements(By.id("home_button")).size() > 0;
    }


    public double userBalance() {
        String balance = walletBalance.getText();

        balance = balance.replace("ILS ", " ");
        balance = balance.trim();
        System.out.println("STRING :" + balance);
        double j = Double.parseDouble(balance);
        System.out.println("INTEGER :" + j);
        return j;
    }

    public boolean isSnackbarDisplayed() {
        return driver.findElements(By.id("snackbar_text")).size() > 0;
    }

    public  String getErrMsg() {
            isElementNotPresent(snackbar_text);
            return snackbar_text.getText();
        }


}

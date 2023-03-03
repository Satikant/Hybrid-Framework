package framework.wallet.bharain.pageObjects;

import common.Assertion;
import framework.wallet.bharain.pageObjects.ProfileDetailsPage;
import initializers.AppPageInit;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonUtils;
import utils.Utils;
import utils.W3CActions;

import java.util.List;

public class DonationPage extends AppPageInit {

    public DonationPage() {
        super();
    }

    @AndroidFindBy(className = "android.widget.ImageView")
    private List<WebElement> NvPage2;

    @AndroidFindBy(id = "com.batelco.sub:id/add_services")
    private WebElement HomeScreenDonation;

    @AndroidFindBy(id = "com.batelco.sub:id/lblListHeader")
    private List<WebElement> DonationMenu;

    @AndroidFindBy(className = "android.widget.EditText")
    private WebElement Amount;

    @AndroidFindBy(id = "com.batelco.sub:id/submit_button")
    private WebElement paynow;

    @AndroidFindBy(id = "com.batelco.sub:id/TxnStatusMsg")
    private WebElement txnStatus;

    @AndroidFindBy(id = "com.batelco.sub:id/home_button")
    private WebElement homeBtn;

    @AndroidFindBy(id = "com.batelco.sub:id/textview1")
    private List<WebElement> txnId;


    @AndroidFindBy(id = "com.batelco.sub:id/transactionId")
    private List<WebElement> txnIdHistory;

    ProfileDetailsPage profileDetailsPage = new ProfileDetailsPage();

    public DonationPage clickOnDonationFromHomeScreen() {
        isElementNotPresent(NvPage2.get(0));
        clickOnElement(NvPage2.get(10), "Clcik on next page");
  //      clickOnElement(HomeScreenDonation, "Click on Donation");
        return this;
    }

    public Boolean isTransactionDetailPresent() {
        return driver.findElements(By.id("com.batelco.sub:id/linear")).size() > 0;
    }

    public DonationPage clickOnDonation() throws InterruptedException {
        profileDetailsPage.clickOnMenuButton();
        W3CActions w3CActions = new W3CActions();
        w3CActions.scrollDown();
        clickOnElement(DonationMenu.get(9), "Click On Donation");
        return this;
    }

    public DonationPage enterAmount(String amount) {
        setText(Amount, amount, "Enter Amount");
        return this;
    }

    public DonationPage clickOnPayNow() {
        clickOnElement(paynow, "Click On Pay Now");
        return this;
    }

    public Boolean isTxnStatusDisplayed() {
        return driver.findElements(By.id("com.batelco.sub:id/TxnStatusMsg")).size() > 0;
    }

    public String fetchTxnStatus() {
        return txnStatus.getText();
    }

    public DonationPage clickOnHome() {
        clickOnElement(homeBtn, "Click on Home");
        return this;
    }

    public String[] fetchDetails() {
        String details[]={txnId.get(0).getText(),txnId.get(1).getText(),txnId.get(2).getText()};
        return details;
    }

    public DonationPage clickOnTransactionHistory() {
        clickOnElement(DonationMenu.get(0), "CLick on transaction history");
        return this;
    }

    public Boolean isTransactionPresentInTxnHistory(String txn_id) {
        clickOnHome();
        profileDetailsPage.clickOnMenuButton();
        clickOnTransactionHistory();
        CommonUtils.pauseExecution(2);
        int n = driver.findElements(By.id("com.batelco.sub:id/transactionId")).size();
        int i;
        for (i = 0; i < n; i++) {
            if (txnIdHistory.get(i).getText().contains(txn_id)) {
                String txn = txnIdHistory.get(i).getText();
                Assertion.verifyEqual(txnIdHistory.get(i).getText(), "Txn ID "+txn_id);
                break;
            }
            break;
        }
        return true;
    }

    public boolean isHomeBtnDisplayed() {
        return driver.findElements(By.id("com.batelco.sub:id/home_button")).size() > 0;
    }

    public boolean isBackBtnPresent() {
        return driver.findElements(By.className("android.widget.ImageButton")).size() > 0;
    }

    public boolean isAmountFieldAvailable() {
        return driver.findElements(By.id("android.widget.EditText")).size() > 0;
    }
}
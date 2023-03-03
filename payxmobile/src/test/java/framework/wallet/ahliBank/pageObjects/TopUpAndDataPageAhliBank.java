package framework.wallet.ahliBank.pageObjects;


import globalConstants.Config;
import initializers.AppPageInit;


import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TopUpAndDataPageAhliBank extends AppPageInit{

    public TopUpAndDataPageAhliBank(){
        super();
    }

    @AndroidFindBy(id = "com.ahlibank.ahlipay.subscriber.uat:id/imgService")
    private List<WebElement> selectBillPay;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.subscriber.uat:id/tvProviderTitle")
    private List<WebElement> selectBiller;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/tvItemName")
    private List<WebElement> selectService;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/rechargeTopupSpinnerOoredoo")
    private WebElement amtDropdown;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/etRechargeMobileNumber")
    private WebElement etRechargeMobileNumber;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/planItem")
    private List<WebElement> selectAmount;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/etRechargeNickName")
    private WebElement etRechargeNickName;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.subscriber.uat:id/i_accept_checked_view")
    private WebElement terms_cond ;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.subscriber.uat:id/btnSubmit")
    private WebElement btnSubmit ;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/dataPackItemLayout")
    private List<WebElement> selectPackage;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.subscriber.uat:id/etDataRechargeNickName")
    private WebElement dataRechargeNickName ;


    public TopUpAndDataPageAhliBank clickOnTopUpAndData(){
        isElementNotPresent(selectBillPay.get(1));
        clickOnElement(selectBillPay.get(3),"Data And Top UP");
        return this;
    }

    public void selectBiller(String billpaymethod) throws InterruptedException {
        isElementNotPresent(selectBiller.get(0));
        switch (billpaymethod) {

            case "OOREDOO":
                clickOnElement(selectBiller.get(0),"Ooredo");
                break;

            case "VODAFONE":
                clickOnElement(selectBiller.get(1),"Vodafone");
                break;

            default:
                throw new UnsupportedOperationException(billpaymethod+":- This method is not supported");
        }
    }

    public TopUpAndDataPageAhliBank clickOnTopUp(){
        isElementNotPresent(selectService.get(0));
        clickOnElement(selectService.get(0),"Top Up");
        return this;
    }


    public TopUpAndDataPageAhliBank clickOnDataRecharge(){
        clickOnElement(selectService.get(2),"Data Recharge");
        return this;
    }

    public TopUpAndDataPageAhliBank setMsisdn(String msisdn)
    {
        setText(etRechargeMobileNumber,msisdn,"Top up number");
        return this;
    }

    public TopUpAndDataPageAhliBank clickOnAmountField(){
        clickOnElement(amtDropdown,"Amount Field");
        return this;
    }

    public TopUpAndDataPageAhliBank selectAmount(int i){
        clickOnElement(selectAmount.get(0),"Add Favourite Transaction");
        return this;
    }

    public TopUpAndDataPageAhliBank setNickname(String nickname)
    {
        setText(etRechargeNickName,nickname,"Nickname");
        return this;
    }

    public TopUpAndDataPageAhliBank clickOnTermsCondition(){
        if(Config.isTermsAndCondNonClickable){
            Config.setTermsAndCondNonClickable();
        }
        else{
            if(!terms_cond.isSelected()){
                clickOnElement(terms_cond,"Terms and condition");
            }
        }
        return this;
    }

    public TopUpAndDataPageAhliBank clickOnSubmit(){
        clickOnElement(btnSubmit,"Submit Button");
        return this;
    }

    public TopUpAndDataPageAhliBank clickOnTopUpAndDataPack(int i){
        isElementNotPresent(selectPackage.get(0));
        clickOnElement(selectPackage.get(i),"Data Pack");
        return this;
    }

    public TopUpAndDataPageAhliBank setDataRechargeNickname(String nickname)
    {
        setText(dataRechargeNickName,nickname,"Nickname");
        return this;
    }

}

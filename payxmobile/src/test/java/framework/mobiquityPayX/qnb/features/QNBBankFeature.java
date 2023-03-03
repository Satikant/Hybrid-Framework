package framework.mobiquityPayX.qnb.features;

import framework.mobiquityPayX.qnb.pageObjects.QNBBankPageObjects;
import framework.mobiquityPayX.qnb.pageObjects.QNBHomePageObjects;

public class QNBBankFeature {
    QNBBankPageObjects qnbBankPageObjects = new QNBBankPageObjects();
    QNBLoginFeature qnbLoginFeature = new QNBLoginFeature();
    QNBHomePageObjects qnbHomePageObjects = new QNBHomePageObjects();

    public void addBank(String msisdn, String pin, String otp){
        qnbLoginFeature.login(msisdn,pin,otp);
        qnbHomePageObjects.clickOnToolBarIcon()
                .clickOnPaymentsMethod();
        qnbBankPageObjects.clickOnAddBank()
                .clickOnFirstBank() //Todo verify links
//                OTP
                .clickOnAssociateBank();
    }

    public String viewBankBalance(String msisdn, String pin, String otp,int index){
        qnbLoginFeature.login(msisdn,pin,otp);
        qnbHomePageObjects.clickOnToolBarIcon()
                .clickOnPaymentsMethod();
        String bankBalanceAmt= qnbBankPageObjects.selectBankWithIndex(index)
                .clickOnCheckBalance()
                .getBankBalanceAmt();
        qnbBankPageObjects.clickOnBalanceOkBtn();
        return bankBalanceAmt;
    }

    public void removeBankWithIndex(String msisdn, String pin, String otp,int index){
        qnbLoginFeature.login(msisdn,pin,otp);
        qnbHomePageObjects.clickOnToolBarIcon()
                .clickOnPaymentsMethod();
        qnbBankPageObjects.selectBankWithIndex(index)
                .clickOnRemoveBank()
                .clickOnRemoveBankOkBtn();
    }


}

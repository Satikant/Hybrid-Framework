package framework.mobiquityPayX.qnb.features;

import framework.mobiquityPayX.qnb.pageObjects.QNBHomePageObjects;
import framework.mobiquityPayX.qnb.pageObjects.QNBLoginPageObjects;

public class QNBLogoutFeature {
    QNBLoginFeature loginFeature = new QNBLoginFeature();
    QNBHomePageObjects homePageObjects = new QNBHomePageObjects();

    public void logout(String msisdn, String pin, String otp){
        loginFeature.login(msisdn,pin,otp);
        homePageObjects.clickOnToolBarIcon()
                .clickOnLogoutOption();

    }



}

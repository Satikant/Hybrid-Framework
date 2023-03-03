package framework.wallet.bharain.features;

import framework.wallet.bharain.pageObjects.LoginPageBharain;
import framework.wallet.bharain.pageObjects.ProfileDetailsPage;
import globalConstants.Config;
import utils.CommonUtils;


/**
 * Created by ayush.singh on 09-12-2019.
 */
public class ProfileDetailsFeature {
    static ProfileDetailsPage profileDetailsPage=new ProfileDetailsPage();

    public static void logOut() {
        profileDetailsPage.clickOnMenuButton();
        CommonUtils.pauseExecution(2);
        profileDetailsPage.clickOnLogOut();
        Config.isFirstTimeLogin=true;
    }
}
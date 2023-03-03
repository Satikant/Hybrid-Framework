package framework.wallet.bankMuscat.features;


import framework.wallet.bharain.pageObjects.ProfileDetailsPage;

public class ProfileDetailsFeature {
    static ProfileDetailsPage profileDetailsPage=new ProfileDetailsPage();

    public static void logOut(){
        profileDetailsPage.clickOnMenuButton().clickOnLogOut();
    }

}


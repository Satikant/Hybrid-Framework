package globalConstants;

/**
 * Created by ayush.singh on 09-10-2019.
 */
public class Config {

    public static boolean isFirstTimeLogin = true;
    public static int chaneLanguageCounter = 0;
    public static boolean isAssertionRequired = true;
    public static boolean isSendMoneySuccess = true;
    public static boolean FirstTimeLogin = false;
    public static boolean toastCheck = false;
    public static boolean checkSufficientBalance = false;
    public static boolean isBillEnquiryReuired = false;
    public static boolean isTermsAndCondNonClickable = true;
    public static boolean isForgotSecurityPresent = false;
    public static boolean isDeleteMember = false;
    public static boolean checkNotification = false;
    public static boolean isOtpPositiveAction = true;
    public static boolean isOtpRetry = false;
    public static boolean isFavouriteTransactionCheck = false;
    public static boolean isMultipleOtpValidationCheck = false;
    public static boolean isAssertionRequiredCheck = false;
    public static boolean isSelectContactFromList = false;
    public static boolean isOtpCancel = false;
    //  public static boolean isOtpCancelConfirm=false;
    public static boolean PositiveloginCase = false;
    public static boolean isOneMemberPresent = false;
    public static boolean isClearFieldTrue = false;

    public static boolean isValidationRequired = false;
    public static boolean isLoginWithDifferentMsisdnRequired = false;

    public static boolean isRetryOptionRequired = false;

    public static String userStatus = "";


    public static void setClearFieldFalse() {
        isClearFieldTrue = false;
    }

    public static void setFirstTimeLoginFalse() {
        isFirstTimeLogin = false;
        chaneLanguageCounter++;
    }

    public static void setIsSendMoneySuccessFalse() {
        isSendMoneySuccess = false;
    }

    public static void setCheckSufficientBalance() {
        checkSufficientBalance = false;
    }

    public static void setIsSendMoneySuccessTrue() {
        isSendMoneySuccess = true;
    }

    public static void FirstTimeLoginFalse() {
        isFirstTimeLogin = false;
    }

    public static void setToastCheckFalse() {
        toastCheck = false;
    }

    public static void setToastCheckTrue() {
        toastCheck = true;
    }

    public static void setTermsAndCondNonClickable() {
        isTermsAndCondNonClickable = false;
    }

    public static void setTermsAndCondClickable() {
        isTermsAndCondNonClickable = true;
    }

    public static void setOTPcancel() {
        isOtpCancel = true;
    }

    public static void setOTPnotcancel() {
        isOtpCancel = false;
    }

    public static void setBillEnquiryFalse() {
        isBillEnquiryReuired = false;
    }

    public static void setIsForgotSecurityPresent() {
        isForgotSecurityPresent = false;
    }

    public static void setOtpPositiveActionTrue() {
        isOtpPositiveAction = true;
    }

    public static void setOtpRetryFalse() {
        isOtpRetry = false;
    }

    public static void setAssertionRequiredCheckFalse() {
        isAssertionRequiredCheck = false;
    }

    public static void setFavouriteTransactionCheckFalse() {
        isFavouriteTransactionCheck = false;
    }

    public static void setMultipleOtpValidationCheckFalse() {
        isMultipleOtpValidationCheck = false;
    }

    public static void setPositiveLoginFalse() {
        PositiveloginCase = false;
    }

    public static void setFalsePinValidationRequired() {
        isValidationRequired = false;
    }

    public static void setLoginWithDifferentMsisdnRequired(){
        isLoginWithDifferentMsisdnRequired = false;
        userStatus = "";
    }

    public static void setRetryOptionRequiredFalse() {
        isRetryOptionRequired = false;
    }

}

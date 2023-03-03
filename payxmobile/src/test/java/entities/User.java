package entities;

public abstract class User {

    private String salutation, firstName , lastName, idNo , externalCode, email, password, confirmPassword;
    private int msisdn =77232323;
    private String proofType1, proofType2, proofType3 ;
    private WebGroupRole webGroupRole;


    User(){

    }

    public Integer getMsisdn(){
        return this.msisdn;
    }

    public void setGeneralDetails(){

    }

    public void setDomainCategoryDetails(){

    }

    public abstract void writeDataToExcel(User user);

}

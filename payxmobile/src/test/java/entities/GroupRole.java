package entities;

import java.util.List;

public abstract class GroupRole {

    protected String domainName,domainCode,categoryName,categoryCode,gradeName,gradeCode;

    protected String roleType,roleName;
    //protected String roleName;
    protected String provider;
    protected String paymentInstrument;
    protected String paymentInstrumentType;
    protected String paymentInstrumentTypeId;
    protected String remarks ;
    protected boolean isCreated,isActive;
    protected List<String> applicableRoles;

    public abstract void setGroupRoleDetails();
    public abstract void writeDataToExcel();

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getDomainCode() {
        return domainCode;
    }

    public void setDomainCode(String domainCode) {
        this.domainCode = domainCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public String getGradeCode() {
        return gradeCode;
    }

    public void setGradeCode(String gradeCode) {
        this.gradeCode = gradeCode;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getPaymentInstrument() {
        return paymentInstrument;
    }

    public void setPaymentInstrument(String paymentInstrument) {
        this.paymentInstrument = paymentInstrument;
    }

    public String getPaymentInstrumentType() {
        return paymentInstrumentType;
    }

    public void setPaymentInstrumentType(String paymentInstrumentType) {
        this.paymentInstrumentType = paymentInstrumentType;
    }

    public String getPaymentInstrumentTypeId() {
        return paymentInstrumentTypeId;
    }

    public void setPaymentInstrumentTypeId(String paymentInstrumentTypeId) {
        this.paymentInstrumentTypeId = paymentInstrumentTypeId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public boolean isCreated() {
        isCreated = false;
        return isCreated;
    }
}

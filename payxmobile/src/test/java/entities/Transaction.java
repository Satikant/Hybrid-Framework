package entities;

public class Transaction {

    private String serviceType;
    private String description;
    private int amount;
    private User payer,payee;

    public Transaction(){
        setAmount(1);
        setDescription("Automation");
    }

    public Transaction(String serviceType,User payerObj,User payeeObj){
        setPayer(payerObj);
        setPayee(payeeObj);
        setServiceType(serviceType);
    }



    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public Integer getAmount(int amount) {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getPayer() {
        return payer;
    }

    public void setPayer(User payer) {
        this.payer = payer;
    }

    public User getPayee() {
        return payee;
    }

    public void setPayee(User payee) {
        this.payee = payee;
    }





}

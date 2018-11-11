package in.co.myrupee.constant;

public enum AccountType {

    C_SAVINGS("C_SAVINGS", "Customer savings account"),
    C_CURRENT("C_CURRENT", "Customer current account"),
    M_SAVINGS("M_SAVINGS", "Merchant savings account"),
    M_CURRENT("M_CURRENT", "Merchant current account");


    String type;
    String description;

    private AccountType(String code, String description) {

        this.type = code;
        this.description = description;
    }


    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

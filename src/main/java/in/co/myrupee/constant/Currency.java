package in.co.myrupee.constant;

public enum  Currency {

    INR("INR", "Indian Rupee"),
    USD("USD", "US Dollar"),
    ZAR("ZAR", "African Rand"),
    CNY("CNY", "Yuan Renminbi"),
    AUD("AUD", "Australian Dollar"),
    GBP("GBP","Pound Sterling");


    String ISOCode;
    String description;

    private Currency(String ISOCode, String description) {

        this.ISOCode = ISOCode;
        this.description = description;
    }


    public String getDescription() {
        return description;
    }

    public String getISOCode() {
        return ISOCode;
    }


}

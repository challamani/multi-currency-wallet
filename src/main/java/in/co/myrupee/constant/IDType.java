package in.co.myrupee.constant;

public enum IDType {

    PASSPORT("PASSPORT", "Country passport"),
    DRIVING_LICENCE("DRIVING_LICENCE", "Driving Licence"),
    UAN("UAN", "Universal account number"),
    PAN("PAN", "Personal account number");


    String type;
    String description;

    private IDType(String code, String description) {

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

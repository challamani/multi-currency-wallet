package in.co.myrupee.constant;

public enum ResponseCode {

    SUCCESS("SUCCESS", "Successfully Created"),
    INVALID_TOKEN("INVALID_CREDENTIALS", "Verify the credentials."),
    INVALID_CREDENTIALS("INVALID_CREDENTIALS", "Verify the credentials."),
    NO_SUCH_USER("SYSTEM_USER_NOT_FOUND", "System user not found."),
    SYSTEM_MALFUNCTION("SYSTEM_MALFUNCTION", "System Exception."),
    NO_RESOURCE_FOUND("NO_RESOURCE_FOUND","Request content not available."),
    NO_SERVICE_AVAIL("NO_SERVICE_AVAIL","Requested service not available.");

    String response;
    String description;

    private ResponseCode( String response, String description) {
        this.response = response;
        this.description = description;
    }

    @Override
    public String toString() {
        return "{" +
                ",\"response\":\"" + response + '\"' +
                ",\"description\":\"" + description + '\"' +
                "}";
    }


    public String getResponse() {
        return response;
    }

    public String getDescription() {
        return description;
    }
}

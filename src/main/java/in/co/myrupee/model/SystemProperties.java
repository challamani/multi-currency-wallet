package in.co.myrupee.model;

import java.util.HashMap;

public class SystemProperties {

    private HashMap<String,String> serviceCodes;
    private HashMap<String,String> systemCredentials;

    public HashMap<String, String> getServiceCodes() {
        return serviceCodes;
    }

    public void setServiceCodes(HashMap<String, String> serviceCodes) {
        this.serviceCodes = serviceCodes;
    }

    public HashMap<String, String> getSystemCredentials() {
        return systemCredentials;
    }

    public void setSystemCredentials(HashMap<String, String> systemCredentials) {
        this.systemCredentials = systemCredentials;
    }
}

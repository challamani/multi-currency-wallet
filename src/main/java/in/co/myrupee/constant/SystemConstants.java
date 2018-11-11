package in.co.myrupee.constant;

public class SystemConstants {

    public static final String BAD_REQUEST = "BAD_REQUEST";
    public static final String ACCOUNT_ACTIVE_STATUS = "ACTIVE";
    public static final String ACCOUNT_BLOCKED_STATUS = "BLOCKED";
    public static final String ACCOUNT_PENDING_STATUS = "PENDING";
    public static final String ACCOUNT_DECLINED_STATUS = "DECLINED";

    public static final String ACC_TYPE_SAVING = "SAVINGS";
    public static final String ACC_TYPE_CURRENT = "CURRENT";
    public static final Integer TOKEN_LIFE_TIME = 3600000;

    public static final String V_CARD_INR = "1000";
    public static final String V_CARD_USD = "2000";
    public static final String V_CARD_GBP = "3000";
    public static final String V_CARD_ZAR = "4000";

    public static final String SET_PIN_RESOURCE = "http://localhost:8080/mywallet/api/v1/setSuperPin/";
    public static final String CREATE_ACCOUNT_TEMPLATE="Account %s has created successfully, please use reference link to set the super-pin";
    public static final String PIN_ACTION_SUCCESS=", stored as a message digest, now you can perform transactions by using active tokens.";

}

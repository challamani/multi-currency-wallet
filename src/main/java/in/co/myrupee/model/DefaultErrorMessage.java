package in.co.myrupee.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * DefaultErrorMessage
 */

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DefaultErrorMessage {

    @JsonProperty("transmissionDateTime")
    private String transmissionDateTime = null;

    @JsonProperty("messageID")
    private String messageID = null;

    @JsonProperty("responseCode")
    private String responseCode = null;

    @JsonProperty("responseText")
    private String responseText = null;



    public DefaultErrorMessage(String transmissionDateTime, String messageID,  String responseCode, String responseText) {
        this.transmissionDateTime = transmissionDateTime;
        this.messageID = messageID;
        this.responseCode = responseCode;
        this.responseText = responseText;
    }
    public DefaultErrorMessage(){}

    public String getTransmissionDateTime() {
        return transmissionDateTime;
    }

    public void setTransmissionDateTime(String transmissionDateTime) {
        this.transmissionDateTime = transmissionDateTime;
    }

    public String getMessageID() {
        return messageID;
    }

    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseText() {
        return responseText;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }
}


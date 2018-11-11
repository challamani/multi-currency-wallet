package in.co.myrupee.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountAuthInfoBO {

    @JsonProperty("loginId")
    private String username;

    @JsonProperty("description")
    private String description;

    @JsonProperty("expiryDate")
    private String pinExpiryDate;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPinExpiryDate() {
        return pinExpiryDate;
    }

    public void setPinExpiryDate(String pinExpiryDate) {
        this.pinExpiryDate = pinExpiryDate;
    }


}

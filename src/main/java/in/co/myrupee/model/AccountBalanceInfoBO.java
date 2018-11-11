package in.co.myrupee.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountBalanceInfoBO {

    @JsonProperty("currencyCode")
    private String currencyCode;

    @JsonProperty("balance")
    private BigDecimal balance;

    @JsonProperty("description")
    private String description;

    @JsonProperty("createdOn")
    private Date createdOn;

    @JsonProperty("virtualCard")
    private String virtualCard;

    @JsonProperty("walletStatus")
    private String walletStatus;

    public AccountBalanceInfoBO(){

    }

    public AccountBalanceInfoBO(String currencyCode, BigDecimal balance, String description, Date createdOn, String virtualCard, String walletStatus) {
        this.currencyCode = currencyCode;
        this.balance = balance;
        this.description = description;
        this.createdOn = createdOn;
        this.virtualCard = virtualCard;
        this.walletStatus = walletStatus;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getVirtualCard() {
        return virtualCard;
    }

    public void setVirtualCard(String virtualCard) {
        this.virtualCard = virtualCard;
    }

    public String getWalletStatus() {
        return walletStatus;
    }

    public void setWalletStatus(String walletStatus) {
        this.walletStatus = walletStatus;
    }
}

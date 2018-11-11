package in.co.myrupee.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountBO {

    @JsonProperty("profileName")
    private String profileName;

    @JsonProperty("accountNumber")
    private String accountNumber;

    @JsonProperty("msisdn")
    private String msisdn;

    @JsonProperty("accountType")
    private String accountType;

    @JsonProperty("status")
    private String status;

    @JsonProperty("createdOn")
    private Date createdOn;

    @JsonProperty("email")
    private String email;

    @JsonProperty("firstname")
    private String firstname;

    @JsonProperty("lastname")
    private String lastname;

    @JsonProperty("birthCountryCode")
    private String birthCountryCode;


    public AccountBO(){

    }

    @JsonProperty("IDInfoList")
    private List<AccountHolderIDInfoBO> accountHolderIDInfos;

    @JsonProperty("addressList")
    private List<AccountHolderAddressBO> accountHolderAddresses;

    @JsonProperty("balanceInfoList")
    private List<AccountBalanceInfoBO> accountBalanceInfoBOS;

    @JsonProperty("LoginInfo")
    private AccountAuthInfoBO accountAuthInfoBO;

    public AccountAuthInfoBO getAccountAuthInfoBO() {
        return accountAuthInfoBO;
    }

    public void setAccountAuthInfoBO(AccountAuthInfoBO accountAuthInfoBO) {
        this.accountAuthInfoBO = accountAuthInfoBO;
    }

    @NotNull
    @Pattern(regexp="^[a-zA-Z0-9]{8,20}$")
    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @NotNull
    @Pattern(regexp="^[0-9]{10,13}$")
    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    @NotNull
    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    @NotNull
    @Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NotNull
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @NotNull
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @NotNull
    public String getBirthCountryCode() {
        return birthCountryCode;
    }

    public void setBirthCountryCode(String birthCountryCode) {
        this.birthCountryCode = birthCountryCode;
    }

    @NotNull
    public List<AccountHolderIDInfoBO> getAccountHolderIDInfos() {
        return accountHolderIDInfos;
    }

    public void setAccountHolderIDInfos(List<AccountHolderIDInfoBO> accountHolderIDInfoBOS) {
        this.accountHolderIDInfos = accountHolderIDInfoBOS;
    }

    @NotNull
    public List<AccountHolderAddressBO> getAccountHolderAddresses() {
        return accountHolderAddresses;
    }

    public void setAccountHolderAddresses(List<AccountHolderAddressBO> accountHolderAddressBOS) {
        this.accountHolderAddresses = accountHolderAddressBOS;
    }

    @NotNull
    public List<AccountBalanceInfoBO> getAccountBalanceInfoBOS() {
        return accountBalanceInfoBOS;
    }

    public void setAccountBalanceInfoBOS(List<AccountBalanceInfoBO> accountBalanceInfoBOS) {
        this.accountBalanceInfoBOS = accountBalanceInfoBOS;
    }


    @Override
    public String toString() {
        return "AccountBO{" +
                "profileName='" + profileName + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", msisdn='" + msisdn + '\'' +
                ", accountType='" + accountType + '\'' +
                ", status='" + status + '\'' +
                ", createdOn=" + createdOn +
                ", email='" + email + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthCountryCode='" + birthCountryCode + '\'' +
                ", accountHolderIDInfos=" + accountHolderIDInfos +
                ", accountHolderAddresses=" + accountHolderAddresses +
                ", accountBalanceInfoBOS=" + accountBalanceInfoBOS +
                ", accountAuthInfoBO=" + accountAuthInfoBO +
                '}';
    }
}
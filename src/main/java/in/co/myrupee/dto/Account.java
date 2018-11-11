package in.co.myrupee.dto;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="account")
public class Account implements Serializable {

    private static final long serialVersionUID = -1604333737340047541L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "profile_name")
    private String profileName;

    @Column(name="account_number")
    private String accountNumber;

    @Column(name="msisdn")
    private String msisdn;

    @Column(name="account_type")
    private String accountType;

    @Column(name="status")
    private String status;

    @Column(name="created_on")
    private Date createdOn;

    @Column(name="email")
    private String email;

    @Column(name="firstname")
    private String firstname;

    @Column(name="lastname")
    private String lastname;

    @Column(name="birth_country_code")
    private String countryCode;


    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "account")
    private Set<AccountHolderIDInfo> accountHolderIDInfos;


    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "account")
    private Set<AccountBalanceInfo> accountBalanceInfos;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "account")
    private Set<AccountHolderAddress> accountHolderAddresses;


    @OneToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "account")
    private AccountAuthInfo accountAuthInfo;

    public AccountAuthInfo getAccountAuthInfo() {
        return accountAuthInfo;
    }

    public void setAccountAuthInfo(AccountAuthInfo accountAuthInfo) {
        this.accountAuthInfo = accountAuthInfo;
    }

    public Account() {
        createdOn = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

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


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Set<AccountHolderIDInfo> getAccountHolderIDInfos() {
        return accountHolderIDInfos;
    }

    public void setAccountHolderIDInfos(Set<AccountHolderIDInfo> accountHolderIDInfos) {
        this.accountHolderIDInfos = accountHolderIDInfos;
    }

    public Set<AccountBalanceInfo> getAccountBalanceInfos() {
        return accountBalanceInfos;
    }

    public void setAccountBalanceInfos(Set<AccountBalanceInfo> accountBalanceInfos) {
        this.accountBalanceInfos = accountBalanceInfos;
    }

    public Set<AccountHolderAddress> getAccountHolderAddresses() {
        return accountHolderAddresses;
    }

    public void setAccountHolderAddresses(Set<AccountHolderAddress> accountHolderAddresses) {
        this.accountHolderAddresses = accountHolderAddresses;
    }
}

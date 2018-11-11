package in.co.myrupee.dto;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="account_holder_idinfo")
public class AccountHolderIDInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="idnumber")
    private String idNumber;

    @Column(name="country_code")
    private String countryCode;

    @Column(name="issued_date")
    private Date issuedDate;

    @Column(name="expired_date")
    private Date expiredDate;

    @Column(name="issued_place")
    private String issuedPlace;

    @Column(name="created_on")
    private Date createdOn;

    @Column(name="idtype")
    private String idType;

    @ManyToOne
    @JoinColumn(name = "account_id",referencedColumnName="id")
    private Account account;
    public AccountHolderIDInfo() {
        createdOn = new Date();
    }

    public AccountHolderIDInfo(String idNumber, String countryCode, Date issuedDate, Date expiredDate, String issuedPlace, Date createdOn, String idType, Account account) {
        this.idNumber = idNumber;
        this.countryCode = countryCode;
        this.issuedDate = issuedDate;
        this.expiredDate = expiredDate;
        this.issuedPlace = issuedPlace;
        this.createdOn = createdOn;
        this.idType = idType;
        this.account  = account;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public String getIssuedPlace() {
        return issuedPlace;
    }

    public void setIssuedPlace(String issuedPlace) {
        this.issuedPlace = issuedPlace;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }


    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    @Override
    public String toString() {
        return "AccountHolderIDInfoBO{" +
                "idNumber='" + idNumber + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", issuedDate=" + issuedDate +
                ", expiredDate=" + expiredDate +
                ", issuedPlace='" + issuedPlace + '\'' +
                ", createdOn=" + createdOn +
                ", idType='" + idType + '\'' +
                '}';
    }
}

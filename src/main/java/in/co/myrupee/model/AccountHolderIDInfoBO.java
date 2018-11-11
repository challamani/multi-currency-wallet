package in.co.myrupee.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountHolderIDInfoBO {

    @JsonProperty("idNumber")
    private String idNumber;
    @JsonProperty("countryCode")
    private String countryCode;
    @JsonProperty("issuedDate")
    private Date issuedDate;
    @JsonProperty("expiredDate")
    private Date expiredDate;
    @JsonProperty("issuedPlace")
    private String issuedPlace;


    private Date createdOn;

    @JsonProperty("idType")
    private String idType;

    public AccountHolderIDInfoBO() {

    }

    public AccountHolderIDInfoBO(String idNumber, String countryCode, Date issuedDate, Date expiredDate, String issuedPlace, Date createdOn, String idType) {
        this.idNumber = idNumber;
        this.countryCode = countryCode;
        this.issuedDate = issuedDate;
        this.expiredDate = expiredDate;
        this.issuedPlace = issuedPlace;
        this.createdOn = createdOn;
        this.idType = idType;
    }

    @NotNull
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    @NotNull
    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }
    @NotNull
    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }
    @NotNull
    public String getIssuedPlace() {
        return issuedPlace;
    }

    public void setIssuedPlace(String issuedPlace) {
        this.issuedPlace = issuedPlace;
    }
    @NotNull
    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
    @NotNull
    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
    @NotNull
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

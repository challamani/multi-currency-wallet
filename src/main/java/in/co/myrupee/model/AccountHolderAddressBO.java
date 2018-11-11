package in.co.myrupee.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountHolderAddressBO {

    @JsonProperty("street")
    private String street;
    @JsonProperty("buildingNo")
    private String buildingNo;
    @JsonProperty("pinCode")
    private String pinCode;
    @JsonProperty("district")
    private String district;
    @JsonProperty("landmark")
    private String landmark;
    @JsonProperty("addressType")
    private String addressType;
    @JsonProperty("state")
    private String state;

    public AccountHolderAddressBO(){}

    public AccountHolderAddressBO(String street, String buildingNo, String pinCode, String district, String landmark, String addressType, String state) {
        this.street = street;
        this.buildingNo = buildingNo;
        this.pinCode = pinCode;
        this.district = district;
        this.landmark = landmark;
        this.addressType = addressType;
        this.state = state;
    }

    @NotNull
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @NotNull
    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    @NotNull
    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @NotNull
    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    @NotNull
    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    @NotNull
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @NotNull
    public String getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(String buildingNo) {
        this.buildingNo = buildingNo;
    }
}

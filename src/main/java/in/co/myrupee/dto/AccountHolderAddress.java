package in.co.myrupee.dto;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="account_holder_address")
public class AccountHolderAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="street")
    private String street;

    @Column(name="building_no")
    private String buildingNo;

    @Column(name="pincode")
    private String pincode;

    @Column(name="district")
    private String district;

    @Column(name="landmark")
    private String landmark;

    @Column(name="address_type")
    private String addressType;

    @Column(name="state")
    private String state;

    @Column(name="created_on")
    private Date createdOn;


    @ManyToOne
    @JoinColumn(name = "account_id",referencedColumnName="id")
    private Account account;
    public AccountHolderAddress() {
        createdOn = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(String buildingNo) {
        this.buildingNo = buildingNo;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public AccountHolderAddress(String street, String buildingNo, String pincode, String district, String landmark, String addressType, String state, Date createdOn, Account account) {
        this.street = street;
        this.buildingNo = buildingNo;
        this.pincode = pincode;
        this.district = district;
        this.landmark = landmark;
        this.addressType = addressType;
        this.state = state;
        this.createdOn = createdOn;
        this.account = account;
    }

    @Override
    public String toString() {
        return "AccountHolderAddress{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", buildingNo='" + buildingNo + '\'' +
                ", pincode='" + pincode + '\'' +
                ", district='" + district + '\'' +
                ", landmark='" + landmark + '\'' +
                ", addressType='" + addressType + '\'' +
                ", state='" + state + '\'' +
                ", createdOn=" + createdOn +
                '}';
    }
}

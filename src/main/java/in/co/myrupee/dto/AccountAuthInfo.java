package in.co.myrupee.dto;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="account_auth_info")
public class AccountAuthInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="username")
    private String username;

    @Column(name="super_pin_md5")
    private String superPinMD5;

    @Column(name="created_on")
    private Date createdOn;

    @Column(name="expired_on")
    private Date expiredOn;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false,referencedColumnName="id")
    private Account account;

    public AccountAuthInfo(String username, String superPinMD5, Date createdOn, Date expiredOn, Account account) {
        this.username = username;
        this.superPinMD5 = superPinMD5;
        this.createdOn = createdOn;
        this.expiredOn = expiredOn;
        this.account = account;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public AccountAuthInfo(){}

    public String getSuperPinMD5() {
        return superPinMD5;
    }

    public void setSuperPinMD5(String superPinMD5) {
        this.superPinMD5 = superPinMD5;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }


    public Date getExpiredOn() {
        return expiredOn;
    }

    public void setExpiredOn(Date expiredOn) {
        this.expiredOn = expiredOn;
    }
}

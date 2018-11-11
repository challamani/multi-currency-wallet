package in.co.myrupee.dto;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="account_balance_info")
public class AccountBalanceInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "currency_code")
    private String currencyCode;

    @Column(name = "balance")
    private BigDecimal balance;

    @Column(name = "description")
    private String description;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "virtual_card")
    private String virtualCard;

    @Column(name = "wallet_status")
    private String walletStatus;


    @ManyToOne
    @JoinColumn(name = "account_id",referencedColumnName="id")
    private Account account;


    public AccountBalanceInfo(){}

    @Override
    public String toString() {
        return "AccountBalanceInfo{" +
                "id=" + id +
                ", currencyCode='" + currencyCode + '\'' +
                ", balance=" + balance +
                ", description='" + description + '\'' +
                ", createdOn=" + createdOn +
                ", virtualCard='" + virtualCard + '\'' +
                ", walletStatus='" + walletStatus + '\'' +
                '}';
    }

    public AccountBalanceInfo(String currencyCode, BigDecimal balance, String description, Date createdOn, String virtualCard, String walletStatus,Account account) {
        this.currencyCode = currencyCode;
        this.balance = balance;
        this.description = description;
        this.createdOn = createdOn;
        this.virtualCard = virtualCard;
        this.walletStatus = walletStatus;
        this.account = account;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}

package in.co.myrupee.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountResponseBO {


    @JsonProperty("result")
    private BasicResponseBO basicResponseBO;

    @JsonProperty("accounts")
    private List<AccountBO> accountBOList;


    public AccountResponseBO(BasicResponseBO basicResponseBO, List<AccountBO> accountBOList) {
        this.basicResponseBO = basicResponseBO;
        this.accountBOList = accountBOList;
    }
    public AccountResponseBO(){

    }

    public List<AccountBO> getAccountBOList() {
        return accountBOList;
    }

    public void setAccountBOList(List<AccountBO> accountBOList) {
        this.accountBOList = accountBOList;
    }

    public BasicResponseBO getBasicResponseBO() {
        return basicResponseBO;
    }

    public void setBasicResponseBO(BasicResponseBO basicResponseBO) {
        this.basicResponseBO = basicResponseBO;
    }

    @Override
    public String toString() {
        return "AccountResponseBO{" +
                "basicResponseBO=" + basicResponseBO +
                ", accountBOList=" + accountBOList +
                '}';
    }
}

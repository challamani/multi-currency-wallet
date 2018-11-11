package in.co.myrupee.service;


import in.co.myrupee.model.AccountBO;
import in.co.myrupee.model.AccountResponseBO;

import java.util.List;

public interface AccountService {

    AccountResponseBO createAccount(AccountBO account) throws Exception;

    List<AccountBO> getAccountsByFilter(String filter);

    AccountResponseBO getAccounts() throws Exception;

    AccountBO updateAccount(AccountBO account);

}

package in.co.myrupee.repository;


import in.co.myrupee.dto.Account;
import in.co.myrupee.dto.AccountBalanceInfo;
import in.co.myrupee.dto.AccountHolderIDInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository  extends CrudRepository<Account, Long> {
    Account findByAccountHolderIDInfos(AccountHolderIDInfo accountHolderIDInfo);
    Account findByAccountBalanceInfos(AccountBalanceInfo accountBalanceInfo);
}

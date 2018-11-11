package in.co.myrupee.repository;

import in.co.myrupee.dto.Account;
import in.co.myrupee.dto.AccountAuthInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountAuthInfoRepository extends CrudRepository<AccountAuthInfo, Long> {
    AccountAuthInfo findByAccount(Account account);
    AccountAuthInfo findByUsername(String username);
}

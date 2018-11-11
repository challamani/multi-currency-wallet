package in.co.myrupee.repository;


import in.co.myrupee.dto.AccountBalanceInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountBalanceInfoRepository extends CrudRepository<AccountBalanceInfo, Long> {

    List<AccountBalanceInfo> findByAccountId(long accountId);
}

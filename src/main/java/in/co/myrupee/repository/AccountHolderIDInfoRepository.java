package in.co.myrupee.repository;

import in.co.myrupee.dto.AccountHolderIDInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountHolderIDInfoRepository extends CrudRepository<AccountHolderIDInfo, Long> {

    List<AccountHolderIDInfo> findByAccountId(long accountId);
}

package in.co.myrupee.repository;

import in.co.myrupee.dto.AccountHolderAddress;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountHolderAddressRepository  extends CrudRepository<AccountHolderAddress, Long> {
    List<AccountHolderAddress> findByAccountId(long accountId);
}

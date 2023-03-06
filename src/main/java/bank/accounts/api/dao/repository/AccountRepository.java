package bank.accounts.api.dao.repository;

import bank.accounts.api.dao.entity.Account;
import bank.accounts.api.model.enums.AccountStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findAccountsByStatusActive(AccountStatus status);

    Optional<Account> findAccountByAccountNumber(Long accountNumber);
}

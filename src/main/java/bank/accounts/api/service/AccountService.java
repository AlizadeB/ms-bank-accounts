package bank.accounts.api.service;

import bank.accounts.api.client.CashbackClient;
import bank.accounts.api.client.model.CashbackDto;
import bank.accounts.api.dao.entity.Account;
import bank.accounts.api.dao.repository.AccountRepository;
import bank.accounts.api.exception.AccountNotFoundException;
import bank.accounts.api.exception.constant.ErrorCode;
import bank.accounts.api.mapper.AccountMapper;
import bank.accounts.api.model.dto.AccountCashbackDto;
import bank.accounts.api.model.dto.AccountDto;
import bank.accounts.api.model.enums.AccountStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountService {

    private final static AccountMapper mapper = AccountMapper.ACCOUNT_MAPPER;

    private final AccountRepository accountRepository;

    private final CashbackClient cashbackClient;

    public AccountCashbackDto getAccountCashback(Long accountNumber) {
        Account account = accountRepository.findAccountByAccountNumber(accountNumber).orElseThrow(
                () -> AccountNotFoundException.of(ErrorCode.ACCOUNT_NOT_FOUND, accountNumber)
        );
        CashbackDto cashbackDto = cashbackClient.getCashbackByIban(account.getAccountNumber());
        return mapper.toAccountCashbackDto(cashbackDto, accountNumber);
    }

    public AccountDto getAccountInfo(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(
                () -> AccountNotFoundException.of(ErrorCode.ACCOUNT_NOT_FOUND, id)
        );
        return mapper.toAccountDto(account);
    }

    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return mapper.toAccountDtoList(accounts);
    }

    public void activateAccount(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(
                () -> AccountNotFoundException.of(ErrorCode.ACCOUNT_NOT_FOUND, id)
        );
        account.setStatus(AccountStatus.ACTIVE);
        accountRepository.save(account);
    }

    public void deactivateAccount(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(
                () -> AccountNotFoundException.of(ErrorCode.ACCOUNT_NOT_FOUND, id)
        );
        account.setStatus(AccountStatus.DEACTIVE);
        accountRepository.save(account);
    }

    public List<AccountDto> getActiveAccounts(AccountStatus accountStatus) {
        List<Account> accounts = accountRepository.findAccountsByStatusActive(accountStatus);
        return mapper.toAccountDtoList(accounts);
    }


}

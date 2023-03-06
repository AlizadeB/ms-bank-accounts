package bank.accounts.api.controller;


import bank.accounts.api.model.dto.AccountDto;
import bank.accounts.api.model.enums.AccountStatus;
import bank.accounts.api.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("accounts/")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts() {
        return ResponseEntity.ok().body(accountService.getAllAccounts());
    }

    @GetMapping("{id}")
    public ResponseEntity<AccountDto> getAccountInfo(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(accountService.getAccountInfo(id));
    }

    @GetMapping("{status}")
    public ResponseEntity<List<AccountDto>> getActiveAccounts(@PathVariable AccountStatus accountStatus){
        return ResponseEntity.ok().body(accountService.getActiveAccounts(accountStatus.ACTIVE));
    }

    @PutMapping("{accountId}/activate")
    public ResponseEntity<Void> activateAccount(@PathVariable Long id) {
        accountService.activateAccount(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{accountId}/deactivate")
    public ResponseEntity<Void> deactivateAccount(@PathVariable Long id) {
        accountService.deactivateAccount(id);
        return ResponseEntity.noContent().build();
    }
}

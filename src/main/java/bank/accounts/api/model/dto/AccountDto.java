package bank.accounts.api.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class AccountDto {
    private List<AccountDetail> accounts;
}

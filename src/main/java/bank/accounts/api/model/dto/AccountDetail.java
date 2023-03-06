package bank.accounts.api.model.dto;

import bank.accounts.api.model.enums.AccountStatus;
import lombok.Data;

import java.util.List;

@Data
public class AccountDetail {
    private Long accountNumber;
    private List<Card> activeCards;
    private AccountStatus status;
}

package bank.accounts.api.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountCashbackDto {
    @NotNull
    private Long accountNumber;
    private BigDecimal amount;
    private String currency;
}

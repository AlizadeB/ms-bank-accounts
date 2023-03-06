package bank.accounts.api.model.dto;

import bank.accounts.api.model.enums.Currency;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Card {
    @NotNull
    private LocalDateTime createDate;
    private BigDecimal balance;
    private Currency currency;
}

package bank.accounts.api.dao.entity;

import bank.accounts.api.model.enums.AccountStatus;
import bank.accounts.api.model.enums.Currency;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "account_number")
    private String accountNumber;

    @NotNull
    @Column(name = "balance")
    private BigDecimal balance;

    @NotNull
    @Column(name = "currency")
    private Currency currency;

    @NotNull
    @Column(name = "status")
    private AccountStatus status;

}

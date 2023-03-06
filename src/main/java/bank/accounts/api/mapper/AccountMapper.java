package bank.accounts.api.mapper;

import bank.accounts.api.client.model.CashbackDto;
import bank.accounts.api.dao.entity.Account;
import bank.accounts.api.model.dto.AccountCashbackDto;
import bank.accounts.api.model.dto.AccountDetail;
import bank.accounts.api.model.dto.AccountDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountMapper ACCOUNT_MAPPER = Mappers.getMapper(AccountMapper.class);

    AccountDto toAccountDto(Account account);

    List<AccountDto> toAccountDtoList(List<Account> accounts);

    @Mapping(target = "amount",source = "cashbackDto.amount")
    @Mapping(target = "currency",source = "cashbackDto.currency")
    AccountCashbackDto toAccountCashbackDto(CashbackDto cashbackDto, Long accountNumber);
}

package bank.accounts.api.exception;

import bank.accounts.api.exception.constant.ErrorCode;

import java.text.MessageFormat;

public class AccountNotFoundException extends CommonException {
    public AccountNotFoundException(String message) {
        super(ErrorCode.ACCOUNT_NOT_FOUND, message);
    }

    public static AccountNotFoundException of(String message, Object... args) {
        return new AccountNotFoundException(MessageFormat.format(message, args));
    }
}

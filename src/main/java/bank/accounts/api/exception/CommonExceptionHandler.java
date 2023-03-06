package bank.accounts.api.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static bank.accounts.api.exception.constant.ErrorCode.UNEXPECTED_INTERNAL_ERROR;
import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class CommonExceptionHandler {

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(AccountNotFoundException.class)
    public CommonErrorResponse handleAccountNotFoundException(AccountNotFoundException ex) {
        return new CommonErrorResponse(ex.getErrorCode(), ex.getMessage());
    }

    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public CommonErrorResponse handleAll(Exception ex) {
        ex.printStackTrace();
        String errMsg = "Unexpected internal server error";
        return new CommonErrorResponse(UNEXPECTED_INTERNAL_ERROR, errMsg);
    }
}

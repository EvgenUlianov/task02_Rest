package evgenulianov.task02_rest.advice;

import evgenulianov.task02_rest.service.InvalidCredentials;
import evgenulianov.task02_rest.service.UnauthorizedUser;
import org.springframework.core.annotation.AliasFor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class MyControllerAdvice {

    @AliasFor("evgenulianov.task02_rest")
    @ResponseStatus(HttpStatus.BAD_REQUEST) // 400
    @ExceptionHandler(InvalidCredentials.class)
    public String icHandler(InvalidCredentials exception){
        return exception.getMessage();
    }

    @AliasFor("evgenulianov.task02_rest")
    @ResponseStatus(HttpStatus.UNAUTHORIZED) // 401
    @ExceptionHandler(UnauthorizedUser.class)
    public String uuHandler(UnauthorizedUser exception){
        return exception.getMessage();
    }

    @AliasFor("evgenulianov.task02_rest")
    @ResponseStatus(HttpStatus.BAD_REQUEST) // 400
    @ExceptionHandler(ConstraintViolationException.class)
    public String cveException(ConstraintViolationException e) {
        return "NOT VALIDATED! " + e.getMessage();
    }

}

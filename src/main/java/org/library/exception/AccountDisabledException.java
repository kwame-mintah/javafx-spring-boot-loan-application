package org.library.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "User account is currently disabled")
public class AccountDisabledException extends RuntimeException {
}

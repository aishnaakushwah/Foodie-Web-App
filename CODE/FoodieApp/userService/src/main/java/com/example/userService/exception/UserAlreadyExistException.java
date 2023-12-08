package com.example.userService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT ,reason = "User already present with the same id...")
public class UserAlreadyExistException extends Exception{
}

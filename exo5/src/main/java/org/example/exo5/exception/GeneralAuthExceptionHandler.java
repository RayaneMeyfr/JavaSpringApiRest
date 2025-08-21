package org.example.exo5.exception;

import org.example.exo5.dto.LoginResponseDto;
import org.example.exo5.dto.RegisterResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralAuthExceptionHandler {

  @ExceptionHandler(UserAlreadyExistException.class)
  public ResponseEntity<RegisterResponseDto> handleUserAlreadyExistsEception(UserAlreadyExistException exception) {
    RegisterResponseDto registerResponseDto = new RegisterResponseDto();
    return new ResponseEntity<>(registerResponseDto, HttpStatus.OK);
  }

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<LoginResponseDto> handleNotFoundException(NotFoundException exception) {
    LoginResponseDto loginResponseDto = new LoginResponseDto("NotFound");
    return new ResponseEntity<>(loginResponseDto, HttpStatus.OK);
  }
}

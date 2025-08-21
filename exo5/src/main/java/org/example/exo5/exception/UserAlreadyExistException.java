package org.example.exo5.exception;

public class UserAlreadyExistException extends Exception{
  public UserAlreadyExistException() {
    super("User already exists");
  }
}

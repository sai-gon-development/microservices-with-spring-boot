package com.saigon.development.application.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class ApplicationException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  private HttpStatus httpStatus;

  public ApplicationException(String message) {
    super(message);
  }

  public ApplicationException(String message, HttpStatus httpStatus) {
    super(message);
    this.httpStatus = httpStatus;
  }

}
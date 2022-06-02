package com.saigon.development.application.exceptions;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.saigon.development.application.responses.Notification;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ApplicationExceptionsHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Notification> handleValidationExceptions(MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult().getAllErrors().forEach((error) -> {
      String fieldName = ((FieldError) error).getField();
      String errorMessage = error.getDefaultMessage();
      errors.put(fieldName, errorMessage);
    });

    Notification errorNotification = new Notification(ZonedDateTime.now(), ex.getMessage());
    log.error(ex.getMessage());
    return new ResponseEntity<>(errorNotification, new HttpHeaders(), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(value = { Exception.class })
  public ResponseEntity<Notification> handleOtherExceptions(Exception ex, WebRequest request) {
    Notification errorNotification = new Notification(ZonedDateTime.now(), ex.getMessage());
    log.error(ex.getMessage());
    return new ResponseEntity<>(errorNotification, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(value = { ApplicationException.class })
  public ResponseEntity<Notification> handleApplicationException(ApplicationException ex, WebRequest request) {
    Notification errorNotification = new Notification(ZonedDateTime.now(), ex.getMessage());
    log.error(ex.getMessage());
    return new ResponseEntity<>(errorNotification, new HttpHeaders(), ex.getHttpStatus());
  }

}

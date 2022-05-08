package com.bhargrah.guestservice.advice;

import com.bhargrah.guestservice.controller.GuestController;
import com.bhargrah.guestservice.advice.exceptions.GuestNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@ControllerAdvice(assignableTypes = GuestController.class)
public class GuestControllerAdvice {
  /** Note use base class if you wish to leverage its handling. Some code will need changing. */
  private static final Logger logger = LoggerFactory.getLogger(GuestControllerAdvice.class);

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  public ResponseEntity<ErrorResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
    List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
    List<ObjectError> globalErrors = ex.getBindingResult().getGlobalErrors();
    List<String> errors = new ArrayList<>(fieldErrors.size() + globalErrors.size());
    String error;
    for (FieldError fieldError : fieldErrors) {
      error = fieldError.getField() + ", " + fieldError.getDefaultMessage();
      errors.add(error);
    }
    for (ObjectError objectError : globalErrors) {
      error = objectError.getObjectName() + ", " + objectError.getDefaultMessage();
      errors.add(error);
    }
    ErrorResponse errorMessage = new ErrorResponse(errors);

    return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(ConstraintViolationException.class)
  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  public ResponseEntity<ErrorResponse> handleConstraintViolatedException(ConstraintViolationException ex) {
    Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();

    List<String> errors = new ArrayList<>(constraintViolations.size());
    String error;
    for (ConstraintViolation constraintViolation : constraintViolations) {
      error = constraintViolation.getMessage();
      errors.add(error);
    }

    return new ResponseEntity(new ErrorResponse(errors), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(MissingServletRequestParameterException.class)
  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  public ResponseEntity<ErrorResponse> handleMissingServletRequestParameterException(MissingServletRequestParameterException ex) {

    List<String> errors = new ArrayList<>();
    String error = ex.getParameterName() + ", " + ex.getMessage();
    errors.add(error);
    return new ResponseEntity(new ErrorResponse(errors), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
  @ResponseStatus(code = HttpStatus.UNSUPPORTED_MEDIA_TYPE)
  public ResponseEntity<ErrorResponse> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex) {
    String unsupported = "Unsupported content type: " + ex.getContentType();
    String supported = "Supported content types: " + MediaType.toString(ex.getSupportedMediaTypes());
    return new ResponseEntity(new ErrorResponse(unsupported, supported), HttpStatus.UNSUPPORTED_MEDIA_TYPE);
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  public ResponseEntity<ErrorResponse> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
    return new ResponseEntity(new ErrorResponse(ex.getMessage()), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(NoSuchElementException.class)
  @ResponseStatus(code = HttpStatus.NO_CONTENT)
  public ResponseEntity<ErrorResponse> handleHttpMessageNoSuchElementException(NoSuchElementException ex) {
    return new ResponseEntity(new ErrorResponse(ex.getMessage()), HttpStatus.NO_CONTENT);
  }

  @ExceptionHandler(GuestNotFoundException.class)
  @ResponseStatus(code = HttpStatus.NO_CONTENT)
  public ResponseEntity<ErrorResponse> handleGuestNotFoundException(GuestNotFoundException ex) {
    return new ResponseEntity(new ErrorResponse(ex.getMessage()), HttpStatus.NO_CONTENT);
  }

}

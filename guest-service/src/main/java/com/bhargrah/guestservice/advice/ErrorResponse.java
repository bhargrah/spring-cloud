package com.bhargrah.guestservice.advice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ErrorResponse {

  private List<String> errors;

  public ErrorResponse() {}

  public ErrorResponse(List<String> errors) {
    this.errors = errors;
  }

  public ErrorResponse(String error) {
    this(Collections.singletonList(error));
  }

  public ErrorResponse(String... errors) {
    this(Arrays.asList(errors));
  }

  public List<String> getErrors() {
    return errors;
  }

  public void setErrors(List<String> errors) {
    this.errors = errors;
  }
}

package com.bhargrah.guestservice.exceptions;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Error {

  @NonNull private String message;
  @NonNull private String cause;
}

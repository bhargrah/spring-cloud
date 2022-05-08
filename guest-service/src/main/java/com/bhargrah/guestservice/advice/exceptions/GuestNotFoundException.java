package com.bhargrah.guestservice.advice.exceptions;

import lombok.NonNull;

public class GuestNotFoundException extends RuntimeException {

    public GuestNotFoundException(@NonNull String id) {
        super();
    }
}

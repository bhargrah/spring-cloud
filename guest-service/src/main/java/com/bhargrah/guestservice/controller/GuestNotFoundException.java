package com.bhargrah.guestservice.controller;

import lombok.NonNull;

public class GuestNotFoundException extends RuntimeException {

    public GuestNotFoundException(@NonNull String id) {
        super();
    }
}

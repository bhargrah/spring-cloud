package com.bhargrah.roomreservationservice.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Guest {
    private Long guestId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
}

package com.bhargrah.roomreservationservice.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
public class Room {
    private Long roomId;
    private String roomName;
    private String roomNumber;
    private String bedInfo;

    public Long getRoomId() {
        return roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getBedInfo() {
        return bedInfo;
    }
}

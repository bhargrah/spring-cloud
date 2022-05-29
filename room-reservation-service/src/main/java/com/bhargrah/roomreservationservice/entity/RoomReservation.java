package com.bhargrah.roomreservationservice.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class RoomReservation {
    private Long roomId;
    private Long guestId;
    private String roomName;
    private String roomNumber;
    private String bedInfo;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Long getRoomId() {
        return roomId;
    }

    public Long getGuestId() {
        return guestId;
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

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public void setGuestId(Long guestId) {
        this.guestId = guestId;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setBedInfo(String bedInfo) {
        this.bedInfo = bedInfo;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

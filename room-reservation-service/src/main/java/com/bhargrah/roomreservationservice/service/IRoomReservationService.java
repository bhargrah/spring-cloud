package com.bhargrah.roomreservationservice.service;

import com.bhargrah.roomreservationservice.entity.RoomReservation;

import java.util.List;

public interface IRoomReservationService {

    List<RoomReservation> getRoomReservation();

    RoomReservation getRoomReservation(Long roomId);
}

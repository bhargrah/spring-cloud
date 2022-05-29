package com.bhargrah.roomreservationservice.service;

import com.bhargrah.roomreservationservice.client.RoomServiceClient;
import com.bhargrah.roomreservationservice.entity.Room;
import com.bhargrah.roomreservationservice.entity.RoomReservation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomReservationService {

    private final RoomServiceClient roomServiceClient;

    public RoomReservationService(RoomServiceClient roomServiceClient) {
        this.roomServiceClient = roomServiceClient;
    }

    public List<RoomReservation> getRoomReservation(){
        List<Room> rooms = this.roomServiceClient.getAll();
        List<RoomReservation> roomReservations = new ArrayList<>();

        rooms.forEach( room -> {
            RoomReservation roomReservation = new RoomReservation();
            roomReservation.setRoomId(room.getRoomId());
            roomReservation.setRoomName(room.getRoomName());
            roomReservation.setRoomNumber(room.getRoomNumber());
            roomReservation.setBedInfo(room.getBedInfo());
            roomReservations.add(roomReservation);
        });

        return roomReservations;
    }


}

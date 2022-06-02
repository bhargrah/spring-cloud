package com.bhargrah.roomreservationservice.service;

import com.bhargrah.roomreservationservice.client.RoomServiceClient;
import com.bhargrah.roomreservationservice.entity.Room;
import com.bhargrah.roomreservationservice.entity.RoomReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomReservationService {


    @Autowired
    RoomServiceClient roomServiceClient;

    public List<RoomReservation> getRoomReservation(){
        Iterable<Room> rooms = roomServiceClient.getAll();
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

    public RoomReservation getRoomReservation(Long roomId){
       Room room = roomServiceClient.getRoomById(roomId);
        RoomReservation roomReservation = new RoomReservation();
        roomReservation.setRoomId(room.getRoomId());
        roomReservation.setRoomName(room.getRoomName());
        roomReservation.setRoomNumber(room.getRoomNumber());
        roomReservation.setBedInfo(room.getBedInfo());
        return roomReservation;
    }


}

package com.bhargrah.roomreservationservice.controller;

import com.bhargrah.roomreservationservice.client.RoomServiceClient;
import com.bhargrah.roomreservationservice.entity.Room;
import com.bhargrah.roomreservationservice.entity.RoomReservation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/room-reservations")
public class RoomReservationController {

   /* private final RoomReservationService roomReservationService;

    public RoomReservationController(RoomReservationService roomReservationService) {
        super();
        this.roomReservationService = roomReservationService;
    }

    @GetMapping("/all")
    public List<RoomReservation> getRoomReservation(){
       return roomReservationService.getRoomReservation();
    }*/

    private final RoomServiceClient roomServiceClient;

    public RoomReservationController(RoomServiceClient roomServiceClient) {
        this.roomServiceClient = roomServiceClient;
    }

    @GetMapping("/all")
    public List<RoomReservation> getRoomReservation(){
        List<Room> rooms = this.roomServiceClient.getAllRooms();
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

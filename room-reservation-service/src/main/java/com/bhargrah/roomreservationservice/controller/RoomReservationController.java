package com.bhargrah.roomreservationservice.controller;

import com.bhargrah.roomreservationservice.entity.RoomReservation;
import com.bhargrah.roomreservationservice.service.RoomReservationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/room-reservations")
public class RoomReservationController {

    private final RoomReservationService roomReservationService;

    public RoomReservationController(RoomReservationService roomReservationService) {
        super();
        this.roomReservationService = roomReservationService;
    }

    @GetMapping("/all")
    public List<RoomReservation> getRoomReservation(){
       return roomReservationService.getRoomReservation();
    }


}

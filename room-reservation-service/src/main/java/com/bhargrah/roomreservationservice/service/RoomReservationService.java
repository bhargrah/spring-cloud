package com.bhargrah.roomreservationservice.service;

import com.bhargrah.roomreservationservice.client.GuestServiceClient;
import com.bhargrah.roomreservationservice.client.ReservationServiceClient;
import com.bhargrah.roomreservationservice.client.RoomServiceClient;
import com.bhargrah.roomreservationservice.entity.Guest;
import com.bhargrah.roomreservationservice.entity.Reservation;
import com.bhargrah.roomreservationservice.entity.Room;
import com.bhargrah.roomreservationservice.entity.RoomReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomReservationService implements IRoomReservationService {
    @Autowired RoomServiceClient roomServiceClient;
    @Autowired GuestServiceClient guestServiceClient;
    @Autowired ReservationServiceClient reservationServiceClient;

    @Override
    public List<RoomReservation> getRoomReservation(){

        Iterable<Reservation> reservations = reservationServiceClient.findAllReservation();
        List<RoomReservation> roomReservations = new ArrayList<>();

        reservations.forEach( reservation -> {

            // Calling service via Feign client
            Room room = roomServiceClient.getRoomById(reservation.getRoomId());
            Guest guest = guestServiceClient.getGuestById(reservation.getGuestId());

            RoomReservation roomReservation = new RoomReservation();
            roomReservation.setRoomId(room.getRoomId());
            roomReservation.setRoomName(room.getRoomName());
            roomReservation.setRoomNumber(room.getRoomNumber());
            roomReservation.setBedInfo(room.getBedInfo());
            roomReservation.setGuestId(guest.getGuestId());
            roomReservation.setFirstName(guest.getFirstName());
            roomReservation.setLastName(guest.getLastName());
            roomReservation.setPhoneNumber(guest.getPhoneNumber());
            roomReservations.add(roomReservation);
        });

        return roomReservations;
    }

    @Override
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

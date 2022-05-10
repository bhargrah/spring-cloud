package com.bhargrah.reservationservice.controller;

import com.bhargrah.reservationservice.entity.Reservation;
import com.bhargrah.reservationservice.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    private ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/{reservationId}")
    public Reservation findReservationById(@NotNull @PathVariable Long reservationId){
        return reservationService.findReservation(reservationId);
    }

    @DeleteMapping("/delete/{reservationId}")
    public void deleteReservationById(@NotNull @PathVariable Long reservationId){
         reservationService.deleteReservation(reservationId);
    }

}

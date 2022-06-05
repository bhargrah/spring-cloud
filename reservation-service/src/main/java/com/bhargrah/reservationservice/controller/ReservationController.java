package com.bhargrah.reservationservice.controller;

import com.bhargrah.reservationservice.entity.Reservation;
import com.bhargrah.reservationservice.service.IReservationService;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    private IReservationService reservationService;

    public ReservationController(IReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/all")
    public Iterable<Reservation> findAllReservation(){
        return reservationService.findAllReservation();
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

package com.bhargrah.roomreservationservice.client;

import com.bhargrah.roomreservationservice.entity.Reservation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.constraints.NotNull;

@FeignClient("ReservationService")
public interface ReservationServiceClient {

    @RequestMapping(method = RequestMethod.GET , value = "/reservation/{reservationId}")
    Reservation findReservation(@NotNull @PathVariable Long reservationId);

    @RequestMapping(method = RequestMethod.GET , value = "/reservation/all")
    Iterable<Reservation> findAllReservation();

}

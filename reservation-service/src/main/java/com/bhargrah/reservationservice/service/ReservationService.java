package com.bhargrah.reservationservice.service;

import com.bhargrah.reservationservice.entity.Reservation;

public interface ReservationService {

  Reservation findReservation(Long reservationId);

  Reservation addReservation(Reservation reservation);

  Reservation updateReservation(Long reservationId, Reservation reservation);

  void deleteReservation(Long reservationId);
}

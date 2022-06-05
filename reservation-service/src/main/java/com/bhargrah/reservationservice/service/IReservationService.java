package com.bhargrah.reservationservice.service;

import com.bhargrah.reservationservice.entity.Reservation;

public interface IReservationService {

  Reservation findReservation(Long reservationId);

  Iterable<Reservation> findAllReservation();

  Reservation addReservation(Reservation reservation);

  Reservation updateReservation(Long reservationId, Reservation reservation);

  void deleteReservation(Long reservationId);
}

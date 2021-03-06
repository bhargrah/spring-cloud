package com.bhargrah.reservationservice.service;

import com.bhargrah.reservationservice.advice.exception.ReservationNotFound;
import com.bhargrah.reservationservice.entity.Reservation;
import com.bhargrah.reservationservice.repository.ReservationRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservationService implements IReservationService {

  private final ReservationRepository reservationRepository;

  public ReservationService(ReservationRepository reservationRepository) {
    this.reservationRepository = reservationRepository;
  }

  @Override
  public Reservation findReservation(Long reservationId) {
    return reservationRepository
        .findById(reservationId)
        .orElseThrow(() -> new ReservationNotFound());
  }

    @Override
    public Iterable<Reservation> findAllReservation() {
        return reservationRepository.findAll();
    }

    @Override
  public Reservation addReservation(Reservation newReservation) {
    return reservationRepository.save(newReservation);
  }

  @Override
  public Reservation updateReservation(Long reservationId, Reservation newReservation) {

    return reservationRepository
        .findById(reservationId)
        .map(
            reservation -> {
              reservation.setGuestId(newReservation.getGuestId());
              reservation.setRoomId(newReservation.getRoomId());
              reservation.setReservationDate(newReservation.getReservationDate());
              return reservationRepository.save(reservation);
            })
        .orElseGet(
            () -> {
              newReservation.setReservationId(reservationId);
              return reservationRepository.save(newReservation);
            });
  }

  @Override
  public void deleteReservation(Long reservationId) {
    reservationRepository.deleteById(reservationId);
  }
}

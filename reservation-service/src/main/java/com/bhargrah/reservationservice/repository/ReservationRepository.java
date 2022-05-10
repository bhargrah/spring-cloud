package com.bhargrah.reservationservice.repository;

import com.bhargrah.reservationservice.entity.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation,Long> {

}

package com.bhargrah.guestservice.repository;

import com.bhargrah.guestservice.entity.Guest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends CrudRepository<Guest, Long> { }

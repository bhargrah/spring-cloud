package com.bhargrah.guestservice.service;

import com.bhargrah.guestservice.entity.Guest;

public interface GuestService {

  Iterable<Guest> getAllGuest();

  Guest findGuestById(Long id);

  Guest addGuest(Guest guest);

  void deleteGuest(Long guestId);

  Guest updateGuestWithId(Guest newGuest, Long id);

  Guest updateContactDetailsOfGuestWithId(Guest newGuest, Long id);

  Guest updateNameOfGuest(Guest newGuest, Long id);
}

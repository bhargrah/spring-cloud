package com.bhargrah.guestservice.service;

import com.bhargrah.guestservice.advice.exceptions.GuestNotFoundException;
import com.bhargrah.guestservice.entity.Guest;
import com.bhargrah.guestservice.repository.GuestRepository;
import org.springframework.stereotype.Service;

@Service
public class GuestServiceImpl implements IGuestService {

  private final GuestRepository guestRepository;

  public GuestServiceImpl(GuestRepository guestRepository) {
    this.guestRepository = guestRepository;
  }

  @Override
  public Iterable<Guest> getAllGuest() {
    return guestRepository.findAll();
  }

  @Override
  public Guest findGuestById(Long id) {
    return guestRepository
        .findById(id)
        .orElseThrow(() -> new GuestNotFoundException("Guest with [" + id + "] not found"));
  }

  @Override
  public Guest addGuest(Guest guest) {
    return guestRepository.save(guest);
  }

  @Override
  public void deleteGuest(Long guestId) {
    guestRepository.deleteById(guestId);
  }

  @Override
  public Guest updateGuestWithId(Guest newGuest, Long id) {
    return guestRepository
        .findById(id)
        .map(
            guest -> {
              guest.setAddress(newGuest.getAddress());
              guest.setCountry(newGuest.getCountry());
              guest.setState(newGuest.getState());
              guest.setLastName(newGuest.getLastName());
              guest.setFirstName(newGuest.getFirstName());
              guest.setEmailAddress(newGuest.getEmailAddress());
              guest.setPhoneNumber(newGuest.getPhoneNumber());
              return guestRepository.save(guest);
            })
        .orElseGet(
            () -> {
              newGuest.setId(id);
              return guestRepository.save(newGuest);
            });
  }

  @Override
  public Guest updateContactDetailsOfGuestWithId(Guest newGuest, Long id) {
    return guestRepository
        .findById(id)
        .map(
            guest -> {
              guest.setEmailAddress(newGuest.getEmailAddress());
              guest.setPhoneNumber(newGuest.getPhoneNumber());
              return guestRepository.save(guest);
            })
        .orElseThrow(
            () ->
                new GuestNotFoundException(
                    "Cant update guest with [" + id + "] as entity not found"));
  }

  @Override
  public Guest updateNameOfGuest(Guest newGuest, Long id) {
    return guestRepository
        .findById(id)
        .map(
            guest -> {
              guest.setLastName(newGuest.getLastName());
              guest.setFirstName(newGuest.getFirstName());
              return guestRepository.save(guest);
            })
        .orElseThrow(
            () ->
                new GuestNotFoundException(
                    "Cant update guest with [" + id + "] as entity not found"));
  }
}

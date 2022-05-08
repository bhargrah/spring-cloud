package com.bhargrah.guestservice.controller;

import com.bhargrah.guestservice.entity.Guest;
import com.bhargrah.guestservice.service.GuestServiceImpl;
import lombok.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/guests")
public class GuestController {

  private final GuestServiceImpl guestService;

  public GuestController(GuestServiceImpl guestService) {
    this.guestService = guestService;
  }

  @GetMapping("/all")
  Iterable<Guest> getAllGuest() {
    return guestService.getAllGuest();
  }

  @GetMapping("/search/{id}")
  public Guest getGuestById(@NonNull @PathVariable("id") Long id) {
    return guestService.findGuestById(id);
  }

  @PostMapping("/add")
  public Guest addGuest(@RequestBody Guest guest) {
    return guestService.addGuest(guest);
  }

  @DeleteMapping("/delete/{id}")
  public void deleteGuest(@NonNull @PathVariable("id") Long id) {
    guestService.deleteGuest(id);
  }

  @PutMapping("/update/{id}")
  public Guest updateGuestWithId(@RequestBody Guest newGuest, @PathVariable Long id) {
    return guestService.updateGuestWithId(newGuest, id);
  }

  @PatchMapping("/update/contact/{id}")
  public Guest updateContactDetailsOfGuestWithId(
      @RequestBody Guest newGuest, @PathVariable Long id) {
    return guestService.updateContactDetailsOfGuestWithId(newGuest, id);
  }

  @PatchMapping("/update/name/{id}")
  public Guest updateNameOfGuest(@RequestBody Guest newGuest, @PathVariable Long id) {
    return guestService.updateNameOfGuest(newGuest, id);
  }
}

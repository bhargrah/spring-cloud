package com.bhargrah.guestservice.controller;

import com.bhargrah.guestservice.entity.Guest;
import com.bhargrah.guestservice.repository.GuestRepository;
import lombok.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/guests")
public class GuestController {

    private final GuestRepository repository;

    public GuestController(GuestRepository guestRepository) {
        super();
        this.repository=guestRepository;
    }
    
    @GetMapping("/all")
    Iterable<Guest> getAllGuest(){
        return this.repository.findAll();
    }

    @GetMapping("/find/{id}")
    public Guest getGuestById(@NonNull @PathVariable("id") Long id) {
        return this.repository.findById(id).orElseThrow(() -> new GuestNotFoundException("Guest with ["+id+"] not found"));
    }

    @PostMapping("/add")
    public Guest addGuest(@RequestBody Guest guest){
        return repository.save(guest);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteGuest(@NonNull @PathVariable("id") Long id){
        repository.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public Guest updateGuestWithId(@RequestBody Guest newGuest, @PathVariable Long id) {

        return repository.findById(id)
                .map(guest -> {
                    guest.setAddress(newGuest.getAddress());
                    guest.setCountry(newGuest.getCountry());
                    guest.setState(newGuest.getState());
                    guest.setLastName(newGuest.getLastName());
                    guest.setFirstName(newGuest.getFirstName());
                    guest.setEmailAddress(newGuest.getEmailAddress());
                    guest.setPhoneNumber(newGuest.getPhoneNumber());
                    return repository.save(guest);
                })
                .orElseGet(() -> {
                    newGuest.setId(id);
                    return repository.save(newGuest);
                });
    }

    @PatchMapping("/update/contact/{id}")
    public Guest updateContactDetailsOfGuestWithId(@RequestBody Guest newGuest, @PathVariable Long id) {

    return repository
        .findById(id)
        .map(
            guest -> {
              guest.setEmailAddress(newGuest.getEmailAddress());
              guest.setPhoneNumber(newGuest.getPhoneNumber());
              return repository.save(guest);
            })
        .orElseThrow(() -> new GuestNotFoundException("Cant update guest with [" + id + "] as entity not found"));
    }

    @PatchMapping("/update/name/{id}")
    public Guest updateNameOfGuest(@RequestBody Guest newGuest, @PathVariable Long id) {

        return repository.findById(id)
                .map(guest -> {
                    guest.setLastName(newGuest.getLastName());
                    guest.setFirstName(newGuest.getFirstName());
                    return repository.save(guest);
                })
                .orElseThrow(() -> new GuestNotFoundException("Cant update guest with [" + id + "] as entity not found"));
    }

}

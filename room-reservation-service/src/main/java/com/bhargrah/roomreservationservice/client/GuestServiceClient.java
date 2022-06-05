package com.bhargrah.roomreservationservice.client;

import com.bhargrah.roomreservationservice.entity.Guest;
import lombok.NonNull;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("GuestService") //this has to match with Eureka service name
public interface GuestServiceClient {

    @RequestMapping(method = RequestMethod.GET, value = "/guests/all")
    Iterable<Guest> getAllGuest();

    @RequestMapping(method = RequestMethod.GET, value = "/guests/search/{id}")
    Guest getGuestById(@NonNull @PathVariable("id") Long id);

}

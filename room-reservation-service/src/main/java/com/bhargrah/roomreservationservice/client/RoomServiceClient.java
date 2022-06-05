package com.bhargrah.roomreservationservice.client;

import com.bhargrah.roomreservationservice.entity.Room;
import lombok.NonNull;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="RoomService") //this has to match with Eureka service name
public interface RoomServiceClient {

    @RequestMapping(method = RequestMethod.GET, value = "/rooms/all")
    Iterable<Room> getAllRoom();

    @RequestMapping(method = RequestMethod.GET, value = "/rooms/{roomId}")
    Room getRoomById(@NonNull @PathVariable Long roomId);

    }

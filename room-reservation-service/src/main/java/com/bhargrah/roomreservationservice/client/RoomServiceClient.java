package com.bhargrah.roomreservationservice.client;

import com.bhargrah.roomreservationservice.entity.Room;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="ROOMSERVICE")
public interface RoomServiceClient {

    @GetMapping("/rooms")
    List<Room> getAllRooms();

    @GetMapping("/rooms/{roomId}")
    Room getRoom(@PathVariable("roomId") long roomId);

}

package com.bhargrah.roomreservationservice.client;

import com.bhargrah.roomreservationservice.entity.Room;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="roomservice",url = "http://localhost:8083")
public interface RoomServiceClient {

    @GetMapping("/rooms/all")
    List<Room> getAll();

    @GetMapping("/rooms/{roomId}")
    Room getRoomById(@PathVariable("roomId") long roomId);

}

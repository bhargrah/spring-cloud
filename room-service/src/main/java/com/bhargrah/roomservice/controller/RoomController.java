package com.bhargrah.roomservice.controller;

import com.bhargrah.roomservice.entity.Room;
import com.bhargrah.roomservice.service.RoomService;
import lombok.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rooms")
public class RoomController {

  private final RoomService roomService;

  public RoomController(RoomService roomService) {
    this.roomService = roomService;
  }

  @GetMapping("/all")
  public Iterable<Room> getAll() {
    return roomService.getAllRoom();
  }

  @GetMapping("/{roomId}")
  public Room getRoomById(@NonNull @PathVariable Long roomId) {
    return roomService.findRoomById(roomId);
  }

  @PostMapping("/add")
  public Room addRoom(@RequestBody Room room) {
    return roomService.addRoom(room);
  }

  @PostMapping("/delete/{roomId}")
  public void deleteRoomById(@PathVariable Long roomId) {
    roomService.deleteRoomById(roomId);
  }
}

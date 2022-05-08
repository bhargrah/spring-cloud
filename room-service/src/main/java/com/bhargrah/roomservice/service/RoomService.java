package com.bhargrah.roomservice.service;

import com.bhargrah.roomservice.entity.Room;

public interface RoomService {

    Iterable<Room> getAllRoom();

    Room findRoomById(Long id);

    Room addRoom(Room room);

    void deleteRoomById(Long roomId);

}

package com.bhargrah.roomservice.service;

import com.bhargrah.roomservice.entity.Room;

public interface IRoomService {

    Iterable<Room> getAllRoom();

    Room findRoomById(Long roomId);

    Room addRoom(Room room);

    void deleteRoomById(Long roomId);

}

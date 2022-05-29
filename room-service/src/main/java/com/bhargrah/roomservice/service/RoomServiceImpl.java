package com.bhargrah.roomservice.service;

import com.bhargrah.roomservice.advice.exceptions.RoomNotFound;
import com.bhargrah.roomservice.entity.Room;
import com.bhargrah.roomservice.repository.RoomRepository;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {

    private RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public Iterable<Room> getAllRoom() {
        return roomRepository.findAll();
    }

    @Override
    public Room findRoomById(Long roomId) {
        return roomRepository.findById(roomId).orElseThrow(() -> new RoomNotFound(roomId));
    }

    @Override
    public Room addRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public void deleteRoomById(Long roomId) {
        roomRepository.deleteById(roomId);
    }
}

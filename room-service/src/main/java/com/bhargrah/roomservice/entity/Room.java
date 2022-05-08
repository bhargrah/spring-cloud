package com.bhargrah.roomservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;


@Entity
@Table(name="ROOM")
@Getter
@Setter
public class Room {

    @Id
    @Column(name="ROOM_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name="NAME")
    @Size(max=16)
    private String roomName;

    @Column(name="ROOM_NUMBER")
    @Size(max=2)
    private String roomNumber;

    @Column(name="BED_INFO")
    @Size(max=2)
    private String bedInfo;




}

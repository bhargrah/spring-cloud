package com.bhargrah.reservationservice.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "RESERVATION")
@Getter
@Setter
public class Reservation {

  @Id
  @Column(name = "RESERVATION_ID")
  @NotNull
  private Long reservationId;

  @Column(name = "ROOM_ID")
  @NotNull
  private Long roomId;

  @Column(name = "GUEST_ID")
  @NotNull
  private Long guestId;

  @Column(name = "RES_DATE")
  @NotNull
  private Date reservationDate;
}

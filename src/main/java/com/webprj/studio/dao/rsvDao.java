package com.webprj.studio.dao;

import java.util.List;

import com.webprj.di.entity.Reservation;

public interface RsvDao {
	
	Reservation getReservation(int rsvno);

	List<Reservation> getReservations(String query);

	int insertReservation(Reservation rsv);

	int updateReservation(Reservation rsv);

	int deleteReservation(int rsvSeq);
}

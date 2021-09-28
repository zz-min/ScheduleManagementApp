package com.webprj.studio.dao;

import java.util.List;

import com.webprj.di.entity.Reservation;

public interface RsvDao {
	
	Reservation getReservation(int rsvno);

	List<Reservation> getReservationList(String query);

}

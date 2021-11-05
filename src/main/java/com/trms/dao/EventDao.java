package com.trms.dao;

import java.util.List; 

import com.trms.models.Event;

public interface EventDao {
	public Event addEvent(Event event);
	public Event getEventById(int id);
	public Event updateEvent(Event event);
	public Event deleteEvent(int id);
	public List<Event> getAllEvents();
	public Event getEventByName(String name);
}

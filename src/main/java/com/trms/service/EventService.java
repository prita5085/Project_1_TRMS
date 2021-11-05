package com.trms.service;

import java.util.List;

import com.trms.models.Event;

public interface EventService {
	
	public Event addEvent(Event event);
	public Event getEventById(int id);
	public Event updateEvent(Event event);
	public Event deleteEvent(int id);
	public List<Event> getAllEvents();
	public Event getEventByName(String name);
}

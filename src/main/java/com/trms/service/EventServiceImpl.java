package com.trms.service;

import java.util.List;

import com.trms.dao.EventDao;
import com.trms.models.Event;

public class EventServiceImpl implements EventService {
	
	EventDao dao;
	
	public EventServiceImpl(EventDao dao) {
		this.dao = dao;
	}

	@Override
	public Event addEvent(Event event) {
		return dao.addEvent(event);
	}

	@Override
	public Event getEventById(int id) {
		return dao.getEventById(id);
	}

	@Override
	public Event updateEvent(Event event) {
		return dao.updateEvent(event);
	}

	@Override
	public Event deleteEvent(int id) {
		return dao.deleteEvent(id);
	}

	@Override
	public List<Event> getAllEvents() {
		return dao.getAllEvents();
	}

	@Override
	public Event getEventByName(String name) {
		return dao.getEventByName(name);
	}
	
	
}

package com.trms.controller;

import java.util.List;

import com.google.gson.Gson;

import com.trms.models.Event;

import com.trms.service.EventService;

import io.javalin.http.Context;
import io.javalin.http.Handler;

public class EventController {

	EventService es;
	Gson gson = new Gson();

	public EventController(EventService es) {
		this.es = es;
	}

	public Handler addEvent = (context) -> {
		Event e = gson.fromJson(context.body(), Event.class);
		e = es.addEvent(e);
		populateResult(context, e);
	};

	public Handler getEventById = (context) -> {

		int id = Integer.parseInt(context.pathParam("id"));
		Event e = es.getEventById(id);
		populateResult(context, e);

	};

	public Handler updateEvent = (context) -> {
		Event e = gson.fromJson(context.body(), Event.class);
		e = es.updateEvent(e);
		populateResult(context, e);
	};

	public Handler deleteEvent = (context) -> {
		int id = Integer.parseInt(context.pathParam("id"));
		Event e = es.deleteEvent(id);
		populateResult(context, e);

	};

	public Handler getAllEvents = (context) -> {
		List<Event> eventList = es.getAllEvents();

		if (eventList != null) {
			context.result(gson.toJson(eventList));
		} else {
			context.result("[]");
		}
	};
	
//	//getEventByName
//	public Handler getEventByName = (context) -> {
//		String name = context.queryParam("name");
//		//String name = context.pathParam("name");
//		Event e = es.getEventByName(name);
//		populateResult(context, e);
//
//	};
	
	// Helper Method
	private void populateResult(Context context, Event e) {

		if (e != null) {
			context.result(gson.toJson(e));
		} else {
			context.result("{}");
		}

	}
}

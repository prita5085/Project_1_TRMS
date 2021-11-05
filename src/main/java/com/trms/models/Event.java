package com.trms.models;

import java.util.Objects; 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "events")
public class Event {
	
	@Id
	@GeneratedValue
	@Column(name="event_id")
	private int eventId;
	
	@Column(name="event_types")
	private String eventTypes;
	
	@Column(name="event_cov")
	private int eventCov;
	
	@Column(name="grading_format")
	private String gradingFormat;
	
	public Event() {
		super();
	}

	public Event(String eventTypes, int eventCov, String gradingFormat) {
		this.eventTypes = eventTypes;
		this.eventCov = eventCov;
		this.gradingFormat = gradingFormat;
	}
	
	public Event(int eventId, String eventTypes, int eventCov, String gradingFormat) {
		super();
		this.eventId = eventId;
		this.eventTypes = eventTypes;
		this.eventCov = eventCov;
		this.gradingFormat = gradingFormat;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getEventTypes() {
		return eventTypes;
	}

	public void setEventTypes(String eventTypes) {
		this.eventTypes = eventTypes;
	}

	public int getEventCov() {
		return eventCov;
	}

	public void setEventCov(int eventCov) {
		this.eventCov = eventCov;
	}

	public String getGradingFormat() {
		return gradingFormat;
	}

	public void setGradingFormat(String gradingFormat) {
		this.gradingFormat = gradingFormat;
	}

	@Override
	public String toString() {
		return "Events [eventId=" + eventId + ", eventTypes=" + eventTypes + ", eventCov=" + eventCov
				+ ", gradingFormat=" + gradingFormat + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(eventCov, eventId, eventTypes, gradingFormat);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		return eventCov == other.eventCov && eventId == other.eventId && Objects.equals(eventTypes, other.eventTypes)
				&& Objects.equals(gradingFormat, other.gradingFormat);
	}
	
	
}

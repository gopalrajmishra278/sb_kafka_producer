package com.gopal.model;

import java.util.Objects;

public class LibraryEvent {
	
	
	private Long eventId;
	private LibraryEventType eventType;
	private Book book;
	
	public LibraryEvent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LibraryEvent(Long eventId, LibraryEventType eventType, Book book) {
		super();
		this.eventId = eventId;
		this.eventType = eventType;
		this.book = book;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public LibraryEventType getEventType() {
		return eventType;
	}

	public void setEventType(LibraryEventType eventType) {
		this.eventType = eventType;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(book, eventId, eventType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LibraryEvent other = (LibraryEvent) obj;
		return Objects.equals(book, other.book) && Objects.equals(eventId, other.eventId)
				&& Objects.equals(eventType, other.eventType);
	}

	@Override
	public String toString() {
		return "LibraryEvent [eventId=" + eventId + ", eventType=" + eventType + ", book=" + book + "]";
	}
	
}

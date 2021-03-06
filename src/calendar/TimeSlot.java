package calendar;

import events.Category;
import events.Event;

public class TimeSlot {
    private Event event = null;

    public String getEventName() {
        return (event != null) ? event.getName() : "XXX";
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public boolean hasEventWithID(int eventID) {
        return ((this.event != null) && (this.event.hasID(eventID))) ;
    }

    public void deleteEvent() {
        this.event = null;
    }

    public boolean hasEvent() {return (this.event != null);}

    public Event getEvent(){ return this.event; }
}

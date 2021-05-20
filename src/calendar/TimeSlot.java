package calendar;

import events.Event;

public class TimeSlot {
    private Event event = null;

    public String getEventName() {
        return (event != null) ? event.getName() : "XXX";
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public void deleteEvent() {
        this.event = null;
    }
}

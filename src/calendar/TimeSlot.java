package calendar;

import events.Event;

public class TimeSlot {
    private Event event = null;

    public String getEventName() {
        return (event != null) ? event.getName() : "XXX";
    }
}

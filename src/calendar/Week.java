package calendar;

import events.Event;

import java.util.*;

public class Week {
    public enum Days {
        Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday
    }

    private final TimeSlot[] TIME_SLOTS;
    private final int DAY_COUNT;
    private final int SLOT_COUNT;
    private final float START_TIME;
    private final float END_TIME;
    private final float DELTA_TIME;

    public Week(int dayCount, int slotCount, float startTime, float endTime) {
        this.DAY_COUNT = dayCount;
        this.SLOT_COUNT = slotCount;
        this.START_TIME = startTime;
        this.END_TIME = endTime;
        this.DELTA_TIME = (endTime - startTime) / slotCount;

        this.TIME_SLOTS = new TimeSlot[dayCount * slotCount];
        this.initWeek();
    }

    private void initWeek() {
        for(int i = 0; i < TIME_SLOTS.length; i++) {
            this.TIME_SLOTS[i] = new TimeSlot();
        }
    }

    public TimeSlot[] getDay(Days day) {
        return this.getDay(day.ordinal());
    }

    public TimeSlot[] getDay(int dayNumber) {
        dayNumber = dayNumber % DAY_COUNT;
        return Arrays.copyOfRange(this.TIME_SLOTS, dayNumber * this.SLOT_COUNT, (dayNumber + 1) * this.SLOT_COUNT);
    }

    public String getDayName(int dayNumber) {
        return Days.values()[dayNumber].toString();
    }

    public String getTime(int slotNumber) {
        float time = this.START_TIME + slotNumber * this.DELTA_TIME;
        return String.format("%02d:%02d", (int) time, (int) ((time % 1) * 60));
    }

    public void addEvent(Event event,Days day, int timeSlot) {
        this.addEvent(event, day.ordinal(), timeSlot);
    }

    public void addEvent(Event event, int dayNumber, int timeSlot) {
        int index = dayNumber * this.SLOT_COUNT + timeSlot;
        this.TIME_SLOTS[index].setEvent(event);
    }

    public void addEventBySlotnumber(Event event, int slotnumber){
        this.TIME_SLOTS[slotnumber].setEvent(event);
    }

    public void removeEvent(Days day, int timeSlot) {
        this.removeEvent(day.ordinal(), timeSlot);
    }

    public void removeEvent(int dayNumber, int timeSlot) {
        int index = dayNumber * this.SLOT_COUNT + timeSlot;
        this.TIME_SLOTS[index].deleteEvent();
    }

    public void removeEvent(int eventID) {
        for (TimeSlot time_slot : this.TIME_SLOTS) {
            if (time_slot.hasEventWithID(eventID)) {
                time_slot.deleteEvent();
                return;
            }
        }
    }

    public void printWeek(){
        Days days[] = {Days.Monday, Days.Tuesday, Days.Wednesday, Days.Thursday, Days.Friday, Days.Saturday, Days.Sunday};
        for (int d = 0; d < this.DAY_COUNT; d++){
            System.out.println(days[d].name() + ":");
            for (int s = 0; s < this.SLOT_COUNT; s++){
                //Print Time
                System.out.print((int)(this.START_TIME + this.DELTA_TIME * s) + " Uhr    ");
                //Print Event
                int index = d * this.SLOT_COUNT + s;    //Get Index
                TimeSlot t = this.TIME_SLOTS[index];    //Get Slot
                String output = t.getEventName();       //Get String
                if (output.equals("XXX")) {output = "";}
                System.out.println(output);   //Print Name
            }
        }
    }

    public int freeSpot(){
        Random r = new Random();
        int check = r.nextInt(TIME_SLOTS.length);
        while (TIME_SLOTS[check].hasEvent()){
            check = r.nextInt(TIME_SLOTS.length);
        }
        return check;
    }

    public int getDayCount() {
        return this.DAY_COUNT;
    }

    public int getSlotCount() {
        return this.SLOT_COUNT;
    }
}

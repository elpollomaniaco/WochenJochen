package calendar;

import java.util.Arrays;

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

    public TimeSlot[] getDay(int dayNumber) {
        dayNumber = dayNumber % DAY_COUNT;
        return Arrays.copyOfRange(this.TIME_SLOTS, dayNumber * this.SLOT_COUNT, (dayNumber + 1) * this.SLOT_COUNT);
    }

    public TimeSlot[] getDay(Days day) {
        return this.getDay(day.ordinal());
    }

    public String getTime(int slotNumber) {
        float time = this.START_TIME + slotNumber * this.DELTA_TIME;
        return String.format("%02d:%02d", (int) time, (int) ((time % 1) * 60));
    }
}

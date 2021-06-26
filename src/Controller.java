import TUIO.TuioClient;
import calendar.TimeSlot;
import calendar.Week;
import events.Category;
import events.CategoryDB;
import events.Event;
import graphics.Drawer;

public class Controller {
    private TuioClient client;
    private Listener listener;
    private Drawer drawer;
    private long lastRefresh = 0;
    private final int REFRESH_RATE;

    private Week week;

    public Controller(int port, int refreshRate, int dayCount, int slotCount, float startTime, float endTime) {
        drawer = new Drawer("WochenJochen", 1100, 770, dayCount, slotCount);
        this.REFRESH_RATE = refreshRate;
        this.listener = new Listener(this);

        this.client = new TuioClient(port);
        this.client.addTuioListener(this.listener);
        this.client.connect();

        this.week = new Week(dayCount, slotCount, startTime, endTime);
    }

    public void addEvent(int id, float x, float y) {
        //Create new Event
        Event newEvent = new Event(id);

        int day = (int)(this.week.getDayCount() * x);
        int timeSlot = (int)(this.week.getSlotCount() * y);
        int slot = day * this.week.getSlotCount() + timeSlot;
        //Check if the slot is already occupied
        if (week.spotOccupied(slot)){
            //Check whether the Categories match
            Event currentEvent = week.getEvent(slot);
            if (currentEvent.getCategory().equals(newEvent.getCategory())){
                //Remove old Event
                this.removeEvent(id);
                //Add new Event
                this.createEvent(newEvent, x, y);
            }
        }
        else {
            this.createEvent(newEvent, x, y);
        }
    }

    public void addEvent(int id, Category cat, float x, float y) {
        Event event = new Event(id, cat);
        this.createEvent(event, x, y);
    }

    public void addEventBySpotnumber(int id, int spot){
        Event event = new Event(id);
        this.createEvent(event, spot);
    }

    private void createEvent(Event event, float x, float y) {
        int day = (int)(this.week.getDayCount() * x);
        int timeSlot = (int)(this.week.getSlotCount() * y);
        this.createEvent(event, (day * this.week.getSlotCount() + timeSlot));
    }
    
    //main creation
    private void createEvent(Event event, int slotNumber) {
    	drawer.addImage(event.getImage(), slotNumber);
    	this.week.addEventBySlotnumber(event, slotNumber);
    }

    public void updateEvent(int id, float x, float y) {
        this.removeEvent(id);
        this.addEvent(id, x, y);
    }

    public void removeEvent(int id) {
        this.week.removeEvent(id);
    }

    public void refreshView(long seconds) {
        if (seconds > this.lastRefresh && seconds % this.REFRESH_RATE == 0) {
            drawer.refreshDrawing();
            this.lastRefresh += this.REFRESH_RATE;
        }
    }

    public Week getWeek() {
        return this.week;
    }
}

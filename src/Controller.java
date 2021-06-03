import TUIO.TuioClient;
import calendar.Week;
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
        Event event = new Event(id);
        int day = (int)(this.week.getDayCount() * x);
        int timeSlot = (int)(this.week.getSlotCount() * y);
        this.week.addEvent(event, day, timeSlot);
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

}

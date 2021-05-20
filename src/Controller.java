import TUIO.TuioClient;
import calendar.Week;

public class Controller {
    private TuioClient client;
    private Listener listener;
    private long lastRefresh = 0;
    private final int REFRESH_RATE;

    private Week week;

    public Controller(int port, int refreshRate, int dayCount, int slotCount, float startTime, float endTime) {
        this.REFRESH_RATE = refreshRate;
        this.listener = new Listener(this);

        this.client = new TuioClient(port);
        this.client.addTuioListener(this.listener);
        this.client.connect();

        this.week = new Week(dayCount, slotCount, startTime, endTime);
    }

    public void addEvent(int id, float x, float y) {
        System.out.println("Add event");
    }

    public void updateEvent(int id, float x, float y) {
        System.out.println("Update event");
    }
    public void removeEvent(int id) {
        System.out.println("Remove event");
    }

    public void refreshView(long seconds) {
        if (seconds > this.lastRefresh && seconds % this.REFRESH_RATE == 0) {
            System.out.println("Refresh event");
            this.lastRefresh += this.REFRESH_RATE;
        }
    }

}

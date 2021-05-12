import TUIO.TuioClient;

public class Controller {
    private TuioClient client;
    private Listener listener;
    private long lastRefresh = 0;
    private final int refreshRate;

    public Controller(int port, int refreshRate) {
        this.refreshRate = refreshRate;
        this.listener = new Listener(this);

        this.client = new TuioClient(port);
        this.client.addTuioListener(this.listener);
        this.client.connect();
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
        if (seconds > this.lastRefresh && seconds % this.refreshRate == 0) {
            System.out.println("Refresh event");
            this.lastRefresh += this.refreshRate;
        }
    }

}

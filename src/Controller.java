import TUIO.TuioClient;

public class Controller {
    private TuioClient client;
    private Listener listener;

    public Controller(int port) {
        this.listener = new Listener();

        this.client = new TuioClient(port);
        this.client.addTuioListener(this.listener);
        this.client.connect();
    }
}

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
        drawer = new Drawer("WochenJochen", 1920, 1080, dayCount, slotCount);
        this.REFRESH_RATE = refreshRate;
        this.listener = new Listener(this);

        this.client = new TuioClient(port);
        this.client.addTuioListener(this.listener);
        this.client.connect();

        this.week = new Week(dayCount, slotCount, startTime, endTime);
    }

    //Add event from Klotz
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
                this.removeEvent(id, x, y);
                //Add new Event
                this.createEvent(newEvent, x, y);
            }
        }
        else {
            this.createEvent(newEvent, x, y);
        }
    }

    //Aktuell nicht in Verwendung
    public void addEvent(int id, Category cat, float x, float y) {
        Event event = new Event(id, cat);
        this.createEvent(event, x, y);
    }
    
    //Add event from server
    public void addEventBySpotnumber(int id, int spot){
        Event event = new Event(id);
        this.createEvent(event, spot, true);
    }

    private void createEvent(Event event, float x, float y) {
        int day = this.getDay(x,y);
        int timeSlot = this.getSlot(y);
        this.createEvent(event, (day * this.week.getSlotCount() + timeSlot), false);
    }
    
    //main creation
    private void createEvent(Event event, int slotNumber, boolean fromServer) {
    	if(fromServer) {
    		drawer.addImage(event.getImage(), slotNumber);
    	}
    	this.week.addEventBySlotnumber(event, slotNumber);
    }

    public void updateEvent(int id, float x, float y) {
        this.removeEvent(id, x, y);
        this.addEvent(id, x, y);
    }

    public void removeEvent(int id, float x, float y) {
        if (x >= 0) {
	    	int day = (int)(this.week.getDayCount() * x);
	        int timeSlot = (int)(this.week.getSlotCount() * y);
	        drawer.removeImage(day, timeSlot);
        }
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
    
    
    // Trapezumwandlung von Hand...
//    private int getDay(float x) {
//    	
//    	if (x < 0.35) {
//    		return 0;
//    	} else if (x < 0.44) {
//    		return 1;
//    	} else if (x < 0.52) {
//    		return 2;
//    	} else if (x < 0.61) {
//    		return 3;
//    	} else if (x < 0.7) {
//    		return 4;
//    	} else if (x < 0.8){
//    		return 5;
//    	} else {
//    		return 6;
//    	}
//    }
    
    private int getDay(float x, float y) {
    	
    	if (y < 0.34) {
    		if (x < 0.3) {
	    		return 0;
	    	} else if (x < 0.38) {
	    		return 1;
	    	} else if (x < 0.47) {
	    		return 2;
	    	} else if (x < 0.55) {
	    		return 3;
	    	} else if (x < 0.63) {
	    		return 4;
	    	} else if (x < 0.71){
	    		return 5;
	    	} else {
	    		return 6;
	    	}
    	}else{
    		if (x < 0.35) {
	    		return 0;
	    	} else if (x < 0.44) {
	    		return 1;
	    	} else if (x < 0.52) {
	    		return 2;
	    	} else if (x < 0.61) {
	    		return 3;
	    	} else if (x < 0.7) {
	    		return 4;
	    	} else if (x < 0.8){
	    		return 5;
	    	} else {
	    		return 6;
	    	}
    	}
    	
    }
    
    
    private int getSlot(float y) {
    	
    	if (y < 0.10) {
    		return 0;
    	} else if (y < 0.16) {
    		return 1;
    	} else if (y < 0.22) {
    		return 2;
    	} else if (y < 0.29) {
    		return 3;
    	} else if (y < 0.34){
    		return 4;
    	} else if (y < 0.40){
    		return 5;
    	} else if (y < 0.46){
        	return 6;
    	} else if (y < 0.51){
    		return 7;
    	} else if (y < 0.57){
    		return 8;
    	} else if (y < 0.64){
    		return 9;
    	} else if (y < 0.70){
    		return 10;
    	} else {
    		return 11;
    	}
    	
    	
    	//return (int) ((y / fy) * this.week.getSlotCount());
    }
}

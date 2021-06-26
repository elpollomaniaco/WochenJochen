import TUIO.*;

public class Listener implements TuioListener {
    private Controller controller;

    public Listener(Controller controller) {
        this.controller = controller;
    }

    @Override
    // new object enters sight of cam
    public void addTuioObject(TuioObject tobj) {
    	// bool draw (wenn vom listener, dann nicht zeichnen, wenn vom server, dann draw)
        this.controller.addEvent(tobj.getSymbolID(), tobj.getX(), tobj.getY());
    }

    @Override
    // seen object changes state (position, angle...)
    public void updateTuioObject(TuioObject tobj) {
        this.controller.updateEvent(tobj.getSymbolID(), tobj.getX(), tobj.getY());
    }

    @Override
    // object leaves sight of cam
    public void removeTuioObject(TuioObject tobj) {
        this.controller.removeEvent(tobj.getSymbolID(),-1,-1);
    }

    @Override
    public void addTuioCursor(TuioCursor tcur) {
        // nothing to do here
    }

    @Override
    public void updateTuioCursor(TuioCursor tcur) {
        // nothing to do here
    }

    @Override
    public void removeTuioCursor(TuioCursor tcur) {
        // nothing to do here
    }

    @Override
    public void addTuioBlob(TuioBlob tblb) {
        // nothing to do here
    }

    @Override
    public void updateTuioBlob(TuioBlob tblb) {
        // nothing to do here
    }

    @Override
    public void removeTuioBlob(TuioBlob tblb) {
        // nothing to do here
    }

    @Override
    // invoked at end of a received TUIO message bundle
    public void refresh(TuioTime ftime) {
        controller.refreshView(ftime.getSeconds());
    }
}

import TUIO.*;

public class Listener implements TuioListener {
    @Override
    // new object enters sight of cam
    public void addTuioObject(TuioObject tobj) {
        System.out.printf("Add object: %d at %f:%f%n", tobj.getSymbolID(), tobj.getX(), tobj.getY());
    }

    @Override
    // seen object changes state (position, angle...)
    public void updateTuioObject(TuioObject tobj) {
        System.out.printf("Update object: %d at %f:%f%n", tobj.getSymbolID(), tobj.getX(), tobj.getY());
    }

    @Override
    // object leaves sight of cam
    public void removeTuioObject(TuioObject tobj) {
        System.out.printf("Remove object: %d", tobj.getSymbolID());
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
        System.out.println("Refresh");
    }
}

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

public class PlanningCollections {
    private ArrayList<Reservation> chReservlist;
    private TreeSet<Reservation> chReservset;
    private TreeMap<Integer, TreeSet<Reservation>> chReservmap;

    // Constructor
    public PlanningCollections() {
        chReservlist = new ArrayList<Reservation>();
        chReservset = new TreeSet<Reservation>();
        chReservmap = new TreeMap<>();

    }
    public String toString(){
        return chReservlist + "\n"+ "["+ chReservlist.size() + "]"+ chReservset + "\n" + "["+ chReservset.size() + "]";
    }


    public void ajout(Reservation parReservation) throws ExceptionPlanning {
        chReservlist.add(parReservation);
        chReservset.add(parReservation);
        int semaine = parReservation.getdate().getChJourSemaine();
        if (chReservmap.containsKey(semaine)) {
            TreeSet<Reservation> set = chReservmap.get(semaine);
        }
        else {
            TreeSet<Reservation> set = new TreeSet<>();
            set.add(parReservation);
            chReservmap.put(semaine, set);
        }
    }
    public TreeSet<Reservation> getReservations(DateCalendrier parDate) {
        TreeSet<Reservation> nouveau = new TreeSet<>();
        Iterator<Reservation> it = chReservset.iterator();
        while (it.hasNext()) {
            Reservation r = it.next();
            if (r.getdate().compareTo(parDate) == 0) {
                nouveau.add(r);
            }
        }
        return nouveau;
    }

    public TreeSet<Reservation> getReservations(String parString) {
        TreeSet<Reservation> nouveau = new TreeSet<>();
        Iterator<Reservation> it = chReservset.iterator();
        while (it.hasNext()) {
            Reservation r = it.next();
            if (r.getintitul().equals(parString)) {
                nouveau.add(r);
            }
        }
        return nouveau;
    }

}

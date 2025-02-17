import java.util.ArrayList;
import java.util.TreeSet;

public class PlanningCollections {

    private List <Reservation> chListReservations;
    private Set <Reservation> chSetReservations;

    public PlanningCollections() {
        chListReservations = new ArrayList<Reservation>();
        chSetReservations = new TreeSet<Reservation>();
    }

    public String toString() {
        return "treeSet :" + chSetReservations.size() + "-"

    }
}

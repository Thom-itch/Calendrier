public class Planning {
    private Reservation[] chTabReservations;
    private final int TAILLE;

    public Planning (int parTaille) {
        TAILLE = parTaille;
        chTabReservations = new Reservation[TAILLE];
    }

    public void ajout(Reservation parReserv) throws ExceptionPlanning {
        if (chTabReservations[TAILLE-1] != null){
            throw new ExceptionPlanning(1);
        }
        for (int i = 0 ; i<chTabReservations.length; i++){
            if(chTabReservations[i] == null) {
                chTabReservations[i] = parReserv;
                break;
            }
            if (chTabReservations[i].compareTo(parReserv) == 0){
                throw new ExceptionPlanning(2);
            }
        }
    }


    public String toString() {
        String str = new String("");
        for (int i=0;(i<chTabReservations.length); i++) {
            if (chTabReservations[i]!=null)
                str = str+chTabReservations[i]+",\n";
        }
        return str;
    }

    public Reservation getReservation(Date parDate) {
        for (int i=0 ; i < chTabReservations.length ; i++ ) {
            if (chTabReservations[i] != null && chTabReservations[i].getDate().compareTo(parDate) == 0) {
                return chTabReservations[i];
            }
        }
        return null;
    }

    public Reservation [] getReservations(Date parDate) {
        Reservation [] tabReservations = new Reservation [TAILLE];
        int nbReservations = 0;
        for (int i=0; i < chTabReservations.length ; i++ ) {
            if (chTabReservations[i] != null && chTabReservations[i].getDate().compareTo(parDate) == 0) {
                tabReservations[nbReservations] = chTabReservations[i];
                nbReservations++;
            }
        }
        return tabReservations;
    }
}